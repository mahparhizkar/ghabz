package com.toranj.ghabz.controller;

import com.squareup.okhttp.*;
import com.toranj.ghabz.dao.NaturalPersonDAO;
import com.toranj.ghabz.dao.UserDAO;
import com.toranj.ghabz.dao.impl.OtpServiceImpl;
import com.toranj.ghabz.entity.NaturalPerson;
import com.toranj.ghabz.entity.User;
import com.toranj.ghabz.utils.UserRole;
import com.toranj.ghabz.utils.UserStatus;
import com.toranj.ghabz.validator.UserValidator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static com.toranj.ghabz.utils.UserRole.COMMON;

@Controller
@Transactional
@EnableWebMvc
public class UserController extends BaseController {

    private static final Logger logger = Logger.getLogger(UserController.class);
    @Autowired
    public OtpServiceImpl otpService;
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private UserValidator userValidator;
    @Autowired
    private NaturalPersonDAO naturalPersonDAO;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String dashboard(@ModelAttribute("naturalPersonForm") NaturalPerson naturalPerson, Model model) {
        try {
            String username = null;
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (principal instanceof UserDetails) {
                username = ((UserDetails) principal).getUsername();
            }
            else {
                username = principal.toString();
            }
            naturalPerson = naturalPersonDAO.findByNationalId(username);

            if ((naturalPerson.getName() == null) || (naturalPerson.getFamily() == null) || (naturalPerson.getBirthDate() == null)
                    || (naturalPerson.getMobileNumber() == null)) {
                model.addAttribute("profileStatus", true);
                model.addAttribute("name", null);
                model.addAttribute("family", null);
                model.addAttribute("birthDate", null);
            } else {
                model.addAttribute("profileStatus", false);
                model.addAttribute("image", naturalPerson.getImage());
                model.addAttribute("name", naturalPerson.getName());
                model.addAttribute("family", naturalPerson.getFamily());
                model.addAttribute("birthDate", naturalPerson.getBirthDate());
                model.addAttribute("mobile", naturalPerson.getMobileNumber());
            }
            model.addAttribute("nationalId",naturalPerson.getNationalId());
            model.addAttribute("naturalPersonForm",naturalPerson);
            return "dashboard";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        try {
            model.addAttribute("registrationForm", new User());
            return "registration";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("registrationForm") User user, BindingResult bindingResult, Model model) {
        try {
            user.setConfirmPassword(user.getPassword());
            userValidator.bussinessValidate(user, bindingResult);
            userValidator.validate(user, bindingResult);
            if (bindingResult.hasErrors()) {
                return "registration";
            }

            if (userDAO.findByUsername(user.getUserName()) != null) {
                model.addAttribute("msgExist", true);
                model.addAttribute("msg", getMessage("user.exist"));
                return "login";
            }

            int otp = otpService.generateOTP(user.getUserName());
            String mobile = user.getMobileNumber();
            sendSMS(otp, mobile);
            model.addAttribute("verificationForm", user);
            return "verification";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    @RequestMapping(value = "/verification", method = RequestMethod.POST)
    public String verification(@ModelAttribute("verificationForm") User user, Model model) {
        try {
            int otpnum = Integer.parseInt(user.getOtp());
            String username = user.getUserName();
            boolean otpIsValid = verifySMS(otpnum, username);

            if (!otpIsValid) {
                model.addAttribute("msg", getMessage("otp.invalid"));
                model.addAttribute("msgExist", true);

                model.addAttribute("verificationForm", user);
                return "verification";
            }

            NaturalPerson naturalPerson;

            if (naturalPersonDAO.findByNationalId(user.getUserName()) == null) {
                //New Contact
                //New BankAccount
                naturalPerson = new NaturalPerson(UUID.randomUUID().toString(),user.getUserName(), user.getMobileNumber(),true);
                naturalPersonDAO.save(naturalPerson);
            } else {
                naturalPerson = naturalPersonDAO.findByNationalId(user.getUserName());
            }

            user.setId(UUID.randomUUID().toString());
            user.setShenase(userDAO.getUserNewShenase());
            user.setFkUserRole(COMMON.text());
            user.setFkPerson(naturalPerson.getId());
            user.setStatus(UserStatus.ACTIVE.value());
            user.setCreationDate(new Date());
            user.setValidFrom(new Date());
            userDAO.save(user);

            model.addAttribute("msgExist", true);
            model.addAttribute("msg", getMessage("success"));

            return "login";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    @RequestMapping(value = "/recoveryPass", method = RequestMethod.GET)
    public String recoveryPass(Model model) {
        try {
            model.addAttribute("recoveryPassForm", new User());
            return "recoveryPass";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    @RequestMapping(value = "/recoveryPass", method = RequestMethod.POST)
    public String recoveryPass(@ModelAttribute("registrationForm") User user, BindingResult bindingResult, Model model) {
        try {
            if (bindingResult.hasErrors()) {
                return "recoveryPass";
            }
            if (userDAO.findByUsername(user.getUserName()) == null) {
                model.addAttribute("msgExist", true);
                model.addAttribute("msg", "user.dont.exist");
                model.addAttribute("recoveryPassForm", user);
                return "recoveryPass";
            } else {
                resendOtp(user, model);
                return "recoveryPassOtp";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    @RequestMapping(value = "/recoveryPassOtp", method = RequestMethod.POST)
    public String recoveryPassOtp(@ModelAttribute("recoveryPassOtpForm") User user, Model model) {
        try {
            int otpnum = Integer.parseInt(user.getOtp());
            String username = user.getUserName();
            boolean otpIsValid = verifySMS(otpnum, username);

            if (!otpIsValid) {
                model.addAttribute("msg", getMessage("otp.invalid"));
                model.addAttribute("msgExist", true);
                model.addAttribute("recoveryPassOtpForm", user);
                return "recoveryPassOtp";
            } else {
                model.addAttribute("changePasswordForm", user);
                return "changePassword";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    @RequestMapping(value = "/changePassword", method = RequestMethod.POST)
    public String changePassword(@ModelAttribute("changePasswordForm") User user, BindingResult bindingResult, Model model) {
        try {
            userValidator.validate(user, bindingResult);
            if (bindingResult.hasErrors()) {
                model.addAttribute("changePasswordForm", user);
                return "changePassword";
            }
            User ouser = userDAO.findByUsername(user.getUserName());
            ouser.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            userDAO.updateUser(ouser);
            return "login";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    public void sendSMS(int otp, String mobile) {
        try {
            String isflash = "false";
            String username = env.getProperty("melliPayamak.username");
            String password = env.getProperty("melliPayamak.password");
            String from = env.getProperty("melliPayamak.from");

            OkHttpClient client = new OkHttpClient();
            MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");

            RequestBody body = RequestBody.create(
                    mediaType,
                    "username=" + username + "&" +
                            "password=" + password + "&" +
                            "to=" + mobile.substring(1) + "&" +
                            "from=" + from + "&" +
                            "text=" + "کد تایید قبض: " + otp + "&" +
                            "isflash=" + isflash
            );

            Request request = new Request.Builder()
                    .url(env.getProperty("melliPayamak.url"))
                    .post(body)
                    .addHeader("cache-control", "no-cache")
                    .addHeader("postman-token", "c26ca3b0-9f44-3cdf-9da3-60c86a9f75b3")
                    .addHeader("content-type", "application/x-www-form-urlencoded")
                    .build();

            Response response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean verifySMS(int otpnum, String username) {
        if (otpnum >= 0) {
            int serverOtp = otpService.getOtp(username);
            if (serverOtp > 0) {
                if (otpnum == serverOtp) {
                    otpService.clearOTP(username);
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public String mobileFormat(String mobile) {
        String mobileFirst = mobile.substring(0, 4);
        String mobileLast = mobile.substring(9, 11);
        return mobileLast.concat("*****").concat(mobileFirst);
    }

    public String resendOtp(User user, Model model) {
        try {
            String mobileNumber = naturalPersonDAO.findByNationalId(user.getUserName()).getMobileNumber();
            int otp = otpService.generateOTP(user.getUserName());
            sendSMS(otp, mobileNumber);
            model.addAttribute("msgExist", true);
            model.addAttribute("msg", "ارسال کد به شماره: " + mobileFormat(mobileNumber));
            user.setMobileNumber(mobileNumber);
            model.addAttribute("recoveryPassOtpForm", user);
            return "recoveryPassOtp";

        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    @RequestMapping(value = "/userManagement", method = RequestMethod.GET)
    public String userManagement(@ModelAttribute("userManagement") User user, Model model) {
        try {
            String username = null;
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (principal instanceof UserDetails) {
                username = ((UserDetails) principal).getUsername();
            } else {
                username = principal.toString();
            }
            User currentUser = userDAO.findByUsername(username);
            List<User> users = new ArrayList<User>();
            String fkUserRole = currentUser.getFkUserRole();
            switch (fkUserRole) {
                case "ROLE_Admin": {
                    users = userDAO.getUsersForAdmin();
                    break;
                }
                case "ROLE_Power": {
                    users = userDAO.getUsersForPowerUser();
                    break;
                }
                case "ROLE_Support":
                    users = userDAO.getUsersForSupportUser();
            }
            model.addAttribute("users", users);
            model.addAttribute("userForm", user);
            model.addAttribute("userRoles", UserRole.getSomeRoles());
            return "userManagement";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    @RequestMapping(value = "/userManagement", method = RequestMethod.POST)
    public String userManagement(@ModelAttribute("userForm") User user, BindingResult bindingResult, Model model) {
        try {
            User oUser = userDAO.findByUsername(user.getUserName());
            oUser.setFkUserRole(user.getFkUserRole());
            String username = null;
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (principal instanceof UserDetails) {
                username = ((UserDetails) principal).getUsername();
            } else {
                username = principal.toString();
            }
            User currentUser = userDAO.findByUsername(username);
            List<User> users = new ArrayList<User>();
            String fkUserRole = currentUser.getFkUserRole();
            switch (fkUserRole) {
                case "ROLE_Admin": {
                    users = userDAO.getUsersForAdmin();
                    break;
                }
                case "ROLE_Power": {
                    users = userDAO.getUsersForPowerUser();
                    break;
                }
                case "ROLE_Support":
                    users = userDAO.getUsersForSupportUser();
            }
            model.addAttribute("users", users);
            model.addAttribute("userForm", new User());
            model.addAttribute("userRoles", UserRole.getSomeRoles());
            userDAO.updateUser(oUser);
            return "userManagement";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    @RequestMapping(value = "/changeStatus", method = RequestMethod.POST)
    public String changeStatus(Model model, HttpServletRequest request, @RequestParam(value = "userName", required = false) String userName) {
        try {
            User oUser = userDAO.findByUsername(userName);
            if (oUser.getStatus().equals(UserStatus.ACTIVE.value())) {
                oUser.setStatus(UserStatus.DEACTIVE.value());
            } else if (oUser.getStatus().equals(UserStatus.DEACTIVE.value())) {
                oUser.setStatus(UserStatus.ACTIVE.value());
            }

            List<User> users = userDAO.getUsers();
            model.addAttribute("users", users);
            model.addAttribute("userForm", new User());
            model.addAttribute("userRoles", UserRole.getSomeRoles());
            userDAO.updateUser(oUser);
            return "userManagement";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    @RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
    public String resetPassword(Model model, HttpServletRequest request, @RequestParam(value = "userName", required = false) String userName) {
        try {
            User oUser = userDAO.findByUsername(userName);
            oUser.setPassword(bCryptPasswordEncoder.encode("0123456789"));
            List<User> users = userDAO.getUsers();
            model.addAttribute("users", users);
            model.addAttribute("userForm", new User());
            model.addAttribute("userRoles", UserRole.getSomeRoles());
            userDAO.updateUser(oUser);
            return "userManagement";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    @RequestMapping(value = "/messages", method = RequestMethod.GET)
    public String messages(NaturalPerson naturalPerson, Model model) {

        return "messages";
    }

    @RequestMapping(value = "/messages", method = RequestMethod.POST)
    public String messages(@ModelAttribute("naturalPerson") NaturalPerson naturalPerson, BindingResult bindingResult, Model model) {

        return "messages";
    }
}
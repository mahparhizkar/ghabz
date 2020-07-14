package com.toranj.ghabz.validator;

import com.toranj.ghabz.dao.NaturalPersonDAO;
import com.toranj.ghabz.dao.UserDAO;
import com.toranj.ghabz.entity.User;
import com.toranj.ghabz.utils.Validation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private NaturalPersonDAO naturalPersonDAO;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "NotEmpty");
        if (user.getUserName().length() != 10) {
            errors.rejectValue("userName", "Size.userForm.userName");
        }
        if (!StringUtils.isNumeric(user.getUserName())) {
            errors.rejectValue("userName", "Int.Format.userForm.userName");
        }
        if (!Validation.isValidNationalCode(user.getUserName())) {
            errors.rejectValue("userName", "Format.userForm.userName");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mobileNumber", "NotEmpty");
        if (user.getMobileNumber().length() < 11 || user.getUserName().length() > 11) {
            errors.rejectValue("mobileNumber", "Size.userForm.mobile");
        }
        if (!StringUtils.isNumeric(user.getMobileNumber())) {
            errors.rejectValue("mobileNumber", "Int.Format.userForm.mobile");
        }
        if (!Validation.isValidMobile(user.getMobileNumber())) {
            errors.rejectValue("mobileNumber", "Format.userForm.mobile");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }

        if (!user.getConfirmPassword().equals(user.getPassword())) {
            errors.rejectValue("confirmPassword", "Diff.userForm.passwordConfirm");
        }
    }

    public void bussinessValidate(Object o, Errors errors) {
        User user = (User) o;

        if (userDAO.findByUsername(user.getUserName()) != null) {
            errors.rejectValue("userName", "Duplicate.userForm.userName");
        }

        if (naturalPersonDAO.findByMobile(user.getMobileNumber()) != null) {
            errors.rejectValue("mobileNumber", "Duplicate.userForm.mobile");
        }
    }

    //Login Validation
    public void loginValidate(Object o, Errors errors) {
        User user = (User) o;

        if (userDAO.findByUsername(user.getUserName()) != null) {
            errors.rejectValue("userName", "Duplicate.userForm.userName");
        }

        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }

        if (user.getCaptcha().length() != 6) {
            errors.rejectValue("captcha", "Size.userForm.captcha");
        }
    }
}

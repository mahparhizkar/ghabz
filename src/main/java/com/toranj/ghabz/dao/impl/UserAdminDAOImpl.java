package com.toranj.ghabz.dao.impl;

import com.toranj.ghabz.dao.NaturalPersonDAO;
import com.toranj.ghabz.dao.UserAdminDAO;
import com.toranj.ghabz.dao.UserDAO;
import com.toranj.ghabz.entity.NaturalPerson;
import com.toranj.ghabz.entity.User;
import com.toranj.ghabz.utils.UserStatus;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Transactional
@Component("userAdminDAO")
public class UserAdminDAOImpl implements UserAdminDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private NaturalPersonDAO naturalPersonDAO;

    @Autowired
    private UserDAO userDAO;

    @Override
    public void saveUser(String nationalId, String mobileNumber, String shenase, String pass, String role) {
    try {
        if(userDAO.findByUsername(nationalId)==null) {
            NaturalPerson naturalPerson = new NaturalPerson(UUID.randomUUID().toString(), nationalId, mobileNumber, true);
            if (role.equals("ROLE_Admin")) {
                naturalPerson.setProfileCompletionStatus(true);
            }
            User user = new User();
            user.setId(UUID.randomUUID().toString());
            user.setShenase(shenase);
            user.setFkUserRole(role);
            user.setUserName(nationalId);
            user.setFkPerson(naturalPerson.getId());
            user.setStatus(UserStatus.ACTIVE.value());
            user.setCreationDate(new Date());
            user.setValidFrom(new Date());
            user.setPassword(pass);
            naturalPersonDAO.save(naturalPerson);
            userDAO.save(user);
        }
     }
    catch (Exception e){
        System.out.println("Exception: " + e.getMessage() + " happened!");
        e.printStackTrace();
    }
    }
}

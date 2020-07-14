package com.toranj.ghabz.dao.impl;

import com.toranj.ghabz.dao.UserDAO;
import com.toranj.ghabz.entity.User;
import com.toranj.ghabz.utils.UserStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            User user = userDAO.findByUsername(username);
            System.out.println("User= " + user);

            if (user == null) {
                throw new UsernameNotFoundException("User "
                        + username + " was not found in the database");
            }

            String role = user.getFkUserRole();
            List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
            GrantedAuthority authority = new SimpleGrantedAuthority(role);
            grantList.add(authority);



            boolean enabled = false;
            if (user.getStatus().equals(UserStatus.ACTIVE.value())) {
                enabled = true;
            }
            //TODO: Saeed: Spring Security custom authentication failure handler redirect with parameter
            //Check all this values
            boolean accountNonExpired = true;
            boolean credentialsNonExpired = true;
            boolean accountNonLocked = true;

            UserDetails userDetails = (UserDetails) new org.springframework.security.core.userdetails.User(user.getUserName(),
                    user.getPassword(), enabled, accountNonExpired,
                    credentialsNonExpired, accountNonLocked, grantList);
            return userDetails;
        }
        catch (Exception e) {
            System.out.println("Exception: " + e.getMessage() + " happened!");
            e.printStackTrace();
        }
        return null;

    }
}

package com.toranj.ghabz.config;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthFailureHandler implements AuthenticationFailureHandler {

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

@Override
public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
    try {
        if(exception.getMessage().equals("Bad credentials")){
            redirectStrategy.sendRedirect(request, response, "/login?error=a");
        }
        else if(exception.getMessage().equals("User is disabled")){
            redirectStrategy.sendRedirect(request, response, "/login?error=b");
        }

    }
    catch (Exception e){
        e.printStackTrace();
    }
}

}

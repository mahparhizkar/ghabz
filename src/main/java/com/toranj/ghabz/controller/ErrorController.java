package com.toranj.ghabz.controller;

import com.toranj.ghabz.dao.ErrorDAO;
import com.toranj.ghabz.entity.Error;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.UUID;

@Controller
public class ErrorController {
    @Autowired
    private ErrorDAO errorDAO;

    @RequestMapping(value = "errors", method = RequestMethod.GET)
    public ModelAndView renderErrorPage(HttpServletRequest httpRequest) {
        ModelAndView errorPage = new ModelAndView("errorPage");
        int httpErrorCode = getErrorCode(httpRequest);
        if(httpErrorCode>=400 && httpErrorCode<600){
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if(httpErrorCode != 404 && auth != null && !auth.getName().equals("anonymousUser")){
                errorDAO.save(new Error(UUID.randomUUID().toString(),String.valueOf(httpErrorCode),auth.getName(),new Date(),httpRequest.getRemoteAddr()));
            }
            if (httpErrorCode == 404){
               return new ModelAndView("404");
            }
            else {
                errorPage.addObject("httpErrorCode", httpErrorCode);
            }
        }
        return errorPage;
    }

    private int getErrorCode(HttpServletRequest httpRequest) {
        return (Integer) httpRequest
                .getAttribute("javax.servlet.error.status_code");
    }
}

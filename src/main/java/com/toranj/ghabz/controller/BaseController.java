package com.toranj.ghabz.controller;


import com.toranj.ghabz.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
@Transactional
@EnableWebMvc
@EnableAspectJAutoProxy
public class BaseController {

    @Autowired
    public Environment env;

    @Autowired
    private ResourceBundleMessageSource messageSource;


    protected String getMessage(String code) {
        return messageSource.getMessage(code, null, getUserCurrentLocale());
    }


    private Locale getUserCurrentLocale() {
        return new Locale("fa");
    }


    protected void addErrorMessage(String messageCode) {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session = attr.getRequest().getSession();
        List<String> errors = (List<String>) session.getAttribute(Consts.ERRORS_SESSION_KEY);
        if (errors == null) {
            errors = new ArrayList<>();
        }
        errors.add(getMessage(messageCode));
        session.setAttribute(Consts.ERRORS_SESSION_KEY, errors);
    }


}

package com.farmaciaya.controllers;

import com.farmaciaya.entities.User;
import com.farmaciaya.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by nachogarrone on 13/10/15.
 */
public class BaseController {

    @Autowired
    HttpServletRequest httpServletRequest;

    @Autowired
    UserRepository userRepository;

    public User getCurrentUser() {
        String token = httpServletRequest.getParameter("auth_token");
        if (token == null) return null;
        User user = userRepository.findByToken(token);
        return user;
    }
}

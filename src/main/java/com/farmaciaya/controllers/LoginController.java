package com.farmaciaya.controllers;

import com.farmaciaya.requests.LoginRequest;
import com.farmaciaya.responses.BaseDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by nachogarrone on 8/10/15.
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @RequestMapping(method = RequestMethod.POST)
    public BaseDTO login(LoginRequest loginRequest) {
        BaseDTO baseDTO = new BaseDTO();
        baseDTO.setStatus(BaseDTO.Status.SUCCESS);
        baseDTO.setMessage(loginRequest.getUsername());

        System.out.println(loginRequest.getUsername());

        return baseDTO;
    }
}

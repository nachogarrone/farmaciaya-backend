package com.farmaciaya.controllers;

import com.farmaciaya.entities.User;
import com.farmaciaya.repositories.UserRepository;
import com.farmaciaya.requests.LoginRequest;
import com.farmaciaya.responses.BaseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by nachogarrone on 8/10/15.
 */
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    UserRepository userRepository;

    @RequestMapping(method = RequestMethod.POST)
    public BaseDTO login(@RequestBody LoginRequest loginRequest) {
        BaseDTO baseDTO = new BaseDTO();
        baseDTO.setStatus(BaseDTO.Status.SUCCESS);
        baseDTO.setMessage(loginRequest.getUsername());

        userRepository.save(new User(loginRequest.getUsername(),"lastname"));

        return baseDTO;
    }

    @RequestMapping(method = RequestMethod.GET)
    public BaseDTO getUsers() {
       BaseDTO baseDTO = new BaseDTO();
        baseDTO.setStatus(BaseDTO.Status.SUCCESS);

        for (User user : userRepository.findAll()) {
            baseDTO.setData(baseDTO.getData()+"; " +user.toString());
        }

        return baseDTO;
    }
}

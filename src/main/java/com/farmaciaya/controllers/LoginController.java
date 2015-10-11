package com.farmaciaya.controllers;

import com.farmaciaya.entities.User;
import com.farmaciaya.repositories.UserRepository;
import com.farmaciaya.requests.LoginRequest;
import com.farmaciaya.responses.BaseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

        User user = new User();
        user.setUsername(loginRequest.getUsername());
        user.setFirstname(loginRequest.getUsername());
        user.setPassword(loginRequest.getPassword());
        user.setEmail("someemail");

        userRepository.save(user);

        return baseDTO;
    }

    @RequestMapping(method = RequestMethod.GET)
    public BaseDTO getUsers() {
        BaseDTO baseDTO = new BaseDTO();
        baseDTO.setStatus(BaseDTO.Status.SUCCESS);

        for (User user : userRepository.findAll()) {
            baseDTO.setData(baseDTO.getData() + "; " + user.getUsername());
        }

        return baseDTO;
    }
}

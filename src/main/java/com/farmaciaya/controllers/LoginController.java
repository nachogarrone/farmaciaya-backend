package com.farmaciaya.controllers;

import com.farmaciaya.entities.User;
import com.farmaciaya.repositories.UserRepository;
import com.farmaciaya.requests.LoginRequest;
import com.farmaciaya.requests.RegisterRequest;
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
@RequestMapping("/user/")
public class LoginController {
    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public BaseDTO login(@RequestBody LoginRequest loginRequest) {
        BaseDTO baseDTO = new BaseDTO();

        User user = userRepository.findByUsername(loginRequest.getUsername());
        if(!user.getPassword().equals(loginRequest.getPassword())) {
            baseDTO.setStatus(BaseDTO.Status.ERROR);
            baseDTO.setMessage(BaseDTO.Message.WRONG_PASSWORD);
            return baseDTO;
        }

        baseDTO.setStatus(BaseDTO.Status.SUCCESS);
        return baseDTO;
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public BaseDTO register(@RequestBody RegisterRequest registerRequest) {
        BaseDTO baseDTO = new BaseDTO();
        baseDTO.setStatus(BaseDTO.Status.SUCCESS);

        if (userRepository.findByUsername(registerRequest.getUsername()) != null) {
            User user = new User();
            user.setUsername(registerRequest.getUsername());
            user.setPassword(registerRequest.getPassword());
            user.setFirstname(registerRequest.getFirstname());
            user.setLastname(registerRequest.getLastname());
            user.setEmail(registerRequest.getEmail());
            user.setAddress(registerRequest.getAddress());
            user.setBirthdate(registerRequest.getBirthdate());
            if (userRepository.save(user) != null) {
                baseDTO.setStatus(BaseDTO.Status.SUCCESS);
            } else {
                baseDTO.setStatus(BaseDTO.Status.ERROR);
                baseDTO.setMessage(BaseDTO.Message.UNKNOWN);
            }
        } else {
            baseDTO.setStatus(BaseDTO.Status.ERROR);
            baseDTO.setMessage(BaseDTO.Message.USERNAME_TAKEN);
        }

        return baseDTO;
    }
}

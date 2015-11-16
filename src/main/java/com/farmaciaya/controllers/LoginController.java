package com.farmaciaya.controllers;

import com.farmaciaya.entities.User;
import com.farmaciaya.repositories.UserRepository;
import com.farmaciaya.requests.LoginRequest;
import com.farmaciaya.requests.RegisterRequest;
import com.farmaciaya.responses.BaseDTO;
import com.farmaciaya.responses.LoginResponse;
import com.farmaciaya.security.TokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;

/**
 * Created by nachogarrone on 8/10/15.
 */
@RestController
@RequestMapping("/user/")
public class LoginController extends BaseController{

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public BaseDTO login(@RequestParam(value = "username") String username, @RequestParam(value = "password") String
            password) {
        BaseDTO baseDTO = new BaseDTO();

        User user = userRepository.findByUsername(username);
        if (!user.getPassword().equals(password)) {
            baseDTO.setStatus(BaseDTO.Status.ERROR);
            baseDTO.setMessage(BaseDTO.Message.WRONG_PASSWORD);
            return baseDTO;
        }

        String token = TokenGenerator.nextSessionId();
        user.setToken(token);
        user.setToken_created(Calendar.getInstance().getTime());
        userRepository.save(user);

        baseDTO.setStatus(BaseDTO.Status.SUCCESS);
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(token);
        loginResponse.setFirstname(user.getFirstname());
        loginResponse.setLastname(user.getLastname());

        baseDTO.setData(loginResponse);
        return baseDTO;
    }

     @RequestMapping(value = "register", method = RequestMethod.POST)
    public BaseDTO register(@RequestBody RegisterRequest registerRequest) {
        BaseDTO baseDTO = new BaseDTO();
        baseDTO.setStatus(BaseDTO.Status.SUCCESS);

        if (userRepository.findByUsername(registerRequest.getUsername()) == null) {
            User user = new User();
            user.setUsername(registerRequest.getUsername());
            user.setPassword(registerRequest.getPassword());
            user.setFirstname(registerRequest.getFirstname());
            user.setLastname(registerRequest.getLastname());
            user.setEmail(registerRequest.getEmail());
            user.setAddress(registerRequest.getAddress());
            user.setBirthdate(registerRequest.getBirthdate());
            user.setPhone(registerRequest.getPhone());
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
   
   
   @RequestMapping(value = "getuser", method = RequestMethod.POST)
    public BaseDTO getuser(@RequestParam(value = "auth_token") String auth_token) {
        BaseDTO baseDTO = new BaseDTO();
        baseDTO.setStatus(BaseDTO.Status.SUCCESS);
        User user = userRepository.findByToken(auth_token);
        if ( user != null) {
            baseDTO.setData(user);
        } else {
            baseDTO.setStatus(BaseDTO.Status.ERROR);
            baseDTO.setMessage(BaseDTO.Message.UNKNOWN);
        }
        return baseDTO;
    }
   
   
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public BaseDTO update(@RequestBody RegisterRequest registerRequest) {
        BaseDTO baseDTO = new BaseDTO();
        baseDTO.setStatus(BaseDTO.Status.SUCCESS);
        User user = userRepository.findByUsername(registerRequest.getUsername());
        if (user != null) {
            //user.setUsername(registerRequest.getUsername());
            user.setPassword(registerRequest.getPassword());
            user.setFirstname(registerRequest.getFirstname());
            user.setLastname(registerRequest.getLastname());
            user.setEmail(registerRequest.getEmail());
            user.setAddress(registerRequest.getAddress());
            user.setBirthdate(registerRequest.getBirthdate());
            user.setPhone(registerRequest.getPhone());
            if (userRepository.save(user) != null) {
                baseDTO.setStatus(BaseDTO.Status.SUCCESS);
            } else {
                baseDTO.setStatus(BaseDTO.Status.ERROR);
                baseDTO.setMessage(BaseDTO.Message.UNKNOWN);
            }
        } else {
            baseDTO.setStatus(BaseDTO.Status.ERROR);
            baseDTO.setMessage(BaseDTO.Message.NOT_FOUND);
        }

        return baseDTO;
    }
}

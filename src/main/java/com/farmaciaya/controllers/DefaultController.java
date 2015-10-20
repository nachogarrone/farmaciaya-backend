package com.farmaciaya.controllers;

import com.farmaciaya.responses.BaseDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by nachogarrone on 20/10/15.
 */
@RestController
@RequestMapping("")
public class DefaultController extends BaseController {
    @RequestMapping("")
    public BaseDTO greeting() {
        BaseDTO response = new BaseDTO();
        response.setMessage("FarmaciaYa RESTful API");
        response.setStatus(BaseDTO.Status.SUCCESS);
        return response;
    }
}

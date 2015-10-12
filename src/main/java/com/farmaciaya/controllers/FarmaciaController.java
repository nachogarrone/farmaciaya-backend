package com.farmaciaya.controllers;

import com.farmaciaya.repositories.FarmaciaRepository;
import com.farmaciaya.responses.BaseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by nachogarrone on 12/10/15.
 */@RestController
   @RequestMapping("/farmacia/")
   public class FarmaciaController {

    @Autowired
    FarmaciaRepository farmaciaRepository;

    @RequestMapping(value = "all/{page}", method = RequestMethod.GET)
    public BaseDTO getFarmacias(@PathVariable Integer page) {
        BaseDTO baseDTO = new BaseDTO();
        baseDTO.setStatus(BaseDTO.Status.SUCCESS);
        baseDTO.setData(farmaciaRepository.findAll(new PageRequest(page, 50)));
        return baseDTO;
    }

    @RequestMapping(value = "search/{name}", method = RequestMethod.GET)
    public BaseDTO getFarmacia(@PathVariable String name) {
        BaseDTO baseDTO = new BaseDTO();
        baseDTO.setStatus(BaseDTO.Status.SUCCESS);
        baseDTO.setData(farmaciaRepository.findByNombre("%" + name + "%"));
        return baseDTO;
    }
}

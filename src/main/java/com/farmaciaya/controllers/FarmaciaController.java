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
 */
@RestController
@RequestMapping("/farmacia/")
public class FarmaciaController extends BaseController{

    @Autowired
    FarmaciaRepository farmaciaRepository;

    @RequestMapping(value = "all/{page}", method = RequestMethod.GET)
    public BaseDTO getFarmacias(@PathVariable Integer page) {
        BaseDTO baseDTO = new BaseDTO();
        baseDTO.setStatus(BaseDTO.Status.SUCCESS);
        baseDTO.setData(farmaciaRepository.findAll(new PageRequest(page, 50)));
        return baseDTO;
    }

    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public BaseDTO getFarmaciaById(@PathVariable Integer id) {
        BaseDTO baseDTO = new BaseDTO();
        baseDTO.setStatus(BaseDTO.Status.SUCCESS);
        baseDTO.setData(farmaciaRepository.findOne(id));
        return baseDTO;
    }

    @RequestMapping(value = "search/{name}", method = RequestMethod.GET)
    public BaseDTO getFarmacia(@PathVariable String name) {
        BaseDTO baseDTO = new BaseDTO();
        baseDTO.setStatus(BaseDTO.Status.SUCCESS);
        baseDTO.setData(farmaciaRepository.findByNombre("%" + name + "%"));
        return baseDTO;
    }

//    @RequestMapping(value = "valuate/{id}/{value}", method = RequestMethod.POST)
//    public BaseDTO valuateFarmacia(@PathVariable Integer id, @PathVariable Integer value) {
//        BaseDTO baseDTO = new BaseDTO();
//
//        Farmacia farmacia = farmaciaRepository.findOne(id);
//        if (farmacia == null) {
//            baseDTO.setStatus(BaseDTO.Status.ERROR);
//            baseDTO.setMessage(BaseDTO.Message.NOT_FOUND);
//            return baseDTO;
//        }
//        if (farmacia.getValoracion() == null) farmacia.setValoracion((float) value);
//        farmacia.setValoracion((farmacia.getValoracion() + value) / 2);
//        farmaciaRepository.save(farmacia);
//        baseDTO.setStatus(BaseDTO.Status.SUCCESS);
//
//        return baseDTO;
//    }
}

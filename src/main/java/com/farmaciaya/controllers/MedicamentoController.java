package com.farmaciaya.controllers;

import com.farmaciaya.repositories.MedicamentoRepository;
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
@RequestMapping("/medicamento/")
public class MedicamentoController {

    @Autowired
    MedicamentoRepository medicamentoRepository;

    @RequestMapping(value = "all/{page}", method = RequestMethod.GET)
    public BaseDTO getMedicamentos(@PathVariable Integer page) {
        BaseDTO baseDTO = new BaseDTO();
        baseDTO.setStatus(BaseDTO.Status.SUCCESS);
        baseDTO.setData(medicamentoRepository.findAll(new PageRequest(page, 50)));
        return baseDTO;
    }

    @RequestMapping(value = "search/{name}", method = RequestMethod.GET)
    public BaseDTO getMedicamento(@PathVariable String name) {
        BaseDTO baseDTO = new BaseDTO();
        baseDTO.setStatus(BaseDTO.Status.SUCCESS);
        baseDTO.setData(medicamentoRepository.findByNombre("%" + name + "%"));
        return baseDTO;
    }
}

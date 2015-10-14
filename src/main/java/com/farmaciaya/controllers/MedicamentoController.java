package com.farmaciaya.controllers;

import com.farmaciaya.entities.User;
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
public class MedicamentoController extends BaseController {

    @Autowired
    MedicamentoRepository medicamentoRepository;

    @RequestMapping(value = "all/{page}", method = RequestMethod.GET)
    public BaseDTO getMedicamentos(@PathVariable Integer page) {
        BaseDTO baseDTO = new BaseDTO();
        User user = getCurrentUser();
        if (user == null) {
            baseDTO.setStatus(BaseDTO.Status.ERROR);
            baseDTO.setMessage(BaseDTO.Message.UNATHENTICATED.toString());
            return baseDTO;
        }

        baseDTO.setStatus(BaseDTO.Status.SUCCESS);
        baseDTO.setData(medicamentoRepository.findAll(new PageRequest(page, 50)));
        return baseDTO;
    }

    @RequestMapping(value = "search/{name}", method = RequestMethod.GET)
    public BaseDTO searchMedicamento(@PathVariable String name) {
        BaseDTO baseDTO = new BaseDTO();
        User user = getCurrentUser();
        if (user == null) {
            baseDTO.setStatus(BaseDTO.Status.ERROR);
            baseDTO.setMessage(BaseDTO.Message.UNATHENTICATED.toString());
            return baseDTO;
        }

        baseDTO.setStatus(BaseDTO.Status.SUCCESS);
        baseDTO.setData(medicamentoRepository.findByNombre("%" + name + "%"));
        return baseDTO;
    }

    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public BaseDTO getMedicamento(@PathVariable Integer id) {
        BaseDTO baseDTO = new BaseDTO();
        User user = getCurrentUser();
        if (user == null) {
            baseDTO.setStatus(BaseDTO.Status.ERROR);
            baseDTO.setMessage(BaseDTO.Message.UNATHENTICATED.toString());
            return baseDTO;
        }

        baseDTO.setStatus(BaseDTO.Status.SUCCESS);
        baseDTO.setData(medicamentoRepository.findOne(id));
        return baseDTO;
    }
}

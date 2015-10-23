package com.farmaciaya.controllers;

import com.farmaciaya.email.EmailSender;
import com.farmaciaya.entities.Compra;
import com.farmaciaya.entities.Farmacia;
import com.farmaciaya.entities.Medicamento;
import com.farmaciaya.entities.User;
import com.farmaciaya.repositories.CompraRepository;
import com.farmaciaya.repositories.FarmaciaRepository;
import com.farmaciaya.repositories.MedicamentoRepository;
import com.farmaciaya.requests.CompraItem;
import com.farmaciaya.requests.CompraRequest;
import com.farmaciaya.responses.BaseDTO;
import com.wordnik.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.util.*;

/**
 * Created by nachogarrone on 20/10/15.
 */
@Api(basePath = "/compra", value = "compra", description = "CRUD para compras", produces = "application/json")
@RestController
@RequestMapping("/compra/")
public class CompraController extends BaseController {
    @Autowired
    CompraRepository compraRepository;
    @Autowired
    MedicamentoRepository medicamentoRepository;
    @Autowired
    FarmaciaRepository farmaciaRepository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public BaseDTO getCompras() {
        BaseDTO baseDTO = new BaseDTO();
        User user = getCurrentUser();
        if (user == null) {
            baseDTO.setStatus(BaseDTO.Status.ERROR);
            baseDTO.setMessage(BaseDTO.Message.UNATHENTICATED.toString());
            return baseDTO;
        }

        baseDTO.setStatus(BaseDTO.Status.SUCCESS);
        baseDTO.setData(compraRepository.findByUser(user));
        return baseDTO;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public BaseDTO saveCompras(@RequestBody() CompraRequest compraRequest) {
        BaseDTO baseDTO = new BaseDTO();
        User user = getCurrentUser();
        if (user == null) {
            baseDTO.setStatus(BaseDTO.Status.ERROR);
            baseDTO.setMessage(BaseDTO.Message.UNATHENTICATED.toString());
            return baseDTO;
        }

        // ARMAR 1 COMPRA POR CADA FARMACIA
        HashMap<Farmacia, List<Medicamento>> compras = new HashMap<>();
        for (CompraItem compraItem : compraRequest.getCompraItems()) {
            Farmacia farmacia = farmaciaRepository.findOne(compraItem.getIdFarmacia());
            if (farmacia != null) {
                if (!compras.containsKey(farmacia)) compras.put(farmacia, new ArrayList<>());
                Medicamento medicamento = medicamentoRepository.findOne(compraItem.getIdMedicamento());
                if (medicamento != null) {
                    compras.get(farmacia).add(medicamento);
                }
            }
        }

        for (Map.Entry<Farmacia, List<Medicamento>> next : compras.entrySet()) {
            Compra compra = new Compra();
            compra.setUser(user);
            compra.setDate(Calendar.getInstance().getTime());
            compra.setMedicamentos(next.getValue());
            compra.setFarmacia(next.getKey());

            compraRepository.save(compra);
        }

        try {
            if (user.getEmail() != null && user.getEmail().length() > 0) {
                EmailSender.sendMail(user.getEmail(), "Compra realizada con éxito!", "Hola, hemos registrado su compra " +
                        "exitosamente. A la brevedad recibirá su pedido.");
            }
        } catch (MessagingException e) {
            baseDTO.setMessage("Error al enviar email");
            baseDTO.setStatus(BaseDTO.Status.ERROR);
            return baseDTO;
        }
        baseDTO.setStatus(BaseDTO.Status.SUCCESS);
        return baseDTO;
    }
}

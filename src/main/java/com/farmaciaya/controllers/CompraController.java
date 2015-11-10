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
import com.farmaciaya.responses.BaseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.*;

/**
 * Created by nachogarrone on 20/10/15.
 */
@RestController
@RequestMapping("/compra/")
public class CompraController extends BaseController {
    @Autowired
    CompraRepository compraRepository;
    @Autowired
    MedicamentoRepository medicamentoRepository;
    @Autowired
    FarmaciaRepository farmaciaRepository;

    @RequestMapping(value = "get", method = RequestMethod.GET)
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

    @RequestMapping(value = "valuate/{id}/{value}", method = RequestMethod.POST)
    public BaseDTO valuateCompra(@PathVariable Integer id, @PathVariable Integer value) {
        BaseDTO baseDTO = new BaseDTO();

        Compra compra = compraRepository.findOne(id);
        if (compra == null) {
            baseDTO.setStatus(BaseDTO.Status.ERROR);
            baseDTO.setMessage(BaseDTO.Message.NOT_FOUND);
            return baseDTO;
        }

        if (compra.getValoracion() != null) {
            baseDTO.setStatus(BaseDTO.Status.ERROR);
            baseDTO.setMessage("ALREADYVALUATED");
            return baseDTO;
        }

        compra.setValoracion(value);
        compra.getFarmacia().setValoraciones(compra.getFarmacia().getValoraciones() + 1);
        compra.getFarmacia().setValoracion(compra.getFarmacia().getValoracion() + value);
        compraRepository.save(compra);

        baseDTO.setStatus(BaseDTO.Status.SUCCESS);
        return baseDTO;
    }

    @RequestMapping(value = "comprar", method = RequestMethod.POST)
    public BaseDTO saveCompras(@RequestBody CompraItem[] compraItems) {
        BaseDTO baseDTO = new BaseDTO();
        User user = getCurrentUser();
        if (user == null) {
            baseDTO.setStatus(BaseDTO.Status.ERROR);
            baseDTO.setMessage(BaseDTO.Message.UNATHENTICATED.toString());
            return baseDTO;
        }

        // ARMAR 1 COMPRA POR CADA FARMACIA
        HashMap<Farmacia, List<Medicamento>> compras = new HashMap<>();
        for (CompraItem compraItem : compraItems) {
            Farmacia farmacia = farmaciaRepository.findOne(compraItem.getFarmaciaId());
            if (farmacia != null) {
                if (!compras.containsKey(farmacia)) compras.put(farmacia, new ArrayList<Medicamento>());
                Medicamento medicamento = medicamentoRepository.findOne(Integer.valueOf(compraItem.getMedicamentoId()));
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

            compra = compraRepository.save(compra);
            baseDTO.setData(compra.getCompra_id());
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

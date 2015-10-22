package com.farmaciaya.responses;

import java.util.Date;
import java.util.List;

/**
 * Created by nachogarrone on 22/10/15.
 */
public class CompraResponse {
    String farmacia_name;
    Integer total_compra;
    Date fecha_compra;
    List<MedicamentoCompraResponse> medicamentos;

    public String getFarmacia_name() {
        return farmacia_name;
    }

    public void setFarmacia_name(String farmacia_name) {
        this.farmacia_name = farmacia_name;
    }

    public Integer getTotal_compra() {
        return total_compra;
    }

    public void setTotal_compra(Integer total_compra) {
        this.total_compra = total_compra;
    }

    public Date getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(Date fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public List<MedicamentoCompraResponse> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<MedicamentoCompraResponse> medicamentos) {
        this.medicamentos = medicamentos;
    }
}

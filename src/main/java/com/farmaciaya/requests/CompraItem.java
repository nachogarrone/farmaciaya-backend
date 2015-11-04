package com.farmaciaya.requests;

/**
 * Created by nachogarrone on 20/10/15.
 */
public class CompraItem {
    String medicamentoId;
    Integer farmaciaId;

    public CompraItem(String medicamentoId, Integer farmaciaId) {

        this.medicamentoId = medicamentoId;
        this.farmaciaId = farmaciaId;
    }

    public String getMedicamentoId() {
        return medicamentoId;
    }

    public void setMedicamentoId(String medicamentoId) {
        this.medicamentoId = medicamentoId;
    }

    public Integer getFarmaciaId() {
        return farmaciaId;
    }

    public void setFarmaciaId(Integer farmaciaId) {
        this.farmaciaId = farmaciaId;
    }
}

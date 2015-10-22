package com.farmaciaya.requests;

/**
 * Created by nachogarrone on 20/10/15.
 */
public class CompraItem {
    Integer idMedicamento;
    Integer idFarmacia;

    public CompraItem(Integer idMedicamento, Integer idFarmacia) {
        this.idMedicamento = idMedicamento;
        this.idFarmacia = idFarmacia;
    }

    public Integer getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(Integer idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public Integer getIdFarmacia() {
        return idFarmacia;
    }

    public void setIdFarmacia(Integer idFarmacia) {
        this.idFarmacia = idFarmacia;
    }
}

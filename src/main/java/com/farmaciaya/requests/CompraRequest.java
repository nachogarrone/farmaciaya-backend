package com.farmaciaya.requests;

import java.util.List;

/**
 * Created by nachogarrone on 20/10/15.
 */
public class CompraRequest {
    List<CompraItem> compraItems;

    public List<CompraItem> getCompraItems() {
        return compraItems;
    }

    public void setCompraItems(List<CompraItem> compraItems) {
        this.compraItems = compraItems;
    }
}

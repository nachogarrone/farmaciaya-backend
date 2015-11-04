package com.farmaciaya.requests;

/**
 * Created by nachogarrone on 20/10/15.
 */
public class CompraRequest {
    CompraItem[] compraItems;

    public CompraItem[] getCompraItems() {
        return compraItems;
    }

    public void setCompraItems(CompraItem[] compraItems) {
        this.compraItems = compraItems;
    }
}

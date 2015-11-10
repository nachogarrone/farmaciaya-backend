package com.farmaciaya.requests;

import java.util.List;

/**
 * Created by nachogarrone on 10/11/15.
 */
public class CompraWrapper {
    List<CompraItem> compras;
    String auth_token;

    public String getAuth_token() {
        return auth_token;
    }

    public void setAuth_token(String auth_token) {
        this.auth_token = auth_token;
    }

    public List<CompraItem> getCompras() {
        return compras;
    }

    public void setCompras(List<CompraItem> compras) {
        this.compras = compras;
    }
}

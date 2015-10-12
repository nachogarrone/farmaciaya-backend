package com.farmaciaya.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by nachogarrone on 12/10/15.
 */
@Entity
public class Medicamento {
    @Id
    Integer id_medicamento;
    String nombre;
    String concentracion;
    String forma;
    String forma_simplificada;
    String presentacion;
    Integer fracciones;
    Date vencimiento;
    String id_sanitario;
    String nombre_titular;
    Double precio;

    public Integer getId_medicamento() {
        return id_medicamento;
    }

    public void setId_medicamento(Integer id_medicamento) {
        this.id_medicamento = id_medicamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getConcentracion() {
        return concentracion;
    }

    public void setConcentracion(String concentracion) {
        this.concentracion = concentracion;
    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

    public String getForma_simplificada() {
        return forma_simplificada;
    }

    public void setForma_simplificada(String forma_simplificada) {
        this.forma_simplificada = forma_simplificada;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public Integer getFracciones() {
        return fracciones;
    }

    public void setFracciones(Integer fracciones) {
        this.fracciones = fracciones;
    }

    public Date getVencimiento() {
        return vencimiento;
    }

    public void setVencimiento(Date vencimiento) {
        this.vencimiento = vencimiento;
    }

    public String getId_sanitario() {
        return id_sanitario;
    }

    public void setId_sanitario(String id_sanitario) {
        this.id_sanitario = id_sanitario;
    }

    public String getNombre_titular() {
        return nombre_titular;
    }

    public void setNombre_titular(String nombre_titular) {
        this.nombre_titular = nombre_titular;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}

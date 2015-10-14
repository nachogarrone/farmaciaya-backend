package com.farmaciaya.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by nachogarrone on 12/10/15.
 */
@Entity
public class Medicamento {
    @Id
    private Integer id_medicamento;
    private String nombre;
    private String concentracion;
    private String forma;
    private String forma_simplificada;
    private String presentacion;
    private Integer fracciones;
    private Date vencimiento;
    private String id_sanitario;
    private String nombre_titular;
    private Double precio;

    @ManyToMany
    @JoinTable(name = "farmacia_medicamento",
            joinColumns={@JoinColumn(name="id_medicamento", referencedColumnName="id_medicamento")},
            inverseJoinColumns={@JoinColumn(name="id_farmacia", referencedColumnName="id_farmacia")})
    private List<Farmacia> farmacias;

    public List<Farmacia> getFarmacias() {
        return farmacias;
    }

    public void setFarmacias(List<Farmacia> farmacias) {
        this.farmacias = farmacias;
    }

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

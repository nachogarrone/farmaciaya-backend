package com.farmaciaya.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by nachogarrone on 12/10/15.
 */
@Entity
public class Farmacia {
    @Id
    Integer farmacia_id;
    String nombre;
    String direccion;
    String telefono;
    String localidad;
    Float latitud;
    Float longitud;
    Float valoracion;

    public Float getValoracion() {
        return valoracion;
    }

    public void setValoracion(Float valoracion) {
        this.valoracion = valoracion;
    }

    public Float getLatitud() {
        return latitud;
    }

    public void setLatitud(Float latitud) {
        this.latitud = latitud;
    }

    public Float getLongitud() {
        return longitud;
    }

    public void setLongitud(Float longitud) {
        this.longitud = longitud;
    }

    public Integer getFarmacia_id() {
        return farmacia_id;
    }

    public void setFarmacia_id(Integer farmacia_id) {
        this.farmacia_id = farmacia_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }
}

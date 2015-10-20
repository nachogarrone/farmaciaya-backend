package com.farmaciaya.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by nachogarrone on 12/10/15.
 */
@Entity
public class Farmacia {
    @Id
    Integer id_farmacia;
    String nombre;
    String direccion;
    String telefono;
    String localidad;
    Float latitud;
    Float longitud;

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

    public Integer getId_farmacia() {
        return id_farmacia;
    }

    public void setId_farmacia(Integer id_farmacia) {
        this.id_farmacia = id_farmacia;
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

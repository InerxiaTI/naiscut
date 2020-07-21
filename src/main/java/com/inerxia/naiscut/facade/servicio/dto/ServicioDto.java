package com.inerxia.naiscut.facade.servicio.dto;

import com.inerxia.naiscut.facade.salon.dto.SedeDto;

public class ServicioDto {

    private Integer id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private Integer duracion;
    private char estado;
    private SedeDto sedeFk;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public SedeDto getSedeFk() {
        return sedeFk;
    }

    public void setSedeFk(SedeDto sedeFk) {
        this.sedeFk = sedeFk;
    }
}

package com.inerxia.naiscut.facade.cita.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class MetodoPagoDto {
    private Integer id;

    @NotNull
    @Size(max = 50)
    private String descripcion;

    @NotNull
    @Size(max = 1)
    private char estado;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "MetodoPagoDto{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", estado=" + estado +
                '}';
    }
}

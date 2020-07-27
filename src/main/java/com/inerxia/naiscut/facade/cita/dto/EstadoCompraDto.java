package com.inerxia.naiscut.facade.cita.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class EstadoCompraDto {
    private Integer id;

    @NotNull
    @Size(max = 50)
    private String descripcion;

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

    @Override
    public String toString() {
        return "EstadoCompraDto{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}

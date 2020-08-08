package com.inerxia.naiscut.facade.cliente.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RolDto {
    private Integer id;
    @NotNull
    @Size(max = 100)
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
}

package com.inerxia.naiscut.facade.cliente.dto;

public class GeneroDto {
    private Integer id;
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
        return "GeneroDto{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}

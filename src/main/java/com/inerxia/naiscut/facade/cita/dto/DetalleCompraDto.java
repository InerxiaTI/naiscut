package com.inerxia.naiscut.facade.cita.dto;

import com.inerxia.naiscut.facade.servicio.dto.ServicioDto;

import javax.persistence.criteria.CriteriaBuilder;

public class DetalleCompraDto {
    private Integer id;
    private ServicioDto servicioFk;
    private Double precio;
    private Integer duracion;
    private CompraDto compraFk;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ServicioDto getServicioFk() {
        return servicioFk;
    }

    public void setServicioFk(ServicioDto servicioFk) {
        this.servicioFk = servicioFk;
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

    public CompraDto getCompraFk() {
        return compraFk;
    }

    public void setCompraFk(CompraDto compraFk) {
        this.compraFk = compraFk;
    }
}

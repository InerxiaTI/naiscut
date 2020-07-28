package com.inerxia.naiscut.facade.cita.dto;

import com.inerxia.naiscut.facade.servicio.dto.ServicioDto;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.NotNull;

public class DetalleCompraDto {
    private Integer id;
    private ServicioDto servicioFk;

    @NotNull
    private Double precio;

    @NotNull
    private Integer duracion;

    private CompraDto compraFk;

    @NotNull
    private Integer idServicioFk;

    @NotNull
    private Integer idCompraFk;

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

    public Integer getIdServicioFk() {
        return idServicioFk;
    }

    public void setIdServicioFk(Integer idServicioFk) {
        this.idServicioFk = idServicioFk;
    }

    public Integer getIdCompraFk() {
        return idCompraFk;
    }

    public void setIdCompraFk(Integer idCompraFk) {
        this.idCompraFk = idCompraFk;
    }
}

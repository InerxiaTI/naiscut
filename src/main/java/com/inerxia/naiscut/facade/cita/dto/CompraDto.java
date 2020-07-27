package com.inerxia.naiscut.facade.cita.dto;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class CompraDto {
    private Integer id;
    private CitaDto citaFk;

    @NotNull
    private Double valorTotal;

    private MetodoPagoDto metodoPagoFk;
    private EstadoCompraDto estadoCompraFk;

    @NotNull
    private LocalDateTime fechaPago;

    @NotNull
    private Integer idCitaFk;

    @NotNull
    private Integer idMetodoPagoFk;

    @NotNull
    private Integer idEstadoCompraFk;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CitaDto getCitaFk() {
        return citaFk;
    }

    public void setCitaFk(CitaDto citaFk) {
        this.citaFk = citaFk;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public MetodoPagoDto getMetodoPagoFk() {
        return metodoPagoFk;
    }

    public void setMetodoPagoFk(MetodoPagoDto metodoPagoFk) {
        this.metodoPagoFk = metodoPagoFk;
    }

    public EstadoCompraDto getEstadoCompraFk() {
        return estadoCompraFk;
    }

    public void setEstadoCompraFk(EstadoCompraDto estadoCompraFk) {
        this.estadoCompraFk = estadoCompraFk;
    }

    public LocalDateTime getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDateTime fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Integer getIdCitaFk() {
        return idCitaFk;
    }

    public void setIdCitaFk(Integer idCitaFk) {
        this.idCitaFk = idCitaFk;
    }

    public Integer getIdMetodoPagoFk() {
        return idMetodoPagoFk;
    }

    public void setIdMetodoPagoFk(Integer idMetodoPagoFk) {
        this.idMetodoPagoFk = idMetodoPagoFk;
    }

    public Integer getIdEstadoCompraFk() {
        return idEstadoCompraFk;
    }

    public void setIdEstadoCompraFk(Integer idEstadoCompraFk) {
        this.idEstadoCompraFk = idEstadoCompraFk;
    }

    @Override
    public String toString() {
        return "CompraDto{" +
                "id=" + id +
                ", citaFk=" + citaFk +
                ", valorTotal=" + valorTotal +
                ", metodoPagoFk=" + metodoPagoFk +
                ", estadoCompraFk=" + estadoCompraFk +
                ", fechaPago=" + fechaPago +
                '}';
    }
}

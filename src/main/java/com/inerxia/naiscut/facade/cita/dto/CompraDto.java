package com.inerxia.naiscut.facade.cita.dto;

import java.time.LocalDateTime;

public class CompraDto {
    private Integer id;
    private CitaDto citaFk;
    private Double valorTotal;
    private MetodoPagoDto metodoPagoFk;
    private EstadoCompraDto estadoCompraFk;
    private LocalDateTime fechaPago;

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

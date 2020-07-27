package com.inerxia.naiscut.model.cita;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "compra")
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CITA_ID_FK",insertable = false, updatable = false, nullable = false)
    private Cita citaFk;

    @Column(name = "VALOR_TOTAL", nullable = false)
    private Double valorTotal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "METODO_PAGO_FK",insertable = false, updatable = false, nullable = false)
    private MetodoPago metodoPagoFk;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ESTADO_COMPRA_FK",insertable = false, updatable = false, nullable = false)
    private EstadoCompra estadoCompraFk;

    @Column(name = "FECHA_PAGO", nullable = false)
    private LocalDateTime fechaPago;

    @Column(name = "CITA_ID_FK", nullable = false)
    private Integer idCitaFk;

    @Column(name = "METODO_PAGO_FK", nullable = false)
    private Integer idMetodoPagoFk;

    @Column(name = "ESTADO_COMPRA_FK", nullable = false)
    private Integer idEstadoCompraFk;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cita getCitaFk() {
        return citaFk;
    }

    public void setCitaFk(Cita citaFk) {
        this.citaFk = citaFk;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public MetodoPago getMetodoPagoFk() {
        return metodoPagoFk;
    }

    public void setMetodoPagoFk(MetodoPago metodoPagoFk) {
        this.metodoPagoFk = metodoPagoFk;
    }

    public EstadoCompra getEstadoCompraFk() {
        return estadoCompraFk;
    }

    public void setEstadoCompraFk(EstadoCompra estadoCompraFk) {
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
}

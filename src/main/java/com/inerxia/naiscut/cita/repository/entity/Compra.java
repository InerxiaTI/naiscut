package com.inerxia.naiscut.cita.repository.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "COMPRA")
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CITA_ID_FK",insertable = false, updatable = false)
    private Cita citaFk;

    @NotNull
    @Column(name = "VALOR_TOTAL")
    private Double valorTotal;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "METODO_PAGO_FK",insertable = false, updatable = false)
    private MetodoPago metodoPagoFk;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ESTADO_COMPRA_FK",insertable = false, updatable = false)
    private EstadoCompra estadoCompraFk;

    @NotNull
    @Column(name = "FECHA_PAGO")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime fechaPago;

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
}

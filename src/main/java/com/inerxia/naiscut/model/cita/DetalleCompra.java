package com.inerxia.naiscut.model.cita;

import com.inerxia.naiscut.model.servicio.Servicio;

import javax.persistence.*;

@Entity
@Table(name = "detalle_compra")
public class DetalleCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SERVICIO_ID_FK",insertable = false, updatable = false, nullable = false)
    private Servicio servicioFk;

    @Column(name = "PRECIO", nullable = false)
    private Double precio;
    @Column(name = "DURACION", nullable = false)
    private Integer duracion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMPRA_FK",insertable = false, updatable = false, nullable = false)
    private Compra comparaFk;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Servicio getServicioFk() {
        return servicioFk;
    }

    public void setServicioFk(Servicio servicioFk) {
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

    public Compra getComparaFk() {
        return comparaFk;
    }

    public void setComparaFk(Compra comparaFk) {
        this.comparaFk = comparaFk;
    }
}

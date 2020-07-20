package com.inerxia.naiscut.servicio.repository.entity;

import com.inerxia.naiscut.salon.repository.entity.Sede;

import javax.persistence.*;

@Table(name = "SERVICIO")
@Entity
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "PRECIO", nullable = false)
    private Double precio;

    @Column(name = "DURACION", nullable = false)
    private Integer duracion;

    @Column(name = "ESTADO", nullable = false)
    private char estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="SEDE_FK", insertable = false, updatable = false, nullable = false)
    private Sede sedeFk;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public Sede getSedeFk() {
        return sedeFk;
    }

    public void setSedeFk(Sede sedeFk) {
        this.sedeFk = sedeFk;
    }
}

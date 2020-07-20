package com.inerxia.naiscut.cita.repository.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "METODO_PAGO")
public class MetodoPago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @NotNull
    @Column(name = "ESTADO")
    private char estado;

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

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }
}

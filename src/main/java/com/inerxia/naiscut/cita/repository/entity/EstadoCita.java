package com.inerxia.naiscut.cita.repository.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "ESTADO_CITA")
public class EstadoCita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "DESCRIPCION", nullable = false)
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
}

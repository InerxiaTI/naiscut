package com.inerxia.naiscut.empleado.repository.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "EMPLEADO_ROL")
public class EmpleadoRol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name = "DESCRIPCION")
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

package com.inerxia.naiscut.empleado.repository.entity;

import com.inerxia.naiscut.cliente.repository.entity.Persona;
import com.inerxia.naiscut.salon.repository.entity.Sede;
import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "EMPLEADO")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERSONA_FK",insertable = false, updatable = false)
    private Persona personaFk;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROL_ID_FK",insertable = false, updatable = false)
    private EmpleadoRol rolFk;

    @NotNull
    @Column(name = "DISPONIBLE")
    private char disponible;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SEDE_ID_FK",insertable = false, updatable = false)
    private Sede sedeFk;



}

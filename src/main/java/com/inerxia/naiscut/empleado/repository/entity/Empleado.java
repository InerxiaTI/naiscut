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
    @Column(name = "ID")
    private Integer id;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERSONA_FK",insertable = false, updatable = false)
    private Persona personaFk;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROL_ID_FK",insertable = false, updatable = false)
    private EmpleadoRol rolFk;

    @NotNull
    @Column(name = "DISPONIBLE")
    private char disponible;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SEDE_ID_FK",insertable = false, updatable = false)
    private Sede sedeFk;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Persona getPersonaFk() {
        return personaFk;
    }

    public void setPersonaFk(Persona personaFk) {
        this.personaFk = personaFk;
    }

    public EmpleadoRol getRolFk() {
        return rolFk;
    }

    public void setRolFk(EmpleadoRol rolFk) {
        this.rolFk = rolFk;
    }

    public char getDisponible() {
        return disponible;
    }

    public void setDisponible(char disponible) {
        this.disponible = disponible;
    }

    public Sede getSedeFk() {
        return sedeFk;
    }

    public void setSedeFk(Sede sedeFk) {
        this.sedeFk = sedeFk;
    }
}

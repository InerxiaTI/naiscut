package com.inerxia.naiscut.model.empleado;

import com.inerxia.naiscut.model.cliente.Persona;
import com.inerxia.naiscut.model.salon.Sede;

import javax.persistence.*;

@Entity
@Table(name = "empleado")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERSONA_FK",
                insertable = false,
                updatable = false,
                nullable = false,
                unique = true)
    private Persona personaFk;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROL_ID_FK",insertable = false, updatable = false, nullable = false)
    private EmpleadoRol rolFk;

    @Column(name = "DISPONIBLE", nullable = false)
    private char disponible;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SEDE_ID_FK",insertable = false, updatable = false, nullable = false)
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

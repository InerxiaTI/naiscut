package com.inerxia.naiscut.model.empleado;

import com.inerxia.naiscut.model.cliente.Persona;
import com.inerxia.naiscut.model.salon.Sede;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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

    @Column(name = "DISPONIBLE", nullable = false)
    private char disponible;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SEDE_ID_FK",insertable = false, updatable = false, nullable = false)
    private Sede sedeFk;

    @Column(name="PERSONA_FK",  nullable = false)
    private Integer idPersonaFk;

    @Column(name="SEDE_ID_FK",  nullable = false)
    private Integer idSedeFk;

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

    public Integer getIdPersonaFk() {
        return idPersonaFk;
    }

    public void setIdPersonaFk(Integer idPersonaFk) {
        this.idPersonaFk = idPersonaFk;
    }

    public Integer getIdSedeFk() {
        return idSedeFk;
    }

    public void setIdSedeFk(Integer idSedeFk) {
        this.idSedeFk = idSedeFk;
    }
}

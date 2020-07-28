package com.inerxia.naiscut.model.cliente;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERSONA_FK",insertable = false, updatable = false,unique = true, nullable = false)
    private Persona personaFk;

    @Column(name="PERSONA_FK",  nullable = false)
    private Integer idPersonaFk;

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

    public Integer getIdPersonaFk() {
        return idPersonaFk;
    }

    public void setIdPersonaFk(Integer idPersonaFk) {
        this.idPersonaFk = idPersonaFk;
    }
}

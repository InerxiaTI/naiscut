package com.inerxia.naiscut.model.cliente;

import javax.persistence.*;

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
}

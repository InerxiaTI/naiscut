package com.inerxia.naiscut.facade.cliente.dto;

import io.swagger.models.auth.In;

import javax.validation.constraints.NotNull;

public class ClienteDto {
    private Integer id;
    private PersonaDto personaFk;

    @NotNull
    private Integer idPersonaFk;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PersonaDto getPersonaFk() {
        return personaFk;
    }

    public void setPersonaFk(PersonaDto personaFk) {
        this.personaFk = personaFk;
    }

    public Integer getIdPersonaFk() {
        return idPersonaFk;
    }

    public void setIdPersonaFk(Integer idPersonaFk) {
        this.idPersonaFk = idPersonaFk;
    }

    @Override
    public String toString() {
        return "ClienteDto{" +
                "id=" + id +
                ", personaFk=" + personaFk.toString() +
                '}';
    }
}

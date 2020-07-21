package com.inerxia.naiscut.facade.cliente.dto;

public class ClienteDto {
    private Integer id;
    private PersonaDto personaFk;

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

    @Override
    public String toString() {
        return "ClienteDto{" +
                "id=" + id +
                ", personaFk=" + personaFk.toString() +
                '}';
    }
}

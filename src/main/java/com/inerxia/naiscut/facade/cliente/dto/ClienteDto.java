package com.inerxia.naiscut.facade.cliente.dto;

public class ClienteDto {
    private Integer id;
    private Integer personaFk;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPersonaFk() {
        return personaFk;
    }

    public void setPersonaFk(Integer personaFk) {
        this.personaFk = personaFk;
    }
}

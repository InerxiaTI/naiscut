package com.inerxia.naiscut.facade.empleado.dto;

import com.inerxia.naiscut.facade.cliente.dto.PersonaDto;
import com.inerxia.naiscut.facade.salon.dto.SedeDto;

import javax.persistence.criteria.CriteriaBuilder;

public class EmpleadoDto {
    private Integer id;
    private PersonaDto personaFk;
    private EmpleadoRolDto rolFk;
    private char disponible;
    private SedeDto sedeFk;

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

    public EmpleadoRolDto getRolFk() {
        return rolFk;
    }

    public void setRolFk(EmpleadoRolDto rolFk) {
        this.rolFk = rolFk;
    }

    public char getDisponible() {
        return disponible;
    }

    public void setDisponible(char disponible) {
        this.disponible = disponible;
    }

    public SedeDto getSedeFk() {
        return sedeFk;
    }

    public void setSedeFk(SedeDto sedeFk) {
        this.sedeFk = sedeFk;
    }

    @Override
    public String toString() {
        return "EmpleadoDto{" +
                "id=" + id +
                ", personaFk=" + personaFk.toString() +
                ", rolFk=" + rolFk.toString() +
                ", disponible=" + disponible +
                ", sedeFk=" + sedeFk.toString() +
                '}';
    }
}

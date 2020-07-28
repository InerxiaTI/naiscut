package com.inerxia.naiscut.facade.empleado.dto;

import com.inerxia.naiscut.facade.cliente.dto.PersonaDto;
import com.inerxia.naiscut.facade.salon.dto.SedeDto;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class EmpleadoDto {
    private Integer id;
    private PersonaDto personaFk;
    private EmpleadoRolDto rolFk;

    @NotNull
    @Size(max = 1)
    private char disponible;
    private SedeDto sedeFk;

    @NotNull
    private Integer idRolFk;

    @NotNull
    private Integer idPersonaFk;

    @NotNull
    private Integer idSedeFk;

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

    public Integer getIdRolFk() {
        return idRolFk;
    }

    public void setIdRolFk(Integer idRolFk) {
        this.idRolFk = idRolFk;
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

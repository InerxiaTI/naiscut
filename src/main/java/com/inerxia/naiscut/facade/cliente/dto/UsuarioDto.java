package com.inerxia.naiscut.facade.cliente.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UsuarioDto {
    private Integer id;

    @NotNull
    @Size(max = 50)
    private String usuario;
    @NotNull
    @Size(max = 250)
    private String clave;

    private PersonaDto personaFk;
    private RolDto rolFk;

    @NotNull
    @Size(max = 1)
    private char estado;

    private Integer idPersonaFk;
    private Integer idRolFk;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public PersonaDto getPersonaFk() {
        return personaFk;
    }

    public void setPersonaFk(PersonaDto personaFk) {
        this.personaFk = personaFk;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public Integer getIdPersonaFk() {
        return idPersonaFk;
    }

    public void setIdPersonaFk(Integer idPersonaFk) {
        this.idPersonaFk = idPersonaFk;
    }

    public RolDto getRolFk() {
        return rolFk;
    }

    public void setRolFk(RolDto rolFk) {
        this.rolFk = rolFk;
    }

    public Integer getIdRolFk() {
        return idRolFk;
    }

    public void setIdRolFk(Integer idRolFk) {
        this.idRolFk = idRolFk;
    }
}

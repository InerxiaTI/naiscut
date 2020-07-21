package com.inerxia.naiscut.facade.cliente.dto;

public class UsuarioDto {
    private Integer id;
    private String usuario;
    private String clave;
    private Integer personaFk;

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

    public Integer getPersonaFk() {
        return personaFk;
    }

    public void setPersonaFk(Integer personaFk) {
        this.personaFk = personaFk;
    }

    @Override
    public String toString() {
        return "UsuarioDto{" +
                "id=" + id +
                ", usuario='" + usuario + '\'' +
                ", clave='********"+'\'' +
                ", personaFk=" + personaFk +
                '}';
    }
}

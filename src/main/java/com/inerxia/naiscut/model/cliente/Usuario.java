package com.inerxia.naiscut.model.cliente;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "USUARIO", nullable = false, unique = true)
    private String usuario;
    @Column(name = "CLAVE", nullable = false)
    private String clave;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERSONA_FK",insertable = false, updatable = false,unique = true)
    private Persona personaFk;
    @Column(name = "ESTADO", nullable = false)
    private char estado;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ROL_ID_FK",insertable = false, updatable = false)
    private Rol rolFk;

    @Column(name="ROL_ID_FK",  nullable = false)
    private Integer idRolFk;

    @Column(name="PERSONA_FK",  nullable = false)
    private Integer idPersonaFk;

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

    public Persona getPersonaFk() {
        return personaFk;
    }

    public void setPersonaFk(Persona personaFk) {
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

    public Rol getRolFk() {
        return rolFk;
    }

    public void setRolFk(Rol rolFk) {
        this.rolFk = rolFk;
    }

    public Integer getIdRolFk() {
        return idRolFk;
    }

    public void setIdRolFk(Integer idRolFk) {
        this.idRolFk = idRolFk;
    }
}

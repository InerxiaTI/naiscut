package com.inerxia.naiscut.salon.repository.entity;

import javax.persistence.*;

@Table(name = "SEDE")
@Entity
public class Sede {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "CIUDAD")
    private String ciudad;

    @Column(name = "TELEFONO")
    private String telefono;

    @Column(name = "DOMICILIO")
    private char domicilio;

    @Column(name = "PRINCIPAL")
    private char principal;

    @Column(name = "ESTADO_SEDE_FK")
    private char estadoSedeFk;

    @Column(name = "ADMINISTRADOR_FK")
    private Integer administradorFk;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public char getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(char domicilio) {
        this.domicilio = domicilio;
    }

    public char getPrincipal() {
        return principal;
    }

    public void setPrincipal(char principal) {
        this.principal = principal;
    }

    public char getEstadoSedeFk() {
        return estadoSedeFk;
    }

    public void setEstadoSedeFk(char estadoSedeFk) {
        this.estadoSedeFk = estadoSedeFk;
    }

    public Integer getAdministradorFk() {
        return administradorFk;
    }

    public void setAdministradorFk(Integer administradorFk) {
        this.administradorFk = administradorFk;
    }
}

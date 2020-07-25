package com.inerxia.naiscut.facade.salon.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SedeDto {

    @NotNull
    private Integer id;

    @Size(max = 200)
    private String descripcion;

    @Size(max = 100)
    private String ciudad;

    @NotNull
    @Size(max = 100)
    private String direccion;

    @NotNull
    @Size(max = 15)
    private String telefono;

    @NotNull
    @Size(max = 1)
    private char domicilio;

    @NotNull
    @Size(max = 1)
    private char principal;

    @NotNull
    @Size(max = 1)
    private char estadoSede;

    @NotNull
    private Integer administradorFk;

    @NotNull
    private SalonDto salonFk;

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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    public char getEstadoSede() {
        return estadoSede;
    }

    public void setEstadoSede(char estadoSede) {
        this.estadoSede = estadoSede;
    }

    public Integer getAdministradorFk() {
        return administradorFk;
    }

    public void setAdministradorFk(Integer administradorFk) {
        this.administradorFk = administradorFk;
    }

    public SalonDto getSalonFk() {
        return salonFk;
    }

    public void setSalonFk(SalonDto salonFk) {
        this.salonFk = salonFk;
    }
}

package com.inerxia.naiscut.facade.salon.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SalonDto {

    @NotNull
    private Integer id;

    @NotNull
    @Size(max = 100)
    private String nit;

    @NotNull
    @Size(max = 100)
    private String nombre;

    @Size(max = 100)
    private String logo;

    @NotNull
    private TipoSalonDto tipoSalonFk;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public TipoSalonDto getTipoSalonFk() {
        return tipoSalonFk;
    }

    public void setTipoSalonFk(TipoSalonDto tipoSalonFk) {
        this.tipoSalonFk = tipoSalonFk;
    }
}
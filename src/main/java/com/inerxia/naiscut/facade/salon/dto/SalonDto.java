package com.inerxia.naiscut.facade.salon.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SalonDto {

    private Integer id;

    @NotNull
    @Size(max = 100)
    private String nit;

    @NotNull
    @Size(max = 100)
    private String nombre;

    private String logo;

    private TipoSalonDto tipoSalonFk;

    @NotNull
    private Integer idTipoSalonFk;

    @NotNull
    private Integer administrador_total_fk;

    public Integer getAdministrador_total_fk() {
        return administrador_total_fk;
    }

    public void setAdministrador_total_fk(Integer administrador_total_fk) {
        this.administrador_total_fk = administrador_total_fk;
    }

    public Integer getIdTipoSalonFk() {
        return idTipoSalonFk;
    }

    public void setIdTipoSalonFk(Integer idTipoSalonFk) {
        this.idTipoSalonFk = idTipoSalonFk;
    }

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
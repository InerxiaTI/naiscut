package com.inerxia.naiscut.facade.salon.dto;

public class SalonDto {

    private Integer id;
    private String nit;
    private String nombre;
    private String logo;
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
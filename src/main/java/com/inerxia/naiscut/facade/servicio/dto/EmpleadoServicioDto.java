package com.inerxia.naiscut.facade.servicio.dto;

public class EmpleadoServicioDto {

    private Integer id;
    private Integer empleadoFk;
    private Integer servicioFk;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmpleadoFk() {
        return empleadoFk;
    }

    public void setEmpleadoFk(Integer empleadoFk) {
        this.empleadoFk = empleadoFk;
    }

    public Integer getServicioFk() {
        return servicioFk;
    }

    public void setServicioFk(Integer servicioFk) {
        this.servicioFk = servicioFk;
    }
}

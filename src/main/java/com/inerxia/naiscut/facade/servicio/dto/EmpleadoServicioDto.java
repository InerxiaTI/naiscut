package com.inerxia.naiscut.facade.servicio.dto;

//TODO falta dto de empleado
public class EmpleadoServicioDto {

    private Integer id;
    private Integer empleadoFk;
    private ServicioDto servicioFk;

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

    public ServicioDto getServicioFk() {
        return servicioFk;
    }

    public void setServicioFk(ServicioDto servicioFk) {
        this.servicioFk = servicioFk;
    }
}

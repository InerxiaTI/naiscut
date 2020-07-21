package com.inerxia.naiscut.facade.servicio.dto;

import com.inerxia.naiscut.facade.empleado.dto.EmpleadoDto;

public class EmpleadoServicioDto {

    private Integer id;
    private EmpleadoDto empleadoFk;
    private ServicioDto servicioFk;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EmpleadoDto getEmpleadoFk() {
        return empleadoFk;
    }

    public void setEmpleadoFk(EmpleadoDto empleadoFk) {
        this.empleadoFk = empleadoFk;
    }

    public ServicioDto getServicioFk() {
        return servicioFk;
    }

    public void setServicioFk(ServicioDto servicioFk) {
        this.servicioFk = servicioFk;
    }
}

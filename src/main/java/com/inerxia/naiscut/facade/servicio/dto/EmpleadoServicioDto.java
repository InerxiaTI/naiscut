package com.inerxia.naiscut.facade.servicio.dto;

import com.inerxia.naiscut.facade.empleado.dto.EmpleadoDto;

import javax.validation.constraints.NotNull;

public class EmpleadoServicioDto {

    @NotNull
    private Integer id;

    @NotNull
    private EmpleadoDto empleadoFk;

    @NotNull
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

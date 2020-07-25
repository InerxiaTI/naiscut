package com.inerxia.naiscut.facade.servicio.dto;

import com.inerxia.naiscut.facade.empleado.dto.EmpleadoDto;

import javax.validation.constraints.NotNull;

public class EmpleadoServicioDto {

    private Integer id;

    private EmpleadoDto empleadoFk;

    private ServicioDto servicioFk;

    @NotNull
    private Integer idEmpleadoFk;

    @NotNull
    private Integer idServicioFk;

    public Integer getIdEmpleadoFk() {
        return idEmpleadoFk;
    }

    public void setIdEmpleadoFk(Integer idEmpleadoFk) {
        this.idEmpleadoFk = idEmpleadoFk;
    }

    public Integer getIdServicioFk() {
        return idServicioFk;
    }

    public void setIdServicioFk(Integer idServicioFk) {
        this.idServicioFk = idServicioFk;
    }

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

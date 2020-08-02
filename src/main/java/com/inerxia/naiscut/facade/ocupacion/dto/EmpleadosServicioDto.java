package com.inerxia.naiscut.facade.ocupacion.dto;

import java.util.List;

public class EmpleadosServicioDto {
    private Integer idServicioFk;
    private List<Integer> idEmpleadosFk;

    public Integer getIdServicioFk() {
        return idServicioFk;
    }

    public void setIdServicioFk(Integer idServicioFk) {
        this.idServicioFk = idServicioFk;
    }

    public List<Integer> getIdEmpleadosFk() {
        return idEmpleadosFk;
    }

    public void setIdEmpleadosFk(List<Integer> idEmpleadosFk) {
        this.idEmpleadosFk = idEmpleadosFk;
    }
}

package com.inerxia.naiscut.facade.ocupacion.dto;

import java.time.LocalTime;

public class CuartoDisponibleDto {
    private LocalTime cuarto;
    private boolean disponible;
    private Integer idEmpleadoFk;

    public LocalTime getCuarto() {
        return cuarto;
    }

    public void setCuarto(LocalTime cuarto) {
        this.cuarto = cuarto;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public Integer getIdEmpleadoFk() {
        return idEmpleadoFk;
    }

    public void setIdEmpleadoFk(Integer idEmpleadoFk) {
        this.idEmpleadoFk = idEmpleadoFk;
    }
}

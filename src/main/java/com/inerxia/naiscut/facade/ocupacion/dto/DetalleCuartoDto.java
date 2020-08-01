package com.inerxia.naiscut.facade.ocupacion.dto;

import java.time.LocalTime;

public class DetalleCuartoDto {

    private Integer idEmpleadoFk;
    private Integer idCitaFk;
    private LocalTime horaFinalCita;

    public LocalTime getHoraFinalCita() {
        return horaFinalCita;
    }

    public void setHoraFinalCita(LocalTime horaFinalCita) {
        this.horaFinalCita = horaFinalCita;
    }

    public Integer getIdCitaFk() {
        return idCitaFk;
    }

    public void setIdCitaFk(Integer idCitaFk) {
        this.idCitaFk = idCitaFk;
    }

    public Integer getIdEmpleadoFk() {
        return idEmpleadoFk;
    }

    public void setIdEmpleadoFk(Integer idEmpleadoFk) {
        this.idEmpleadoFk = idEmpleadoFk;
    }
}

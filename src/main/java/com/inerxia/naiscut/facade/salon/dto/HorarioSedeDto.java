package com.inerxia.naiscut.facade.salon.dto;

import java.time.LocalDateTime;

public class HorarioSedeDto {

    private Integer id;
    private LocalDateTime fechaHoraInicio;
    private LocalDateTime fechaHoraFinal;
    private Integer sedeFk;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public void setFechaHoraInicio(LocalDateTime fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }

    public LocalDateTime getFechaHoraFinal() {
        return fechaHoraFinal;
    }

    public void setFechaHoraFinal(LocalDateTime fechaHoraFinal) {
        this.fechaHoraFinal = fechaHoraFinal;
    }

    public Integer getSedeFk() {
        return sedeFk;
    }

    public void setSedeFk(Integer sedeFk) {
        this.sedeFk = sedeFk;
    }
}

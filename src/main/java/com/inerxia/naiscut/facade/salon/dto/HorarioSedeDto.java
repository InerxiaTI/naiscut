package com.inerxia.naiscut.facade.salon.dto;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class HorarioSedeDto {

    private Integer id;

    @NotNull
    private LocalDateTime fechaHoraInicio;

    @NotNull
    private LocalDateTime fechaHoraFinal;

    @NotNull
    private SedeDto sedeFk;

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

    public SedeDto getSedeFk() {
        return sedeFk;
    }

    public void setSedeFk(SedeDto sedeFk) {
        this.sedeFk = sedeFk;
    }
}

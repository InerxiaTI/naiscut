package com.inerxia.naiscut.facade.ocupacion.dto;

import com.inerxia.naiscut.facade.salon.dto.SedeDto;

import java.time.LocalDateTime;

//TODO falta dto de empleado, cita
public class OcupacionDto {

    private Integer id;
    private Integer empleadoFk;
    private LocalDateTime fechaHoraInicio;
    private LocalDateTime fechaHoraFinal;
    private Integer citaFk;
    private String comentario;
    private SedeDto sedeFk;

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

    public Integer getCitaFk() {
        return citaFk;
    }

    public void setCitaFk(Integer citaFk) {
        this.citaFk = citaFk;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public SedeDto getSedeFk() {
        return sedeFk;
    }

    public void setSedeFk(SedeDto sedeFk) {
        this.sedeFk = sedeFk;
    }
}

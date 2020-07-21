package com.inerxia.naiscut.facade.ocupacion.dto;

import com.inerxia.naiscut.facade.cita.dto.CitaDto;
import com.inerxia.naiscut.facade.empleado.dto.EmpleadoDto;
import com.inerxia.naiscut.facade.salon.dto.SedeDto;

import java.time.LocalDateTime;

public class OcupacionDto {

    private Integer id;
    private EmpleadoDto empleadoFk;
    private LocalDateTime fechaHoraInicio;
    private LocalDateTime fechaHoraFinal;
    private CitaDto citaFk;
    private String comentario;
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

    public EmpleadoDto getEmpleadoFk() {
        return empleadoFk;
    }

    public void setEmpleadoFk(EmpleadoDto empleadoFk) {
        this.empleadoFk = empleadoFk;
    }

    public CitaDto getCitaFk() {
        return citaFk;
    }

    public void setCitaFk(CitaDto citaFk) {
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

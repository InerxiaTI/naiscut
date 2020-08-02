package com.inerxia.naiscut.facade.ocupacion.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class OcupacionDiaServicioDto {
    @NotNull
    @Size(max = 1)
    private char dia;

    @NotNull
    private Integer idSedeFk;

    @NotNull
    private List<Integer> idServiciosFK;

    @NotNull
    private LocalDate fechaConsulta;

    private LocalTime horaInicio;
    private LocalTime horaFinal;
    private List<CuartoDisponibleDto> cuartoDisponibleDtos;


    public char getDia() {
        return dia;
    }

    public void setDia(char dia) {
        this.dia = dia;
    }

    public Integer getIdSedeFk() {
        return idSedeFk;
    }

    public void setIdSedeFk(Integer idSedeFk) {
        this.idSedeFk = idSedeFk;
    }

    public List<Integer> getIdServiciosFK() {
        return idServiciosFK;
    }

    public void setIdServiciosFK(List<Integer> idServiciosFK) {
        this.idServiciosFK = idServiciosFK;
    }

    public LocalDate getFechaConsulta() {
        return fechaConsulta;
    }

    public void setFechaConsulta(LocalDate fechaConsulta) {
        this.fechaConsulta = fechaConsulta;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(LocalTime horaFinal) {
        this.horaFinal = horaFinal;
    }

    public List<CuartoDisponibleDto> getCuartoDisponibleDtos() {
        return cuartoDisponibleDtos;
    }

    public void setCuartoDisponibleDtos(List<CuartoDisponibleDto> cuartoDisponibleDtos) {
        this.cuartoDisponibleDtos = cuartoDisponibleDtos;
    }
}

package com.inerxia.naiscut.facade.cita.dto;

import com.inerxia.naiscut.facade.cliente.dto.ClienteDto;
import com.inerxia.naiscut.facade.empleado.dto.EmpleadoDto;
import com.inerxia.naiscut.facade.salon.dto.SedeDto;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDateTime;

public class CitaDto {
    private Integer id;
    private ClienteDto clienteFk;
    private EmpleadoDto empleadoFk;
    private SedeDto sedeFk;
    private LocalDateTime fechaHoraInicio;
    private Integer duracionTotal;
    private EstadoCitaDto estadoCitaFk;
    private LocalDateTime fechaCreacion;
    private Integer consecutivo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ClienteDto getClienteFk() {
        return clienteFk;
    }

    public void setClienteFk(ClienteDto clienteFk) {
        this.clienteFk = clienteFk;
    }

    public EmpleadoDto getEmpleadoFk() {
        return empleadoFk;
    }

    public void setEmpleadoFk(EmpleadoDto empleadoFk) {
        this.empleadoFk = empleadoFk;
    }

    public SedeDto getSedeFk() {
        return sedeFk;
    }

    public void setSedeFk(SedeDto sedeFk) {
        this.sedeFk = sedeFk;
    }

    public LocalDateTime getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public void setFechaHoraInicio(LocalDateTime fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }

    public Integer getDuracionTotal() {
        return duracionTotal;
    }

    public void setDuracionTotal(Integer duracionTotal) {
        this.duracionTotal = duracionTotal;
    }

    public EstadoCitaDto getEstadoCitaFk() {
        return estadoCitaFk;
    }

    public void setEstadoCitaFk(EstadoCitaDto estadoCitaFk) {
        this.estadoCitaFk = estadoCitaFk;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(Integer consecutivo) {
        this.consecutivo = consecutivo;
    }

    @Override
    public String toString() {
        return "CitaDto{" +
                "id=" + id +
                ", clienteFk=" + clienteFk +
                ", empleadoFk=" + empleadoFk +
                ", sedeFk=" + sedeFk +
                ", fechaHoraInicio=" + fechaHoraInicio +
                ", duracionTotal=" + duracionTotal +
                ", estadoCitaFk=" + estadoCitaFk +
                ", fechaCreacion=" + fechaCreacion +
                ", consecutivo=" + consecutivo +
                '}';
    }
}

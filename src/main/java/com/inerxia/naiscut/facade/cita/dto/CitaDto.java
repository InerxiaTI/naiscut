package com.inerxia.naiscut.facade.cita.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.inerxia.naiscut.facade.cliente.dto.ClienteDto;
import com.inerxia.naiscut.facade.empleado.dto.EmpleadoDto;
import com.inerxia.naiscut.facade.salon.dto.SedeDto;
import lombok.NoArgsConstructor;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class CitaDto {
    private Integer id;
    @JsonIgnore
    private ClienteDto clienteFk;
    @JsonIgnore
    private EmpleadoDto empleadoFk;
    @JsonIgnore
    private SedeDto sedeFk;

    @NotNull
    private LocalDateTime fechaHoraInicio;

    @NotNull
    private Integer duracionTotal;
    @JsonInclude()
    private EstadoCitaDto estadoCitaFk;

    @NotNull
    private LocalDateTime fechaCreacion;

    private Integer consecutivo;

    @NotNull
    private Integer idClienteFk;

    @NotNull
    private Integer idEmpleadoFk;

    @NotNull
    private Integer idSedeFk;

    @NotNull
    private Integer idEstadoCitaFk;

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

    public Integer getIdClienteFk() {
        return idClienteFk;
    }

    public void setIdClienteFk(Integer idClienteFk) {
        this.idClienteFk = idClienteFk;
    }

    public Integer getIdEmpleadoFk() {
        return idEmpleadoFk;
    }

    public void setIdEmpleadoFk(Integer idEmpleadoFk) {
        this.idEmpleadoFk = idEmpleadoFk;
    }

    public Integer getIdSedeFk() {
        return idSedeFk;
    }

    public void setIdSedeFk(Integer idSedeFk) {
        this.idSedeFk = idSedeFk;
    }

    public Integer getIdEstadoCitaFk() {
        return idEstadoCitaFk;
    }

    public void setIdEstadoCitaFk(Integer idEstadoCitaFk) {
        this.idEstadoCitaFk = idEstadoCitaFk;
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

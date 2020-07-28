package com.inerxia.naiscut.model.cita;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.inerxia.naiscut.model.cliente.Cliente;
import com.inerxia.naiscut.model.empleado.Empleado;
import com.inerxia.naiscut.model.salon.Sede;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "cita")
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CLIENTE_ID_FK",insertable = false, updatable = false, nullable = false)
    private Cliente clienteFk;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EMPLEADO_ID_FK",insertable = false, updatable = false, nullable = false)
    private Empleado empleadoFk;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SEDE_ID_FK",insertable = false, updatable = false, nullable = false)
    private Sede sedeFk;

    @Column(name = "FECHA_HORA_INICIO", nullable = false)
    private LocalDateTime fechaHoraInicio;

    @Column(name = "DURACION_TOTAL", nullable = false)
    private Integer duracionTotal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ESTADO_CITA_FK",insertable = false, updatable = false, nullable = false)
    private EstadoCita estadoCitaFk;

    @Column(name = "FECHA_CREACION", nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "CONSECUTIVO", nullable = false, updatable = false)
    private Integer consecutivo;

    @Column(name="CLIENTE_ID_FK",  nullable = false)
    private Integer idClienteFk;

    @Column(name="EMPLEADO_ID_FK",  nullable = false)
    private Integer idEmpleadoFk;

    @Column(name="SEDE_ID_FK",  nullable = false)
    private Integer idSedeFk;

    @Column(name="ESTADO_CITA_FK",  nullable = false)
    private Integer idEstadoCitaFk;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cliente getClienteFk() {
        return clienteFk;
    }

    public void setClienteFk(Cliente clienteFk) {
        this.clienteFk = clienteFk;
    }

    public Empleado getEmpleadoFk() {
        return empleadoFk;
    }

    public void setEmpleadoFk(Empleado empleadoFk) {
        this.empleadoFk = empleadoFk;
    }

    public Sede getSedeFk() {
        return sedeFk;
    }

    public void setSedeFk(Sede sedeFk) {
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

    public void setDuracionTotal(Integer duracion) {
        this.duracionTotal = duracion;
    }

    public EstadoCita getEstadoCitaFk() {
        return estadoCitaFk;
    }

    public void setEstadoCitaFk(EstadoCita estadoCitaFk) {
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
}

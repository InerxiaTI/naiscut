package com.inerxia.naiscut.model.ocupacion;

import com.inerxia.naiscut.model.cita.Cita;
import com.inerxia.naiscut.model.empleado.Empleado;
import com.inerxia.naiscut.model.salon.Sede;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "OCUPACION")
@Entity
public class Ocupacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="EMPLEADO_FK", insertable = false, updatable = false, nullable = false)
    private Empleado empleadoFk;

    @Column(name = "FECHA_HORA_INICIO", nullable = false)
    private LocalDateTime fechaHoraInicio;

    @Column(name = "FECHA_HORA_FINAL", nullable = false)
    private LocalDateTime fechaHoraFinal;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="CITA_FK",
                insertable = false,
                updatable = false,
                unique = true)
    private Cita citaFk;

    @Column(name = "COMENTARIO")
    private String comentario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="SEDE_FK", insertable = false, updatable = false, nullable = false)
    private Sede sedeFk;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Empleado getEmpleadoFk() {
        return empleadoFk;
    }

    public void setEmpleadoFk(Empleado empleadoFk) {
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

    public Cita getCitaFk() {
        return citaFk;
    }

    public void setCitaFk(Cita citaFk) {
        this.citaFk = citaFk;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Sede getSedeFk() {
        return sedeFk;
    }

    public void setSedeFk(Sede sedeFk) {
        this.sedeFk = sedeFk;
    }
}

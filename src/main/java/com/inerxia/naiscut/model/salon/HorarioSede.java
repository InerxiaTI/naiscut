package com.inerxia.naiscut.model.salon;

import javax.persistence.*;
import java.time.LocalTime;

@Table(name = "horario_sede")
@Entity
public class HorarioSede {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "DIA", nullable = false)
    private char dia;

    @Column(name = "HORA_INICIO", nullable = false)
    private LocalTime horaInicio;

    @Column(name = "HORA_FINAL", nullable = false)
    private LocalTime horaFinal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="SEDE_FK", insertable = false, updatable = false, nullable = false)
    private Sede sedeFk;

    @Column(name = "SEDE_FK", nullable = false)
    private Integer idSedeFk;

    public Integer getIdSedeFk() {
        return idSedeFk;
    }

    public void setIdSedeFk(Integer idSedeFk) {
        this.idSedeFk = idSedeFk;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Sede getSedeFk() {
        return sedeFk;
    }

    public void setSedeFk(Sede sedeFk) {
        this.sedeFk = sedeFk;
    }

    public char getDia() {
        return dia;
    }

    public void setDia(char dia) {
        this.dia = dia;
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
}

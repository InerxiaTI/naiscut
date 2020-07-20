package com.inerxia.naiscut.servicio.repository.entity;

import com.inerxia.naiscut.empleado.repository.entity.Empleado;

import javax.persistence.*;

@Table(name = "EMPLEADO_SERVICIOS")
@Entity
public class EmpleadoServicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="EMPLEADO_FK", insertable = false, updatable = false, nullable = false)
    private Empleado empleadoFk;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="SERVICIO_FK", insertable = false, updatable = false, nullable = false)
    private Servicio servicioFk;

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

    public Servicio getServicioFk() {
        return servicioFk;
    }

    public void setServicioFk(Servicio servicioFk) {
        this.servicioFk = servicioFk;
    }
}

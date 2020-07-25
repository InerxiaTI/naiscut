package com.inerxia.naiscut.model.servicio;

import com.inerxia.naiscut.model.empleado.Empleado;
import io.swagger.models.auth.In;

import javax.persistence.*;

@Table(name = "empleado_servicio")
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

    @Column(name = "EMPLEADO_FK", nullable = false)
    private Integer idEmpleadoFk;

    @Column(name = "SERVICIO_FK", nullable = false)
    private Integer idServicioFk;

    public Integer getIdEmpleadoFk() {
        return idEmpleadoFk;
    }

    public void setIdEmpleadoFk(Integer idEmpleadoFk) {
        this.idEmpleadoFk = idEmpleadoFk;
    }

    public Integer getIdServicioFk() {
        return idServicioFk;
    }

    public void setIdServicioFk(Integer idServicioFk) {
        this.idServicioFk = idServicioFk;
    }

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

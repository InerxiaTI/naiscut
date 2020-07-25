package com.inerxia.naiscut.model.cita;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "estado_compra")
public class EstadoCompra implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "DESCRIPCION", nullable = false)
    private String descripcion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "EstadoCompra{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}

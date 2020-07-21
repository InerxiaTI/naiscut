package com.inerxia.naiscut.model.salon;

import javax.persistence.*;

@Table(name = "TIPO_SALON")
@Entity
public class TipoSalon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
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
}

package com.inerxia.naiscut.cita.repository.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "ESTADO_COMPRA")
public class EstadoCompra implements Serializable {


    private Integer id;
    private String descripcion;
}

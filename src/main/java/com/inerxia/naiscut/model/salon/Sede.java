package com.inerxia.naiscut.model.salon;

import com.inerxia.naiscut.model.empleado.Empleado;

import javax.persistence.*;

@Table(name = "sede")
@Entity
public class Sede {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "CIUDAD")
    private String ciudad;

    @Column(name = "DIRECCION", nullable = false, unique = true)
    private String direccion;

    @Column(name = "TELEFONO", nullable = false)
    private String telefono;

    @Column(name = "DOMICILIO", nullable = false)
    private char domicilio;

    @Column(name = "PRINCIPAL", nullable = false)
    private char principal;

    @Column(name = "ESTADO_SEDE", nullable = false)
    private char estadoSede;

    @Column(name="ADMINISTRADOR_FK",  nullable = false)
    private Integer administradorFk;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="SALON_FK", insertable = false, updatable = false, nullable = false)
    private Salon salonFk;

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

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public char getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(char domicilio) {
        this.domicilio = domicilio;
    }

    public char getPrincipal() {
        return principal;
    }

    public void setPrincipal(char principal) {
        this.principal = principal;
    }

    public char getEstadoSede() {
        return estadoSede;
    }

    public void setEstadoSede(char estadoSede) {
        this.estadoSede = estadoSede;
    }

    public Integer getAdministradorFk() {
        return administradorFk;
    }

    public void setAdministradorFk(Integer administradorFk) {
        this.administradorFk = administradorFk;
    }

    public Salon getSalonFk() {
        return salonFk;
    }

    public void setSalonFk(Salon salonFk) {
        this.salonFk = salonFk;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}

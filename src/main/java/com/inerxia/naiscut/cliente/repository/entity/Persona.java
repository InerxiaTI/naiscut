package com.inerxia.naiscut.cliente.repository.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "PERSONA")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "IDENTIFICACION", nullable = false)
    private String identificacion;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TIPO_IDENTIFICACION_FK",insertable = false, updatable = false, nullable = false)
    private TipoIdentificacion tipoIdentificaionFk;
    @Column(name = "PRIMER_NOMBRE", nullable = false)
    private String primerNombre;
    @Column(name = "SEGUNDO_NOMBRE", nullable = false)
    private String segundoNombre;
    @Column(name = "PRIMER_APELLIDO", nullable = false)
    private String primerApellido;
    @Column(name = "SEGUNDO_NOMBRE", nullable = false)
    private String segundoApellido;
    @Column(name = "DIRECCION", nullable = false)
    private String direccion;
    @Column(name = "CORREO", nullable = false)
    private String correo;
    @Column(name = "TELEFONO_MOVIL", nullable = false)
    private String telefonoMovil;
    @Column(name = "TELEFONO_FIJO", nullable = false)
    private String telefonoFijo;
    @Column(name = "FECHA_NACIMIENTO", nullable = false)
    private String fechaNacimiento;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GENERO_FK",insertable = false, updatable = false, nullable = false)
    private Genero generoFk;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public TipoIdentificacion getTipoIdentificaionFk() {
        return tipoIdentificaionFk;
    }

    public void setTipoIdentificaionFk(TipoIdentificacion tipoIdentificaionFk) {
        this.tipoIdentificaionFk = tipoIdentificaionFk;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefonoMovil() {
        return telefonoMovil;
    }

    public void setTelefonoMovil(String telefonoMovil) {
        this.telefonoMovil = telefonoMovil;
    }

    public String getTelefonoFijo() {
        return telefonoFijo;
    }

    public void setTelefonoFijo(String telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}

package com.inerxia.naiscut.cliente.repository.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "PERSONA")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name = "IDENTIFICACION")
    private String identificacion;
    @NotNull
    @Column(name = "TIPO_IDENTIFICACION_FK")
    private Integer tipoIdentificaionFk;
    @NotNull
    @Column(name = "PRIMER_NOMBRE")
    private String primerNombre;
    @NotNull
    @Column(name = "SEGUNDO_NOMBRE")
    private String segundoNombre;
    @NotNull
    @Column(name = "PRIMER_APELLIDO")
    private String primerApellido;
    @NotNull
    @Column(name = "SEGUNDO_NOMBRE")
    private String segundoApellido;
    @NotNull
    @Column(name = "DIRECCION")
    private String direccion;
    @NotNull
    @Column(name = "CORREO")
    private String correo;
    @NotNull
    @Column(name = "TELEFONO_MOVIL")
    private String telefonoMovil;
    @NotNull
    @Column(name = "TELEFONO_FIJO")
    private String telefonoFijo;
    @NotNull
    @Column(name = "FECHA_NACIMIENTO")
    private String fechaNacimiento;

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

    public Integer getTipoIdentificaionFk() {
        return tipoIdentificaionFk;
    }

    public void setTipoIdentificaionFk(Integer tipoIdentificaionFk) {
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

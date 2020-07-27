package com.inerxia.naiscut.model.cliente;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "persona")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "IDENTIFICACION", nullable = false)
    private String identificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TIPO_IDENTIFICACION_FK",insertable = false, updatable = false, nullable = false)
    private TipoIdentificacion tipoIdentificacionFk;

    @Column(name = "PRIMER_NOMBRE", nullable = false)
    private String primerNombre;

    @Column(name = "SEGUNDO_NOMBRE")
    private String segundoNombre;

    @Column(name = "PRIMER_APELLIDO", nullable = false)
    private String primerApellido;

    @Column(name = "SEGUNDO_APELLIDO")
    private String segundoApellido;

    @Column(name = "DIRECCION", nullable = false)
    private String direccion;

    @Column(name = "CORREO", nullable = false)
    private String correo;

    @Column(name = "TELEFONO_MOVIL", nullable = false)
    private String telefonoMovil;

    @Column(name = "TELEFONO_FIJO")
    private String telefonoFijo;

    @Column(name = "FECHA_NACIMIENTO")
    private LocalDateTime fechaNacimiento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GENERO_FK",insertable = false, updatable = false, nullable = false)
    private Genero generoFk;

    @Column(name="TIPO_IDENTIFICACION_FK",  nullable = false)
    private Integer idTipoIdentificacionFk;

    @Column(name="GENERO_FK",  nullable = false)
    private Integer idGeneroFk;

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

    public TipoIdentificacion getTipoIdentificacionFk() {
        return tipoIdentificacionFk;
    }

    public void setTipoIdentificacionFk(TipoIdentificacion tipoIdentificacionFk) {
        this.tipoIdentificacionFk = tipoIdentificacionFk;
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

    public LocalDateTime getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Genero getGeneroFk() {
        return generoFk;
    }

    public void setGeneroFk(Genero generoFk) {
        this.generoFk = generoFk;
    }

    public Integer getIdTipoIdentificacionFk() {
        return idTipoIdentificacionFk;
    }

    public void setIdTipoIdentificacionFk(Integer idTipoIdentificacionFk) {
        this.idTipoIdentificacionFk = idTipoIdentificacionFk;
    }

    public Integer getIdGeneroFk() {
        return idGeneroFk;
    }

    public void setIdGeneroFk(Integer idGeneroFk) {
        this.idGeneroFk = idGeneroFk;
    }
}

package com.inerxia.naiscut.facade.cliente.dto;


import java.time.LocalDateTime;

public class PersonaDto {
    private Integer id;
    private String identificacion;
    private TipoIdentificacionDto tipoIdentificacionFk;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String direccion;
    private String correo;
    private String telefonoMovil;
    private String telefonoFijo;
    private LocalDateTime fechaNacimiento;
    private GeneroDto generoFk;

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

    public TipoIdentificacionDto getTipoIdentificacionFk() {
        return tipoIdentificacionFk;
    }

    public void setTipoIdentificacionFk(TipoIdentificacionDto tipoIdentificacionFk) {
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

    public GeneroDto getGeneroFk() {
        return generoFk;
    }

    public void setGeneroFk(GeneroDto generoFk) {
        this.generoFk = generoFk;
    }

    @Override
    public String toString() {
        return "PersonaDto{" +
                "id=" + id +
                ", identificacion='" + identificacion + '\'' +
                ", tipoIdentificacionFk=" + tipoIdentificacionFk.toString() +
                ", primerNombre='" + primerNombre + '\'' +
                ", segundoNombre='" + segundoNombre + '\'' +
                ", primerApellido='" + primerApellido + '\'' +
                ", segundoApellido='" + segundoApellido + '\'' +
                ", direccion='" + direccion + '\'' +
                ", correo='" + correo + '\'' +
                ", telefonoMovil='" + telefonoMovil + '\'' +
                ", telefonoFijo='" + telefonoFijo + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", generoFk=" + generoFk.toString() +
                '}';
    }
}

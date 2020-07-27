package com.inerxia.naiscut.facade.cliente.dto;



import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class PersonaDto {
    private Integer id;

    @NotNull
    @Size(max = 100)
    private String identificacion;
    private TipoIdentificacionDto tipoIdentificacionFk;

    @NotNull
    @Size(max = 50)
    private String primerNombre;
    @Size(max = 50)
    private String segundoNombre;
    @NotNull
    @Size(max = 50)
    private String primerApellido;
    @Size(max = 50)
    private String segundoApellido;
    @Size(max = 30)
    private String direccion;
    @NotNull
    @Size(max = 100)
    private String correo;
    @NotNull
    @Size(max = 12)
    private String telefonoMovil;
    @Size(max = 10)
    private String telefonoFijo;

    private LocalDateTime fechaNacimiento;

    private GeneroDto generoFk;

    @NotNull
    private Integer idTipoIdentificacionFk;
    @NotNull
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

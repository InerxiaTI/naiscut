package com.inerxia.naiscut.facade.salon.dto;

public class SedeSalonDto {

    private Integer idSede;
    private String descripcionSede;
    private String ciudadSede;
    private String direccionSede;
    private String telefonoSede;
    private char domicilioSede;
    private char principalSede;
    private char estadoSedeSede;
    private String nitSalon;
    private String nombreSalon;
    private String logoSalon;
    private String tipoSalon;

    public SedeSalonDto(Integer idSede,
                        String descripcionSede,
                        String ciudadSede,
                        String direccionSede,
                        String telefonoSede,
                        char domicilioSede,
                        char principalSede,
                        char estadoSedeSede,
                        String nitSalon,
                        String nombreSalon,
                        String logoSalon,
                        String tipoSalon) {
        this.idSede = idSede;
        this.descripcionSede = descripcionSede;
        this.ciudadSede = ciudadSede;
        this.direccionSede = direccionSede;
        this.telefonoSede = telefonoSede;
        this.domicilioSede = domicilioSede;
        this.principalSede = principalSede;
        this.estadoSedeSede = estadoSedeSede;
        this.nitSalon = nitSalon;
        this.nombreSalon = nombreSalon;
        this.logoSalon = logoSalon;
        this.tipoSalon = tipoSalon;
    }

    public Integer getIdSede() {
        return idSede;
    }

    public void setIdSede(Integer idSede) {
        this.idSede = idSede;
    }

    public String getDescripcionSede() {
        return descripcionSede;
    }

    public void setDescripcionSede(String descripcionSede) {
        this.descripcionSede = descripcionSede;
    }

    public String getCiudadSede() {
        return ciudadSede;
    }

    public void setCiudadSede(String ciudadSede) {
        this.ciudadSede = ciudadSede;
    }

    public String getDireccionSede() {
        return direccionSede;
    }

    public void setDireccionSede(String direccionSede) {
        this.direccionSede = direccionSede;
    }

    public String getTelefonoSede() {
        return telefonoSede;
    }

    public void setTelefonoSede(String telefonoSede) {
        this.telefonoSede = telefonoSede;
    }

    public char getDomicilioSede() {
        return domicilioSede;
    }

    public void setDomicilioSede(char domicilioSede) {
        this.domicilioSede = domicilioSede;
    }

    public char getPrincipalSede() {
        return principalSede;
    }

    public void setPrincipalSede(char principalSede) {
        this.principalSede = principalSede;
    }

    public char getEstadoSedeSede() {
        return estadoSedeSede;
    }

    public void setEstadoSedeSede(char estadoSedeSede) {
        this.estadoSedeSede = estadoSedeSede;
    }

    public String getNitSalon() {
        return nitSalon;
    }

    public void setNitSalon(String nitSalon) {
        this.nitSalon = nitSalon;
    }

    public String getNombreSalon() {
        return nombreSalon;
    }

    public void setNombreSalon(String nombreSalon) {
        this.nombreSalon = nombreSalon;
    }

    public String getLogoSalon() {
        return logoSalon;
    }

    public void setLogoSalon(String logoSalon) {
        this.logoSalon = logoSalon;
    }

    public String getTipoSalon() {
        return tipoSalon;
    }

    public void setTipoSalon(String tipoSalon) {
        this.tipoSalon = tipoSalon;
    }
}

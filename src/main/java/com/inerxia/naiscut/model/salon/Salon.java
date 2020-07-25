package com.inerxia.naiscut.model.salon;

import javax.persistence.*;

@Table(name = "salon")
@Entity
public class Salon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NIT", nullable = false, unique = true)
    private String nit;

    @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    @Column(name = "LOGO")
    private String logo;

    @Column(name = "TIPO_SALON_FK", nullable = false)
    private Integer idTipoSalonFk;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="TIPO_SALON_FK",
                insertable = false,
                updatable = false,
                nullable = false)
    private TipoSalon tipoSalonFk;

    public Integer getIdTipoSalonFk() {
        return idTipoSalonFk;
    }

    public void setIdTipoSalonFk(Integer idTipoSalonFk) {
        this.idTipoSalonFk = idTipoSalonFk;
    }

    public TipoSalon getTipoSalonFk() {
        return tipoSalonFk;
    }

    public void setTipoSalonFk(TipoSalon tipoSalonFk) {
        this.tipoSalonFk = tipoSalonFk;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

}

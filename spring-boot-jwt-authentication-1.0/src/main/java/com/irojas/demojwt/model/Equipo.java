package com.irojas.demojwt.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Equipo")
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Equipo")
    private Integer idEquipo;

    @Column(name = "Nombre_Equipo")
    private String nombreEquipo;

    @ManyToOne
    @JoinColumn(name = "ID_Mision", referencedColumnName = "ID_Mision")
    private Mision mision;

    public Equipo() {
    }

    public Equipo(String nombreEquipo, Mision mision) {
        this.nombreEquipo = nombreEquipo;
        this.mision = mision;
    }

    public Integer getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Integer idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public Mision getMision() {
        return mision;
    }

    public void setMision(Mision mision) {
        this.mision = mision;
    }
}

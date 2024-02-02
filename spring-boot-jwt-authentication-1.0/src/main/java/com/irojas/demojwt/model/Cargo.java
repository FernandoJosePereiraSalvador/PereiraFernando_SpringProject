package com.irojas.demojwt.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Cargo")
public class Cargo {

    @Id
    @Column(name = "ID_Cargo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCargo;

    @Column(name = "Nombre_Cargo", unique = true, length = 50)
    private String nombreCargo;

    public Integer getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Integer idCargo) {
        this.idCargo = idCargo;
    }

    public String getNombreCargo() {
        return nombreCargo;
    }

    public void setNombreCargo(String nombreCargo) {
        this.nombreCargo = nombreCargo;
    }
}

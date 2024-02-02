package com.irojas.demojwt.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "habilidad")
public class Habilidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Habilidad")
    private Integer idHabilidad;

    @Column(name = "Nombre_Habilidad")
    private String nombreHabilidad;

    @ManyToMany(mappedBy = "habilidades")
    @JsonBackReference
    private Set<Astronauta> astronautas = new HashSet<>();

    public Set<Astronauta> getAstronautas() {
        return astronautas;
    }

    public void setAstronautas(Set<Astronauta> astronautas) {
        this.astronautas = astronautas;
    }

    public Integer getIdHabilidad() {
        return idHabilidad;
    }

    public void setIdHabilidad(Integer idHabilidad) {
        this.idHabilidad = idHabilidad;
    }

    public String getNombreHabilidad() {
        return nombreHabilidad;
    }

    public void setNombreHabilidad(String nombreHabilidad) {
        this.nombreHabilidad = nombreHabilidad;
    }


}

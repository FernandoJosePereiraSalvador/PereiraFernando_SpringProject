package com.irojas.demojwt.dto.habilidad;


import com.irojas.demojwt.model.Astronauta;

import java.util.Set;

public class HabilidadDTO {

    private Integer idHabilidad;
    private String nombreHabilidad;

    private Set<Astronauta> astronautas;

    public Set<Astronauta> getAstronautas() {
        return astronautas;
    }

    public void setAstronautas(Set<Astronauta> astronautas) {
        this.astronautas = astronautas;
    }

    public HabilidadDTO() {
    }

    public HabilidadDTO(Integer idHabilidad, String nombreHabilidad,Set<Astronauta> astronautas) {
        this.idHabilidad = idHabilidad;
        this.nombreHabilidad = nombreHabilidad;
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

package com.irojas.demojwt.dto.equipo;


import com.irojas.demojwt.model.Mision;

public class EquipoDTO {
    private int idEquipo;
    private String nombreEquipo;
    private Mision idMision;

    public EquipoDTO() {
    }

    public EquipoDTO(int idEquipo, String nombreEquipo, Mision idMision) {
        this.idEquipo = idEquipo;
        this.nombreEquipo = nombreEquipo;
        this.idMision = idMision;
    }



    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public Mision getIdMision() {
        return idMision;
    }

    public void setIdMision(Mision idMision) {
        this.idMision = idMision;
    }
}

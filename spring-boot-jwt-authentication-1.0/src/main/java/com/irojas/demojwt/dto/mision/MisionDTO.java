package com.irojas.demojwt.dto.mision;


import java.sql.Date;

public class MisionDTO {
    private int idMision;
    private String nombreMision;
    private Date fechaLanzamiento;
    private Date fechaFinalizacion;

    public MisionDTO() {
    }

    public MisionDTO(int idMision, String nombreMision, Date fechaLanzamiento, Date fechaFinalizacion) {
        this.idMision = idMision;
        this.nombreMision = nombreMision;
        this.fechaLanzamiento = fechaLanzamiento;
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public int getIdMision() {
        return idMision;
    }

    public void setIdMision(int idMision) {
        this.idMision = idMision;
    }

    public String getNombreMision() {
        return nombreMision;
    }

    public void setNombreMision(String nombreMision) {
        this.nombreMision = nombreMision;
    }

    public Date getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(Date fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public Date getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(Date fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }
}

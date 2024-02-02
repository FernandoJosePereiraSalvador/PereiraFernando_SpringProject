package com.irojas.demojwt.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "Mision")
public class Mision {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Mision")
    private Integer idMision;

    @Column(name = "Nombre_Mision")
    private String nombreMision;

    @Column(name = "Fecha_Lanzamiento")
    private Date fechaLanzamiento;

    @Column(name = "Fecha_Finalizacion")
    private Date fechaFinalizacion;
    public Mision() {
    }

    public Mision(String nombreMision, Date fechaLanzamiento, Date fechaFinalizacion) {
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

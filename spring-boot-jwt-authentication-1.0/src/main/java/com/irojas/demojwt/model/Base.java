/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.irojas.demojwt.model;

import jakarta.persistence.*;

@Entity
@Table(name = "base")
public class Base{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Base")
    private int idBase;

    @Column(name = "localizacion")
    private String localizacion;

    @Column(name = "Nombre_Base")
    private String nombreBase;

    public Base() {
    }

    public int getIdBase() {
        return idBase;
    }

    public void setIdBase(int idBase) {
        this.idBase = idBase;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public String getNombreBase() {
        return nombreBase;
    }

    public void setNombreBase(String nombreBase) {
        this.nombreBase = nombreBase;
    }

    @Override
    public String toString() {
        return "Base{" +
                "idBase=" + idBase +
                ", localizacion='" + localizacion + '\'' +
                ", nombreBase='" + nombreBase + '\'' +
                '}';
    }
}

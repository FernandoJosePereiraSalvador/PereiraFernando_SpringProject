package com.irojas.demojwt.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Nave")
public class Nave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Nave")
    private int idNave;

    @Column(name = "Nombre_Nave")
    private String nombreNave;

    @ManyToOne
    @JoinColumn(name = "ID_Base", referencedColumnName = "ID_Base")
    private Base base;


    public Nave() {
    }

    public Nave(String nombreNave, Base base) {
        this.nombreNave = nombreNave;
        this.base = base;
    }

    public int getIdNave() {
        return idNave;
    }

    public void setIdNave(int idNave) {
        this.idNave = idNave;
    }

    public String getNombreNave() {
        return nombreNave;
    }

    public void setNombreNave(String nombreNave) {
        this.nombreNave = nombreNave;
    }

    public Base getBase() {
        return base;
    }

    public void setBase(Base base) {
        this.base = base;
    }


}

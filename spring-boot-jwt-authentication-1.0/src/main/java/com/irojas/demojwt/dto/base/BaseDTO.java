package com.irojas.demojwt.dto.base;


public class BaseDTO{
    private int idBase;
    private String localizacion;
    private String nombreBase;

    public BaseDTO() {
    }

    public BaseDTO(int idBase, String localizacion, String nombreBase) {
        this.idBase = idBase;
        this.localizacion = localizacion;
        this.nombreBase = nombreBase;
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
}

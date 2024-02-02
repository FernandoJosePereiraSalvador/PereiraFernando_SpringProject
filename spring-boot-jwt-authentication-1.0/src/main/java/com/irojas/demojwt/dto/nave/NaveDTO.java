package com.irojas.demojwt.dto.nave;

public class NaveDTO {
    private int idNave;
    private String nombreNave;
    private int idBase;

    public NaveDTO() {
    }

    public NaveDTO(int idNave, String nombreNave, int idBase) {
        this.idNave = idNave;
        this.nombreNave = nombreNave;
        this.idBase = idBase;
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

    public int getIdBase() {
        return idBase;
    }

    public void setIdBase(int idBase) {
        this.idBase = idBase;
    }
}

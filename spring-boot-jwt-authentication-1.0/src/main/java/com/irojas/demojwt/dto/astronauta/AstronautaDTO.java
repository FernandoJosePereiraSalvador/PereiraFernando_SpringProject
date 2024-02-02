package com.irojas.demojwt.dto.astronauta;

import com.irojas.demojwt.dto.habilidad.HabilidadDTO;
import com.irojas.demojwt.model.Cargo;
import com.irojas.demojwt.model.Equipo;

import java.time.LocalDate;
import java.util.Set;

public class AstronautaDTO {

    private Integer idAstronauta;
    private String nombre;
    private String apellidos;
    private LocalDate fechaNacimiento;
    private LocalDate fechaIngresoNASA;
    private String sexo;
    private String nacionalidad;
    private Integer numVuelosEspaciales;
    private float horasEspacio;
    private Equipo idEquipo;
    private Cargo idCargo;

    private String nombreCompleto;

    private Set<HabilidadDTO> habilidades;

    public Set<HabilidadDTO> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(Set<HabilidadDTO> habilidades) {
        this.habilidades = habilidades;
    }

    public AstronautaDTO() {
    }

    public AstronautaDTO(Integer idAstronauta, String nombre, String apellidos, LocalDate fechaNacimiento,
                         LocalDate fechaIngresoNASA, String sexo, String nacionalidad, Integer numVuelosEspaciales,
                         float horasEspacio, Equipo idEquipo, Cargo idCargo, Set<HabilidadDTO> habilidades) {
        this.idAstronauta = idAstronauta;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaIngresoNASA = fechaIngresoNASA;
        this.sexo = sexo;
        this.nacionalidad = nacionalidad;
        this.numVuelosEspaciales = numVuelosEspaciales;
        this.horasEspacio = horasEspacio;
        this.idEquipo = idEquipo;
        this.idCargo = idCargo;
        this.habilidades = habilidades;

        this.nombreCompleto = nombre + " " + apellidos;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public Integer getIdAstronauta() {
        return idAstronauta;
    }

    public void setIdAstronauta(Integer idAstronauta) {
        this.idAstronauta = idAstronauta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public LocalDate getFechaIngresoNASA() {
        return fechaIngresoNASA;
    }

    public void setFechaIngresoNASA(LocalDate fechaIngresoNASA) {
        this.fechaIngresoNASA = fechaIngresoNASA;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Integer getNumVuelosEspaciales() {
        return numVuelosEspaciales;
    }

    public void setNumVuelosEspaciales(Integer numVuelosEspaciales) {
        this.numVuelosEspaciales = numVuelosEspaciales;
    }

    public float getHorasEspacio() {
        return horasEspacio;
    }

    public void setHorasEspacio(float horasEspacio) {
        this.horasEspacio = horasEspacio;
    }

    public Equipo getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Equipo idEquipo) {
        this.idEquipo = idEquipo;
    }

    public Cargo getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Cargo idCargo) {
        this.idCargo = idCargo;
    }
}

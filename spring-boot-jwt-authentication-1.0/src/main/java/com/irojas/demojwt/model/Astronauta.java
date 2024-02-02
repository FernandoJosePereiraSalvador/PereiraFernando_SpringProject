package com.irojas.demojwt.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Astronauta")
public class Astronauta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Astronauta", columnDefinition = "BIGINT")
    private Integer idAstronauta;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Apellidos")
    private String apellidos;

    @Column(name = "Fecha_Nacimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "Fecha_Ingreso_NASA")
    private LocalDate fechaIngresoNASA;

    @Column(name = "Sexo")
    private String sexo;

    @Column(name = "Nacionalidad")
    private String nacionalidad;

    @Transient
    private String nombreCompleto;

    public String getNombreCompleto() {
        return nombre + " " + apellidos;
    }

    @Column(name = "Num_Vuelos_Espaciales")
    private Integer numVuelosEspaciales;

    @Column(name = "Horas_Espacio", columnDefinition = "DECIMAL")
    private float horasEspacio;

    @ManyToOne
    @JoinColumn(name = "ID_Equipo")
    private Equipo equipo;

    @ManyToOne
    @JoinColumn(name = "ID_Cargo")
    private Cargo cargo;

    @ManyToMany
    @JsonManagedReference
    @JsonBackReference
    @JoinTable(
            name = "Astronauta_Habilidad",
            joinColumns = @JoinColumn(name = "ID_Astronauta"),
            inverseJoinColumns = @JoinColumn(name = "ID_Habilidad")
    )
    private Set<Habilidad> habilidades = new HashSet<>();

    public Set<Habilidad> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(Set<Habilidad> habilidades) {
        this.habilidades = habilidades;
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

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
}

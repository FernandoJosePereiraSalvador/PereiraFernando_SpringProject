package com.irojas.demojwt.dto.astronauta;

import com.irojas.demojwt.dto.habilidad.HabilidadDTOConverter;
import com.irojas.demojwt.model.Astronauta;

import java.util.stream.Collectors;

public class AstronautaDTOConverter {

    /*
     * Converts an entity to a corresponding DTO.
     * @param astronauta The entity to be converted.
     * @return AstronautaDTO representing the converted entity.
     */
    public static AstronautaDTO convertToDTO(Astronauta astronauta) {
        AstronautaDTO astronautaDTO = new AstronautaDTO();
        astronautaDTO.setIdAstronauta(astronauta.getIdAstronauta());
        astronautaDTO.setNombre(astronauta.getNombre());
        astronautaDTO.setApellidos(astronauta.getApellidos());
        astronautaDTO.setFechaNacimiento(astronauta.getFechaNacimiento());
        astronautaDTO.setFechaIngresoNASA(astronauta.getFechaIngresoNASA());
        astronautaDTO.setSexo(astronauta.getSexo());
        astronautaDTO.setNacionalidad(astronauta.getNacionalidad());
        astronautaDTO.setNumVuelosEspaciales(astronauta.getNumVuelosEspaciales());
        astronautaDTO.setHorasEspacio(astronauta.getHorasEspacio());
        astronautaDTO.setIdEquipo(astronauta.getEquipo());
        astronautaDTO.setIdCargo(astronauta.getCargo());
        astronautaDTO.setNombreCompleto(astronauta.getNombre() + " " + astronauta.getApellidos());
        astronautaDTO.setHabilidades(
                astronauta.getHabilidades().stream()
                        .map(HabilidadDTOConverter::convertToDTO)
                        .collect(Collectors.toSet())
        );
        return astronautaDTO;
    }

    /*
     * Converts a DTO to a corresponding entity.
     * @param astronautaDTO The DTO to be converted.
     * @return Astronauta representing the converted DTO.
     */
    public static Astronauta convertToEntity(AstronautaDTO astronautaDTO) {
        Astronauta astronauta = new Astronauta();
        astronauta.setIdAstronauta(astronautaDTO.getIdAstronauta());
        astronauta.setNombre(astronautaDTO.getNombre());
        astronauta.setApellidos(astronautaDTO.getApellidos());
        astronauta.setFechaNacimiento(astronautaDTO.getFechaNacimiento());
        astronauta.setFechaIngresoNASA(astronautaDTO.getFechaIngresoNASA());
        astronauta.setSexo(astronautaDTO.getSexo());
        astronauta.setNacionalidad(astronautaDTO.getNacionalidad());
        astronauta.setNumVuelosEspaciales(astronautaDTO.getNumVuelosEspaciales());
        astronauta.setHorasEspacio(astronautaDTO.getHorasEspacio());
        astronauta.setEquipo(astronautaDTO.getIdEquipo());
        astronauta.setCargo(astronautaDTO.getIdCargo());
        astronautaDTO.setNombreCompleto(astronauta.getNombre() + " " + astronauta.getApellidos());

        astronauta.setHabilidades(
                astronautaDTO.getHabilidades().stream()
                        .map(HabilidadDTOConverter::convertToEntity)
                        .collect(Collectors.toSet())
        );

        return astronauta;
    }
}

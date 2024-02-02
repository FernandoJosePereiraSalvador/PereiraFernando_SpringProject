package com.irojas.demojwt.dto.equipo;

import com.irojas.demojwt.model.Equipo;

public class EquipoDTOConverter {

    /*
     * Converts a entity to a corresponding DTO.
     * @param base The entity to be converted.
     * @return BaseDTO representing the converted entity.
     */
    public static EquipoDTO convertToDTO(Equipo equipo) {
        EquipoDTO equipoDTO = new EquipoDTO();
        equipoDTO.setIdEquipo(equipo.getIdEquipo());
        equipoDTO.setNombreEquipo(equipo.getNombreEquipo());
        equipoDTO.setIdMision(equipo.getMision());

        return equipoDTO;
    }

    /*
     * Converts a DTO to a corresponding entity.
     * @param The DTO to be converted.
     * @return Entity representing the converted DTO.
     */
    public static Equipo convertToEntity(EquipoDTO equipoDTO) {
        Equipo equipo = new Equipo();
        equipo.setIdEquipo(equipoDTO.getIdEquipo());
        equipo.setNombreEquipo(equipoDTO.getNombreEquipo());
        equipo.setMision(equipoDTO.getIdMision());

        return equipo;
    }

}

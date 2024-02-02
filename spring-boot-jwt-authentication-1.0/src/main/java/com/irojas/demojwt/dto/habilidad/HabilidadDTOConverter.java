package com.irojas.demojwt.dto.habilidad;


import com.irojas.demojwt.model.Habilidad;

public class HabilidadDTOConverter {

    /*
     * Converts an entity to a corresponding DTO.
     * @param habilidad The entity to be converted.
     * @return HabilidadDTO representing the converted entity.
     */
    public static HabilidadDTO convertToDTO(Habilidad habilidad) {
        HabilidadDTO habilidadDTO = new HabilidadDTO();
        habilidadDTO.setIdHabilidad(habilidad.getIdHabilidad());
        habilidadDTO.setNombreHabilidad(habilidad.getNombreHabilidad());
        habilidadDTO.setAstronautas(habilidad.getAstronautas());
        return habilidadDTO;
    }

    /*
     * Converts a DTO to a corresponding entity.
     * @param habilidadDTO The DTO to be converted.
     * @return Entity representing the converted DTO.
     */
    public static Habilidad convertToEntity(HabilidadDTO habilidadDTO) {
        Habilidad habilidad = new Habilidad();
        habilidad.setIdHabilidad(habilidadDTO.getIdHabilidad());
        habilidad.setNombreHabilidad(habilidadDTO.getNombreHabilidad());
        habilidad.setAstronautas(habilidadDTO.getAstronautas());
        return habilidad;
    }
}

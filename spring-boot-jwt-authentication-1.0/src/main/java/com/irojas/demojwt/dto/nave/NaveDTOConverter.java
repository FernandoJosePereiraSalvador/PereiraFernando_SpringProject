package com.irojas.demojwt.dto.nave;


import com.irojas.demojwt.model.Nave;

public class NaveDTOConverter {

    /*
     * Converts a entity to a corresponding DTO.
     * @param base The entity to be converted.
     * @return BaseDTO representing the converted entity.
     */
    public static NaveDTO convertToDTO(Nave nave) {
        NaveDTO naveDTO = new NaveDTO();
        naveDTO.setIdNave(nave.getIdNave());
        naveDTO.setNombreNave(nave.getNombreNave());
        naveDTO.setIdNave(nave.getIdNave());

        return naveDTO;
    }

    /*
     * Converts a DTO to a corresponding entity.
     * @param The DTO to be converted.
     * @return Entity representing the converted DTO.
     */
    public static Nave convertToEntity(NaveDTO naveDTO) {
        Nave nave = new Nave();
        nave.setIdNave(naveDTO.getIdNave());
        nave.setNombreNave(naveDTO.getNombreNave());
        nave.setIdNave(naveDTO.getIdNave());


        return nave;
    }


}


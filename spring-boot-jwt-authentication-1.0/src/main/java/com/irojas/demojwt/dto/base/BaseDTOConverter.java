package com.irojas.demojwt.dto.base;

import com.irojas.demojwt.model.Base;

public class BaseDTOConverter {

    /*
     * Converts a entity to a corresponding DTO.
     * @param base The entity to be converted.
     * @return BaseDTO representing the converted entity.
     */
    public static BaseDTO convertToDTO(Base base) {
        BaseDTO baseDTO = new BaseDTO();
        baseDTO.setIdBase(base.getIdBase());
        baseDTO.setLocalizacion(base.getLocalizacion());
        baseDTO.setNombreBase(base.getNombreBase());
        return baseDTO;
    }

    /*
     * Converts a DTO to a corresponding entity.
     * @param The DTO to be converted.
     * @return Entity representing the converted DTO.
     */
    public static Base convertToEntity(BaseDTO baseDTO) {
        Base base = new Base();
        base.setIdBase(baseDTO.getIdBase());
        base.setLocalizacion(baseDTO.getLocalizacion());
        base.setNombreBase(baseDTO.getNombreBase());
        return base;
    }
}

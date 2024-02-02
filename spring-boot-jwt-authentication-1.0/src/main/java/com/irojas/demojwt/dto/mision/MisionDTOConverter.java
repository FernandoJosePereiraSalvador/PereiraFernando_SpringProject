package com.irojas.demojwt.dto.mision;


import com.irojas.demojwt.model.Mision;

public class MisionDTOConverter {

    /*
     * Converts a entity to a corresponding DTO.
     * @param base The entity to be converted.
     * @return BaseDTO representing the converted entity.
     */
    public static MisionDTO convertToDTO(Mision mision) {
        MisionDTO misionDTO = new MisionDTO();
        misionDTO.setIdMision(mision.getIdMision());
        misionDTO.setNombreMision(mision.getNombreMision());
        misionDTO.setFechaLanzamiento(mision.getFechaLanzamiento());
        misionDTO.setFechaFinalizacion(mision.getFechaFinalizacion());
        return misionDTO;
    }

    /*
     * Converts a DTO to a corresponding entity.
     * @param The DTO to be converted.
     * @return Entity representing the converted DTO.
     */
    public static Mision convertToEntity(MisionDTO misionDTO) {
        Mision mision = new Mision();
        mision.setIdMision(misionDTO.getIdMision());
        mision.setNombreMision(misionDTO.getNombreMision());
        mision.setFechaLanzamiento(misionDTO.getFechaLanzamiento());
        mision.setFechaFinalizacion(misionDTO.getFechaFinalizacion());
        return mision;
    }
}

package com.irojas.demojwt.dto.cargo;


import com.irojas.demojwt.model.Cargo;

public class CargoDTOConverter {

    /*
     * Converts a Cargo entity to a corresponding CargoDTO.
     * @param cargo The Cargo entity to be converted.
     * @return CargoDTO representing the converted entity.
     */
    public static CargoDTO convertToDTO(Cargo cargo) {
        CargoDTO cargoDTO = new CargoDTO();
        cargoDTO.setIdCargo(cargo.getIdCargo());
        cargoDTO.setNombreCargo(cargo.getNombreCargo());
        return cargoDTO;
    }

    /*
     * Converts a CargoDTO to a corresponding Cargo entity.
     * @param cargoDTO The CargoDTO to be converted.
     * @return Cargo representing the converted DTO.
     */
    public static Cargo convertToEntity(CargoDTO cargoDTO) {
        Cargo cargo = new Cargo();
        cargo.setIdCargo(cargoDTO.getIdCargo());
        cargo.setNombreCargo(cargoDTO.getNombreCargo());
        return cargo;
    }
}

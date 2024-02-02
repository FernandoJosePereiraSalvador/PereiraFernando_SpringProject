package com.irojas.demojwt.service.cargo;


import com.irojas.demojwt.dto.cargo.CargoDTO;

import java.util.List;

public interface CargoService {

    void saveCargo(CargoDTO cargoDTO);
    CargoDTO getCargoById(Integer id);
    List<CargoDTO> listAllCargos();
    void deleteCargo(Integer id);
}

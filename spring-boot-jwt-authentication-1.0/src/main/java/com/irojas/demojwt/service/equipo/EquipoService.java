package com.irojas.demojwt.service.equipo;


import com.irojas.demojwt.dto.equipo.EquipoDTO;

import java.util.List;

public interface EquipoService {

    void saveEquipo(EquipoDTO equipoDTO);
    EquipoDTO getEquipoById(Integer id);
    List<EquipoDTO> listAllEquipos();
    void deleteEquipo(Integer id);
}

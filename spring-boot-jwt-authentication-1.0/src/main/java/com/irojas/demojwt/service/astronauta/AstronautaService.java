package com.irojas.demojwt.service.astronauta;


import com.irojas.demojwt.dto.astronauta.AstronautaDTO;

import java.util.List;

public interface AstronautaService {

    void saveAstronauta(AstronautaDTO astronautaDTO);
    AstronautaDTO getAstronautaById(Integer id);
    List<AstronautaDTO> listAllAstronautas();
    void deleteAstronauta(Integer id);
}

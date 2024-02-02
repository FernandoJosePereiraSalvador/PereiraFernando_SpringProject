package com.irojas.demojwt.service.habilidad;


import com.irojas.demojwt.dto.habilidad.HabilidadDTO;

import java.util.List;

public interface HabilidadService {

    void saveHabilidad(HabilidadDTO habilidadDTO);
    HabilidadDTO getHabilidadById(Integer id);
    List<HabilidadDTO> listAllHabilidades();
    void deleteHabilidad(Integer id);
}

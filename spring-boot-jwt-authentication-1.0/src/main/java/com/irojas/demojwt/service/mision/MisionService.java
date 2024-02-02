package com.irojas.demojwt.service.mision;


import com.irojas.demojwt.dto.mision.MisionDTO;

import java.util.List;

public interface MisionService {

    void saveMision(MisionDTO misionDTO);
    MisionDTO getMisionById(Integer id);
    List<MisionDTO> listAllMisiones();
    void deleteMision(Integer id);
}

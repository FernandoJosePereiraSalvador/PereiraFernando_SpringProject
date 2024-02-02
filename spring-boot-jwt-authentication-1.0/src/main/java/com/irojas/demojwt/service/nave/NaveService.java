package com.irojas.demojwt.service.nave;


import com.irojas.demojwt.dto.nave.NaveDTO;

import java.util.List;

public interface NaveService {

    void saveNave(NaveDTO naveDTO);
    NaveDTO getNaveById(Integer id);
    List<NaveDTO> listAllNaves();
    void deleteNave(Integer id);
}

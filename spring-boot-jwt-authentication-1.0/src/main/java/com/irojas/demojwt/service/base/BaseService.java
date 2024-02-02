package com.irojas.demojwt.service.base;



import com.irojas.demojwt.dto.base.BaseDTO;

import java.util.List;


public interface BaseService {

    void saveBase(BaseDTO baseDTO);
    BaseDTO getBaseById(Integer id);
    List<BaseDTO> listAllBases();
    void deleteBase(Integer id);
}

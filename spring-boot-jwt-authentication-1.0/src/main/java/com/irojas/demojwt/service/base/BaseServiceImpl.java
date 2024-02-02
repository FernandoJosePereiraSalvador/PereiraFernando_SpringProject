package com.irojas.demojwt.service.base;

import com.irojas.demojwt.dto.base.BaseDTO;
import com.irojas.demojwt.dto.base.BaseDTOConverter;
import com.irojas.demojwt.model.Base;
import com.irojas.demojwt.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BaseServiceImpl implements BaseService {

    @Autowired
    private BaseRepository baseRepository;

    /*
     * Saves a entity to the database.
     * @param baseDTO The DTO representing the entity to be saved.
     */
    @Override
    public void saveBase(BaseDTO baseDTO) {
        Base base = BaseDTOConverter.convertToEntity(baseDTO);
        baseRepository.save(base);
    }

    /*
     * Retrieves a specific entity by its identifier.
     * @param id The identifier of the entity to be retrieved.
     * @return DTO representing the retrieved entity or null if not found.
     */
    @Override
    public BaseDTO getBaseById(Integer id) {
        Optional<Base> base = baseRepository.findById(Integer.valueOf(id));
        if (base.isPresent()) {
            return BaseDTOConverter.convertToDTO(base.get());
        } else {
            return null;
        }
    }

    /*
     * Retrieves a list of all entities in the database.
     * @return List<DTO> representing the list of retrieved entities.
     */
    @Override
    public List<BaseDTO> listAllBases() {
        List<Base> lista = baseRepository.findAll();
        List<BaseDTO> listaResultado = new ArrayList<>();
        for (Base base : lista) {
            listaResultado.add(BaseDTOConverter.convertToDTO(base));
        }
        return listaResultado;
    }

    /*
     * Deletes a specific entity from the database by its identifier.
     * @param id The identifier of the entity to be deleted.
     */
    @Override
    public void deleteBase(Integer id) {
        baseRepository.deleteById(Integer.valueOf(id));
    }
}


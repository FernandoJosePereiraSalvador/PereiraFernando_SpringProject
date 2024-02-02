package com.irojas.demojwt.service.mision;


import com.irojas.demojwt.dto.mision.MisionDTO;
import com.irojas.demojwt.dto.mision.MisionDTOConverter;
import com.irojas.demojwt.model.Mision;
import com.irojas.demojwt.repository.MisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MisionServiceImpl implements MisionService {

    @Autowired
    private MisionRepository misionRepository;

    /*
     * Saves a entity to the database.
     * @param baseDTO The DTO representing the entity to be saved.
     */
    @Override
    public void saveMision(MisionDTO misionDTO) {
        Mision mision = MisionDTOConverter.convertToEntity(misionDTO);
        misionRepository.save(mision);
    }

    /*
     * Retrieves a specific entity by its identifier.
     * @param id The identifier of the entity to be retrieved.
     * @return DTO representing the retrieved entity or null if not found.
     */
    @Override
    public MisionDTO getMisionById(Integer id) {
        Optional<Mision> mision = misionRepository.findById(id);
        return mision.map(MisionDTOConverter::convertToDTO).orElse(null);
    }

    /*
     * Retrieves a list of all entities in the database.
     * @return List<DTO> representing the list of retrieved entities.
     */
    @Override
    public List<MisionDTO> listAllMisiones() {
        List<Mision> lista = misionRepository.findAll();
        List<MisionDTO> listaResultado = new ArrayList<>();
        for (Mision mision : lista) {
            listaResultado.add(MisionDTOConverter.convertToDTO(mision));
        }
        return listaResultado;
    }

    /*
     * Deletes a specific entity from the database by its identifier.
     * @param id The identifier of the entity to be deleted.
     */
    @Override
    public void deleteMision(Integer id) {
        misionRepository.deleteById(id);
    }
}

package com.irojas.demojwt.service.nave;


import com.irojas.demojwt.dto.nave.NaveDTO;
import com.irojas.demojwt.dto.nave.NaveDTOConverter;
import com.irojas.demojwt.model.Nave;
import com.irojas.demojwt.repository.NaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NaveServiceImpl implements NaveService {

    @Autowired
    private NaveRepository naveRepository;

    /*
     * Saves a entity to the database.
     * @param baseDTO The DTO representing the entity to be saved.
     */
    @Override
    public void saveNave(NaveDTO naveDTO) {
        Nave nave = NaveDTOConverter.convertToEntity(naveDTO);
        naveRepository.save(nave);
    }

    /*
     * Retrieves a specific entity by its identifier.
     * @param id The identifier of the entity to be retrieved.
     * @return DTO representing the retrieved entity or null if not found.
     */
    @Override
    public NaveDTO getNaveById(Integer id) {
        Optional<Nave> nave = naveRepository.findById(id);
        if (nave.isPresent()) {
            return NaveDTOConverter.convertToDTO(nave.get());
        } else {
            return null;
        }
    }

    /*
     * Retrieves a list of all entities in the database.
     * @return List<DTO> representing the list of retrieved entities.
     */
    @Override
    public List<NaveDTO> listAllNaves() {
        List<Nave> lista = naveRepository.findAll();
        List<NaveDTO> listaResultado = new ArrayList<>();
        for (Nave nave : lista) {
            listaResultado.add(NaveDTOConverter.convertToDTO(nave));
        }
        return listaResultado;
    }

    /*
     * Deletes a specific entity from the database by its identifier.
     * @param id The identifier of the entity to be deleted.
     */
    @Override
    public void deleteNave(Integer id) {
        naveRepository.deleteById(id);
    }
}

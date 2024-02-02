package com.irojas.demojwt.service.habilidad;

import com.irojas.demojwt.dto.habilidad.HabilidadDTO;
import com.irojas.demojwt.dto.habilidad.HabilidadDTOConverter;
import com.irojas.demojwt.model.Habilidad;
import com.irojas.demojwt.repository.HabilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HabilidadServiceImpl implements HabilidadService {

    @Autowired
    private HabilidadRepository habilidadRepository;

    /*
     * Saves a entity to the database.
     * @param habilidadDTO The DTO representing the entity to be saved.
     */
    @Override
    public void saveHabilidad(HabilidadDTO habilidadDTO) {
        Habilidad habilidad = HabilidadDTOConverter.convertToEntity(habilidadDTO);
        habilidadRepository.save(habilidad);
    }

    /*
     * Retrieves a specific entity by its identifier.
     * @param id The identifier of the entity to be retrieved.
     * @return DTO representing the retrieved entity or null if not found.
     */
    @Override
    public HabilidadDTO getHabilidadById(Integer id) {
        Optional<Habilidad> habilidad = habilidadRepository.findById(id);
        return habilidad.map(HabilidadDTOConverter::convertToDTO).orElse(null);
    }

    /*
     * Retrieves a list of all entities in the database.
     * @return List<DTO> representing the list of retrieved entities.
     */
    @Override
    public List<HabilidadDTO> listAllHabilidades() {
        List<Habilidad> lista = habilidadRepository.findAll();
        List<HabilidadDTO> listaResultado = new ArrayList<>();
        for (Habilidad habilidad : lista) {
            listaResultado.add(HabilidadDTOConverter.convertToDTO(habilidad));
        }
        return listaResultado;
    }

    /*
     * Deletes a specific entity from the database by its identifier.
     * @param id The identifier of the entity to be deleted.
     */
    @Override
    public void deleteHabilidad(Integer id) {
        habilidadRepository.deleteById(id);
    }
}

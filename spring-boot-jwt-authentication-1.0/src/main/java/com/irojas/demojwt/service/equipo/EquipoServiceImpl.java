package com.irojas.demojwt.service.equipo;

import com.irojas.demojwt.dto.equipo.EquipoDTO;
import com.irojas.demojwt.dto.equipo.EquipoDTOConverter;
import com.irojas.demojwt.model.Equipo;
import com.irojas.demojwt.repository.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EquipoServiceImpl implements EquipoService {

    @Autowired
    private EquipoRepository equipoRepository;

    /*
     * Saves a entity to the database.
     * @param baseDTO The DTO representing the entity to be saved.
     */
    @Override
    public void saveEquipo(EquipoDTO equipoDTO) {
        Equipo equipo = EquipoDTOConverter.convertToEntity(equipoDTO);
        equipoRepository.save(equipo);
    }

    /*
     * Retrieves a specific entity by its identifier.
     * @param id The identifier of the entity to be retrieved.
     * @return DTO representing the retrieved entity or null if not found.
     */
    @Override
    public EquipoDTO getEquipoById(Integer id) {
        Optional<Equipo> equipo = equipoRepository.findById(id);
        return equipo.map(EquipoDTOConverter::convertToDTO).orElse(null);
    }

    /*
     * Retrieves a list of all entities in the database.
     * @return List<DTO> representing the list of retrieved entities.
     */
    @Override
    public List<EquipoDTO> listAllEquipos() {
        List<Equipo> lista = equipoRepository.findAll();
        List<EquipoDTO> listaResultado = new ArrayList<>();
        for (Equipo equipo : lista) {
            listaResultado.add(EquipoDTOConverter.convertToDTO(equipo));
        }
        return listaResultado;
    }

    /*
     * Deletes a specific entity from the database by its identifier.
     * @param id The identifier of the entity to be deleted.
     */
    @Override
    public void deleteEquipo(Integer id) {
        equipoRepository.deleteById(id);
    }
}

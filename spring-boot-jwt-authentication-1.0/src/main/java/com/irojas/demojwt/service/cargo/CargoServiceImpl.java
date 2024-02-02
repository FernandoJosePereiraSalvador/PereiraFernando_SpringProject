package com.irojas.demojwt.service.cargo;

import com.irojas.demojwt.dto.cargo.CargoDTO;
import com.irojas.demojwt.dto.cargo.CargoDTOConverter;
import com.irojas.demojwt.model.Cargo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.irojas.demojwt.repository.CargoRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CargoServiceImpl implements CargoService {

    @Autowired
    private CargoRepository CargoRepository;

    /*
     * Saves an entity to the database.
     * @param CargoDTO The DTO representing the entity to be saved.
     */
    @Override
    public void saveCargo(CargoDTO CargoDTO) {
        Cargo Cargo = CargoDTOConverter.convertToEntity(CargoDTO);
        CargoRepository.save(Cargo);
    }

    /*
     * Retrieves a specific entity by its identifier.
     * @param id The identifier of the entity to be retrieved.
     * @return DTO representing the retrieved entity or null if not found.
     */
    @Override
    public CargoDTO getCargoById(Integer id) {
        Optional<Cargo> Cargo = CargoRepository.findById(id);
        return Cargo.map(CargoDTOConverter::convertToDTO).orElse(null);

    }

    /*
     * Retrieves a list of all entities in the database.
     * @return List<DTO> representing the list of retrieved entities.
     */
    @Override
    public List<CargoDTO> listAllCargos() {
        List<Cargo> lista = CargoRepository.findAll();
        List<CargoDTO> listaResultado = new ArrayList<>();
        for (Cargo cargo : lista) {
            listaResultado.add(CargoDTOConverter.convertToDTO(cargo));
        }
        return listaResultado;
    }

    /*
     * Deletes a specific entity from the database by its identifier.
     * @param id The identifier of the entity to be deleted.
     */
    @Override
    public void deleteCargo(Integer id) {
        CargoRepository.deleteById(id);
    }
}

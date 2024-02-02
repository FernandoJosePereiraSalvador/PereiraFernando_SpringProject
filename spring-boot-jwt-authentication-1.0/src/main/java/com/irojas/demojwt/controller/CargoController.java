package com.irojas.demojwt.controller;

import com.irojas.demojwt.dto.cargo.CargoDTO;
import com.irojas.demojwt.service.cargo.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cargo")
public class CargoController {

    @Autowired
    private CargoService cargoService;

    /*
     * Handles HTTP POST requests to insert a new Cargo entity.
     * @param cargoDTO The DTO representing the Cargo entity to be inserted.
     * @return ResponseEntity<String> indicating success or failure of the operation.
     */
    @PostMapping("/insertar")
    public ResponseEntity<String> insertarCargo(@RequestBody CargoDTO cargoDTO) {
        try {
            cargoService.saveCargo(cargoDTO);
            return new ResponseEntity<>("Cargo inserted successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al insertar el cargo", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*
     * Handles HTTP GET requests to retrieve information about a specific Cargo entity.
     * @param id The identifier of the Cargo entity to be retrieved.
     * @return ResponseEntity<CargoDTO> containing the retrieved Cargo entity or an error response.
     */
    @GetMapping("/obtener/{id}")
    public ResponseEntity<CargoDTO> obtenerCargo(@PathVariable Integer id) {
        CargoDTO cargoDTO = cargoService.getCargoById(id);
        if (cargoDTO != null) {
            return new ResponseEntity<>(cargoDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /*
     * Handles HTTP GET requests to retrieve a list of all Cargo entities.
     * @return ResponseEntity<List<CargoDTO>> containing the list of Cargo entities or an error response.
     */
    @GetMapping("/listar")
    public ResponseEntity<List<CargoDTO>> listarCargos() {
        List<CargoDTO> cargos = cargoService.listAllCargos();
        return new ResponseEntity<>(cargos, HttpStatus.OK);
    }

    /*
     * Handles HTTP DELETE requests to delete a specific Cargo entity.
     * @param id The identifier of the Cargo entity to be deleted.
     * @return ResponseEntity<String> indicating success or failure of the deletion operation.
     */
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarCargo(@PathVariable Integer id) {
        try {
            cargoService.deleteCargo(id);
            return new ResponseEntity<>("Cargo eliminado correctamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar el cargo: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        String message = "Error: " + e.getMessage();
        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

package com.irojas.demojwt.controller;

import com.irojas.demojwt.dto.astronauta.AstronautaDTO;
import com.irojas.demojwt.service.astronauta.AstronautaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/astronautas")
@RequiredArgsConstructor
public class AstronautaController {

    @Autowired
    private AstronautaService astronautaService;

    /**
     * Handles HTTP POST requests to insert a new entity.
     *
     * @param astronautaDTO The DTO representing the astronaut to insert.
     * @return ResponseEntity indicating the result of the operation.
     */
    @PostMapping("/insertar")
    public ResponseEntity<String> insertarAstronauta(@RequestBody AstronautaDTO astronautaDTO) {
        try {
            astronautaService.saveAstronauta(astronautaDTO);
            return new ResponseEntity<>("Astronauta insertado correctamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al insertar el astronauta: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*
     * Handles HTTP GET requests to retrieve information about a specific entity.
     *
     * @param id The identifier of the entity to be retrieved.
     * @return ResponseEntity<AstronautaDTO> containing the retrieved entity or an error response.
     */
    @GetMapping("/obtener/{id}")
    public ResponseEntity<AstronautaDTO> obtenerAstronauta(@PathVariable Long id) {
        AstronautaDTO astronautaDTO = astronautaService.getAstronautaById(Math.toIntExact(id));
        if (astronautaDTO != null) {
            return new ResponseEntity<>(astronautaDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /*
     * Handles HTTP GET requests to retrieve a list of all entities.
     * @return ResponseEntity<List<AstronautaDTO>> containing the list of entities or an error response.
     */
    @GetMapping("/listar")
    public ResponseEntity<List<AstronautaDTO>> listarAstronautas() {
        List<AstronautaDTO> astronautas = astronautaService.listAllAstronautas();
        return new ResponseEntity<>(astronautas, HttpStatus.OK);
    }

    /*
     * Handles HTTP DELETE requests to delete a specific entity.
     * @param id The identifier of the entity to be deleted.
     * @return ResponseEntity<String> indicating success or failure of the deletion operation.
     */
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarAstronauta(@PathVariable Long id) {
        try {
            astronautaService.deleteAstronauta(Math.toIntExact(id));
            return new ResponseEntity<>("Astronauta eliminado correctamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar el astronauta: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        String message = "Error: " + e.getMessage();
        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

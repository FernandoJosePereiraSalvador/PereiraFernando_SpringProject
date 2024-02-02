package com.irojas.demojwt.controller;

import com.irojas.demojwt.dto.habilidad.HabilidadDTO;
import com.irojas.demojwt.service.habilidad.HabilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/habilidad")
public class HabilidadController {

    @Autowired
    private HabilidadService habilidadService;

    /*
     * Handles HTTP POST requests to insert a new entity.
     * @param habilidadDTO The DTO representing the entity to be inserted.
     * @return ResponseEntity<String> indicating success or failure of the operation.
     */
    @PostMapping("/insertar")
    public ResponseEntity<String> insertarHabilidad(@RequestBody HabilidadDTO habilidadDTO) {
        try {
            habilidadService.saveHabilidad(habilidadDTO);
            return new ResponseEntity<>("Habilidad insertada correctamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al insertar la habilidad: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*
     * Handles HTTP GET requests to retrieve information about a specific entity.
     * @param id The identifier of the entity to be retrieved.
     * @return ResponseEntity<HabilidadDTO> containing the retrieved entity or an error response.
     */
    @GetMapping("/obtener/{id}")
    public ResponseEntity<HabilidadDTO> obtenerHabilidad(@PathVariable Integer id) {
        HabilidadDTO habilidadDTO = habilidadService.getHabilidadById(id);
        if (habilidadDTO != null) {
            return new ResponseEntity<>(habilidadDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /*
     * Handles HTTP GET requests to retrieve a list of all entities.
     * @return ResponseEntity<List<HabilidadDTO>> containing the list of entities or an error response.
     */
    @GetMapping("/listar")
    public ResponseEntity<List<HabilidadDTO>> listarHabilidades() {
        List<HabilidadDTO> habilidades = habilidadService.listAllHabilidades();
        return new ResponseEntity<>(habilidades, HttpStatus.OK);
    }

    /*
     * Handles HTTP DELETE requests to delete a specific entity.
     * @param id The identifier of the entity to be deleted.
     * @return ResponseEntity<String> indicating success or failure of the deletion operation.
     */
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarHabilidad(@PathVariable Integer id) {
        try {
            habilidadService.deleteHabilidad(id);
            return new ResponseEntity<>("Habilidad eliminada correctamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar la habilidad: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*
     * Handles exceptions thrown within this controller.
     * @param e The exception.
     * @return ResponseEntity<String> containing an error message.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        String message = "Error: " + e.getMessage();
        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

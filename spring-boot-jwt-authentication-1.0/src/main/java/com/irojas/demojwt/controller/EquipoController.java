package com.irojas.demojwt.controller;

import com.irojas.demojwt.dto.equipo.EquipoDTO;
import com.irojas.demojwt.service.equipo.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/equipo")
public class EquipoController {

    @Autowired
    private EquipoService equipoService;

    /*
     * Handles HTTP POST requests to insert a new entity.
     * @param baseDTO The DTO representing the entity to be inserted.
     * @return ResponseEntity<String> indicating success or failure of the operation.
     */
    @PostMapping("/insertar")
    public ResponseEntity<String> insertarEquipo(@RequestBody EquipoDTO equipoDTO) {
        try {
            equipoService.saveEquipo(equipoDTO);
            return new ResponseEntity<>("Equipo insertado correctamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al insertar el equipo", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*
     * Handles HTTP GET requests to retrieve information about a specific entity.
     * @param id The identifier of the entity to be retrieved.
     * @return ResponseEntity<BaseDTO> containing the retrieved entity or an error response.
     */
    @GetMapping("/obtener/{id}")
    public ResponseEntity<EquipoDTO> obtenerEquipo(@PathVariable Integer id) {
        EquipoDTO equipoDTO = equipoService.getEquipoById(id);
        if (equipoDTO != null) {
            return new ResponseEntity<>(equipoDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /*
     * Handles HTTP GET requests to retrieve a list of all entities.
     * @return ResponseEntity<List<BaseDTO>> containing the list of entities or an error response.
     */
    @GetMapping("/listar")
    public ResponseEntity<List<EquipoDTO>> listarEquipos() {
        List<EquipoDTO> equipos = equipoService.listAllEquipos();
        return new ResponseEntity<>(equipos, HttpStatus.OK);
    }

    /*
     * Handles HTTP DELETE requests to delete a specific entity.
     * @param id The identifier of the entity to be deleted.
     * @return ResponseEntity<String> indicating success or failure of the deletion operation.
     */
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarEquipo(@PathVariable Integer id) {
        try {
            equipoService.deleteEquipo(id);
            return new ResponseEntity<>("Equipo eliminado correctamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar el equipo", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        String message = "Error: " + e.getMessage();
        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

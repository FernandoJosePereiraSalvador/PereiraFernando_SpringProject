package com.irojas.demojwt.controller;

import com.irojas.demojwt.dto.nave.NaveDTO;
import com.irojas.demojwt.service.nave.NaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/nave")
public class NaveController {

    @Autowired
    private NaveService naveService;

    /*
     * Handles HTTP POST requests to insert a new entity.
     * @param baseDTO The DTO representing the entity to be inserted.
     * @return ResponseEntity<String> indicating success or failure of the operation.
     */
    @PostMapping("/insertar")
    public ResponseEntity<String> insertarNave(@RequestBody NaveDTO naveDTO) {
        try {
            naveService.saveNave(naveDTO);
            return new ResponseEntity<>("Nave insertada correctamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al insertar la nave", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*
     * Handles HTTP GET requests to retrieve information about a specific entity.
     * @param id The identifier of the entity to be retrieved.
     * @return ResponseEntity<BaseDTO> containing the retrieved entity or an error response.
     */
    @GetMapping("/obtener/{id}")
    public ResponseEntity<NaveDTO> obtenerNave(@PathVariable Integer id) {
        NaveDTO naveDTO = naveService.getNaveById(id);
        if (naveDTO != null) {
            return new ResponseEntity<>(naveDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /*
     * Handles HTTP GET requests to retrieve a list of all entities.
     * @return ResponseEntity<List<BaseDTO>> containing the list of entities or an error response.
     */
    @GetMapping("/listar")
    public ResponseEntity<List<NaveDTO>> listarNaves() {
        List<NaveDTO> naves = naveService.listAllNaves();
        return new ResponseEntity<>(naves, HttpStatus.OK);
    }

    /*
     * Handles HTTP DELETE requests to delete a specific entity.
     * @param id The identifier of the entity to be deleted.
     * @return ResponseEntity<String> indicating success or failure of the deletion operation.
     */
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarNave(@PathVariable Integer id) {
        try {
            naveService.deleteNave(id);
            return new ResponseEntity<>("Nave eliminada correctamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar la nave", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        String message = "Error: " + e.getMessage();
        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

package com.irojas.demojwt.controller;

import com.irojas.demojwt.dto.base.BaseDTO;
import com.irojas.demojwt.service.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/base")
public class BaseController {

    @Autowired
    private BaseService baseService;

    /*
     * Handles HTTP POST requests to insert a new entity.
     * @param baseDTO The DTO representing the entity to be inserted.
     * @return ResponseEntity<String> indicating success or failure of the operation.
     */
    @PostMapping("/insertar")
    public ResponseEntity<String> insertarBase(@RequestBody BaseDTO baseDTO) {
        try {
            baseService.saveBase(baseDTO);
            return new ResponseEntity<>("Base insertada correctamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al insertar la base", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*
     * Handles HTTP GET requests to retrieve information about a specific entity.
     * @param id The identifier of the entity to be retrieved.
     * @return ResponseEntity<BaseDTO> containing the retrieved entity or an error response.
     */
    @GetMapping("/obtener/{id}")
    public ResponseEntity<BaseDTO> obtenerBase(@PathVariable Integer id) {
        BaseDTO baseDTO = baseService.getBaseById(id);
        if (baseDTO != null) {
            return new ResponseEntity<>(baseDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /*
     * Handles HTTP GET requests to retrieve a list of all entities.
     * @return ResponseEntity<List<BaseDTO>> containing the list of entities or an error response.
     */
    @GetMapping("/listar")
    public ResponseEntity<List<BaseDTO>> listarBases() {
        List<BaseDTO> bases = baseService.listAllBases();
        return new ResponseEntity<>(bases, HttpStatus.OK);
    }

    /*
     * Handles HTTP DELETE requests to delete a specific entity.
     * @param id The identifier of the entity to be deleted.
     * @return ResponseEntity<String> indicating success or failure of the deletion operation.
     */
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarBase(@PathVariable Integer id) {
        try {
            baseService.deleteBase(id);
            return new ResponseEntity<>("Base eliminada correctamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar la base: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {

        String message = "Error: " + e.getMessage();
        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

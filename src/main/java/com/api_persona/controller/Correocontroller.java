package com.api_persona.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.api_persona.model.Correo;
import com.api_persona.services.CorreoService;
import com.api_persona.dto.Correodto;

@RestController
@RequestMapping("api/v1/correo")
public class Correocontroller {

     @Autowired
    private CorreoService correoService;

    // Obtener todos los correos (entidad completa)
    @GetMapping
    public ResponseEntity<List<Correo>> getAll() {
        return ResponseEntity.ok(correoService.getAll());
    }

    // Obtener todos los correos en formato DTO
    @GetMapping("/correosdto")
    public ResponseEntity<List<Correodto>> getAllDTO() {
        return ResponseEntity.ok(correoService.getAllDTO());
    }

    // Obtener un correo por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        Correo correo = correoService.getById(id);
        if (correo == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Mensaje("Correo no encontrado"));
        }
        return ResponseEntity.ok(correo);
    }

    // Agregar un nuevo correo
    @PostMapping
    public ResponseEntity<?> add(@RequestBody Correo correo) {
        Correo newCorreo = correoService.add(correo);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCorreo);
    }

    // Actualizar un correo existente
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Correo correo){
        Correo updatedCorreo = correoService.update(id, correo);
        if (updatedCorreo != null) {
            return ResponseEntity.ok(updatedCorreo);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Mensaje("Correo no encontrado"));
    }

    // Eliminar un correo
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        boolean deleted = correoService.delete(id);
        if (deleted) {
            return ResponseEntity.ok(new Mensaje("Correo eliminado correctamente"));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Mensaje("Correo no encontrado"));
    }

}

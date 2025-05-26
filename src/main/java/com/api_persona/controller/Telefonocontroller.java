package com.api_persona.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.api_persona.model.Telefono;
import com.api_persona.services.TelefonoService;
import com.api_persona.dto.Telefonodto;

@RestController
@RequestMapping("api/v1/telefono")
public class Telefonocontroller {

   
    @Autowired
    private TelefonoService telefonoService;

    @GetMapping
    public ResponseEntity<List<Telefono>> getAll() {
        return ResponseEntity.ok(telefonoService.getAll());
    }

    @GetMapping("/telefonosdto")
    public ResponseEntity<List<Telefonodto>> getAllDTO() {
        return ResponseEntity.ok(telefonoService.getAllDTO());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        Telefono telefono = telefonoService.getById(id);
        if (telefono != null) {
            return ResponseEntity.ok(telefono);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Mensaje("Telefono no encontrado"));
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody Telefono telefono) {
        Telefono newTelefono = telefonoService.add(telefono);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTelefono);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Telefono telefono) {
        Telefono updatedTelefono = telefonoService.update(id, telefono);
        if (updatedTelefono != null) {
            return ResponseEntity.ok(updatedTelefono);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Mensaje("Telefono no encontrado"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        boolean deleted = telefonoService.delete(id);
        if (deleted) {
            return ResponseEntity.ok(new Mensaje("Teléfono eliminado correctamente"));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Mensaje("Teléfono no encontrado"));
    }

}

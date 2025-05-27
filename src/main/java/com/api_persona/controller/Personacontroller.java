package com.api_persona.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.api_persona.model.Persona;
import com.api_persona.services.PersonaService;

@RestController
@RequestMapping("/api/v1/persona")
public class Personacontroller {

    @Autowired
    private PersonaService personaService;

    @GetMapping
    public ResponseEntity<List<Persona>> getAll(){
        return ResponseEntity.ok(personaService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id){
        Persona persona = personaService.getById(id);
        if (persona != null){
            return ResponseEntity.ok(persona);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Mensaje("Persona no encontrada"));
        }
    }

    @PostMapping
    public ResponseEntity<Persona> add(@RequestBody Persona persona){
        Persona newPersona = personaService.add(persona);
        return ResponseEntity.status(HttpStatus.CREATED).body(newPersona);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Persona persona){
        Persona updatedPersona = personaService.update(id, persona);
        if (updatedPersona != null){
            return ResponseEntity.ok(updatedPersona);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Mensaje("Persona no encontrada"));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        Persona deletedPersona = personaService.delete(id);
        if (deletedPersona != null){
            return ResponseEntity.ok(deletedPersona);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Mensaje("Persona no encontrada"));
        }
    }



}

package com.api_persona.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api_persona.model.Persona;
import com.api_persona.repository.PersonaRepository;

import java.util.*;
@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    public List<Persona> getAll() {
        return personaRepository.findAll();
    }

    // Obtener una persona por su ID
    public Persona getById(Integer id) {
        Optional<Persona> persona = personaRepository.findById(id);
        return persona.orElse(null);  // Si no se encuentra la persona, devuelve null
    }

    // Agregar una nueva persona
    public Persona add(Persona persona) {
        return personaRepository.save(persona);  // Guardar la nueva persona
    }

    // Actualizar una persona existente
    public Persona update(Integer id, Persona persona) {
        Optional<Persona> existingPersona = personaRepository.findById(id);  // Buscar la persona por ID
        if (existingPersona.isPresent()) {
            // Si la persona existe, actualizar los datos y guardar
            persona.setId(id);
            return personaRepository.save(persona);
        } else {
            // Si la persona no existe, devolver null
            return null;
        }
    }

    // Eliminar una persona
    public Persona delete(Integer id) {
        Optional<Persona> persona = personaRepository.findById(id);  // Buscar la persona por ID
        if (persona.isPresent()) {
            personaRepository.deleteById(id);  // Eliminar la persona
            return persona.get();  // Devolver la persona eliminada
        } else {
            // Si la persona no existe, devolver null
            return null;
        }
    }


}

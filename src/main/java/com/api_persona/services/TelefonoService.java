package com.api_persona.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import com.api_persona.model.Telefono;
import com.api_persona.repository.TelefonoRepository;
import com.api_persona.dto.Telefonodto;
@Service
public class TelefonoService {

    @Autowired
    private TelefonoRepository telefonoRepository;
    // Método para obtener todos los teléfonos

    public List<Telefono> getAll() {
        return telefonoRepository.findAll();
    }

    private List<Telefonodto> getAllDTO() {
        return telefonoRepository.findAll().stream().map(t -> new Telefonodto(
            t.getId(),
            t.getNumero(),
            t.getPersona().getId()
        )).toList();
    }
    public Telefono getById(Integer id) {
        Optional<Telefono> telefono = telefonoRepository.findById(id);
        return telefono.orElse(null);
    }

    public Telefono add(Telefono telefono) {
        return telefonoRepository.save(telefono);
    }

    public Telefono update(Integer id, Telefono telefonoActualizado){
        if (telefonoRepository.existsById(id)) {
            telefonoActualizado.setId(id);
            return telefonoRepository.save(telefonoActualizado);
        }
        return null; // O lanzar una excepción si el teléfono no existe}
    }

    public boolean delete(Integer id){
        Optional<Telefono> telefono = telefonoRepository.findById(id);
        if (telefono.isPresent()) {
            telefonoRepository.deleteById(id);
            return true; // Indica que se eliminó correctamente
        } 
        return false; // Indica que no se encontró el teléfono para eliminar

    }
}
    


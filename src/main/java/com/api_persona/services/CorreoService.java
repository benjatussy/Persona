package com.api_persona.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api_persona.dto.Correodto;
import com.api_persona.repository.CorreoRepository;
import com.api_persona.model.Correo;

@Service
public class CorreoService {

    @Autowired
    private CorreoRepository correoRepository;
    // Método para guardar un correo

    public List<Correo> getAll(){
        return correoRepository.findAll();
    }

    public List<Correodto> getAllDTO(){
        return correoRepository.findAll().stream().map(c -> new Correodto(
            c.getId(),
            c.getCorreo(),
            c.getPersona().getId()
        )).toList();
    }

    public Correo getById(Integer id) {
        Optional<Correo> correo = correoRepository.findById(id);
        return correo.orElse(null);
    }

    public Correo add(Correo correo) {
        return correoRepository.save(correo);
    }

    public Correo update (Integer id, Correo correoActualizado){
        Optional<Correo> correoOptional = correoRepository.findById(id);
        if (correoOptional.isPresent()) {
            Correo existingCorreo = correoOptional.get();
            existingCorreo.setCorreo(correoActualizado.getCorreo());
            existingCorreo.setPersona(correoActualizado.getPersona());
            return correoRepository.save(existingCorreo);
        } else {
            return null; // O lanzar una excepción si el correo no existe
        }
    }

    public boolean delete(Integer id){
        Optional<Correo> correo = correoRepository.findById(id);
        if (correo.isPresent()) {
            correoRepository.delete(correo.get());
            return true; // Indica que se eliminó correctamente
        } 
        return false; // Indica que no se encontró el correo para eliminar
        
    }


}

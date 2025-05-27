package com.api_persona.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.api_persona.dto.Cursodto;
import com.api_persona.model.Curso;
import com.api_persona.repository.CursoRepository;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;
    // Método para guardar un curso

    public List<Curso> getAll(){
        return cursoRepository.findAll();
    }

    public List<Cursodto> getAllDTO(){
        return cursoRepository.findAll().stream().map(c -> new Cursodto(
            c.getId(),
            c.getNombre(),
            c.getDescripcion(),
            /*c.getFechaInicio(),
            c.getFechaFin()*/
            c.getPersona().getId()
        )).toList();

        /*Correodto(
            c.getId(),
            c.getCorreo(),
            c.getPersona().getId()
        )).toList(); */
    }

     public Curso getById(Integer id) {
        Optional<Curso> curso = cursoRepository.findById(id);
        return curso.orElse(null);
    }

    public Curso add(Curso curso) {
        return cursoRepository.save(curso);
    }

    public Curso update(Integer id, Curso cursoActualizado){
        Optional<Curso> cursoOptional = cursoRepository.findById(id);
        if (cursoOptional.isPresent()) {
            Curso existingCurso = cursoOptional.get();
            existingCurso.setNombre(cursoActualizado.getNombre());
            existingCurso.setDescripcion(cursoActualizado.getDescripcion());
            // Si tienes más campos, agrégalos aquí
            existingCurso.setPersona(cursoActualizado.getPersona());
            return cursoRepository.save(existingCurso);
        } else {
            return null; // O lanzar una excepción si el curso no existe
        }

    }

    public boolean delete(Integer id){
        Optional<Curso> curso = cursoRepository.findById(id);
        if (curso.isPresent()) {
            cursoRepository.delete(curso.get());
            return true; // Indica que se eliminó correctamente
        } 
        return false; // Indica que no se encontró el correo para eliminar
        
    }
}

package com.api_persona.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.api_persona.model.Curso;
import com.api_persona.services.CursoService;

@RestController
@RequestMapping("/api/v1/curso")
public class Cursocontroller {

    
    @Autowired
    private CursoService cursoService;

    @GetMapping
    public ResponseEntity<List<Curso>> getAll(){
        return ResponseEntity.ok(cursoService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id){
        Curso curso = cursoService.getById(id);
        if (curso != null){
            return ResponseEntity.ok(curso);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Mensaje("Curso no encontrado"));
        }
    }

    @PostMapping
    public ResponseEntity<Curso> add(@RequestBody Curso curso){
        Curso newCurso = cursoService.add(curso);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCurso);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Curso curso){
        Curso updatedCurso = cursoService.update(id, curso);
        if (updatedCurso != null){
            return ResponseEntity.ok(updatedCurso);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Mensaje("Curso no encontrado"));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        boolean deleted = cursoService.delete(id);
        if (deleted){
            return ResponseEntity.ok(new Mensaje("Curso eliminado correctamente"));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Mensaje("Curso no encontrado"));
        }
    }



}

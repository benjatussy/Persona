package com.api_persona.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.api_persona.model.Curso;
// Una interface en Java define un contrato que las clases pueden implementar. 
// No contiene lógica, solo la declaración de métodos.

// 'extends' en interfaces permite heredar métodos de otra interface. 
// Aquí, CursoRepository hereda todos los métodos de JpaRepository, 
// como save, findAll, findById, delete, etc.
public interface CursoRepository extends JpaRepository<Curso, Integer> {
    // List<Curso> findByNombre(String nombre);
    // Puedes agregar más métodos personalizados según tus necesidades

}

package com.api_persona.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.api_persona.model.Persona;
public interface PersonaRepository extends JpaRepository<Persona, Integer> {
    
    // Aquí puedes agregar métodos personalizados si es necesario
    // Por ejemplo, para buscar personas por nombre:
    // List<Persona> findByNombre(String nombre);
    
    // O para buscar por apellido:
    // List<Persona> findByApellido(String apellido);
    
    // O cualquier otro criterio de búsqueda que necesites

}

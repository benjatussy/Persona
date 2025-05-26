package com.api_persona.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.api_persona.model.Telefono;

public interface TelefonoRepository extends JpaRepository<Telefono, Integer> {
    
    // Aquí puedes agregar métodos personalizados si es necesario
    // Por ejemplo, para buscar teléfonos por número:
    // List<Telefono> findByNumero(String numero);

}

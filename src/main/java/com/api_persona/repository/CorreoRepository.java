package com.api_persona.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.api_persona.model.Correo;

public interface CorreoRepository extends JpaRepository<Correo, Integer> {
    
    // Aquí puedes agregar métodos personalizados si es necesario
    // Por ejemplo, para buscar correos por dirección de correo electrónico:
    // List<Correo> findByEmail(String email);

}

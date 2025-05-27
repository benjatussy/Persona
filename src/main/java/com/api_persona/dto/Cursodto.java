package com.api_persona.dto;

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cursodto {
    
    private Integer id;
    private String nombre;
    private String descripcion;
    private Integer personaId; // ID de la persona asociada al curso

}

package com.api_persona.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Correodto {

    private Integer id;
    private String correo;
    private Integer personaId;

}

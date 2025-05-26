package com.api_persona.model;

import jakarta.persistence.*;
import lombok.*;



@Entity
@Data
@Table(name = "inscripciones")
@NoArgsConstructor
@AllArgsConstructor
public class Inscripciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 45)
    private String curso;

    @Column(nullable = false, length = 45)
    private String institucion;

    @ManyToOne
    @JoinColumn(name = "persona_id", nullable = false)
    private Persona persona;

    @Column(name = "detalle_inscripcion", length = 255)
    private String detalleInscripcion;

}

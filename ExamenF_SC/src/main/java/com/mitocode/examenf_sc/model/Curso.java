package com.mitocode.examenf_sc.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCurso;

    @Column( nullable = false, length = 60)
    private String nombreCurso;

    @Column( nullable = false, length = 100)
    private String profesorCurso;

    @Column(nullable = false)
    private LocalDateTime fechaCreacion;

    @Column( nullable = false)
    private boolean estado;

}

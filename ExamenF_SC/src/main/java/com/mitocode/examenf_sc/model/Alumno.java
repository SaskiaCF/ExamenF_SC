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

public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAlumno;

    @Column( nullable = false, length = 100)
    private String nombreAlumno;

    @Column( nullable = false, length = 20)
    private String tipoDocumento;

    @Column( nullable = false, length = 12)
    private String numerodocumento;

    @Column(nullable = false)
    private LocalDateTime fechaIngreso;

    @Column( nullable = false)
    private boolean estado;

}

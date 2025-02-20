package com.mitocode.examenf_sc.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CursoDto {
    private Integer idCurso;
    @NotNull
    @Size(min = 3, max = 60)
    private String nombreCurso;
    @Size(min = 3, max = 100)
    private String profesorCurso;
    @Size(min = 3, max = 60)
    private String fechaCreacion;
    @Size(min = 3, max = 100)
    private String estado;
}

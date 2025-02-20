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
public class AlumnoDto {
    private Integer idAlumno;
    @NotNull
    @Size(min = 3, max = 100)
    private String nombreAlumno;
    @Size(min = 3, max = 20)
    private String tipoDocumento;
    @Size(min = 3, max = 12)
    private String numerodocumento;
    @NotNull
    private LocalDateTime fechaIngreso;
    @NotNull
    private boolean estado;
}

package com.mitocode.examenf_sc.expose;

import com.mitocode.examenf_sc.business.IAlumno;
import com.mitocode.examenf_sc.dto.AlumnoDto;
import com.mitocode.examenf_sc.dto.CursoDto;
import com.mitocode.examenf_sc.dto.GenericResponse;
import com.mitocode.examenf_sc.model.Alumno;
import com.mitocode.examenf_sc.model.Curso;
import com.mitocode.examenf_sc.business.ICurso;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/alumno")
@RequiredArgsConstructor
public class AlumnoController {
    private final IAlumno alumnoService;
    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;
    @GetMapping
    public ResponseEntity<GenericResponse<AlumnoDto>> getAllAtencioness() {
        List<AlumnoDto> list= alumnoService.findAll().stream().map(this::converToDto).toList();
        //return ResponseEntity.ok(list);
        return ResponseEntity.ok(new GenericResponse<>(200,"success",list));
    }
    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody AlumnoDto alumnoDto) {
        Alumno obj= alumnoService.save(converToEntity(alumnoDto));
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdAlumno()).toUri();
        return ResponseEntity.created(location).build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<AlumnoDto>> getAtencionesById(@PathVariable("id") int id) {
        Alumno obj= alumnoService.findById(id);
        return ResponseEntity.ok(new GenericResponse<>(200,"success", Arrays.asList(converToDto(obj))));
    }
    @PutMapping("/{id}")
    public ResponseEntity<GenericResponse<AlumnoDto>> update(@Valid @PathVariable("id") int id,@RequestBody AlumnoDto alumnoDto) {
        alumnoDto.setIdAlumno(id);
        Alumno obj= alumnoService.update(id, converToEntity(alumnoDto));
        return ResponseEntity.ok(new GenericResponse<>(200,"success", Arrays.asList(converToDto(obj))));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        alumnoService.delete(id);
        return ResponseEntity.noContent().build();
    }
    private AlumnoDto converToDto(Alumno alumno) {
        return modelMapper.map(alumno,AlumnoDto.class);
    }
    private Alumno converToEntity(AlumnoDto alumnoDto) {
        return modelMapper.map(alumnoDto,Alumno.class);
    }
}


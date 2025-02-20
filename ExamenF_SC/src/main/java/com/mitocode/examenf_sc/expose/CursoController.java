package com.mitocode.examenf_sc.expose;

import com.mitocode.examenf_sc.dto.CursoDto;
import com.mitocode.examenf_sc.dto.GenericResponse;
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
@RequestMapping("/curso")
@RequiredArgsConstructor
public class CursoController {
    private final ICurso cursoService;
    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;
    @GetMapping
    public ResponseEntity<GenericResponse<CursoDto>> getAllAtencioness() {
        List<CursoDto> list= cursoService.findAll().stream().map(this::converToDto).toList();
        //return ResponseEntity.ok(list);
        return ResponseEntity.ok(new GenericResponse<>(200,"success",list));
    }
    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody CursoDto cursoDto) {
        Curso obj= cursoService.save(converToEntity(cursoDto));
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdCurso()).toUri();
        return ResponseEntity.created(location).build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<CursoDto>> getAtencionesById(@PathVariable("id") int id) {
        Curso obj= cursoService.findById(id);
        return ResponseEntity.ok(new GenericResponse<>(200,"success", Arrays.asList(converToDto(obj))));
    }
    @PutMapping("/{id}")
    public ResponseEntity<GenericResponse<CursoDto>> update(@Valid @PathVariable("id") int id,@RequestBody CursoDto cursoDto) {
        cursoDto.setIdCurso(id);
        Curso obj= cursoService.update(id, converToEntity(cursoDto));
        return ResponseEntity.ok(new GenericResponse<>(200,"success", Arrays.asList(converToDto(obj))));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        cursoService.delete(id);
        return ResponseEntity.noContent().build();
    }
    private CursoDto converToDto(Curso atencion) {
        return modelMapper.map(atencion,CursoDto.class);
    }
    private Curso converToEntity(CursoDto atencionDto) {
        return modelMapper.map(atencionDto,Curso.class);
    }
}

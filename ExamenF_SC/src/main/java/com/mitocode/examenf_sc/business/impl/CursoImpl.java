package com.mitocode.examenf_sc.business.impl;

import com.mitocode.examenf_sc.model.Curso;
import com.mitocode.examenf_sc.repo.IAlumnoRepo;
import com.mitocode.examenf_sc.repo.ICursoRepo;
import com.mitocode.examenf_sc.repo.IGenericRepo;
import com.mitocode.examenf_sc.business.ICurso;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class CursoImpl  extends CRUDimpl<Curso,Integer> implements ICurso {
    private final ICursoRepo repo;

    public CursoImpl(ICursoRepo repo) {
        super();
        this.repo = repo;
    }
    @Override
    protected IGenericRepo<Curso, Integer> getRepo() {
        return repo;
    }
}

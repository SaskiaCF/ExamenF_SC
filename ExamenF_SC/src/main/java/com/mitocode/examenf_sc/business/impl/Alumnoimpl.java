package com.mitocode.examenf_sc.business.impl;

import com.mitocode.examenf_sc.model.Alumno;
import com.mitocode.examenf_sc.repo.IAlumnoRepo;
import com.mitocode.examenf_sc.repo.IGenericRepo;
import com.mitocode.examenf_sc.business.IAlumno;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class Alumnoimpl extends CRUDimpl<Alumno,Integer> implements IAlumno {
    private final IAlumnoRepo repo;

    public Alumnoimpl(IAlumnoRepo repo) {
        super();
        this.repo = repo;
    }
    @Override
    protected IGenericRepo<Alumno, Integer> getRepo() {
        return repo;
    }
}

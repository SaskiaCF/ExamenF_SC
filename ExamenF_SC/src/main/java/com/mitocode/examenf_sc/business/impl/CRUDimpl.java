package com.mitocode.examenf_sc.business.impl;

import com.mitocode.examenf_sc.repo.IGenericRepo;
import com.mitocode.examenf_sc.business.ICRUD;
import com.mitocode.examenf_sc.exception.ModelNotFoundException;

import java.util.List;


public abstract class CRUDimpl<T,ID> implements ICRUD<T,ID> {

    protected abstract IGenericRepo<T,ID> getRepo();

    @Override
    public T save(T t) {

        return getRepo().save(t);
    }

    @Override
    public T update(ID id, T t) {
        getRepo().findById(id).orElseThrow(() -> new ModelNotFoundException("ID NOT FOUND: "+ id));
        return getRepo().save(t);
    }

    @Override
    public List<T> findAll() {
        return getRepo().findAll();
    }

    @Override
    public T findById(ID id) {
        return getRepo().findById(id).orElseThrow(()-> new ModelNotFoundException("ID NOT FOUND: "+ id));
    }

    @Override
    public void delete(ID id) {
        getRepo().findById(id).orElseThrow(()-> new ModelNotFoundException("ID NOT FOUND: "+ id));
        getRepo().deleteById(id);
    }
}

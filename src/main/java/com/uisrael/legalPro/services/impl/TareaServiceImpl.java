package com.uisrael.legalPro.services.impl;

import com.uisrael.legalPro.models.Tarea;
import com.uisrael.legalPro.repository.ITareaRepository;
import com.uisrael.legalPro.services.ITareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaServiceImpl implements ITareaService {

    @Autowired
    private ITareaRepository repository;

    @Override
    public Tarea get() {
        return null;
    }

    @Override
    public Tarea update(Tarea object) {
        return repository.save(object);
    }

    @Override
    public Tarea create(Tarea object) {
        return repository.save(object);
    }

    @Override
    public void delete(String identifier) {
        repository.deleteById(Integer.parseInt(identifier));
    }

    @Override
    public List<Tarea> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Tarea> findBy(String identifier) {
        return repository.findAll();
    }
}
package com.uisrael.legalPro.services;

import com.uisrael.legalPro.models.Tarea;
import com.uisrael.legalPro.models.Tarea;

import java.util.List;

public interface ITareaService {
    public Tarea get();
    public Tarea update(Tarea object);
    public Tarea create(Tarea object);
    public void delete(String identifier);
    public List<Tarea> getAll();
    public List<Tarea> findBy(String identifier);
}

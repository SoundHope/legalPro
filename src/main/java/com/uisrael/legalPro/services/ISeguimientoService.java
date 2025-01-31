package com.uisrael.legalPro.services;

import com.uisrael.legalPro.models.DTO.SeguimientoDTO;
import com.uisrael.legalPro.models.Seguimiento;
import com.uisrael.legalPro.models.Tarea;

import java.util.List;

public interface ISeguimientoService {
    public Seguimiento get();
    public Seguimiento update(Seguimiento object);
    public Seguimiento create(Seguimiento object);
    public void delete(String identifier);
    public List<Seguimiento> getAll();
    public List<Seguimiento> findBy(String identifier);
    List<SeguimientoDTO> findSeguimientosOrdenados();
}

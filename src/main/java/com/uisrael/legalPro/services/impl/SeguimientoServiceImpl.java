package com.uisrael.legalPro.services.impl;

import com.uisrael.legalPro.models.DTO.SeguimientoDTO;
import com.uisrael.legalPro.models.Seguimiento;
import com.uisrael.legalPro.repository.ISeguimientoRepository;
import com.uisrael.legalPro.services.ISeguimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SeguimientoServiceImpl implements ISeguimientoService {

    @Autowired
    private ISeguimientoRepository repository;

    @Override
    public Seguimiento get() {
        return null;
    }

    @Override
    public Seguimiento update(Seguimiento object) {
        return repository.save(object);
    }

    @Override
    public Seguimiento create(Seguimiento object) {
        return repository.save(object);
    }

    @Override
    public void delete(String identifier) {
        repository.deleteById(Integer.parseInt(identifier));
    }

    @Override
    public List<Seguimiento> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Seguimiento> findBy(String identifier) {
        return repository.findAll();
    }
    @Override
    public List<SeguimientoDTO> findSeguimientosOrdenados() {
        return repository.findAllByOrderByFechaLimiteAsc().stream().map(seguimiento -> {
            SeguimientoDTO dto = new SeguimientoDTO();
            dto.setSeguimientoId(seguimiento.getSeguimientoId());
            dto.setEstado(seguimiento.getEstado());
            dto.setClienteNombre(seguimiento.getCaso().getCliente().getNombres());
            dto.setClienteDni(seguimiento.getCaso().getCliente().getDni());
            dto.setFechaLimite(seguimiento.getFechaLimite());
            dto.setDescripcion(seguimiento.getDescripcion());
            dto.setFechaCreacion(seguimiento.getFechaCreacion());
            dto.setFechaActualizacion(seguimiento.getFechaActualizacion());
            dto.setRecordatorio(seguimiento.getRecordatorio());
            return dto;
        }).collect(Collectors.toList());
    }
}
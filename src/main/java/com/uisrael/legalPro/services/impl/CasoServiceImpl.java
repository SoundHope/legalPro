package com.uisrael.legalPro.services.impl;

import com.uisrael.legalPro.models.Caso;
import com.uisrael.legalPro.models.Cliente;
import com.uisrael.legalPro.repository.ICasoRepository;
import com.uisrael.legalPro.repository.IClienteRepository;
import com.uisrael.legalPro.services.ICasoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CasoServiceImpl implements ICasoService {

    @Autowired
    ICasoRepository repository;

    @Autowired
    IClienteRepository clienteRepository;

    @Override
    public Caso get() {

        return null;
    }

    @Override
    public Caso update(Caso object) {
        return repository.save(object);
    }

    @Override
    public Caso create(Caso object) {
        return repository.save(object);
    }

    @Override
    public void delete(String identifier) {
        repository.deleteById(Integer.parseInt(identifier));
    }


    @Override
    public List<Caso> getAll() {
        return repository.findAll();
    }

    public List<Caso> findBy(String identifier) {
        return repository.findAll();
    }
    @Override
    public Caso findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public int createCasoWithCliente(Caso caso, Cliente cliente) {
        Cliente savedCliente = clienteRepository.save(cliente);
        caso.setCliente(savedCliente);
        Caso savedCaso = repository.save(caso);
        return savedCaso.getCasoId();
    }
}

package com.uisrael.legalPro.services.impl;

import com.uisrael.legalPro.models.Cliente;
import com.uisrael.legalPro.repository.IClienteRepository;
import com.uisrael.legalPro.services.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    private IClienteRepository repository;

    @Override
    public Cliente get() {
        return null;
    }

    @Override
    public Cliente update(Cliente object) {
        return repository.save(object);
    }

    @Override
    public Cliente create(Cliente object) {
        return repository.save(object);
    }

    @Override
    public void delete(String identifier) {
        repository.deleteById(Integer.parseInt(identifier));
    }

    @Override
    public List<Cliente> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Cliente> findBy(String identifier) {
        return repository.findAll();
    }
}
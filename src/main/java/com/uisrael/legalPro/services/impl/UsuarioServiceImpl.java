package com.uisrael.legalPro.services.impl;

import com.uisrael.legalPro.models.Usuario;
import com.uisrael.legalPro.repository.IUsuarioRepository;
import com.uisrael.legalPro.services.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    IUsuarioRepository repository;

    @Override
    public Usuario get() {
        return null;
    }

    @Override
    public Usuario update(Usuario object) {
       return repository.save(object);
    }

    @Override
    public Usuario create(Usuario object) {
        return repository.save(object);
    }

    @Override
    public void delete(String identifier) {
        repository.deleteById(Integer.parseInt(identifier));
    }

    @Override
    public List<Usuario> getAll() {
        return repository.findAll();
    }

    @Override
    public Usuario findBy(String identifier) {
        int id = Integer.parseInt(identifier);
        return repository.findById(id).orElse(null);
    }
    @Override
    public Usuario findById(int id) {
        return repository.findById(id).orElse(null);
    }
}
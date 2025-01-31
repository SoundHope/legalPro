package com.uisrael.legalPro.services;

import com.uisrael.legalPro.models.Usuario;
import com.uisrael.legalPro.models.Tarea;

import java.util.List;

public interface IUsuarioService {
    Usuario get();
    Usuario update(Usuario object);
    Usuario create(Usuario Object);
    void delete(String identifier);
    List<Usuario> getAll();
    Usuario findBy(String identifier);
    Usuario findById(int id);
}

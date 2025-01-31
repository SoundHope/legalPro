package com.uisrael.legalPro.services;

import com.uisrael.legalPro.models.Caso;
import com.uisrael.legalPro.models.Cliente;

import java.util.List;

public interface ICasoService {

    Caso get();
    Caso update(Caso object);
    Caso create(Caso object);
    void delete(String identifier);
    List<Caso> getAll();
    List<Caso> findBy(String identifier);
    Caso findById(int id);
    int createCasoWithCliente(Caso caso, Cliente cliente);
}

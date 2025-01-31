package com.uisrael.legalPro.services;

import ch.qos.logback.core.net.server.Client;
import com.uisrael.legalPro.models.Cliente;
import com.uisrael.legalPro.models.Tarea;

import java.util.List;

public interface IClienteService {
    Cliente get();
    Cliente update(Cliente object);
    Cliente create(Cliente object);
    void delete(String identifier);
    List<Cliente> getAll();
    List<Cliente> findBy(String identifier);
}

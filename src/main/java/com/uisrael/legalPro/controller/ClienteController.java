package com.uisrael.legalPro.controller;

import com.uisrael.legalPro.models.Cliente;
import com.uisrael.legalPro.models.Usuario;
import com.uisrael.legalPro.services.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cliente/")
public class ClienteController {

    @Autowired
    IClienteService service;

    @PostMapping("create")
    public ResponseEntity<Cliente> create(Cliente object) {
        Cliente result = service.create(object);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("update/{objectId}")
    public ResponseEntity<Cliente> update(Cliente object) {
        Cliente result = service.update(object);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @GetMapping("/found/all")
    public List<Cliente> found() {
        return service.getAll();
    }


    @GetMapping("/found/dni/{dni}")
    public List<Cliente> foundBy(@PathVariable String dni) {
        return service.findBy(dni);
    }
}

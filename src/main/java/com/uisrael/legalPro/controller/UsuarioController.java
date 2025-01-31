package com.uisrael.legalPro.controller;

import com.uisrael.legalPro.models.Usuario;
import com.uisrael.legalPro.services.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuario/")
public class UsuarioController {

    @Autowired
    IUsuarioService service;

    @PostMapping("create")
    public ResponseEntity<Usuario> create(@RequestBody Usuario objectToCreate) {
        Usuario createdUsuario = service.create(objectToCreate);
        return new ResponseEntity<>(createdUsuario, HttpStatus.CREATED);
    }

    @PutMapping("update/{objectId}")
    public ResponseEntity<Usuario> update(@RequestBody Usuario objectToCreate) {
        Usuario updated = service.update(objectToCreate);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }
    @GetMapping("/found/all")
    public List<Usuario> found() {
        return service.getAll();
    }


    @GetMapping("/found/id/{dni}")
    public Usuario foundBy(@PathVariable String dni) {
        return service.findBy(dni);
    }
}

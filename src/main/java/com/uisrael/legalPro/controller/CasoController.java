package com.uisrael.legalPro.controller;

import com.uisrael.legalPro.models.Caso;
import com.uisrael.legalPro.models.Cliente;
import com.uisrael.legalPro.models.Usuario;
import com.uisrael.legalPro.services.ICasoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("caso/")
public class CasoController {

    @Autowired
    ICasoService service;

    @PostMapping("create")
    public ResponseEntity<Caso> create(@RequestBody Caso object) {
        Caso result = service.create(object);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("update/{objectId}")
    public ResponseEntity<Caso> update(@RequestBody Caso object) {
        Caso result = service.update(object);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @GetMapping("/found/all")
    public List<Caso> found() {
        return service.getAll();
    }


    @GetMapping("/found/dni/{id}")
    public List<Caso> foundBy(@PathVariable String id) {
        return service.findBy(id);
    }

    @PostMapping("createWithCliente")
    public ResponseEntity<Integer> createCasoWithCliente(@RequestBody Caso caso, @RequestBody Cliente cliente) {
        int casoId = service.createCasoWithCliente(caso, cliente);
        return new ResponseEntity<>(casoId, HttpStatus.CREATED);
    }

}

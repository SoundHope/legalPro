package com.uisrael.legalPro.controller;

import com.uisrael.legalPro.models.Caso;
import com.uisrael.legalPro.models.Cliente;
import com.uisrael.legalPro.models.DTO.CasoClienteRequestDTO;
import com.uisrael.legalPro.models.Usuario;
import com.uisrael.legalPro.services.ICasoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    public ResponseEntity<Map<String, String>> createCasoWithCliente(@RequestBody CasoClienteRequestDTO request) {
        Caso caso = request.getCaso();
        Cliente cliente = request.getCliente();
        int casoId = service.createCasoWithCliente(caso, cliente);

        String responseMessage = String.format("Caso registrado para el cliente %s con identificador %s, Numero de caso: %d",
                cliente.getNombres(), cliente.getDni(), casoId);

        return new ResponseEntity<>(Map.of("message", responseMessage), HttpStatus.CREATED);
    }

}

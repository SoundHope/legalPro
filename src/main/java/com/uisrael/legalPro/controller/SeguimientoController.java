package com.uisrael.legalPro.controller;

import com.uisrael.legalPro.models.DTO.SeguimientoDTO;
import com.uisrael.legalPro.models.Seguimiento;
import com.uisrael.legalPro.models.Usuario;
import com.uisrael.legalPro.services.ISeguimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("seguimiento/")
public class SeguimientoController {

    @Autowired
    ISeguimientoService service;

    @PostMapping("create")
    public ResponseEntity<Seguimiento> create(Seguimiento object) {
        Seguimiento result = service.create(object);
        return new ResponseEntity<>(result, HttpStatus.CREATED);

    }

    @PutMapping("update/{objectId}")
    public ResponseEntity<Seguimiento> update(Seguimiento object) {
        Seguimiento result = service.update(object);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @GetMapping("/found/all")
    public List<Seguimiento> found() {
        return service.getAll();
    }


    @GetMapping("/found/id/{dni}")
    public List<Seguimiento> foundBy(@PathVariable String dni) {
        return service.findBy(dni);
    }

    @GetMapping("/ordenados")
    public ResponseEntity<List<SeguimientoDTO>> getSeguimientosOrdenados() {
        List<SeguimientoDTO> result = service.findSeguimientosOrdenados();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}

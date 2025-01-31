package com.uisrael.legalPro.controller;

import com.uisrael.legalPro.models.Caso;
import com.uisrael.legalPro.models.DTO.TareaRequestDTO;
import com.uisrael.legalPro.models.Seguimiento;
import com.uisrael.legalPro.models.Tarea;
import com.uisrael.legalPro.models.Usuario;
import com.uisrael.legalPro.services.ICasoService;
import com.uisrael.legalPro.services.ITareaService;
import com.uisrael.legalPro.services.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("tarea/")
public class TareaController {

    @Autowired
    ITareaService service;
    @Autowired
    ICasoService casoService;
    @Autowired
    IUsuarioService usuarioService;

    @PostMapping("create")
    public ResponseEntity<Tarea> create(Tarea object) {
        Tarea result = service.create(object);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("update/{objectId}")
    public ResponseEntity<Tarea> update(Tarea object) {
        Tarea result = service.update(object);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @GetMapping("/found/all")
    public List<Tarea> found() {
        return service.getAll();
    }


    @PostMapping("createWithUsuario")
    public ResponseEntity<Map<String, String>> createTareaWithUsuario(@RequestBody TareaRequestDTO tareaRequest) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        Date parsedFechaLimite;
        try {
            parsedFechaLimite = dateFormat.parse(tareaRequest.getFechaLimite());
        } catch (ParseException e) {
            return new ResponseEntity<>(Map.of("mensaje", "Invalid date format"), HttpStatus.BAD_REQUEST);
        }

        Caso caso = casoService.findById(tareaRequest.getCasoId());
        Usuario usuario = usuarioService.findById(tareaRequest.getUsuarioId());

        Tarea tarea = new Tarea();
        tarea.setCaso(caso);
        tarea.setUsuario(usuario);
        tarea.setFechaLimite(parsedFechaLimite);
        tarea.setEstado("Asignada");
        tarea.setPrioridad(tareaRequest.getPrioridad());
        tarea.setDescripcion(String.format("tarea con prioridad %d asignada al usuario %s con el rol %s fecha maxima %s",
                tareaRequest.getPrioridad(), usuario.getNombre(), usuario.getRol(), tareaRequest.getFechaLimite()));

        Tarea savedTarea = service.create(tarea);

        String responseMessage = String.format("tarea numero %d generada con exito para el caso %d y asignada al usuario %s con fecha maxima de %s",
                savedTarea.getTareaId(), tareaRequest.getCasoId(), usuario.getNombre(), tareaRequest.getFechaLimite());

        return new ResponseEntity<>(Map.of("mensaje", responseMessage), HttpStatus.CREATED);
    }
}

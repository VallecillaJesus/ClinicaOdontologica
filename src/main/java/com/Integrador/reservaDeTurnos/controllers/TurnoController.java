package com.Integrador.reservaDeTurnos.controllers;

import com.Integrador.reservaDeTurnos.entities.Odontologo;
import com.Integrador.reservaDeTurnos.entities.Turno;
import com.Integrador.reservaDeTurnos.exceptions.NoTargetFoundException;
import com.Integrador.reservaDeTurnos.services.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("turno")
@CrossOrigin(origins = "*")
public class TurnoController {

    @Autowired
    TurnoService service;

    @GetMapping("/list")
    public ResponseEntity<List<Turno>> listarTurnos(){
        return ResponseEntity.ok(service.listarTurnos());
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<Optional<Turno>> buscarTurno(@PathVariable Long id) throws NoTargetFoundException{
        return ResponseEntity.ok(service.buscarTurno(id));
    }

    @PostMapping("/save")
    public ResponseEntity<Turno> guardarTurno(@RequestBody Turno turno ){
        return ResponseEntity.ok(service.guardarTurno(turno));
    }

    @PutMapping("/update")
    public ResponseEntity<Turno> actualizarTurno(@RequestBody Turno turno) throws NoTargetFoundException{
        return ResponseEntity.ok(service.actualizarTurno(turno));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> eliminarTurno(@PathVariable Long id) throws NoTargetFoundException {
        return ResponseEntity.ok(service.eliminarTurno(id));
    }

}

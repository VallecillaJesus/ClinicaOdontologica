package com.Integrador.reservaDeTurnos.controllers;

import com.Integrador.reservaDeTurnos.entities.Odontologo;
import com.Integrador.reservaDeTurnos.entities.Paciente;
import com.Integrador.reservaDeTurnos.exceptions.NoTargetFoundException;
import com.Integrador.reservaDeTurnos.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    PacienteService service;

    @GetMapping("/list")
    public ResponseEntity<List<Paciente>> listarPacientes(){
        return ResponseEntity.ok(service.listarPacientes());
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<Optional<Paciente>> buscarPaciente(@PathVariable Long id) throws NoTargetFoundException{
        return ResponseEntity.ok(service.buscarPaciente(id));
    }

    @PostMapping("/save")
    public ResponseEntity<Paciente> guardarPaciente(@RequestBody Paciente paciente){
        return ResponseEntity.ok(service.guardarPaciente(paciente));
    }

    @PutMapping("/update")
    public ResponseEntity<Paciente> actualizarPaciente(@RequestBody Paciente paciente) throws NoTargetFoundException{
        return ResponseEntity.ok(service.actualizarPaciente(paciente));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> eliminarPaciente (@PathVariable Long id) throws NoTargetFoundException {
        return ResponseEntity.ok(service.eliminarPaciente(id));
    }

}

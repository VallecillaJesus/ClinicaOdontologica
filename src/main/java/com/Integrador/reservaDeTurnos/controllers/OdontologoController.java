package com.Integrador.reservaDeTurnos.controllers;

import com.Integrador.reservaDeTurnos.entities.Odontologo;
import com.Integrador.reservaDeTurnos.exceptions.NoTargetFoundException;
import com.Integrador.reservaDeTurnos.services.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("odontologo")
public class OdontologoController{

    @Autowired
    OdontologoService service;

    @GetMapping("/list")
    public ResponseEntity<List<Odontologo>> listarOdontologos(){
        return ResponseEntity.ok(service.listarOdontologos());
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<Optional<Odontologo>> buscarOdontologo(@PathVariable Long id) throws NoTargetFoundException{
        return ResponseEntity.ok(service.buscarOdontologo(id));
    }

    @PostMapping("/save")
    public ResponseEntity<Odontologo> guardarOdontologo(@RequestBody Odontologo odontologo){
        return ResponseEntity.ok(service.guardarOdontologo(odontologo));
    }

    @PutMapping("/update")
    public ResponseEntity<Odontologo> actualizarOdontologo(@RequestBody Odontologo odontologo) throws NoTargetFoundException {
        return ResponseEntity.ok(service.actualizarOdontologo(odontologo));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> eliminarOdontologo(@PathVariable Long id) throws NoTargetFoundException{
        return ResponseEntity.ok(service.eliminarOdontologo(id));
    }

}

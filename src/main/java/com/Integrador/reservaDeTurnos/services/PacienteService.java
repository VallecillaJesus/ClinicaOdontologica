package com.Integrador.reservaDeTurnos.services;

import com.Integrador.reservaDeTurnos.entities.Odontologo;
import com.Integrador.reservaDeTurnos.entities.Paciente;
import com.Integrador.reservaDeTurnos.exceptions.NoTargetFoundException;
import com.Integrador.reservaDeTurnos.repositories.IOdontologoRepository;
import com.Integrador.reservaDeTurnos.repositories.IPacienteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service @Slf4j @RequiredArgsConstructor
public class PacienteService {

    private final IPacienteRepository repository;

    public List<Paciente> listarPacientes(){
        log.info("Listando todos los pacientes");
        return repository.findAll();
    }

    public Optional<Paciente> buscarPaciente(Long id) throws NoTargetFoundException{
        log.info("Buscando al paciente con id:{}", id);
        Optional<Paciente> paciente = repository.findById(id);
        if(paciente.isPresent()) return paciente;
        throw new NoTargetFoundException("No se encontrar el "+Paciente.class.getTypeName() + ", con id: " + id);
    }

    public Paciente actualizarPaciente(Paciente paciente) throws NoTargetFoundException{
        if(buscarPaciente(paciente.getId()).isPresent()){
            log.info("Actualizando paciente: {}", paciente.toString());
            return repository.save(paciente);
        }
        throw new NoTargetFoundException("No se encontrar el "+Paciente.class.getTypeName() + ", con id: " + paciente.getId());
    }

    public Paciente guardarPaciente(Paciente paciente){
        log.info("Guardando paciendo: {}", paciente.toString());
        return repository.save(paciente);
    }

    public String eliminarPaciente(Long id) throws NoTargetFoundException{
        if(buscarPaciente(id).isEmpty()){
            log.info("Paciente con id:{}, no eliminado", id);
            throw new NoTargetFoundException("No se encontrar el "+Paciente.class.getTypeName() + ", con id: " + id);
        }
        repository.deleteById(id);
        log.info("Paciente con id:{}, eliminado correctamente", id);
        return "Succes";
    }

}

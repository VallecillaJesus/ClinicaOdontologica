package com.Integrador.reservaDeTurnos.services;

import com.Integrador.reservaDeTurnos.entities.Turno;
import com.Integrador.reservaDeTurnos.exceptions.NoTargetFoundException;
import com.Integrador.reservaDeTurnos.repositories.ITurnoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service @RequiredArgsConstructor @Slf4j
public class TurnoService {

    private final ITurnoRepository repository;

    public List<Turno> listarTurnos(){
        log.info("Listando todos los turnos");
        return repository.findAll();
    }
    public Turno guardarTurno(Turno turno) {
        log.info("Guardando turno: {}", turno);
       return repository.save(turno);
    }

    public Optional<Turno> buscarTurno(Long id) throws NoTargetFoundException{
        log.info("Busando turno con id:{}", id);
        Optional<Turno> turno = repository.findById(id);
        if(turno.isPresent()) return turno;
        throw new NoTargetFoundException("No se encontrar el "+Turno.class.getTypeName() + ", con id: " + id);
    }

    public Turno actualizarTurno(Turno turno) throws NoTargetFoundException {
        log.info("Actualizando turno con id:{}, a {}", turno.getId(), turno.toString());
        if(buscarTurno(turno.getId()).isPresent()) return repository.save(turno);
        throw new NoTargetFoundException("No se encontrar el "+Turno.class.getTypeName() + ", con id: " + turno.getId());
    }

    public String eliminarTurno(Long id) throws NoTargetFoundException{
        if(buscarTurno(id).isEmpty()){
            log.info("Turno con id:{}, no eliminado",id);
            throw new NoTargetFoundException("No se encontrar el "+Turno.class.getTypeName() + ", con id: " + id);
        }
        repository.deleteById(id);
        log.info("Turno con id:{}, eliminado exitosamente", id);
        return "Succes";
    }

}

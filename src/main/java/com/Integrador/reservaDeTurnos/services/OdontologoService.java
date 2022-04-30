package com.Integrador.reservaDeTurnos.services;

import com.Integrador.reservaDeTurnos.entities.Odontologo;
import com.Integrador.reservaDeTurnos.exceptions.NoTargetFoundException;
import com.Integrador.reservaDeTurnos.repositories.IOdontologoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Not;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service @RequiredArgsConstructor @Slf4j
public class OdontologoService {

    private final IOdontologoRepository repository;

    public List<Odontologo> listarOdontologos(){
        log.info("Listando todos los odontologos");
        return repository.findAll();
    }

    public Optional<Odontologo> buscarOdontologo(Long id) throws NoTargetFoundException{
        log.info("Buscando odontologo con id:{}", id);
        Optional<Odontologo> odontologo = repository.findById(id);
        if(odontologo.isPresent()){
            log.info("{}", odontologo.get().toString());
            return odontologo;
        }
        throw new NoTargetFoundException("No se encontrar el "+Odontologo.class.getTypeName() + ", con id:" +id);
    }

    public Odontologo actualizarOdontologo(Odontologo odontologo) throws NoTargetFoundException {
        if(buscarOdontologo(odontologo.getId()).isPresent()){
            log.info("Actualizano odontologo con id:{} , a: {}", odontologo.getId(), odontologo.toString());
            return repository.save(odontologo);
        }
        throw new NoTargetFoundException("No se encontrar el "+Odontologo.class.getTypeName() + ", con id: " +odontologo.getId());
    }

    public Odontologo guardarOdontologo(Odontologo odontologo){
        log.info("Guardando odontologo: {}", odontologo.toString());
        return repository.save(odontologo);
    }

    public String eliminarOdontologo(Long id) throws NoTargetFoundException {
        log.info("Eliminando odontologo con id: {}",id);
        if(buscarOdontologo(id).isEmpty()){
            log.info("Odontologo con id:{}, no eliminado",id);
            throw new NoTargetFoundException("No se encontrar el "+Odontologo.class.getTypeName() + ", con id: " + id);
        }
        repository.deleteById(id);
        log.info("Odontologo con id:{}, eliminado exitosamente",id);
        return "Eliminado exitosamente";
    }

}

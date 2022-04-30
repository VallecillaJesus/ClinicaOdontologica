package com.Integrador.reservaDeTurnos.repositories;

import com.Integrador.reservaDeTurnos.entities.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface ITurnoRepository extends JpaRepository<Turno,Long> {
}

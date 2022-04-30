package com.Integrador.reservaDeTurnos.repositories;

import com.Integrador.reservaDeTurnos.entities.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOdontologoRepository extends JpaRepository<Odontologo,Long> {
}

package com.Integrador.reservaDeTurnos.repositories;

import com.Integrador.reservaDeTurnos.entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPacienteRepository extends JpaRepository<Paciente,Long> {
}

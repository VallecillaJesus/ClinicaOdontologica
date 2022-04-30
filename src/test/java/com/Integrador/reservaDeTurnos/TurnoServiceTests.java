package com.Integrador.reservaDeTurnos;

import com.Integrador.reservaDeTurnos.entities.Domicilio;
import com.Integrador.reservaDeTurnos.entities.Odontologo;
import com.Integrador.reservaDeTurnos.entities.Paciente;
import com.Integrador.reservaDeTurnos.entities.Turno;
import com.Integrador.reservaDeTurnos.exceptions.NoTargetFoundException;
import com.Integrador.reservaDeTurnos.services.OdontologoService;
import com.Integrador.reservaDeTurnos.services.PacienteService;
import com.Integrador.reservaDeTurnos.services.TurnoService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class TurnoServiceTests {

    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private OdontologoService odontologoService;
    @Autowired
    private TurnoService turnoService;

    // ====== CÓDIGO LILI======= TEST UNITARIOS

    public void cargarDatos(){
        Domicilio domicilio = new Domicilio(
                "Gracias",
                "Bariloche",
                "Rio Negro"
        );
        Paciente paciente = new Paciente(
                "Jesus",
                "Jose",
                "12323123",
                LocalDate.of(2020,8,11),domicilio);

        pacienteService.guardarPaciente(paciente);
        odontologoService.guardarOdontologo(
                new Odontologo(
                        "abc123",
                        "Silvia",
                        "Urda")
        );
    }

    @Test
    public void d_listarTurnoTest() {
        Assert.assertNotNull(turnoService.listarTurnos());
    }

}

package com.Integrador.reservaDeTurnos;

import com.Integrador.reservaDeTurnos.entities.Odontologo;
import com.Integrador.reservaDeTurnos.exceptions.NoTargetFoundException;
import com.Integrador.reservaDeTurnos.services.OdontologoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;

import java.util.Optional;

@SpringBootTest
class ReservaDeTurnosApplicationTests {

	@Autowired

	@Test
	void contextLoads() throws NoTargetFoundException {

	}

}

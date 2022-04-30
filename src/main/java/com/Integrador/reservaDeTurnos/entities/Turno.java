package com.Integrador.reservaDeTurnos.entities;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Turno {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Odontologo odontologo;

    public Turno(LocalDate fecha, Paciente paciente, Odontologo odontologo) {
        this.fecha = fecha;
        this.paciente = paciente;
        this.odontologo = odontologo;
    }
}

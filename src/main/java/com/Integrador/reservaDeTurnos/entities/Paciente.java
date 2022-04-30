package com.Integrador.reservaDeTurnos.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Paciente {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String dni;
    private LocalDate fechaDeAlta;

    @OneToOne(cascade = CascadeType.ALL)
    private Domicilio domicilio;

    @JsonIgnore
    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
    private Set<Turno> turnos = new HashSet<>(0);

    public Paciente(String nombre, String apellido, String dni, LocalDate fechaDeAlta, Domicilio domicilio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaDeAlta = fechaDeAlta;
        this.domicilio = domicilio;
    }
}

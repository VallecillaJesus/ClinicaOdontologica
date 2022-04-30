package com.Integrador.reservaDeTurnos.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Odontologo {

    @Id
    @GeneratedValue( strategy = IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String matricula;

    @JsonIgnore
    @OneToMany(mappedBy = "odontologo", cascade = CascadeType.ALL)
    private Set<Turno> turnos;

    public Odontologo(String nombre, String apellido, String matricula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
    }
}

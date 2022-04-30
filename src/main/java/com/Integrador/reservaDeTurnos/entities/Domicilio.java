package com.Integrador.reservaDeTurnos.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Domicilio {

    @Id
    @GeneratedValue( strategy = IDENTITY)
    private Long id;
    private String localidad;
    private String ciudad;
    private String direccion;

    public Domicilio(String localidad, String ciudad, String direccion) {
        this.localidad = localidad;
        this.ciudad = ciudad;
        this.direccion = direccion;
    }
}

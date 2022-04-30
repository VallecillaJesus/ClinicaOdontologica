package com.Integrador.reservaDeTurnos.security.controller;

import com.Integrador.reservaDeTurnos.security.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping("/user")
    public Collection<? extends GrantedAuthority> loggedUser(){
        return service.getUserContext();
    }

}

package com.Integrador.reservaDeTurnos.security.service;

import com.Integrador.reservaDeTurnos.security.entities.User;
import com.Integrador.reservaDeTurnos.security.entities.UserRole;
import com.Integrador.reservaDeTurnos.security.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component @RequiredArgsConstructor
public class DataLoader implements ApplicationRunner {

    private final IUserRepository repository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        repository.save(new User(null,
                "admin",
                "admin@integrador.com",
                PasswordEncoder.encodePassword("admin"),
                UserRole.ROLE_ADMIN));

        repository.save(new User(null, "usuario",
                "usuario@integrador.com",
                PasswordEncoder.encodePassword("usuario"),
                UserRole.ROLE_USER));
    }
}

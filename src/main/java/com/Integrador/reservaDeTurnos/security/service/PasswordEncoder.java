package com.Integrador.reservaDeTurnos.security.service;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import static lombok.AccessLevel.PRIVATE;

@Component
public class PasswordEncoder {

    private static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Bean
    public static BCryptPasswordEncoder getEncoder() {
        return encoder;
    }

    public static String encodePassword(String password){
        return encoder.encode(password);
    }

    public static Boolean comparePasswords(String rawPassword, String encodedPassword){
        return encoder.matches(rawPassword,encodedPassword);
    }

}

package com.Integrador.reservaDeTurnos.security.service;

import com.Integrador.reservaDeTurnos.security.entities.User;
import com.Integrador.reservaDeTurnos.security.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service @Slf4j @RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final IUserRepository repository;

    public Collection<? extends GrantedAuthority> getUserContext(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = null;
        if (principal instanceof UserDetails) {
            userDetails = (UserDetails) principal;
        }
        if(userDetails != null){
            log.info("Rol del usuario logeado: {}", userDetails.getAuthorities());
            return userDetails.getAuthorities();
        }
        log.info("Rol del usuario logeado: null");
        return null;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = repository.findByEmail(username);
        if(user.isPresent()) return user.get();
        throw new UsernameNotFoundException("Usuario no encontrado");
    }
}

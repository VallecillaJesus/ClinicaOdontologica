package com.Integrador.reservaDeTurnos.exceptions;

import ch.qos.logback.classic.net.SMTPAppender;
import lombok.extern.slf4j.Slf4j;
import org.jboss.jandex.Main;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice @Slf4j
public class GlobalExceptionsHandler {

    @ExceptionHandler({NoTargetFoundException.class})
    public ResponseEntity<String> handleNoTargetFoundException (NoTargetFoundException exception){
        log.error(exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

}

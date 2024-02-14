package com.example.desafiobackendjunior.exceptions;

import com.example.desafiobackendjunior.dtos.ExceptionDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity dadoDuplicado() {
        ExceptionDTO exceptionDTO = new ExceptionDTO("CPF ou placa já cadastrado", HttpStatus.BAD_GATEWAY.value());

        return ResponseEntity.badRequest().body(exceptionDTO);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity entidadeNaoEncontrada() {
        ExceptionDTO exceptionDTO = new ExceptionDTO("Veículo não encontrado", HttpStatus.BAD_GATEWAY.value());

        return ResponseEntity.badRequest().body(exceptionDTO);
    }
}

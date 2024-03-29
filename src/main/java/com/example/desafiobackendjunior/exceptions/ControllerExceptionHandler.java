package com.example.desafiobackendjunior.exceptions;

import com.example.desafiobackendjunior.exceptions.dtos.ExceptionDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<?> dataDuplicate() {
        ExceptionDTO exceptionDTO = new ExceptionDTO("CPF ou placa já cadastrado", HttpStatus.BAD_REQUEST.value());

        return ResponseEntity.badRequest().body(exceptionDTO);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> entityNotFound() {
        ExceptionDTO exceptionDTO = new ExceptionDTO("Veículo não encontrado", HttpStatus.NOT_FOUND.value());

        return ResponseEntity.badRequest().body(exceptionDTO);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> invalidArgument() {
        ExceptionDTO exceptionDTO = new ExceptionDTO("Argumento não específicado", HttpStatus.BAD_REQUEST.value());

        return ResponseEntity.badRequest().body(exceptionDTO);
    }
}

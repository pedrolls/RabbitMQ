package com.example.demo_rabbit.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ControleDeExcecoes {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> erroDeValidacaoDeCamposDTO(
            MethodArgumentNotValidException ex){
        Map<String, String> erros = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(e ->
            erros.put(e.getField(), e.getDefaultMessage())
        );
        return new ResponseEntity<>(erros, HttpStatus.BAD_REQUEST);
    }
}

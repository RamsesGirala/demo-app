package com.example.demoapp.presentation.advice;

import com.example.demoapp.domain.dtos.ErrorDto;
import com.example.demoapp.exceptions.EdadIncorrecta;
import com.example.demoapp.exceptions.EntidadNoEncontrada;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AdviceController {
    private static final Logger logger = LoggerFactory.getLogger(AdviceController.class);

    //Metodo para manejar cualquier excepcion que no se controle en ningun lado
    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorDto> handleEmptyInput(Exception e){
        String errorMsg = e.getClass() + " : " + e.getMessage();
        logger.error(errorMsg);
        return ResponseEntity.internalServerError()
                .body(ErrorDto.builder()
                        .errorMsg(e.getMessage())
                        .errorClass(e.getClass().getSimpleName())
                        .build());
    }

    //Metodo para manejar excepciones del tipo 'EntidadNoEncontrada'
    @ExceptionHandler(value = EntidadNoEncontrada.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorDto> entidadNoEncontrada(EntidadNoEncontrada e){
        String errorMsg = e.getClass() + " : " + e.getMessage();
        logger.error(errorMsg);
        return ResponseEntity.internalServerError()
                .body(ErrorDto.builder()
                        .errorMsg(e.getErrorMsg())
                        .codigo(e.getCODIGO())
                        .errorClass(e.getClass().getSimpleName())
                        .build());
    }

    //Metodo para manejar excepciones del tipo 'EdadIncorrecta'
    @ExceptionHandler(value = EdadIncorrecta.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorDto> edadIncorrecta(EdadIncorrecta e){
        String errorMsg = e.getClass() + " : " + e.getMessage();
        logger.error(errorMsg);
        return ResponseEntity.internalServerError()
                .body(ErrorDto.builder()
                        .errorMsg(e.getErrorMsg())
                        .codigo(e.getCODIGO())
                        .errorClass(e.getClass().getSimpleName())
                        .build());
    }

}
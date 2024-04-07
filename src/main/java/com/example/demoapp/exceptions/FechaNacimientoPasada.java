package com.example.demoapp.exceptions;

import lombok.Getter;

@Getter
public class FechaNacimientoPasada extends RuntimeException {
    private String errorMsg = "No se puede crear una persona porque la fecha de nacimiento es demasiado antigua";
    private final int CODIGO = 23;

    public FechaNacimientoPasada(){

    }
}

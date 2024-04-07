package com.example.demoapp.exceptions;

import lombok.Getter;

@Getter
public class PersonaSinDomicilio extends RuntimeException{
    private String errorMsg = "No se puede crear una persona sin asignarle un domicilio";
    private final int CODIGO = 22;

    public PersonaSinDomicilio(){
    }

}

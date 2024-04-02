package com.example.demoapp.exceptions;

import lombok.Getter;

@Getter
public class EdadIncorrecta extends RuntimeException{

    private String errorMsg;
    private final String MSG_CONSTANT = "No se puede crear la persona porque no es congruente la fecha de nacimiento %s con la edad ignresada %d";
    private final int CODIGO = 21;

    public EdadIncorrecta(String fecha, int edad){
        this.errorMsg = MSG_CONSTANT.formatted(fecha,edad);
    }

}

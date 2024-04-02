package com.example.demoapp.exceptions;

import lombok.Getter;

@Getter
public class EntidadNoEncontrada extends RuntimeException{

    private String errorMsg;
    private final String MSG_CONSTANT = "No existe una %s con el id %d";
    private final int CODIGO = 20;

    public EntidadNoEncontrada(String entidad,Long id){
        this.errorMsg = MSG_CONSTANT.formatted(entidad,id);
    }

}

package com.example.demoapp.business.mapper;

import com.example.demoapp.domain.dtos.PersonaFullDto;
import com.example.demoapp.domain.dtos.PersonaShortDto;
import com.example.demoapp.domain.entities.Domicilio;
import com.example.demoapp.domain.entities.Persona;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PersonaMapper {

    //Genera un metodo para mappear todos los atributos de la clase Persona a la Clase PersonaFullDto
    PersonaFullDto personaToPersonaFullDto(Persona persona);

    //Genera un metodo para mappear todos los atributos de la clase PersonaFullDto a la Clase Persona
    Persona personaFullDtoToPersona(PersonaFullDto personaFullDto);

    //Genera un metodo para mappear todos los atributos de la clase Persona a la Clase PersonaShortDto
    //Ademas mappea el atributo 'provincia' dentro del objeto de domicilio asociado a dicha persona
    //y lo agrega al atributo 'provincia' del Dto
    @Mapping(source = "domicilio.provincia", target = "provincia")
    PersonaShortDto personaToPersonaShortDto(Persona persona);

}

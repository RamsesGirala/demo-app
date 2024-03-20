package com.example.demoapp.business.mapper;

import com.example.demoapp.domain.dtos.PersonaFullDto;
import com.example.demoapp.domain.dtos.PersonaShortDto;
import com.example.demoapp.domain.entities.Domicilio;
import com.example.demoapp.domain.entities.Persona;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PersonaMapper {

    PersonaFullDto personaToPersonaFullDto(Persona persona);

    Persona personaFullDtoToPersona(PersonaFullDto personaFullDto);

    @Mapping(source = "domicilio.provincia", target = "provincia")
    PersonaShortDto personaToPersonaShortDto(Persona persona);

}

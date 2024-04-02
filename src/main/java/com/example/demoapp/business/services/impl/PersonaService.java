package com.example.demoapp.business.services.impl;

import com.example.demoapp.business.services.IPersonaService;
import com.example.demoapp.domain.entities.Persona;
import com.example.demoapp.exceptions.EdadIncorrecta;
import com.example.demoapp.exceptions.EntidadNoEncontrada;
import com.example.demoapp.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class PersonaService implements IPersonaService {

    @Autowired
    private PersonaRepository personaRepository;


    @Override
    public Persona crear(Persona persona) {
        validarFechaYEdad(persona);
        return personaRepository.save(persona);
    }

    @Override
    public Persona getById(Long id) {
        var persona = personaRepository.findById(id);
        if(persona.isEmpty()) throw new EntidadNoEncontrada(Persona.class.getSimpleName(),id);
        return persona.get();
    }

    private void validarFechaYEdad(Persona persona){
        int edadCalculada = Period.between(persona.getFechaNacimiento(), LocalDate.now()).getYears();
        if(edadCalculada != persona.getEdad()) throw new EdadIncorrecta(persona.getFechaNacimiento().toString(),persona.getEdad());
    }
}

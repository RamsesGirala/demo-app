package com.example.demoapp.business.services.impl;

import com.example.demoapp.business.services.IPersonaService;
import com.example.demoapp.domain.entities.Persona;
import com.example.demoapp.exceptions.EdadIncorrecta;
import com.example.demoapp.exceptions.EntidadNoEncontrada;
import com.example.demoapp.exceptions.FechaNacimientoPasada;
import com.example.demoapp.exceptions.PersonaSinDomicilio;
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
        validarCrearPersona(persona);
        return personaRepository.save(persona);
    }

    @Override
    public Persona getById(Long id) {
        var persona = personaRepository.findById(id);
        if(persona.isEmpty()) throw new EntidadNoEncontrada(Persona.class.getSimpleName(),id);
        return persona.get();
    }

    private void validarCrearPersona(Persona persona){
        validarPersonaConDomicilio(persona);
        validarFechaYEdad(persona);
        validarFechaNacimientoPasada(persona);
    }

    private void validarFechaYEdad(Persona persona){
        int edadCalculada = Period.between(persona.getFechaNacimiento(), LocalDate.now()).getYears();
        if(edadCalculada != persona.getEdad()) throw new EdadIncorrecta(persona.getFechaNacimiento().toString(),persona.getEdad());
    }

    private void validarPersonaConDomicilio(Persona persona){
        if(persona.getDomicilio() == null) throw new PersonaSinDomicilio();
    }

    private void validarFechaNacimientoPasada(Persona persona) {
        LocalDate fechaLimite = LocalDate.now().minusYears(110);
        if (persona.getFechaNacimiento().isBefore(fechaLimite)) {
            throw new FechaNacimientoPasada();
        }
    }
}

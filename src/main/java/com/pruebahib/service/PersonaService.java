package com.pruebahib.service;

import com.pruebahib.model.Persona;
import com.pruebahib.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService implements IPersonaService{

    @Autowired
    PersonaRepository personaRepository;

    @Override
    public void save(Persona persona) {
        Persona save = personaRepository.save(persona);
        System.out.println(save.toString());
    }

    @Override
    public void update(Long idPersona, String nombre, String apellido, int edad) {
        Persona personaBD = this.getPersonaById(idPersona);

        if (personaBD != null) {
            personaBD.setNombre(nombre);
            personaBD.setApellido(apellido);
            personaBD.setEdad(edad);

            this.save(personaBD);
        }
    }

    @Override
    public List<Persona> getAll() {
        return personaRepository.findAll();
    }

    @Override
    public Persona getPersonaById(Long id) {
        return personaRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Persona persona) {
        personaRepository.delete(persona);
    }
}

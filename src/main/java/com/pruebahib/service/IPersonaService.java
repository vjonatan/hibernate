package com.pruebahib.service;

import com.pruebahib.model.Persona;

import java.util.List;

public interface IPersonaService {

    void save(Persona persona);

    void update(Long idPersona, String  nombre, String apellido, int edad );

    List<Persona> getAll();

    Persona getPersonaById(Long id);

    void delete(Persona persona);


}

package com.pruebahib.controller;

import com.pruebahib.model.Persona;
import com.pruebahib.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class PersonaController {

    @Autowired
    private IPersonaService personaService;

    @PostMapping("/persona")
    public String create(@RequestBody Persona persona) {
        personaService.save(persona);
        return "Persona CREADA";
    }

    @PutMapping("/persona/{id}")
    public String update(@PathVariable Long id, @RequestBody Persona persona) {
        personaService.update(id, persona.getNombre(),  persona.getApellido(), persona.getEdad());
        return "Persona MODIFICADA";
    }

    @GetMapping("/persona")
    public List<Persona> getAll() {
        return personaService.getAll();
    }

    @GetMapping("/persona/{id}")
    public Persona getPersonaById(@PathVariable Long id) {
        return personaService.getPersonaById(id);
    }

    @DeleteMapping()
    public String delete(@RequestBody Persona persona) {
        personaService.delete(persona);
        return "Persona ELIMINADA";
    }
}

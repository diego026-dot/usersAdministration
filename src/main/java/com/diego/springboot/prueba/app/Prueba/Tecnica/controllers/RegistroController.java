package com.diego.springboot.prueba.app.Prueba.Tecnica.controllers;

import com.diego.springboot.prueba.app.Prueba.Tecnica.entities.Registros;
import com.diego.springboot.prueba.app.Prueba.Tecnica.services.RegistroService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/registro")
@RequiredArgsConstructor
public class RegistroController {

    private final RegistroService service;

    @PostMapping("/entrada/{id}")
    public Registros entrada(@PathVariable Long id){
        return service.entrada(id);
    }

    @PostMapping("/salida/{id}")
    public Registros salida(@PathVariable Long id){
        return service.salida(id);
    }

    @PostMapping("/salario/{id}")
    public Double salarioDiario(@PathVariable Long id){
        return service.salarioDiario(id);
    }
}

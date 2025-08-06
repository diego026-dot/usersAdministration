package com.diego.springboot.prueba.app.Prueba.Tecnica.controllers;

import com.diego.springboot.prueba.app.Prueba.Tecnica.entities.Empleado;
import com.diego.springboot.prueba.app.Prueba.Tecnica.services.EmpleadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class EmpleadoController {
    private final EmpleadoService service;

    @PostMapping("/id")
    public Empleado getID(@RequestBody Integer id){
        return service.findById(id);
    }
}


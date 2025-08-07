package com.diego.springboot.prueba.app.Prueba.Tecnica.controllers;

import com.diego.springboot.prueba.app.Prueba.Tecnica.entities.Departamento;
import com.diego.springboot.prueba.app.Prueba.Tecnica.entities.Empleado;
import com.diego.springboot.prueba.app.Prueba.Tecnica.repositories.DepartamentoRepository;
import com.diego.springboot.prueba.app.Prueba.Tecnica.services.EmpleadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class EmpleadoController {

    private final EmpleadoService service;
    private final DepartamentoRepository departamentoRepository;

    @PostMapping("/create")
    public Optional<Empleado> create(@RequestBody Empleado empleado){
        String nombreDepartamento = empleado.getDepartamento().getNombre();
        Optional<Departamento> departamento = departamentoRepository.findByNombre(nombreDepartamento);
        if (departamento.isPresent()) {
            empleado.setDepartamento(departamento.get());
            return service.create(empleado);
        }
        return Optional.empty();
    }

}


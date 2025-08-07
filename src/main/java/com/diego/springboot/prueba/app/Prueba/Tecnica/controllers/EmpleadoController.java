package com.diego.springboot.prueba.app.Prueba.Tecnica.controllers;

import com.diego.springboot.prueba.app.Prueba.Tecnica.entities.Empleado;
import com.diego.springboot.prueba.app.Prueba.Tecnica.entities.dto.EmpleadoCreateDTO;
import com.diego.springboot.prueba.app.Prueba.Tecnica.entities.dto.EmpleadoDTO;
import com.diego.springboot.prueba.app.Prueba.Tecnica.entities.dto.LoginDTO;
import com.diego.springboot.prueba.app.Prueba.Tecnica.services.EmpleadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class EmpleadoController {

    private final EmpleadoService service;

    @PostMapping("/create")
    public Optional<Empleado> create(@RequestBody EmpleadoCreateDTO empleado){
        return service.create(empleado);
    }

    @PostMapping ("/empleadoID/{id}")
    public Optional<Empleado> getAll(@PathVariable Long id){
        return service.getById(id);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id ,@RequestBody EmpleadoDTO empleado){
        return service.update(id,empleado);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        service.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO login){
        return service.login(login);
    }

}


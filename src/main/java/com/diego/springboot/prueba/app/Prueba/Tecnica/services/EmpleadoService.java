package com.diego.springboot.prueba.app.Prueba.Tecnica.services;

import com.diego.springboot.prueba.app.Prueba.Tecnica.entities.Empleado;
import com.diego.springboot.prueba.app.Prueba.Tecnica.repositories.EmpleadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmpleadoService {
    @Autowired
    private final EmpleadoRepository empleado;

    public Empleado findById(Integer id){
        return (Empleado) empleado.findById(id);
    }

}

package com.diego.springboot.prueba.app.Prueba.Tecnica.services;

import com.diego.springboot.prueba.app.Prueba.Tecnica.entities.Departamento;
import com.diego.springboot.prueba.app.Prueba.Tecnica.entities.Empleado;
import com.diego.springboot.prueba.app.Prueba.Tecnica.repositories.DepartamentoRepository;
import com.diego.springboot.prueba.app.Prueba.Tecnica.repositories.EmpleadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmpleadoService {

    private final EmpleadoRepository repository;
    private final DepartamentoRepository departamentoRepository;

    public Optional<Empleado> create(Empleado empleado){
        return Optional.of(repository.save(empleado));
    }

    public ResponseEntity<Object> update(Long id , Empleado empleadoBody){
        Optional<Empleado> empleadoOptional = repository.findById(id);

        if (empleadoOptional.isPresent()) {
            Empleado empleado = empleadoOptional.get();
            empleado.setName(empleadoBody.getName());
            String nombreDepartamento = empleado.getDepartamento().getNombre();
            Optional<Departamento> departamento = departamentoRepository.findByNombre(nombreDepartamento);
            empleado.setDepartamento(departamento.get()); // si es un objeto Departamento

            Empleado actualizado = repository.save(empleado);
            return ResponseEntity.ok(actualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

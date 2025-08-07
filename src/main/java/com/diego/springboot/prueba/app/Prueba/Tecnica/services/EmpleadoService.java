package com.diego.springboot.prueba.app.Prueba.Tecnica.services;

import com.diego.springboot.prueba.app.Prueba.Tecnica.entities.Departamento;
import com.diego.springboot.prueba.app.Prueba.Tecnica.entities.Empleado;
import com.diego.springboot.prueba.app.Prueba.Tecnica.entities.dto.EmpleadoCreateDTO;
import com.diego.springboot.prueba.app.Prueba.Tecnica.entities.dto.EmpleadoDTO;
import com.diego.springboot.prueba.app.Prueba.Tecnica.entities.dto.LoginDTO;
import com.diego.springboot.prueba.app.Prueba.Tecnica.repositories.DepartamentoRepository;
import com.diego.springboot.prueba.app.Prueba.Tecnica.repositories.EmpleadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmpleadoService {

    private final EmpleadoRepository repository;
    private final DepartamentoRepository departamentoRepository;
    private final PasswordEncoder passwordEncoder;

    public Optional<Empleado> create(EmpleadoCreateDTO empleado) {
        Optional<Departamento> departamento = departamentoRepository.findByNombre(empleado.getDepartamento());
        String hashPassword = passwordEncoder.encode(empleado.getPassword());
        if (departamento.isPresent()) {
            Empleado empleadoCreate = new Empleado(empleado.getName(),empleado.getEmail(),hashPassword,departamento.get());
            return Optional.of(repository.save(empleadoCreate));
        }
        return Optional.empty();
    }

    public Optional<Empleado> getById(Long id){
        return repository.findById(id);
    }

    public ResponseEntity<Object> update(Long id, EmpleadoDTO empleadoBody) {
        Empleado empleado = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));

        empleado.setName(empleadoBody.getName());
        empleado.setEmail(empleadoBody.getEmail());

        Empleado actualizado = repository.save(empleado);
        return ResponseEntity.ok(actualizado);

    }

    public void deleteUser(Long id){
        Empleado empleado = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));
        repository.deleteById(empleado.getId());
    }

    public ResponseEntity<String> login(LoginDTO login){
        Optional<Empleado> empleado = repository.findByEmail(login.getEmail());
        if(empleado.isPresent()){
            if (passwordEncoder.matches(login.getPassword(), empleado.get().getPassword())){
                return ResponseEntity.ok("Inicio de sesión exitoso");
            }else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Contraseña incorrecta");
            }
        }else {
            // Usuario no encontrado
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
        }
    }



}

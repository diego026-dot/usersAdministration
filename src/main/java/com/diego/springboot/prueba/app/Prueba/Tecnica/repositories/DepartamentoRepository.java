package com.diego.springboot.prueba.app.Prueba.Tecnica.repositories;

import com.diego.springboot.prueba.app.Prueba.Tecnica.entities.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
    Optional<Departamento> findByNombre(String nombre);
}



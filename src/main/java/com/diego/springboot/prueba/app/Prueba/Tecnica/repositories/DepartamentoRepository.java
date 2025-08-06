package com.diego.springboot.prueba.app.Prueba.Tecnica.repositories;

import com.diego.springboot.prueba.app.Prueba.Tecnica.entities.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
}



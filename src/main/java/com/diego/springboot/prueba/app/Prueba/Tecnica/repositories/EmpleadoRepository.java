package com.diego.springboot.prueba.app.Prueba.Tecnica.repositories;

import com.diego.springboot.prueba.app.Prueba.Tecnica.entities.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long>{}

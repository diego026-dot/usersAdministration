package com.diego.springboot.prueba.app.Prueba.Tecnica.repositories;

import com.diego.springboot.prueba.app.Prueba.Tecnica.entities.Registros;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface RegistroRepository extends JpaRepository<Registros, Long> {

    Optional<Registros> findByEmpleadoIdAndFecha(Long id, LocalDate date);
}

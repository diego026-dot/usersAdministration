package com.diego.springboot.prueba.app.Prueba.Tecnica.services;

import com.diego.springboot.prueba.app.Prueba.Tecnica.entities.Empleado;
import com.diego.springboot.prueba.app.Prueba.Tecnica.entities.Registros;
import com.diego.springboot.prueba.app.Prueba.Tecnica.entities.dto.EntradaDTO;
import com.diego.springboot.prueba.app.Prueba.Tecnica.repositories.EmpleadoRepository;
import com.diego.springboot.prueba.app.Prueba.Tecnica.repositories.RegistroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RegistroService {
    private final RegistroRepository repository;
    private final EmpleadoRepository empleado;

    public Registros entrada(Long id){
        Empleado empleadoExists = empleado.findById(id)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));
        boolean entradaExists = repository.findByEmpleadoIdAndFecha(id, LocalDate.now()).isPresent();
        if (entradaExists) {
            throw new RuntimeException("Entrada ya ha sido ingresada");
        }

        Registros registro = new Registros();
        registro.setEmpleadoId(id);
        registro.setFecha(LocalDate.now());
        registro.setHoraEntrada(LocalTime.now());
        return repository.save(registro);
    }

    public Registros salida(Long id){
        Registros registro = repository.findByEmpleadoIdAndFecha(id, LocalDate.now())
                .orElseThrow(() -> new RuntimeException("Registro no encontrado"));

        registro.setHoraSalida(LocalTime.now());
        return repository.save(registro);

    }

    public Double salarioDiario(Long id){
        Optional<Registros> registro = repository.findByEmpleadoIdAndFecha(id, LocalDate.now());
        Empleado empleadoExist = empleado.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if(registro.get().getHoraEntrada() == null && registro.get().getHoraSalida() == null){
            throw new RuntimeException("Entrada y salida no han sido ingresadas");
        }

        double horas = Duration.between(registro.get().getHoraEntrada(), registro.get().getHoraSalida()).toMinutes() / 60.0;
        return empleadoExist.getDepartamento().getTarifa() * horas;
    }


}

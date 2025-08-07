package com.diego.springboot.prueba.app.Prueba.Tecnica.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpleadoCreateDTO {
    private String name;
    private String email;
    private String password;
    private String departamento;
}

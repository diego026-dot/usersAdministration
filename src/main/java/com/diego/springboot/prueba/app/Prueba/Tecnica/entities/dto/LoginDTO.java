package com.diego.springboot.prueba.app.Prueba.Tecnica.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDTO {
    @NotNull
    String email;
    String password;
}

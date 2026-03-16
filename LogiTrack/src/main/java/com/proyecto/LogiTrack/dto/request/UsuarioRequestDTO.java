package com.proyecto.LogiTrack.dto.request;

import com.proyecto.LogiTrack.model.Rol;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UsuarioRequestDTO(
        @NotBlank(message = "El campo nombre es requerido")
        String nombre,

        @NotBlank(message = "El campo email es requerido")
        @Email(message = "email inválido")
        String email,

        @NotBlank(message = "El campo contraseña es obligatorio")
        String password,

        @NotNull(message = "El campo rol es requerido")
        Rol rol
) {
}

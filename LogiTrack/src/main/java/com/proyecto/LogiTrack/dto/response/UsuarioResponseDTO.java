package com.proyecto.LogiTrack.dto.response;

import com.proyecto.LogiTrack.model.Rol;

public record UsuarioResponseDTO(
        Long id,
        String nombre,
        String email,
        Rol rol
) {
}

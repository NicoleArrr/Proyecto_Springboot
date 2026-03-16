package com.proyecto.LogiTrack.dto.response;

public record BodegaResponseDTO(
        Long id,
        String nombre,
        String ubicacion,
        Integer capacidad,
        UsuarioResponseDTO encargado
) {
}

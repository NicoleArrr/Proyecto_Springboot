package com.proyecto.LogiTrack.dto.response;

import com.proyecto.LogiTrack.model.Tipo;

import java.time.LocalDateTime;

public record AuditoriaResponseDTO(
        Long id,
        Tipo tipoOperacion,
        LocalDateTime fecha,
        String entidadAfectada,
        String valoresAnteriores,
        String valoresNuevos,
        UsuarioResponseDTO usuario
) {
}

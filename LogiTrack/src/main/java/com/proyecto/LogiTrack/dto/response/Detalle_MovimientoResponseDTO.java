package com.proyecto.LogiTrack.dto.response;

public record Detalle_MovimientoResponseDTO(
        Long id,
        ProductoResponseDTO producto,
        Integer cantidad
) {
}

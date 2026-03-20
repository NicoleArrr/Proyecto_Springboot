package com.proyecto.LogiTrack.dto.response;

import java.util.List;

public record Detalle_MovimientoResponseDTO(
        Long id,
        ProductoResponseDTO producto,
        Integer cantidad

        // Aquí es como retorna la consulta
) {
}

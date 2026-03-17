package com.proyecto.LogiTrack.dto.response;

import java.math.BigDecimal;

public record ProductoResponseDTO(
        Long id,
        String nombre,
        String categoria,
        BigDecimal precio
        // Integer stock
) {
}

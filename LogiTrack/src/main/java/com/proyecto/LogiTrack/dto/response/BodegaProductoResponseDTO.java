package com.proyecto.LogiTrack.dto.response;

public record BodegaProductoResponseDTO(
        Long id,
        BodegaResponseDTO bodega,
        ProductoResponseDTO producto,
        Integer stock
) {
}

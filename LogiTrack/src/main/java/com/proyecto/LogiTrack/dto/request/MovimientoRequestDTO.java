package com.proyecto.LogiTrack.dto.request;

import com.proyecto.LogiTrack.model.Tipo;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record MovimientoRequestDTO(
        @NotNull(message = "El tipo de movimiento es obligatorio")
        Tipo tipo,

        @NotNull(message = "El usuario es obligatorio")
        Long idUsuario,

        Long idBodegaOrigen,

        Long idBodegaDestino,

        @NotNull(message = "Los detalles son obligatorios")
        List<Detalle_MovimientoRequestDTO> detalles
) {
}

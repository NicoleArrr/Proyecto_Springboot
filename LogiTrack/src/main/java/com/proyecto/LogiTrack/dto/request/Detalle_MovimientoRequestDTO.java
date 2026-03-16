package com.proyecto.LogiTrack.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record Detalle_MovimientoRequestDTO(
        @NotNull(message = "El campo id del encargado es obligatorio")
        Long id_encargado,

        @NotNull(message = "El campo cantidad es requerido")
        @Positive(message = "La cantidad debe ser mayor que 0")
        Integer cantidad

) {
}

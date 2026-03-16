package com.proyecto.LogiTrack.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ProductoRequestDTO(
        @NotBlank(message = "El campo nombre es requerido")
        String nombre,

        @NotBlank(message = "El campo categoría es requerido")
        String categoria,

        @NotNull(message = "El campo precio es requerido")
        @Positive(message = "El precio debe ser mayor que 0")
        BigDecimal precio
) {
}

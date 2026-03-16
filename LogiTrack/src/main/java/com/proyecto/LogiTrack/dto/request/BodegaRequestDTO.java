package com.proyecto.LogiTrack.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record BodegaRequestDTO(
        @NotBlank(message = "El campo nombre es requerido")
        String nombre,

        @NotBlank(message = "El campo ubicación es requerido")
        String ubicacion,

        @NotNull(message = "El campo capacidad es requerido")
        @Positive(message = "La capacidad debe ser mayor que 0")
        Integer capacidad,

        @NotNull(message = "El campo id del encargado es requerido")
        Long id_encargado
) {
}

package com.proyecto.LogiTrack.dto.request;

import com.proyecto.LogiTrack.model.Tipo;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record MovimientoRequestDTO(
        @NotNull(message = "El campo descriptivo del tipo de movimiento a practicar es requerido")
        Tipo tipo,

        @NotNull(message = "El id del usuario es requerido")
        Long id_usuario,

        Long id_Borigen,

        Long id_Bdestino,

        @NotNull(message = "Los detalles del movimiento son requeridos")
        List<Detalle_MovimientoRequestDTO> Detalles
) {
}

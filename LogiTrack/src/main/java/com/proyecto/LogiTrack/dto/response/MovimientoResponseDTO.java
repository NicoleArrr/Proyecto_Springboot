package com.proyecto.LogiTrack.dto.response;

import com.proyecto.LogiTrack.model.Tipo;

import java.time.LocalDateTime;
import java.util.List;

public record MovimientoResponseDTO(
        Long id,
        LocalDateTime fecha,
        Tipo tipo,
        UsuarioResponseDTO encargado,
        BodegaResponseDTO origen,
        BodegaResponseDTO destino,
        List<Detalle_MovimientoResponseDTO> Detalles
) {
}

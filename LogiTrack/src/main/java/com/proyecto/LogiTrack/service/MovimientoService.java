package com.proyecto.LogiTrack.service;

import com.proyecto.LogiTrack.dto.request.MovimientoRequestDTO;
import com.proyecto.LogiTrack.dto.response.MovimientoResponseDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface MovimientoService {

    MovimientoResponseDTO guardarMovimiento(MovimientoRequestDTO dto);
    List<MovimientoResponseDTO> listarMovimientos();
    MovimientoResponseDTO buscarPorId(Long id);
    List<MovimientoResponseDTO> RangoDeFechas(LocalDateTime fechaInicio, LocalDateTime fechaFin);
}

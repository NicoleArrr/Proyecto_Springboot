package com.proyecto.LogiTrack.service;

import com.proyecto.LogiTrack.dto.request.BodegaRequestDTO;
import com.proyecto.LogiTrack.dto.response.BodegaResponseDTO;

import java.util.List;

public interface BodegaService {
    BodegaResponseDTO guardarBodega(BodegaRequestDTO dto);
    BodegaResponseDTO actualizarBodega(BodegaRequestDTO dto, Long id);
    void eliminarBodega(Long id);
    List<BodegaResponseDTO> listarBodegas();
    BodegaResponseDTO buscarPorId(Long id);
}

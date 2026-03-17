package com.proyecto.LogiTrack.service;

import com.proyecto.LogiTrack.dto.response.AuditoriaResponseDTO;
import com.proyecto.LogiTrack.model.Tipo;

import java.util.List;

public interface AuditoriaService {
    List<AuditoriaResponseDTO> listarHistorial();
    List<AuditoriaResponseDTO> buscarPorUsuario(Long idUsuario);
    List<AuditoriaResponseDTO> buscarPorTipoOperacion(Tipo tipoOperacion);
    void registrar(String entidad, String valoresAnteriores, String valoresNuevos,
                   Tipo tipoOperacion, Long id_usuario);
}

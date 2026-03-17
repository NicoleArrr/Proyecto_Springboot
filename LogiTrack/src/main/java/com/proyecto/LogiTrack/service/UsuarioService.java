package com.proyecto.LogiTrack.service;

import com.proyecto.LogiTrack.dto.request.UsuarioRequestDTO;
import com.proyecto.LogiTrack.dto.response.UsuarioResponseDTO;

import java.util.List;

public interface UsuarioService {
    UsuarioResponseDTO guardarUsuario(UsuarioRequestDTO dto);
    UsuarioResponseDTO actualizarUsuario(UsuarioRequestDTO dto, Long id);
    void eliminarUsuario(Long id);
    List<UsuarioResponseDTO> listarUsuarios();
    UsuarioResponseDTO buscarPorId(Long id);
}

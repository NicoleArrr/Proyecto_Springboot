package com.proyecto.LogiTrack.service.Impl;

import com.proyecto.LogiTrack.dto.request.UsuarioRequestDTO;
import com.proyecto.LogiTrack.dto.response.UsuarioResponseDTO;
import com.proyecto.LogiTrack.mapper.UsuarioMapper;
import com.proyecto.LogiTrack.model.Usuario;
import com.proyecto.LogiTrack.repository.UsuarioRepository;
import com.proyecto.LogiTrack.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    @Override
    public UsuarioResponseDTO guardarUsuario(UsuarioRequestDTO dto) {
        Usuario u = UsuarioMapper.DTOAEntidad(dto);
        Usuario guardado = usuarioRepository.save(u);
        return usuarioMapper.entidadADTO(guardado);;
    }

    @Override
    public UsuarioResponseDTO actualizarUsuario(UsuarioRequestDTO dto, Long id) {
        Usuario u = usuarioRepository.findById(id)
                .orElseThrow(() -> new BusinessRuleException("El Usuario " + id + " no ha sido identificado"));
        usuarioMapper.actualizarEntidadDesdeDTO(u, dto);
        Usuario actualizado = usuarioRepository.save(u);
        return usuarioMapper.entidadADTO(actualizado);
    }

    @Override
    public void eliminarUsuario(Long id) {
        usuarioRepository.findById(id)
                .orElseThrow(() -> new BusinessRuleException("El Usuario " + id + " no ha sido identificado"));
        usuarioRepository.deleteById(id);
    }

    @Override
    public List<UsuarioResponseDTO> listarUsuarios() {
        return usuarioRepository.findAll()
                .stream()
                .map(usuarioMapper::entidadADTO)
                .toList();
    }

    @Override
    public UsuarioResponseDTO buscarPorId(Long id) {
        Usuario u = usuarioRepository.findById(id)
                .orElseThrow(() -> new BusinessRuleException("El Usuario " + id + " no ha sido identificado"));
        return usuarioMapper.entidadADTO(u);
    }
}

package com.proyecto.LogiTrack.service.Impl;

import com.proyecto.LogiTrack.dto.request.BodegaRequestDTO;
import com.proyecto.LogiTrack.dto.response.BodegaResponseDTO;
import com.proyecto.LogiTrack.mapper.BodegaMapper;
import com.proyecto.LogiTrack.model.Bodega;
import com.proyecto.LogiTrack.model.Usuario;
import com.proyecto.LogiTrack.repository.BodegaRepository;
import com.proyecto.LogiTrack.repository.UsuarioRepository;
import com.proyecto.LogiTrack.service.BodegaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BodegaServiceImpl implements BodegaService {

    private final BodegaRepository bodegaRepository;
    private final BodegaMapper bodegaMapper;
    private final UsuarioRepository usuarioRepository;

    @Override
    public BodegaResponseDTO guardarBodega(BodegaRequestDTO dto) {
        Usuario encargado = usuarioRepository.findById(dto.id_encargado())
                .orElseThrow(() -> new BusinessRuleException("El usuario a cargo " + dto.id_encargado() + " de la bodega no ha sido identificado"));
        Bodega b = bodegaMapper.DTOAEntidad(dto, encargado);
        Bodega guardada = bodegaRepository.save(b);
        return bodegaMapper.entidadADTO(guardada);
    }

    @Override
    public BodegaResponseDTO actualizarBodega(BodegaRequestDTO dto, Long id) {
        Bodega b = bodegaRepository.findById(id)
                .orElseThrow(() -> new BusinessRuleException("La Bodega " + id + " no ha sido identificada"));
        Usuario encargado = usuarioRepository.findById(dto.id_encargado())
                .orElseThrow(() -> new BusinessRuleException("El usuario a cargo " + dto.id_encargado() + " de la bodega no ha sido identificado"));
        bodegaMapper.actualizarEntidadDesdeDTO(b, dto, encargado);
        Bodega actualizada = bodegaRepository.save(b);
        return bodegaMapper.entidadADTO(actualizada);
    }

    @Override
    public void eliminarBodega(Long id) {
        bodegaRepository.findById(id)
                .orElseThrow(() -> new BusinessRuleException("El usuario a cargo " + id + " de la bodega no ha sido identificado"));
        bodegaRepository.deleteById(id);
    }

    @Override
    public List<BodegaResponseDTO> listarBodegas() {
        return bodegaRepository.findAll()
                .stream()
                .map(bodegaMapper::entidadADTO)
                .toList();
    }

    @Override
    public BodegaResponseDTO buscarPorId(Long id) {
        Bodega b = bodegaRepository.findById(id)
                .orElseThrow(() -> new BusinessRuleException("La Bodega " + id + " no ha sido identificado"));
        return bodegaMapper.entidadADTO(b);
    }
}

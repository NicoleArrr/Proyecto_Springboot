package com.proyecto.LogiTrack.mapper;

import com.proyecto.LogiTrack.dto.request.BodegaRequestDTO;
import com.proyecto.LogiTrack.dto.response.BodegaResponseDTO;
import com.proyecto.LogiTrack.model.Bodega;
import com.proyecto.LogiTrack.model.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BodegaMapper {
    private final UsuarioMapper usuarioMapper;

    public Bodega DTOAEntidad(BodegaRequestDTO dto, Usuario encargado) {
        Bodega b = new Bodega();
        b.setNombre(dto.nombre());
        b.setUbicacion(dto.ubicacion());
        b.setCapacidad(dto.capacidad());
        b.setEncargado(encargado);
        return b;
    }

    public BodegaResponseDTO entidadADTO(Bodega b) {
        return new BodegaResponseDTO(
                b.getId(),
                b.getNombre(),
                b.getUbicacion(),
                b.getCapacidad(),
                b.getEncargado() != null ? usuarioMapper.entidadADTO(b.getEncargado()) : null
        );
    }

    public void actualizarEntidadDesdeDTO(Bodega b, BodegaRequestDTO dto, Usuario encargado) {
        b.setNombre(dto.nombre());
        b.setUbicacion(dto.ubicacion());
        b.setCapacidad(dto.capacidad());
        b.setEncargado(encargado);
    }
}

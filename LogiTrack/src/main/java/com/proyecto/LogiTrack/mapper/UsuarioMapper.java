package com.proyecto.LogiTrack.mapper;

import com.proyecto.LogiTrack.dto.request.UsuarioRequestDTO;
import com.proyecto.LogiTrack.dto.response.UsuarioResponseDTO;
import com.proyecto.LogiTrack.model.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {
    public Usuario DTOAEntidad(UsuarioRequestDTO dto) {
        Usuario u = new Usuario();
        u.setNombre(dto.nombre());
        u.setEmail(dto.email());
        u.setPassword(dto.password());
        u.setRol(dto.rol());
        return u;
    }

    public UsuarioResponseDTO entidadADTO(Usuario u) {
        return new UsuarioResponseDTO(
                u.getId(),
                u.getNombre(),
                u.getEmail(),
                u.getRol()
        );
    }

    public void actualizarEntidadDesdeDTO(Usuario u, UsuarioRequestDTO dto) {
        u.setNombre(dto.nombre());
        u.setEmail(dto.email());
        u.setPassword(dto.password());
        u.setRol(dto.rol());
    }
}

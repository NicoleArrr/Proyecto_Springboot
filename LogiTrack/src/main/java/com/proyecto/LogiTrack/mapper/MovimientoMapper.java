package com.proyecto.LogiTrack.mapper;

import com.proyecto.LogiTrack.dto.request.MovimientoRequestDTO;
import com.proyecto.LogiTrack.dto.response.Detalle_MovimientoResponseDTO;
import com.proyecto.LogiTrack.dto.response.MovimientoResponseDTO;
import com.proyecto.LogiTrack.model.Bodega;
import com.proyecto.LogiTrack.model.Movimiento;
import com.proyecto.LogiTrack.model.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MovimientoMapper{

    private final UsuarioMapper usuarioMapper;
    private final BodegaMapper bodegaMapper;
    private final ProductoMapper productoMapper;

    public Movimiento DTOAEntidad(MovimientoRequestDTO dto, Usuario encargado, Bodega origen, Bodega destino) {
        Movimiento mov = new Movimiento();
        mov.setFecha(LocalDateTime.now());
        mov.setTipo(dto.tipo());
        mov.setEncargado(encargado);
        mov.setOrigen(origen);
        mov.setDestino(destino);
        return mov;
    }

    public MovimientoResponseDTO entidadADTO(Movimiento mov, List<Detalle_MovimientoResponseDTO> Detalles) {
        return new MovimientoResponseDTO(
                mov.getId(), mov.getFecha(), mov.getTipo(),
                usuarioMapper.entidadADTO(mov.getEncargado()),
                mov.getOrigen() != null ? bodegaMapper.entidadADTO(mov.getOrigen()) : null,
                mov.getDestino() != null ? bodegaMapper.entidadADTO(mov.getDestino()) : null, Detalles
        );
    }
}

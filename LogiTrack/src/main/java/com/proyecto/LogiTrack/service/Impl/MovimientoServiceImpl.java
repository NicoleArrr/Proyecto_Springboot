package com.proyecto.LogiTrack.service.Impl;

import com.proyecto.LogiTrack.dto.request.MovimientoRequestDTO;
import com.proyecto.LogiTrack.dto.response.Detalle_MovimientoResponseDTO;
import com.proyecto.LogiTrack.dto.response.MovimientoResponseDTO;
import com.proyecto.LogiTrack.mapper.Detalle_MovimientoMapper;
import com.proyecto.LogiTrack.mapper.MovimientoMapper;
import com.proyecto.LogiTrack.model.*;
import com.proyecto.LogiTrack.repository.*;
import com.proyecto.LogiTrack.service.AuditoriaService;
import com.proyecto.LogiTrack.service.MovimientoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovimientoServiceImpl implements MovimientoService {

    private final MovimientoRepository movimientoRepository;
    private final MovimientoMapper movimientoMapper;
    private final Detalle_MovimientoMapper detalle_movimientoMapper;
    private final Detalle_MovimientoRepository detalle_movimientoRepository;
    private final BodegaProductoRepository bodegaProductoRepository;
    private final BodegaRepository bodegaRepository;
    private final ProductoRepository productoRepository;
    private final UsuarioRepository usuarioRepository;
    private final AuditoriaService auditoriaService;

    @Override
    public MovimientoResponseDTO guardarMovimiento(MovimientoRequestDTO dto) {
        Usuario encargado = usuarioRepository.findById(dto.id_usuario())
                .orElseThrow(() -> new BusinessRuleException("El usuario " + dto.id_usuario() + "encargado del movimiento no ha sido identificado"));

        Bodega origen = dto.id_Borigen() != null
                ? bodegaRepository.findById(dto.id_Borigen())
                .orElseThrow(() -> new BusinessRuleException("La bodega origen con id: " + dto.id_Borigen() + "no ha sido idenificada"))
                : null;

        Bodega destino = dto.id_Bdestino() != null
                ? bodegaRepository.findById(dto.id_Bdestino())
                .orElseThrow(() -> new BusinessRuleException("La bodega destino con id: " + dto.id_Bdestino() + "no ha sido idenificada"))
                : null;

        Movimiento movimiento = movimientoMapper.DTOAEntidad(dto, encargado, origen, destino);
        Movimiento guardado = movimientoRepository.save(movimiento);

        List<Detalle_MovimientoResponseDTO> detalles = dto.Detalles().stream().map(detalleDTO -> {

            Producto producto = productoRepository.findById(detalleDTO.id_producto())
                    .orElseThrow(() -> new BusinessRuleException("El Producto " + detalleDTO.id_producto() + " no ha sido identificado"));

            // Actualizar stock según el tipo de movimiento
            actualizarStock(dto.tipo(), origen, destino, producto, detalleDTO.cantidad());

            Detalle_Movimiento detalle = detalle_movimientoMapper.crearEntidad(guardado, producto, detalleDTO.cantidad());
            Detalle_Movimiento detalle_guardado = detalle_movimientoRepository.save(detalle);

            return detalle_movimientoMapper.entidadADTO(detalle_guardado);
    }).toList();

        return movimientoMapper.entidadADTO(guardado, detalles);
    }

    @Override
    public List<MovimientoResponseDTO> listarMovimientos() {
        return movimientoRepository.findAll()
                .stream()
                .map(mov -> movimientoMapper.entidadADTO(mov,
                        mov.getDetalles().stream()
                                .map(detalle_movimientoMapper::entidadADTO)
                                .toList()))
                .toList();
    }

    @Override
    public MovimientoResponseDTO buscarPorId(Long id) {
        Movimiento mov = movimientoRepository.findById(id)
                .orElseThrow(() -> new BusinessRuleException("El Movimiento " + id + " no ha sido identificado"));
        List<Detalle_MovimientoResponseDTO> detalles = mov.getDetalles()
                .stream()
                .map(detalle_movimientoMapper::entidadADTO)
                .toList();
        return movimientoMapper.entidadADTO(mov, detalles);
    }

    @Override
    public List<MovimientoResponseDTO> RangoDeFechas(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        return movimientoRepository.findByFechaBetween(fechaInicio, fechaFin)
                .stream()
                .map(mov -> movimientoMapper.entidadADTO(mov,
                        mov.getDetalles().stream()
                                .map(detalle_movimientoMapper::entidadADTO)
                                .toList()))
                .toList();
    }
}

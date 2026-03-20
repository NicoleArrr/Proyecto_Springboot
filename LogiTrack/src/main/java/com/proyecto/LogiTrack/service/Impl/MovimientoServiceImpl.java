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

import java.util.List;

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
                .orElseThrow(() -> new BusinessRuleException("No existe el usuario con id: " + dto.id_usuario()));

        Bodega origen = dto.id_Borigen() != null
                ? bodegaRepository.findById(dto.id_Borigen())
                .orElseThrow(() -> new BusinessRuleException("No existe la bodega origen con id: " + dto.id_Borigen()))
                : null;

        Bodega destino = dto.id_Bdestino() != null
                ? bodegaRepository.findById(dto.id_Bdestino())
                .orElseThrow(() -> new BusinessRuleException("No existe la bodega destino con id: " + dto.id_Bdestino()))
                : null;

        Movimiento movimiento = movimientoMapper.DTOAEntidad(dto, encargado, origen, destino);
        Movimiento guardado = movimientoRepository.save(movimiento);

        List<Detalle_MovimientoResponseDTO> detalles = dto.Detalles().stream().map(detalleDTO -> {

            Producto producto = productoRepository.findById(detalleDTO.id_producto())
                    .orElseThrow(() -> new BusinessRuleException("No existe el producto con id: " + detalleDTO.id_producto()));

            // Actualizar stock según el tipo de movimiento
            actualizarStock(dto.tipo(), origen, destino, producto, detalleDTO.cantidad());

            Detalle_Movimiento detalle = detalle_movimientoMapper.crearEntidad(guardado, producto, detalleDTO.cantidad());
            Detalle_Movimiento detalle_guardado = detalle_movimientoRepository.save(detalle);

            return detalle_movimientoMapper.entidadADTO(detalle_guardado);
    }

    @Override
    public List<MovimientoResponseDTO> listarMovimientos() {
        return List.of();
    }

    @Override
    public MovimientoResponseDTO buscarPorId(Long id) {
        return null;
    }

    @Override
    public List<MovimientoResponseDTO> RangoDeFechas(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        return List.of();
    }
}

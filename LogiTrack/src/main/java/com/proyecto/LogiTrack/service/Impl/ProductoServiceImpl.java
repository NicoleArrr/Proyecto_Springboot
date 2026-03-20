package com.proyecto.LogiTrack.service.Impl;

import com.proyecto.LogiTrack.dto.request.ProductoRequestDTO;
import com.proyecto.LogiTrack.dto.response.ProductoResponseDTO;
import com.proyecto.LogiTrack.mapper.ProductoMapper;
import com.proyecto.LogiTrack.model.Producto;
import com.proyecto.LogiTrack.repository.BodegaProductoRepository;
import com.proyecto.LogiTrack.repository.ProductoRepository;
import com.proyecto.LogiTrack.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {

    private ProductoRepository productoRepository;
    private ProductoMapper productoMapper;
    private BodegaProductoRepository bodegaProductoRepository;

    private Integer calcularStock(Long id_producto) {
        Integer stock = bodegaProductoRepository.sumStockByProductoId(id_producto);
        return stock != null ? stock : 0;
    }

    @Override
    public ProductoResponseDTO guardarProducto(ProductoRequestDTO dto) {
        Producto p = productoMapper.DTOAEntidad(dto);
        Producto guardado = productoRepository.save(p);
        return productoMapper.entidadADTO(guardado, calcularStock(guardado.getId()));
    }

    @Override
    public ProductoResponseDTO actualizarProducto(ProductoRequestDTO dto, Long id) {
        Producto p = productoRepository.findById(id)
                .orElseThrow(() -> new BusinessRuleException("El Producto " + id + " no ha sido identificado"));
        productoMapper.actualizarEntidadDesdeDTO(p, dto);
        Producto guardado = productoRepository.save(p);
        return productoMapper.entidadADTO(guardado, calcularStock(guardado.getId()));
    }

    @Override
    public void eliminarProducto(Long id) {
        productoRepository.findById(id)
                .orElseThrow(() -> new BusinessRuleException("El Producto " + id + " no ha sido identificado"));
        productoRepository.deleteById(id);
    }

    @Override
    public List<ProductoResponseDTO> listarProductos() {
        return productoRepository.findAll()
                .stream()
                .map(p -> productoMapper.entidadADTO(p, calcularStock(p.getId())))
                .toList();
    }

    @Override
    public ProductoResponseDTO buscarPorId(Long id) {
        Producto p = productoRepository.findById(id)
                .orElseThrow(() -> new BusinessRuleException("El Producto " + id + " no ha sido identificado"));
        return productoMapper.entidadADTO(p, calcularStock(p.getId()));
    }

    @Override
    public List<ProductoResponseDTO> productosStockBajo() {
        return bodegaProductoRepository.findProductosLessThanEqual(10)
                .stream()
                .map(p -> productoMapper.entidadADTO(p, calcularStock(p.getId())))
                .toList();
    }
}

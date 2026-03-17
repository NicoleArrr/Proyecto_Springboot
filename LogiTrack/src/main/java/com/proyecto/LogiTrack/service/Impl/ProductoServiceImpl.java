package com.proyecto.LogiTrack.service.Impl;

import com.proyecto.LogiTrack.dto.request.ProductoRequestDTO;
import com.proyecto.LogiTrack.dto.response.ProductoResponseDTO;
import com.proyecto.LogiTrack.mapper.ProductoMapper;
import com.proyecto.LogiTrack.model.Producto;
import com.proyecto.LogiTrack.model.Usuario;
import com.proyecto.LogiTrack.repository.BodegaProductoRepository;
import com.proyecto.LogiTrack.repository.ProductoRepository;
import com.proyecto.LogiTrack.service.ProductoService;

import java.util.List;

public class ProductoServiceImpl extends ProductoService {

    private final ProductoRepository productoRepository;
    private final ProductoMapper productoMapper;
    private final BodegaProductoRepository bodegaProductoRepository;

    @Override
    public ProductoResponseDTO guardarProducto(ProductoRequestDTO dto) {
        Producto p = ProductoMapper.DTOAEntidad(dto);
        Producto guardado = productoRepository.save(p);
        return productoMapper.entidadADTO(guardado, calcularStock(guardado.getId()));;
    }

    @Override
    public ProductoResponseDTO actualizarProducto(ProductoRequestDTO dto, Long id) {
        Producto p = productoRepository.findById(id)
                .orElseThrow(() -> new BusinessRuleException("El Producto " + id + " no ha sido identificado"));
        productoMapper.actualizarEntidadDesdeDTO(p, dto);
        Producto actualizado = productoRepository.save(p);
        return productoMapper.entidadADTO(actualizado, calcularStock(actualizado.getId()));
    }

    @Override
    public void eliminarProducto(Long id) {
        productoRepository.findById(id)
                .orElseThrow(() -> new BusinessRuleException("El Producto " + id + " no ha sido identificado"));
        productoRepository.deleteById(id);
    }

    @Override
    public ProductoResponseDTO buscarPorId(Long id) {
        Usuario u = usuarioRepository.findById(id)
                .orElseThrow(() -> new BusinessRuleException("El Producto " + id + " no ha sido identificado"));
        return usuarioMapper.entidadADTO(u);
    }

    @Override
    public List<ProductoResponseDTO> listarProductos() {
        return ProductoRepository.findAll()
                .stream()
                .map(productoMapper.entidadADTO)
                .toList();
    }

    @Override
    public List<ProductoResponseDTO> ProductosStockBajo(Integer stock) {
        List<Producto> p= ProductoRepository.findByStockLessThan(10);
        return p.stream().map(ProductoMapper::entidadADTO).toList();
    }
}

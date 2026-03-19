package com.proyecto.LogiTrack.service;

import com.proyecto.LogiTrack.dto.request.ProductoRequestDTO;
import com.proyecto.LogiTrack.dto.response.ProductoResponseDTO;

import java.util.List;

public interface ProductoService {
    ProductoResponseDTO guardarProducto(ProductoRequestDTO dto);
    ProductoResponseDTO actualizarProducto(ProductoRequestDTO dto, Long id);
    void eliminarProducto(Long id);
    List<ProductoResponseDTO> listarProductos();
    ProductoResponseDTO buscarPorId(Long id);
    // Consulta de Productos con stock menor a diez.
    List<ProductoResponseDTO> productosStockBajo();
}

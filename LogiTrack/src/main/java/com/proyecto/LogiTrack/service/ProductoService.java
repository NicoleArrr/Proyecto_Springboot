package com.proyecto.LogiTrack.service;

import com.proyecto.LogiTrack.dto.request.ProductoRequestDTO;
import com.proyecto.LogiTrack.dto.response.ProductoResponseDTO;

import java.util.List;

public interface ProductoService {
    ProductoResponseDTO guardarUsuario(ProductoRequestDTO dto);
    ProductoResponseDTO actualizarUsuario(ProductoRequestDTO dto, Long id);
    void eliminarUsuario(Long id);
    List<ProductoResponseDTO> listarProductos();
    ProductoResponseDTO buscarPorId(Long id);
    List<ProductoResponseDTO> consultaStockBajo();
}

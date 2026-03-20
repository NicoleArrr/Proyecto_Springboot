package com.proyecto.LogiTrack.controller;

import com.proyecto.LogiTrack.dto.request.ProductoRequestDTO;
import com.proyecto.LogiTrack.dto.response.ProductoResponseDTO;
import com.proyecto.LogiTrack.service.Impl.ProductoServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Productos", description = "Entidad encargada de representar y efectuar la gestion en los productos dentro del sistema")
@RestController
@RequestMapping("/api/Productos")
@RequiredArgsConstructor

public class GestionProducto {

    private ProductoServiceImpl productoServiceImpl;

    @PostMapping
    public ResponseEntity<ProductoResponseDTO> guardar(@Valid @RequestBody ProductoRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productoServiceImpl.guardarProducto(dto));
    }

    @GetMapping
    public ResponseEntity<List<ProductoResponseDTO>> listarProductos() {
        return ResponseEntity.ok(productoServiceImpl.listarProductos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(productoServiceImpl.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoResponseDTO> actualizar(@Valid @RequestBody ProductoRequestDTO dto, @PathVariable Long id) {
        return ResponseEntity.ok(productoServiceImpl.actualizarProducto(dto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        productoServiceImpl.eliminarProducto(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/stock-bajo")
    public ResponseEntity<List<ProductoResponseDTO>> listarStockBajo() {
        return ResponseEntity.ok(productoServiceImpl.productosStockBajo());
    }
}

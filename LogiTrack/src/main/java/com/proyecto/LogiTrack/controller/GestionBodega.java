package com.proyecto.LogiTrack.controller;


import com.proyecto.LogiTrack.dto.request.BodegaRequestDTO;
import com.proyecto.LogiTrack.dto.response.BodegaResponseDTO;
import com.proyecto.LogiTrack.service.Impl.BodegaServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Bodegas", description = "Entidad encargada de representar y efectuar la gestion en las bodegas dentro del sistema")
@RestController
@RequestMapping("/api/Bodegas")
@RequiredArgsConstructor
public class GestionBodega {
    private final BodegaServiceImpl bodegaServiceImpl;

    @PostMapping
    public ResponseEntity<BodegaResponseDTO> guardar(@Valid @RequestBody BodegaRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bodegaServiceImpl.guardarBodega(dto));
    }

    @GetMapping
    public ResponseEntity<List<BodegaResponseDTO>> listarBodegas() {
        return ResponseEntity.ok(bodegaServiceImpl.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BodegaResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(bodegaServiceImpl.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BodegaResponseDTO> actualizar(@Valid @RequestBody BodegaRequestDTO dto, @PathVariable Long id) {
        return ResponseEntity.ok(bodegaServiceImpl.actualizarBodega(dto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        bodegaServiceImpl.eliminarBodega(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

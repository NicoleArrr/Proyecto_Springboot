package com.proyecto.LogiTrack.controller;

import com.proyecto.LogiTrack.dto.response.ProductoResponseDTO;
import com.proyecto.LogiTrack.service.Impl.MovimientoServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@Tag(name = "Reportes", description = "Entidad encargada de representar y efectuar un historial de movimientos dentro del sistema")
@RestController
@RequestMapping("/api/Bodegas")
@RequiredArgsConstructor
public class ReporteController {
    private MovimientoServiceImpl movimientoServiceImpl;

    @GetMapping("{/reportes/movimientos}")
    public ResponseEntity<List<ProductoResponseDTO>> UltimosMovimientos() {
        return ResponseEntity.ok(movimientoServiceImpl.ultimosMovimientos()(LocalDateTime fecha));
    }


}

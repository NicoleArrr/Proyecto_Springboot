package com.proyecto.LogiTrack.mapper;

import com.proyecto.LogiTrack.dto.response.Detalle_MovimientoResponseDTO;
import com.proyecto.LogiTrack.model.Detalle_Movimiento;
import com.proyecto.LogiTrack.model.Movimiento;
import com.proyecto.LogiTrack.model.Producto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Detalle_MovimientoMapper {

    private final ProductoMapper productoMapper;

    public Detalle_Movimiento crearEntidad(Movimiento movimiento, Producto producto, Integer cantidad) {
        Detalle_Movimiento detmov = new Detalle_Movimiento();
        detmov.setMovimiento(movimiento);
        detmov.setProducto(producto);
        detmov.setCantidad(cantidad);
        return detmov;
    }

    public Detalle_MovimientoResponseDTO entidadADTO(Detalle_Movimiento detmov) {
        return new Detalle_MovimientoResponseDTO(
                detmov.getId(),
                productoMapper.entidadADTO(detmov.getProducto()), // productoMapper.entidadADTO(detmov.getProducto(),0),
                detmov.getCantidad()
        );
    }
}

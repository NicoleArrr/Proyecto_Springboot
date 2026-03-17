package com.proyecto.LogiTrack.repository;

import com.proyecto.LogiTrack.model.Detalle_Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Detalle_MovimientoRepository extends JpaRepository<Detalle_Movimiento, Long> {
    @Query("SELECT dm.producto.nombre, SUM(dm.cantidad) as total FROM DetalleMovimiento dm GROUP BY dm.producto ORDER BY total DESC")
    List<Object[]> productosMasMovidos();
}

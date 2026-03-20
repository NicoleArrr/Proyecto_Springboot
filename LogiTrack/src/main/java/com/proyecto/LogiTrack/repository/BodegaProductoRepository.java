package com.proyecto.LogiTrack.repository;

import com.proyecto.LogiTrack.model.BodegaProducto;
import com.proyecto.LogiTrack.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BodegaProductoRepository extends JpaRepository<BodegaProducto, Long> {
    @Query("SELECT bp.producto FROM BodegaProducto bp GROUP BY bp.producto HAVING SUM(bp.stock) < :stock")
    List<Producto> findProductosLessThanEqual(@Param("stock") Integer stock);
    Integer sumStockByProductoId(Long id_producto);
}

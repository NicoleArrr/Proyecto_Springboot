package com.proyecto.LogiTrack.mapper;

import com.proyecto.LogiTrack.dto.request.ProductoRequestDTO;
import com.proyecto.LogiTrack.dto.response.ProductoResponseDTO;
import com.proyecto.LogiTrack.model.Producto;
import org.springframework.stereotype.Component;

@Component
public class ProductoMapper {
    public Producto DTOAEntidad(ProductoRequestDTO dto) {
        Producto p = new Producto();
        p.setNombre(dto.nombre());
        p.setCategoria(dto.categoria());
        p.setPrecio(dto.precio());
        return p;
    }

    public ProductoResponseDTO entidadADTO(Producto p) {
        return new ProductoResponseDTO(
                p.getId(),
                p.getNombre(),
                p.getCategoria(),
                p.getPrecio()
                // stock
        );
    }

    public void actualizarEntidadDesdeDTO(Producto p, ProductoRequestDTO dto) {
        p.setNombre(dto.nombre());
        p.setCategoria(dto.categoria());
        p.setPrecio(dto.precio());
    }
}

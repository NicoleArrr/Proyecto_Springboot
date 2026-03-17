package com.proyecto.LogiTrack.repository;

import com.proyecto.LogiTrack.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Producto, Long> {

}

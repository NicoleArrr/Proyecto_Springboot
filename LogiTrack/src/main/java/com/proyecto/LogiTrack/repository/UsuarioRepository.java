package com.proyecto.LogiTrack.repository;

import com.proyecto.LogiTrack.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}

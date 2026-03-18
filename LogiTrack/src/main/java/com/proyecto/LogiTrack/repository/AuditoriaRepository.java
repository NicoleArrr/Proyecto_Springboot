package com.proyecto.LogiTrack.repository;

import com.proyecto.LogiTrack.model.Auditoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.List;

public interface AuditoriaRepository extends JpaRepository<Auditoria, Long> {
    List<Auditoria> findByFechaBetween(Timestamp fechaInicio, Timestamp fechaFin);
}

package com.proyecto.LogiTrack.controller;

import com.proyecto.LogiTrack.dto.request.UsuarioRequestDTO;
import com.proyecto.LogiTrack.dto.response.UsuarioResponseDTO;
import com.proyecto.LogiTrack.service.Impl.UsuarioServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Usuarios", description = "Entidad encargada de representar y efectuar la gestion en los usuarios dentro del sistema")
@RestController
@RequestMapping("/api/Users")
@RequiredArgsConstructor
public class GestionUsuario {

        private final UsuarioServiceImpl usuarioServiceImpl;

        @PostMapping
        public ResponseEntity<UsuarioResponseDTO> guardar(@Valid @RequestBody UsuarioRequestDTO dto) {
            return ResponseEntity.status(HttpStatus.CREATED).body(usuarioServiceImpl.guardarUsuario(dto));
        }

        @GetMapping
        public ResponseEntity<List<UsuarioResponseDTO>> mostrar() {
            return ResponseEntity.ok(usuarioServiceImpl.listarUsuarios());
        }

        @GetMapping("/{id}")
        public ResponseEntity<UsuarioResponseDTO> buscarPorId(@PathVariable Long id) {
            return ResponseEntity.ok(usuarioServiceImpl.buscarPorId(id));
        }

        @PutMapping("/{id}")
        public ResponseEntity<UsuarioResponseDTO> actualizar(@Valid @RequestBody UsuarioRequestDTO dto, Long id) {
            return ResponseEntity.ok(usuarioServiceImpl.actualizarUsuario(dto, id));
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> eliminar(@PathVariable Long id) {
            usuarioServiceImpl.eliminarUsuario(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
}
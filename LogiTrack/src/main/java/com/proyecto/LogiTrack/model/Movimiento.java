package com.proyecto.LogiTrack.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "Movimiento")
@Getter
@Setter
@AllArgsConstructor @NoArgsConstructor
public class Movimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false)
    private LocalDateTime fecha;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Tipo tipo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuario encargado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_Borigen")
    private Bodega origen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_Bdestino")
    private Bodega destino;

    @OneToMany(mappedBy = "Movimiento",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<DetalleMovimiento> detalles;
}

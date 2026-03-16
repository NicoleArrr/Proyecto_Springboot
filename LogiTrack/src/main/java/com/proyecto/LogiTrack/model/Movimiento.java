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


    private LocalDateTime fecha;

    @Enumerated(EnumType.STRING)

    private Tipo tipo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_Usuario")
    private Usuario encargado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_Borigen")
    private Bodega origen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_Bdestino")
    private Bodega destino;

}

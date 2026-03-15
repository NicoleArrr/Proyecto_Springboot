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



    private Tipo tipo;


    private Usuario encargado;


    private Bodega origen;


    private Bodega destino;


    
}

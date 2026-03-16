package com.proyecto.LogiTrack.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Detalle_movimiento")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Detalle_Movimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_Movimiento")
    private Movimiento movimiento;


    private Producto producto;


    private Integer cantidad;
}

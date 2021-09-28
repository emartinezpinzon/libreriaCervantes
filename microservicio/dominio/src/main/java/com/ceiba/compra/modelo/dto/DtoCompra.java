package com.ceiba.compra.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class DtoCompra {
    private Long id;
    private Long libroId;
    private int cantidad;
    private LocalDate fechaEntrega;

    private String titulo;
    private String categoria;
    private String distribucion;
    private int disponibles;
    private double precio;

}

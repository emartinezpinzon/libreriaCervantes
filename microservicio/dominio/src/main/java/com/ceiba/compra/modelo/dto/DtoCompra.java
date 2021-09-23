package com.ceiba.compra.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoCompra {
    private Long id;
    private Long libroId;
    private int cantidad;

    private String titulo;
    private String categoria;
    private String distribucion;
    private int disponibles;
    private double precio;

}

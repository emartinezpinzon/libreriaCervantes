package com.ceiba.libro.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoLibro {
    private Long id;
    private String titulo;
    private String categoria;
    private String distribucion;
    private int disponibles;
    private double precio;

}

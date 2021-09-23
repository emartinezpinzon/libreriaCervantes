package com.ceiba.compra.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class DtoCompra {
    private Long id;
    private Long libroId;
    private int cantidad;
    private LocalDate fechaCompra;
    private LocalDate fechaEntrega;

}

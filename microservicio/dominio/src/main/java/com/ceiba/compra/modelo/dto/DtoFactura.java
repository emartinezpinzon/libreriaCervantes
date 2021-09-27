package com.ceiba.compra.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class DtoFactura {
    private Long id;
    private double precioFinal;
    private LocalDate fechaCompra;
}

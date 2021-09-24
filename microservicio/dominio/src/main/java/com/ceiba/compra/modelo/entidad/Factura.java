package com.ceiba.compra.modelo.entidad;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Factura {

    private Long id;
    private double precioFinal;
    private LocalDate fechaCompra;

    public Factura(Long id, double precioFinal) {
        this.id = id;
        this.precioFinal = precioFinal;
        this.fechaCompra = LocalDate.now();
    }
}

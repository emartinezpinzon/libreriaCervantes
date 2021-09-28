package com.ceiba.compra.modelo.entidad;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Factura {

    private Long id;
    private double precioFinal;
    private LocalDate fechaCompra;

    public Factura(Long id, double precioFinal, LocalDate fechaCompra) {
        this.id = id;
        this.precioFinal = precioFinal;
        this.fechaCompra = fechaCompra;
    }
}

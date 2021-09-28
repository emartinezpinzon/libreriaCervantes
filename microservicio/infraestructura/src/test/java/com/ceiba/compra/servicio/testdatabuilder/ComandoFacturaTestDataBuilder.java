package com.ceiba.compra.servicio.testdatabuilder;

import com.ceiba.compra.comando.ComandoFactura;

import java.time.LocalDate;

public class ComandoFacturaTestDataBuilder {

    private Long id;
    private double precioFinal;
    private LocalDate fechaCompra;

    public ComandoFacturaTestDataBuilder() {
    }

    public ComandoFactura build() {
        return new ComandoFactura(id, precioFinal, fechaCompra);
    }
}

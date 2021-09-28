package com.ceiba.compra.servicio.testdatabuilder;

import com.ceiba.compra.modelo.entidad.Factura;

import java.time.LocalDate;

public class FacturaTestDataBuilder {
    private Long id;
    private double precioFinal;
    private LocalDate fechaCompra;

    public FacturaTestDataBuilder() {
    }

    public Factura build() {
        return new Factura(id, precioFinal, fechaCompra);
    }
}

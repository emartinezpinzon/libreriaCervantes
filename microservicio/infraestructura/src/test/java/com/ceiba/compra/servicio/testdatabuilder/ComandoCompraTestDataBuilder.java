package com.ceiba.compra.servicio.testdatabuilder;

import com.ceiba.compra.comando.ComandoCompra;

public class ComandoCompraTestDataBuilder {

    private Long id;
    private Long libroId;
    private int cantidad;

    public ComandoCompraTestDataBuilder() {
        libroId = 1L;
        cantidad = 1;
    }

    public ComandoCompraTestDataBuilder conCantidadCero() {
        this.cantidad = 0;

        return this;
    }

    public ComandoCompra build() {
        return new ComandoCompra(id, libroId, cantidad);
    }
}

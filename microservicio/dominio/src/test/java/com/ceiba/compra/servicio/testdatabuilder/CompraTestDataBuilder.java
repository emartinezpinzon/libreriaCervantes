package com.ceiba.compra.servicio.testdatabuilder;

import com.ceiba.compra.modelo.entidad.Compra;

import java.time.LocalDate;

public class CompraTestDataBuilder {

    private Long id;
    private Long libroId;
    private int cantidad;
    private LocalDate fechaEntrega;

    public CompraTestDataBuilder() {
        libroId = 1L;
        cantidad = 3;
    }

    public CompraTestDataBuilder conId(Long id) {
        this.id = id;

        return this;
    }

    public CompraTestDataBuilder sinLibroId() {
        this.libroId = null;

        return this;
    }

    public CompraTestDataBuilder conCantidadCero() {
        this.cantidad = 0;

        return this;
    }

    public Compra build() {
        return new Compra(id, libroId, cantidad, fechaEntrega);
    }
}

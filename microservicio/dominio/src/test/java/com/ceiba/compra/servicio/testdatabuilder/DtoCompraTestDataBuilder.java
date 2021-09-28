package com.ceiba.compra.servicio.testdatabuilder;

import com.ceiba.compra.modelo.dto.DtoCompra;

import java.time.LocalDate;
import java.util.UUID;

public class DtoCompraTestDataBuilder {
    private Long id;
    private Long libroId;
    private int cantidad;
    private LocalDate fechaEntrega;

    private String titulo;
    private String categoria;
    private String distribucion;
    private int disponibles;
    private double precio;

    public DtoCompraTestDataBuilder() {
        libroId = 1L;
        cantidad = 3;
        fechaEntrega = LocalDate.now();
        titulo = UUID.randomUUID().toString();
        categoria = UUID.randomUUID().toString();
        distribucion = UUID.randomUUID().toString();
        disponibles = 3;
        precio = 100000D;
    }

    public DtoCompra build() {
        return new DtoCompra(id, libroId, cantidad, fechaEntrega, titulo, categoria, distribucion, disponibles, precio);
    }
}

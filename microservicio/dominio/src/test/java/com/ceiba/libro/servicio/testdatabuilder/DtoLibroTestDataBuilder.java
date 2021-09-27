package com.ceiba.libro.servicio.testdatabuilder;

import com.ceiba.libro.modelo.dto.DtoLibro;

import java.util.UUID;

public class DtoLibroTestDataBuilder {
    private Long id;
    private String titulo;
    private String categoria;
    private String distribucion;
    private int disponibles;
    private double precio;

    public DtoLibroTestDataBuilder() {
        titulo = UUID.randomUUID().toString();
        categoria = UUID.randomUUID().toString();
        distribucion = UUID.randomUUID().toString();
        disponibles = 3;
        precio = 45000D;
    }

    public DtoLibro build() {
        return new DtoLibro(id, titulo, categoria, distribucion, disponibles, precio);
    }
}

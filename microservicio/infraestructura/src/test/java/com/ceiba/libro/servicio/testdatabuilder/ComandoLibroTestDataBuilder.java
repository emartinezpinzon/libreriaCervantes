package com.ceiba.libro.servicio.testdatabuilder;

import com.ceiba.libro.comando.ComandoLibro;

import java.util.UUID;

public class ComandoLibroTestDataBuilder {

    private Long id;
    private String titulo;
    private String categoria;
    private String distribucion;
    private int disponibles;
    private double precio;

    public ComandoLibroTestDataBuilder() {
        titulo = UUID.randomUUID().toString();
        categoria = "Literatura";
        distribucion = "Internacional";
        disponibles = 3;
        precio = 45000;
    }

    public ComandoLibroTestDataBuilder conTitulo(String titulo) {
        this.titulo = titulo;

        return this;
    }

    public ComandoLibro build() {
        return new ComandoLibro(id, titulo, categoria, distribucion, disponibles, precio);
    }
}

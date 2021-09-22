package com.ceiba.libro.servicio.testdatabuilder;

import com.ceiba.libro.modelo.entidad.Libro;

public class LibroTestDataBuilder {

    private Long id;
    private String titulo;
    private String categoria;
    private String distribucion;
    private int disponibles;
    private double precio;

    public LibroTestDataBuilder() {
        titulo = "Ficciones";
        categoria = "Literatura";
        distribucion = "Internacional";
        disponibles = 3;
        precio = 45000;
    }

    public LibroTestDataBuilder conId(Long id) {
        this.id = id;

        return this;
    }

    public Libro build() {
        return new Libro(id, titulo, categoria, distribucion, disponibles, precio);
    }
}

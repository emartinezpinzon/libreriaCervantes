package com.ceiba.compra.modelo.entidad;

import com.ceiba.libro.modelo.entidad.Libro;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Compra {
    private List<Libro> libros;

    public Compra() {
        this.libros = new ArrayList<>();
    }
}

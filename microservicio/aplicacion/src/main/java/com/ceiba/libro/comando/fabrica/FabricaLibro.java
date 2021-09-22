package com.ceiba.libro.comando.fabrica;

import com.ceiba.libro.comando.ComandoLibro;
import com.ceiba.libro.modelo.entidad.Libro;

public class FabricaLibro {
    public Libro crear(ComandoLibro comandoLibro) {
        return new Libro(
                comandoLibro.getId(),
                comandoLibro.getTitulo(),
                comandoLibro.getCategoria(),
                comandoLibro.getDistribucion(),
                comandoLibro.getDisponibles(),
                comandoLibro.getPrecio()
        );
    }
}

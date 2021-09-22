package com.ceiba.compra.servicio;

import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.libro.modelo.entidad.Libro;

public class ServicioActualizarCompra {

    private final RepositorioCompra repositorioCompra;

    public ServicioActualizarCompra(RepositorioCompra repositorioCompra) {
        this.repositorioCompra = repositorioCompra;
    }

    /**
     * Ejecuta la incorporación de un libro a la lista de compra
     *
     * @param libro
     */
    public void ejecutar(Libro libro) {
        this.repositorioCompra.agregar(libro);
    }
}

package com.ceiba.compra.puerto.repositorio;

import com.ceiba.libro.modelo.entidad.Libro;

public interface RepositorioCompra {
    /**
     * Permite agregar un libro a la lista de compras
     *
     * @param libro
     */
    void agregar(Libro libro);
}

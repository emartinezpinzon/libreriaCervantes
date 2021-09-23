package com.ceiba.compra.puerto.repositorio;

import com.ceiba.compra.modelo.entidad.Compra;

public interface RepositorioCompra {
    /**
     * Permite agregar un libro a la lista de compras
     *
     * @param compra
     */
    Long crear(Compra compra);
}

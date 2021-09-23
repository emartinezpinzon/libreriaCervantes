package com.ceiba.compra.puerto.repositorio;

import com.ceiba.compra.modelo.entidad.Compra;

public interface RepositorioCompra {
    /**
     * Permite agregar un libro a la lista de compras
     *
     * @param compra
     * @return el id generado
     */
    Long crear(Compra compra);
}

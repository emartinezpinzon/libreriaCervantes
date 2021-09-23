package com.ceiba.compra.servicio;

import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;

public class ServicioActualizarCompra {

    private final RepositorioCompra repositorioCompra;

    public ServicioActualizarCompra(RepositorioCompra repositorioCompra) {
        this.repositorioCompra = repositorioCompra;
    }

    /**
     * Ejecuta la actualización de una compra
     *
     * @param compra
     */
    public void ejecutar(Compra compra) {
        this.repositorioCompra.actualizar(compra);
    }
}

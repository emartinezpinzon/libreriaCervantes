package com.ceiba.compra.puerto.repositorio;

import com.ceiba.compra.modelo.entidad.Factura;

public interface RepositorioFactura {
    /**
     * Permite agregar una factura
     *
     * @param factura
     * @return el id generado
     */
    Long crear(Factura factura);
}

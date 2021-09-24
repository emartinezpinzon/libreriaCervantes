package com.ceiba.compra.servicio;

import com.ceiba.compra.modelo.entidad.Factura;
import com.ceiba.compra.puerto.repositorio.RepositorioFactura;

public class ServicioCrearFactura {

    private final RepositorioFactura repositorioFactura;

    public ServicioCrearFactura(RepositorioFactura repositorioFactura) {
        this.repositorioFactura = repositorioFactura;
    }

    /**
     * Crea una nueva factura
     *
     * @param factura
     * @return el id de la fa
     */
    public Long ejecutar(Factura factura) {
        return this.repositorioFactura.crear(factura);
    }
}

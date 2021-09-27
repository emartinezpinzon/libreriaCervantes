package com.ceiba.compra.servicio;

import com.ceiba.compra.modelo.entidad.Factura;
import com.ceiba.compra.puerto.dao.DaoCompra;
import com.ceiba.compra.puerto.repositorio.RepositorioFactura;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;

public class ServicioCrearFactura {

    private static final String COMPRAS_NO_REGISTRADAS = "No hay compras registradas";

    private final RepositorioFactura repositorioFactura;
    private final DaoCompra daoCompra;

    public ServicioCrearFactura(RepositorioFactura repositorioFactura,
                                DaoCompra daoCompra) {
        this.repositorioFactura = repositorioFactura;
        this.daoCompra = daoCompra;
    }

    public Long ejecutar(Factura factura) {
        validarExistenciaLibrosEnCompra();

        return this.repositorioFactura.crear(factura);
    }

    private void validarExistenciaLibrosEnCompra() {
        int compras = daoCompra.listar().size();

        if (compras == 0)
            throw new ExcepcionSinDatos(COMPRAS_NO_REGISTRADAS);
    }
}

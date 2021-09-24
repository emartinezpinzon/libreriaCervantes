package com.ceiba.compra.servicio;

import com.ceiba.compra.puerto.dao.DaoCompra;

public class ServicioCalcularFechaEnvioCompra {

    private static final String DISTRIBUCION_NACIONAL = "Nacional";
    private static final String DISTRIBUCION_INTERNACIONAL = "Internacional";

    private final DaoCompra daoCompra;

    public ServicioCalcularFechaEnvioCompra(DaoCompra daoCompra) {
        this.daoCompra = daoCompra;
    }
}

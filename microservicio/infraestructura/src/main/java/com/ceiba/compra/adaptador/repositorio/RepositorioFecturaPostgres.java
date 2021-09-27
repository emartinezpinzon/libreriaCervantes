package com.ceiba.compra.adaptador.repositorio;

import com.ceiba.compra.modelo.entidad.Factura;
import com.ceiba.compra.puerto.repositorio.RepositorioFactura;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;

public class RepositorioFecturaPostgres implements RepositorioFactura {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "factura", value = "crear")
    private static String sqlCrear;

    public RepositorioFecturaPostgres(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Factura factura) {
        return this.customNamedParameterJdbcTemplate.crear(factura, sqlCrear);
    }
}

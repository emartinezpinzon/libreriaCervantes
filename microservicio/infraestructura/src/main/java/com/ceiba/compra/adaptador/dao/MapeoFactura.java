package com.ceiba.compra.adaptador.dao;

import com.ceiba.compra.modelo.dto.DtoFactura;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class MapeoFactura implements RowMapper<DtoFactura>, MapperResult {

    @Override
    public DtoFactura mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong("id");
        double precioFinal = resultSet.getDouble("precioFinal");
        LocalDate fechaCompra = extraerLocalDate(resultSet, "fechaCompra");

        return new DtoFactura(id, precioFinal, fechaCompra);
    }
}

package com.ceiba.compra.adaptador.dao;

import com.ceiba.compra.modelo.dto.DtoCompra;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class MapeoCompra implements RowMapper<DtoCompra>, MapperResult {

    @Override
    public DtoCompra mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong("id");
        Long libroId = resultSet.getLong("libroId");
        int cantidad = resultSet.getInt("cantidad");

        String titulo = resultSet.getString("titulo");
        String categoria = resultSet.getString("categoria");
        String distribucion = resultSet.getString("distribucion");
        int disponibles = resultSet.getInt("disponibles");
        double precio = resultSet.getDouble("precio");

        return new DtoCompra(id, libroId, cantidad, titulo, categoria, distribucion, disponibles, precio);
    }
}

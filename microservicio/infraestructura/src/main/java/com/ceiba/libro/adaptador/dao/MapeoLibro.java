package com.ceiba.libro.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.libro.modelo.dto.DtoLibro;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoLibro implements RowMapper<DtoLibro>, MapperResult {

    @Override
    public DtoLibro mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong("id");
        String titulo = resultSet.getString("titulo");
        String categoria = resultSet.getString("categoria");
        String distribucion = resultSet.getString("distribucion");
        int disponibles = resultSet.getInt("disponibles");
        double precio = resultSet.getDouble("precio");

        return new DtoLibro(id, titulo, categoria, distribucion, disponibles, precio);
    }
}

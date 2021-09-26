package com.ceiba.libro.adaptador.dao;

import com.ceiba.compra.adaptador.dao.MapeoCompra;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.libro.modelo.dto.DtoLibro;
import com.ceiba.libro.puerto.dao.DaoLibro;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DaoLibroPostgres implements DaoLibro {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "libro", value = "listar")
    private static String sqlListar;

    @SqlStatement(namespace = "libro", value = "buscaId")
    private static String sqlBuscarId;

    public DaoLibroPostgres(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoLibro> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoLibro());
    }

    @Override
    public DtoLibro buscarPorId(Long id) {
        Map<String,Object> parametros = new HashMap<>();
        parametros.put("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlBuscarId, parametros, new MapeoLibro());
    }
}

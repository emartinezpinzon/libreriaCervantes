package com.ceiba.libro.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.libro.modelo.entidad.Libro;
import com.ceiba.libro.puerto.repositorio.RepositorioLibro;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioLibroPostgres implements RepositorioLibro {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "libro", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "libro", value = "actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace = "libro", value = "existe")
    private static String sqlExiste;

    @SqlStatement(namespace = "libro", value = "existeTitulo")
    private static String sqlExisteTitulo;

    @SqlStatement(namespace = "libro", value = "existeExcluyendoId")
    private static String sqlExisteExcluyendoId;

    public RepositorioLibroPostgres(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Libro libro) {
        return this.customNamedParameterJdbcTemplate.crear(libro, sqlCrear);
    }

    @Override
    public void actualizar(Libro libro) {
        this.customNamedParameterJdbcTemplate.actualizar(libro, sqlActualizar);
    }

    @Override
    public boolean existe(String titulo) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("titulo", titulo);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteTitulo, parameterSource, Boolean.class);
    }

    @Override
    public boolean existe(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste, parameterSource, Boolean.class);
    }

    @Override
    public boolean existeExcluyendoId(Long id, String titulo) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        parameterSource.addValue("titulo", titulo);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteExcluyendoId, parameterSource, Boolean.class);
    }
}

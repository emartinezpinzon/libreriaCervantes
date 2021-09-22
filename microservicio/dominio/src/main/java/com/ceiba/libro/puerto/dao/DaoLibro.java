package com.ceiba.libro.puerto.dao;

import com.ceiba.libro.modelo.dto.DtoLibro;

import java.util.List;

public interface DaoLibro {
    /**
     * Permite listar libros
     *
     * @return un listado de libros
     */
    List<DtoLibro> listar();
}

package com.ceiba.libro.puerto.dao;

import com.ceiba.libro.modelo.dto.DtoLibro;

import java.util.List;

public interface DaoLibro {
    /**
     * Permite listar libros de la lista de compras
     *
     * @return un listado de libros
     */
    List<DtoLibro> listar();

    /**
     * Permite buscar un libro por su id
     *
     * @param id
     * @return un objeto DtoLibro con la información encontrada
     */
    DtoLibro buscarPorId(Long id);
}

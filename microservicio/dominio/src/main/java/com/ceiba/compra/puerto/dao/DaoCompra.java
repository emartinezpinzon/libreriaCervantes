package com.ceiba.compra.puerto.dao;

import com.ceiba.libro.modelo.dto.DtoLibro;

import java.util.List;

public interface DaoCompra {
    /**
     * Permite listar los libros agregados a la compra
     *
     * @return un listado de libros
     */
    List<DtoLibro> listar();
}

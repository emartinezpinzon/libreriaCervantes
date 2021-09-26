package com.ceiba.compra.puerto.dao;

import com.ceiba.compra.modelo.dto.DtoCompra;

import java.util.List;

public interface DaoCompra {
    /**
     * Permite listar toda la compra registrada
     *
     * @return un listado de libros
     */
    List<DtoCompra> listar();

    /**
     * Permite buscar una compra por Id
     *
     * @param id
     * @return
     */
    DtoCompra buscarPorId(Long id);
}

package com.ceiba.compra.puerto.dao;

import com.ceiba.compra.modelo.dto.DtoFactura;

import java.util.List;

public interface DaoFactura {
    /**
     * Permite listar todas las facturas
     *
     * @return una lista de facturas
     */
    List<DtoFactura> listar();

    /**
     * Permite buscar una factura por su ID
     *
     * @param id
     * @return un objeto de factura
     */
    DtoFactura buscarPorId(Long id);
}

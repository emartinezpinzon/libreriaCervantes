package com.ceiba.compra.consulta;

import com.ceiba.compra.modelo.dto.DtoCompra;
import com.ceiba.compra.puerto.dao.DaoCompra;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListaCompra {

    private final DaoCompra daoCompra;

    public ManejadorListaCompra(DaoCompra daoCompra) {
        this.daoCompra = daoCompra;
    }

    public List<DtoCompra> ejecutar() {
        return this.daoCompra.listar();
    }
}

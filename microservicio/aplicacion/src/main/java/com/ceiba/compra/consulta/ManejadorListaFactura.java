package com.ceiba.compra.consulta;

import com.ceiba.compra.modelo.dto.DtoFactura;
import com.ceiba.compra.puerto.dao.DaoFactura;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListaFactura {

    private final DaoFactura daoFactura;

    public ManejadorListaFactura(DaoFactura daoFactura) {
        this.daoFactura = daoFactura;
    }

    public List<DtoFactura> ejecutar() {
        return this.daoFactura.listar();
    }
}

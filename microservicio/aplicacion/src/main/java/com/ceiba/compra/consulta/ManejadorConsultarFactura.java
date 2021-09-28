package com.ceiba.compra.consulta;

import com.ceiba.compra.modelo.dto.DtoFactura;
import com.ceiba.compra.puerto.dao.DaoFactura;
import org.springframework.stereotype.Component;

@Component
public class ManejadorConsultarFactura {

    private final DaoFactura daoFactura;

    public ManejadorConsultarFactura(DaoFactura daoFactura) {
        this.daoFactura = daoFactura;
    }

    public DtoFactura ejecutar(Long id) {
        return this.daoFactura.buscarPorId(id);
    }
}

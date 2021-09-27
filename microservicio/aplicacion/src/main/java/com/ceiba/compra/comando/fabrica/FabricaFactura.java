package com.ceiba.compra.comando.fabrica;

import com.ceiba.compra.comando.ComandoFactura;
import com.ceiba.compra.modelo.entidad.Factura;
import org.springframework.stereotype.Component;

@Component
public class FabricaFactura {

    public Factura crear(ComandoFactura comandoFactura) {
        return new Factura(
                comandoFactura.getId(),
                comandoFactura.getPrecioFinal(),
                comandoFactura.getFechaCompra()
        );
    }
}

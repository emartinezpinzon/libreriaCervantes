package com.ceiba.compra.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.compra.comando.ComandoFactura;
import com.ceiba.compra.comando.fabrica.FabricaFactura;
import com.ceiba.compra.modelo.entidad.Factura;
import com.ceiba.compra.servicio.ServicioCrearFactura;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearFactura implements ManejadorComandoRespuesta<ComandoFactura, ComandoRespuesta<Long>> {

    private final FabricaFactura fabricaFactura;
    private final ServicioCrearFactura servicioCrearFactura;

    public ManejadorCrearFactura(FabricaFactura fabricaFactura,
                                 ServicioCrearFactura servicioCrearFactura) {
        this.fabricaFactura = fabricaFactura;
        this.servicioCrearFactura = servicioCrearFactura;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoFactura comando) {
        Factura factura = fabricaFactura.crear(comando);

        return new ComandoRespuesta<>(servicioCrearFactura.ejecutar(factura));
    }
}

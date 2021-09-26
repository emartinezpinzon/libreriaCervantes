package com.ceiba.compra.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.compra.comando.ComandoCompra;
import com.ceiba.compra.comando.fabrica.FabricaCompra;
import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.servicio.ServicioCrearCompra;
import com.ceiba.libro.puerto.dao.DaoLibro;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearCompra implements ManejadorComandoRespuesta<ComandoCompra, ComandoRespuesta<Long>> {
    private final DaoLibro daoLibro;
    private final FabricaCompra fabricaCompra;
    private final ServicioCrearCompra servicioCrearCompra;

    public ManejadorCrearCompra(DaoLibro daoLibro,
                                FabricaCompra fabricaCompra,
                                ServicioCrearCompra servicioCrearCompra) {
        this.daoLibro = daoLibro;
        this.fabricaCompra = fabricaCompra;
        this.servicioCrearCompra = servicioCrearCompra;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoCompra comando) {
        Compra compra = fabricaCompra.crear(comando);

        return new ComandoRespuesta<>(servicioCrearCompra.ejecutar(compra));
    }
}

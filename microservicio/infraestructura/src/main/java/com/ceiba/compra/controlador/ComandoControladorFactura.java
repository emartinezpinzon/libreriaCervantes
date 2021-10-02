package com.ceiba.compra.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.compra.comando.ComandoFactura;
import com.ceiba.compra.comando.manejador.ManejadorCrearFactura;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/factura")
@Api(tags = {"Modificar la información disponible de facturas"})
public class ComandoControladorFactura {

    private final ManejadorCrearFactura manejadorCrearFactura;

    @Autowired
    public ComandoControladorFactura(ManejadorCrearFactura manejadorCrearFactura) {
        this.manejadorCrearFactura = manejadorCrearFactura;
    }

    @PostMapping
    @ApiOperation("Crear una nueva factura")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoFactura comandoFactura) {
        return manejadorCrearFactura.ejecutar(comandoFactura);
    }
}

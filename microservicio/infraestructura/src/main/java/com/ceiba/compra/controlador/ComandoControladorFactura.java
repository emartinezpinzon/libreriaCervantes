package com.ceiba.compra.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.compra.comando.ComandoFactura;
import com.ceiba.compra.comando.manejador.ManejadorCrearFactura;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/factura")
@Api(tags = {"Controlador comando factura"})
public class ComandoControladorFactura {

    private final ManejadorCrearFactura manejadorCrearFactura;

    @Autowired
    public ComandoControladorFactura(ManejadorCrearFactura manejadorCrearFactura) {
        this.manejadorCrearFactura = manejadorCrearFactura;
    }

    @PostMapping
    @ApiOperation("Crear factura")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoFactura comandoFactura) {
        return manejadorCrearFactura.ejecutar(comandoFactura);
    }
}

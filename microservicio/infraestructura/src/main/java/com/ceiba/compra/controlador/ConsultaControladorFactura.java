package com.ceiba.compra.controlador;

import com.ceiba.compra.consulta.ManejadorListaFactura;
import com.ceiba.compra.modelo.dto.DtoFactura;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/factura")
@Api(tags = {"Consultar la información de factura"})
public class ConsultaControladorFactura {

    private final ManejadorListaFactura manejadorListaFactura;

    public ConsultaControladorFactura(ManejadorListaFactura manejadorListaFactura) {
        this.manejadorListaFactura = manejadorListaFactura;
    }

    @GetMapping
    @ApiOperation("Lista todas las facturas registradas")
    public List<DtoFactura> listar() {
        return this.manejadorListaFactura.ejecutar();
    }

}

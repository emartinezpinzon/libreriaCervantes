package com.ceiba.compra.controlador;

import com.ceiba.compra.consulta.ManejadorListaCompra;
import com.ceiba.compra.modelo.dto.DtoCompra;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/compra")
@Api(tags = {"Controlador consulta compra"})
public class ConsultaControladorCompra {

    private final ManejadorListaCompra manejadorListaCompra;

    public ConsultaControladorCompra(ManejadorListaCompra manejadorListaCompra) {
        this.manejadorListaCompra = manejadorListaCompra;
    }

    @GetMapping
    @ApiOperation("Listar compras")
    public List<DtoCompra> listar() {
        return this.manejadorListaCompra.ejecutar();
    }
}

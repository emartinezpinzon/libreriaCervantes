package com.ceiba.compra.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.compra.comando.ComandoCompra;
import com.ceiba.compra.comando.manejador.ManejadorCrearCompra;
import com.ceiba.compra.comando.manejador.ManejadorActualizarCompra;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/compra")
@Api(tags = {"Modificar la información disponible de compra"})
public class ComandoControladorCompra {

    private final ManejadorCrearCompra manejadorCrearCompra;
    private final ManejadorActualizarCompra manejadorActualizarCompra;

    @Autowired
    public ComandoControladorCompra(ManejadorCrearCompra manejadorCrearCompra, ManejadorActualizarCompra manejadorActualizarCompra) {
        this.manejadorCrearCompra = manejadorCrearCompra;
        this.manejadorActualizarCompra = manejadorActualizarCompra;
    }

    @PostMapping
    @ApiOperation("Agregar un libro a la compra")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoCompra comandoCompra) {
        return manejadorCrearCompra.ejecutar(comandoCompra);
    }


    @PutMapping(value = "/{id}")
    @ApiOperation("Actualizar una compra")
    public void actualizar(@RequestBody ComandoCompra comandoCompra, @PathVariable Long id) {
        comandoCompra.setId(id);

        manejadorActualizarCompra.ejecutar(comandoCompra);
    }
}

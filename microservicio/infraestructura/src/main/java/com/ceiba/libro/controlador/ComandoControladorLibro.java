package com.ceiba.libro.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.libro.comando.ComandoLibro;
import com.ceiba.libro.comando.manejador.ManejadorActualizarLibro;
import com.ceiba.libro.comando.manejador.ManejadorCrearLibro;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/libros")
@Api(tags = {"Controlador comando libro"})
public class ComandoControladorLibro {

    private final ManejadorCrearLibro manejadorCrearLibro;
    private final ManejadorActualizarLibro manejadorActualizarLibro;

    @Autowired
    public ComandoControladorLibro(ManejadorCrearLibro manejadorCrearLibro,
                                   ManejadorActualizarLibro manejadorActualizarLibro) {
        this.manejadorCrearLibro = manejadorCrearLibro;
        this.manejadorActualizarLibro = manejadorActualizarLibro;
    }

    @PostMapping
    @ApiOperation("Crear libro")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoLibro comandoLibro) {
        return manejadorCrearLibro.ejecutar(comandoLibro);
    }

    @PutMapping(value = "/{id}")
    @ApiOperation("Actualizar libro")
    public void actualizar(@RequestBody ComandoLibro comandoLibro, @PathVariable Long id) {
        comandoLibro.setId(id);

        manejadorActualizarLibro.ejecutar(comandoLibro);
    }
}

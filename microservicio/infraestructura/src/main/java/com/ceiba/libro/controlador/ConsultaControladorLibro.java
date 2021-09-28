package com.ceiba.libro.controlador;

import com.ceiba.libro.consulta.ManejadorListarLibros;
import com.ceiba.libro.modelo.dto.DtoLibro;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/libros")
@Api(tags = {"Consultar información de los libros"})
public class ConsultaControladorLibro {

    private final ManejadorListarLibros manejadorListarLibros;

    public ConsultaControladorLibro(ManejadorListarLibros manejadorListarLibros) {
        this.manejadorListarLibros = manejadorListarLibros;
    }

    @GetMapping
    @ApiOperation("Listar los libros registrados")
    public List<DtoLibro> listar() {
        return this.manejadorListarLibros.ejecutar();
    }
}

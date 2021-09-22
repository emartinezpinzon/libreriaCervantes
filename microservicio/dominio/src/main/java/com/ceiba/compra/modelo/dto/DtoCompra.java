package com.ceiba.compra.modelo.dto;

import com.ceiba.libro.modelo.entidad.Libro;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class DtoCompra {
    private List<Libro> libros;
}

package com.ceiba.compra.modelo.entidad;

import lombok.Getter;

import java.time.LocalDate;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Compra {
    private static final String DEBE_INGRESAR_LIBRO_ID = "Debe ingresar un identificador del libro";
    private static final String DEBE_SER_POSITIVO = "Debe ingresar una cantidad positiva";

    private Long id;
    private Long libroId;
    private int cantidad;
    private LocalDate fechaCompra;
    private LocalDate fechaEntrega;

    public Compra(Long id, Long libroId, int cantidad, LocalDate fechaCompra, LocalDate fechaEntrega) {
        validarObligatorio(libroId.toString(), DEBE_INGRESAR_LIBRO_ID);

        this.id = id;
        this.libroId = libroId;
        this.cantidad = cantidad;
        this.fechaCompra = fechaCompra;
        this.fechaEntrega = fechaEntrega;
    }
}

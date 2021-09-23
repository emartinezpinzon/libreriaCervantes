package com.ceiba.compra.modelo.entidad;

import lombok.Getter;

import java.time.LocalDate;

import static com.ceiba.dominio.ValidadorArgumento.*;

@Getter
public class Compra {
    private static final String DEBE_INGRESAR_LIBRO_ID = "Debe ingresar un identificador del libro";
    private static final String DEBE_SER_POSITIVO = "Debe ingresar una cantidad positiva";

    private Long id;
    private Long libroId;
    private int cantidad;
    private LocalDate fechaEntrega;

    public Compra(Long id, Long libroId, int cantidad) {
        validarObligatorio(libroId, DEBE_INGRESAR_LIBRO_ID);
        validarPositivo((double) cantidad, DEBE_SER_POSITIVO);

        this.id = id;
        this.libroId = libroId;
        this.cantidad = cantidad;
        this.fechaEntrega = null;
    }
}

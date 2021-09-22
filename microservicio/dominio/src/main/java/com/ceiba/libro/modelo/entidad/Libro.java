package com.ceiba.libro.modelo.entidad;

import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;
import static com.ceiba.dominio.ValidadorArgumento.validarPositivo;
import static com.ceiba.dominio.ValidadorArgumento.validarMenor;

@Getter
public class Libro {
    private static final String DEBE_INGRESAR_TITULO = "Debe ingresar el titulo del libro";
    private static final String DEBE_INGRESAR_CATEGORIA = "Debe ingresar la categoría del libro";
    private static final String DEBE_INGRESAR_DISTRIBUCION = "Debe ingresar el tipo de distribución del libro";
    private static final String DEBE_SER_CERO_O_POSITIVO = "Las cantidades disponibles no pueden ser negativas";
    private static final String DEBE_SER_POSITIVO = "El precio debe ser un valor positivo";

    private static final long DISPONIBLE_NO_PERMITIDO = -1;

    private Long id;
    private String titulo;
    private String categoria;
    private String distribucion;
    private int disponibles;
    private double precio;

    public Libro(Long id, String titulo, String categoria, String distribucion, int disponibles, double precio) {
        validarObligatorio(titulo, DEBE_INGRESAR_TITULO);
        validarObligatorio(categoria, DEBE_INGRESAR_CATEGORIA);
        validarObligatorio(distribucion, DEBE_INGRESAR_DISTRIBUCION);
        validarMenor(DISPONIBLE_NO_PERMITIDO, (long) disponibles, DEBE_SER_CERO_O_POSITIVO);
        validarPositivo(precio, DEBE_SER_POSITIVO);

        this.id = id;
        this.titulo = titulo;
        this.categoria = categoria;
        this.distribucion = distribucion;
        this.disponibles = disponibles;
        this.precio = precio;
    }
}

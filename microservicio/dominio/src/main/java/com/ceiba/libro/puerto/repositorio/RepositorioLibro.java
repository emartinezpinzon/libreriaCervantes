package com.ceiba.libro.puerto.repositorio;

import com.ceiba.libro.modelo.entidad.Libro;

public interface RepositorioLibro {
    /**
     * Permite crear un libro
     *
     * @param libro
     * @return el id generado
     */
    Long crear(Libro libro);

    /**
     * Permite actualizar un libro
     *
     * @param libro
     */
    void actualizar(Libro libro);

    /**
     * Permite validar si existe un libro con un titulo
     *
     * @param titulo
     * @return si existe o no
     */
    boolean existe(String titulo);

    /**
     * Permite validar si existe un libro excluyendo un id
     *
     * @param id
     * @param titulo
     * @return si existe o no
     */
    boolean existeExcluyendoId(Long id, String titulo);
}

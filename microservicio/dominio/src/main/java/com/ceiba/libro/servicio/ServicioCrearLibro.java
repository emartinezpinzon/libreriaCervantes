package com.ceiba.libro.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.libro.modelo.entidad.Libro;
import com.ceiba.libro.puerto.repositorio.RepositorioLibro;

public class ServicioCrearLibro {
    private static final String USUARIO_YA_EXISTE = "El usuario ya existe en el sistema";

    private final RepositorioLibro repositorioLibro;

    public ServicioCrearLibro(RepositorioLibro repositorioLibro) {
        this.repositorioLibro = repositorioLibro;
    }

    /**
     * Ejecuta la creación de un libro
     *
     * @param libro
     * @return el id generado del libro
     */
    public Long ejecutar(Libro libro) {
        validarExistenciaPrevia(libro);

        return this.repositorioLibro.crear(libro);
    }

    /**
     * Valida la existencia previa de un libro
     *
     * @param libro
     */
    private void validarExistenciaPrevia(Libro libro) {
        boolean existe = this.repositorioLibro.existe(libro.getTitulo());

        if (existe) {
            throw new ExcepcionDuplicidad(USUARIO_YA_EXISTE);
        }
    }
}

package com.ceiba.libro;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.libro.modelo.entidad.Libro;
import com.ceiba.libro.puerto.repositorio.RepositorioLibro;

public class ServicioActualizarLibro {
    private static final String USUARIO_YA_EXISTE = "El usuario ya existe en el sistema";

    private final RepositorioLibro repositorioLibro;

    public ServicioActualizarLibro(RepositorioLibro repositorioLibro) {
        this.repositorioLibro = repositorioLibro;
    }

    /**
     * Ejecuta la actualización de un libro
     *
     * @param libro
     */
    public void ejecutar(Libro libro) {
        validarExistenciaPrevia(libro);

        this.repositorioLibro.actualizar(libro);
    }

    /**
     * Valida la existencia de un titulo excluyendo por id
     *
     * @param libro
     */
    private void validarExistenciaPrevia(Libro libro) {
        boolean existe = this.repositorioLibro.existeExcluyendoId(libro.getId(), libro.getTitulo());

        if(existe){
            throw new ExcepcionDuplicidad(USUARIO_YA_EXISTE);
        }
    }
}

package com.ceiba.compra.servicio;

import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.dominio.excepcion.ExcepcionLibroNoRegistrado;
import com.ceiba.libro.puerto.repositorio.RepositorioLibro;

public class ServicioCrearCompra {

    private static final String LIBRO_NO_REGISTRADO = "El libro no está registrado";

    private final RepositorioCompra repositorioCompra;
    private final RepositorioLibro repositorioLibro;

    public ServicioCrearCompra(RepositorioCompra repositorioCompra, RepositorioLibro repositorioLibro) {
        this.repositorioCompra = repositorioCompra;
        this.repositorioLibro = repositorioLibro;
    }

    /**
     * Crea una nueva compra
     *
     * @param compra
     * @return el id generado de la compra
     */
    public Long ejecutar(Compra compra) {
        validarExistenciaLibro(compra.getLibroId());

        return this.repositorioCompra.crear(compra);
    }

    /**
     * Valida la existencia de un libro
     *
     * @param id
     */
    private void validarExistenciaLibro(Long id) {
        boolean existe = repositorioLibro.existe(id);

        if (!existe)
            throw new ExcepcionLibroNoRegistrado(LIBRO_NO_REGISTRADO);
    }
}

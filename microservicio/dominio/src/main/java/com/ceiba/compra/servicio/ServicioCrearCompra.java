package com.ceiba.compra.servicio;

import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.dominio.excepcion.ExcepcionLibroNoRegistrado;
import com.ceiba.libro.modelo.dto.DtoLibro;
import com.ceiba.libro.puerto.dao.DaoLibro;
import com.ceiba.libro.puerto.repositorio.RepositorioLibro;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ServicioCrearCompra {

    private static final String LIBRO_NO_REGISTRADO = "El libro no está registrado";
    private static final String DISTRIBUCION_NACIONAL = "Nacional";
    private static final int ESPERA_ENVIO_NACIONAL = 3;
    private static final int ESPERA_ENVIO_INTERNACIONAL = 5;
    private static final int HORA_CONTAR_DIA = 9;
    private static final int CONTAR_DIA = 1;

    private final RepositorioCompra repositorioCompra;
    private final RepositorioLibro repositorioLibro;
    private final DaoLibro daoLibro;

    public ServicioCrearCompra(
            RepositorioCompra repositorioCompra,
            RepositorioLibro repositorioLibro,
            DaoLibro daoLibro) {
        this.repositorioCompra = repositorioCompra;
        this.repositorioLibro = repositorioLibro;
        this.daoLibro = daoLibro;
    }

    /**
     * Crea una nueva compra
     *
     * @param compra
     * @return el id generado de la compra
     */
    public Long ejecutar(Compra compra) {
        DtoLibro libro = daoLibro.buscarPorId(compra.getLibroId());

        validarExistenciaLibro(compra.getLibroId());
        calcularFechaEntrega(compra, libro);
        System.out.println(compra);

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

    private void calcularFechaEntrega(Compra compra, DtoLibro libro) {
        LocalDateTime fechaEntrega = LocalDateTime.now();

        if (debeRealizarPedido(compra, libro))
            compra.setFechaEntrega(validarTipoDistribucion(fechaEntrega, libro));
        else
            compra.setFechaEntrega(fechaEntrega.toLocalDate());
    }

    private boolean debeRealizarPedido(Compra compra, DtoLibro libro) {
        return (compra.getCantidad() > libro.getDisponibles())?true:false;
    }

    private LocalDate validarTipoDistribucion(LocalDateTime fechaEntrega, DtoLibro libro) {
        if (libro.getDistribucion().equals(DISTRIBUCION_NACIONAL))
            return validarDiaVigente(fechaEntrega, ESPERA_ENVIO_NACIONAL);

        return validarDiaVigente(fechaEntrega, ESPERA_ENVIO_INTERNACIONAL);
    }

    private LocalDate validarDiaVigente(LocalDateTime fechaEntrega, int dias) {
        if (fechaEntrega.getHour() < HORA_CONTAR_DIA)
            return sumarDiasSinFinesDeSemana(fechaEntrega, dias - CONTAR_DIA);

        return sumarDiasSinFinesDeSemana(fechaEntrega, dias);
    }

    private LocalDate sumarDiasSinFinesDeSemana(LocalDateTime fechaActual, int dias) {
        int diasAgregados = 0;

        while (diasAgregados < dias) {
            fechaActual = fechaActual.plusDays(1);

            if (!(fechaActual.getDayOfWeek() == DayOfWeek.SATURDAY ||
                    fechaActual.getDayOfWeek() == DayOfWeek.SUNDAY))
                ++diasAgregados;
        }

        return fechaActual.toLocalDate();
    }
}

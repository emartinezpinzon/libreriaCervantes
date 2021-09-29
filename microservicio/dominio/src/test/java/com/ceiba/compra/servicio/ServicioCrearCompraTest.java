package com.ceiba.compra.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.compra.servicio.testdatabuilder.CompraTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionNoRegistrado;
import com.ceiba.libro.modelo.dto.DtoLibro;
import com.ceiba.libro.puerto.dao.DaoLibro;
import com.ceiba.libro.puerto.repositorio.RepositorioLibro;
import com.ceiba.libro.servicio.testdatabuilder.DtoLibroTestDataBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;

@RunWith(MockitoJUnitRunner.class)
public class ServicioCrearCompraTest {

    private static final String LIBRO_NO_REGISTRADO = "No hay registros del libro";
    private static final String DISTRIBUCION_INTERNACIONAL = "Internacional";
    private static final String DISTRIBUCION_NACIONAL = "Nacional";
    private static final int ESPERA_ENVIO_INTERNACIONAL = 5;
    private static final int ESPERA_ENVIO_NACIONAL = 3;
    private static final int HORA_CONTAR_DIA = 9;
    private static final int CONTAR_DIA = 1;

    private LocalDateTime fechaActual = LocalDateTime.now();
    private LocalDate fechaEntregaEsperada;

    @Mock
    private DaoLibro daoLibro;

    @Mock
    private RepositorioCompra repositorioCompra;

    @Mock
    private RepositorioLibro repositorioLibro;

    @InjectMocks
    private ServicioCrearCompra servicioCrearCompra;

    @InjectMocks
    private Compra compra = new CompraTestDataBuilder().build();

    @InjectMocks
    private DtoLibro libro = new DtoLibroTestDataBuilder().build();

    @Test
    public void validarLibroNoExistenciaPreviaRegistrarCompraTest() {
        // Arrange
        Mockito.when(repositorioLibro.existe(Mockito.anyLong())).thenReturn(false);

        // Act - Assert
        BasePrueba.assertThrows(() -> servicioCrearCompra.ejecutar(compra), ExcepcionNoRegistrado.class, LIBRO_NO_REGISTRADO);
    }

    @Test
    public void validarCrearCompraConExistenciaTest() {
        // Arrange
        Mockito.when(repositorioLibro.existe(Mockito.anyLong())).thenReturn(true);
        Mockito.when(daoLibro.buscarPorId(1L)).thenReturn(libro);

        // Act
        servicioCrearCompra.ejecutar(compra);

        // Assert
        Assert.assertEquals(LocalDate.now(), compra.getFechaEntrega());
    }

    @Test
    public void validarCrearCompraSinExistenciaDistribucionNacionalTest() {
        // Arrange
        libro.setDistribucion(DISTRIBUCION_NACIONAL);
        compra.setCantidad(5);

        Mockito.when(repositorioLibro.existe(Mockito.anyLong())).thenReturn(true);
        Mockito.when(daoLibro.buscarPorId(1L)).thenReturn(libro);

        // Act
        servicioCrearCompra.ejecutar(compra);

        if (fechaActual.getHour() < HORA_CONTAR_DIA)
            fechaEntregaEsperada = sumarDiasSinFinesDeSemana(fechaActual, ESPERA_ENVIO_NACIONAL - CONTAR_DIA);
        else
            fechaEntregaEsperada = sumarDiasSinFinesDeSemana(fechaActual, ESPERA_ENVIO_NACIONAL);

        // Assert
        Assert.assertEquals(fechaEntregaEsperada, compra.getFechaEntrega());
    }

    @Test
    public void validarCrearCompraSinExistenciaDistribucionInternacionalTest() {
        // Arrange
        libro.setDistribucion(DISTRIBUCION_INTERNACIONAL);
        compra.setCantidad(5);

        Mockito.when(repositorioLibro.existe(Mockito.anyLong())).thenReturn(true);
        Mockito.when(daoLibro.buscarPorId(1L)).thenReturn(libro);

        // Act
        servicioCrearCompra.ejecutar(compra);

        if (fechaActual.getHour() < HORA_CONTAR_DIA)
            fechaEntregaEsperada = sumarDiasSinFinesDeSemana(fechaActual, ESPERA_ENVIO_INTERNACIONAL - CONTAR_DIA);
        else
            fechaEntregaEsperada = sumarDiasSinFinesDeSemana(fechaActual, ESPERA_ENVIO_INTERNACIONAL);

        // Assert
        Assert.assertEquals(fechaEntregaEsperada, compra.getFechaEntrega());
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

package com.ceiba.compra.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.compra.servicio.testdatabuilder.CompraTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionLibroNoRegistrado;
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

    @Mock
    private DaoLibro daoLibro;

    @Mock
    private RepositorioCompra repositorioCompra;

    @Mock
    private RepositorioLibro repositorioLibro;

    @InjectMocks
    Compra compra = new CompraTestDataBuilder().build();

    @InjectMocks
    DtoLibro libro = new DtoLibroTestDataBuilder().build();

    @Test
    public void validarLibroNoExistenciaPreviaRegistrarCompraTest() {
        // Arrange
        ServicioCrearCompra servicioCrearCompra = new ServicioCrearCompra(repositorioCompra, repositorioLibro, daoLibro);
        Mockito.when(repositorioLibro.existe(Mockito.anyLong())).thenReturn(false);

        // Act - Assert
        BasePrueba.assertThrows(() -> servicioCrearCompra.ejecutar(compra), ExcepcionLibroNoRegistrado.class, "El libro no está registrado");
    }

    @Test
    public void validarCrearCompraConExistencia() {
        // Arrange
        Mockito.when(repositorioLibro.existe(Mockito.anyLong())).thenReturn(true);
        Mockito.when(daoLibro.buscarPorId(1L)).thenReturn(libro);

        // Act
        ServicioCrearCompra servicioCrearCompra = new ServicioCrearCompra(repositorioCompra, repositorioLibro, daoLibro);
        servicioCrearCompra.ejecutar(compra);

        // Assert
        Assert.assertEquals(LocalDate.now(), compra.getFechaEntrega());
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

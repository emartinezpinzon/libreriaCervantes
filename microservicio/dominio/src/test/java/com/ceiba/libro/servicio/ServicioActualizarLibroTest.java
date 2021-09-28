package com.ceiba.libro.servicio;

import com.ceiba.BasePrueba;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.libro.modelo.entidad.Libro;
import com.ceiba.libro.puerto.repositorio.RepositorioLibro;
import com.ceiba.libro.servicio.testdatabuilder.LibroTestDataBuilder;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

public class ServicioActualizarLibroTest {

    private static final String LIBRO_YA_EXISTE = "El libro ya existe en el sistema";

    @Test
    public void validarLibroExistenciaPreviaTest() {
        // Arrange
        Libro libro = new LibroTestDataBuilder().conId(1L).build();
        RepositorioLibro repositorioLibro = Mockito.mock(RepositorioLibro.class);
        Mockito.when(repositorioLibro.existeExcluyendoId(Mockito.anyLong(), Mockito.anyString())).thenReturn(true);
        ServicioActualizarLibro servicioActualizarLibro = new ServicioActualizarLibro(repositorioLibro);

        // Act - Assert
        BasePrueba.assertThrows(() -> servicioActualizarLibro.ejecutar(libro), ExcepcionDuplicidad.class, LIBRO_YA_EXISTE);
    }

    @Test
    public void validarLibroNoExistenciaPreviaTest() {
        // Arrange
        Libro libro = new LibroTestDataBuilder().conId(22L).build();
        RepositorioLibro repositorioLibro = Mockito.mock(RepositorioLibro.class);
        Mockito.when(repositorioLibro.existeExcluyendoId(Mockito.anyLong(), Mockito.anyString())).thenReturn(false);
        ServicioActualizarLibro servicioActualizarLibro = new ServicioActualizarLibro(repositorioLibro);

        // Act - Assert
        Assertions.assertDoesNotThrow(() -> servicioActualizarLibro.ejecutar(libro));
        Mockito.verify(repositorioLibro, Mockito.times(1)).actualizar(libro);
    }

}

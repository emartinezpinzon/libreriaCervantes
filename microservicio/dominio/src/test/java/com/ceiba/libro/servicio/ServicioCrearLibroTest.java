package com.ceiba.libro.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.libro.modelo.entidad.Libro;
import com.ceiba.libro.puerto.repositorio.RepositorioLibro;
import com.ceiba.libro.servicio.testdatabuilder.LibroTestDataBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

class ServicioCrearLibroTest {

    private static final String LIBRO_YA_EXISTE = "El libro ya existe en el sistema";

    @Test
    void validarLibroExistenciaPreviaTest() {
        // Arrange
        Libro libro = new LibroTestDataBuilder().build();
        RepositorioLibro repositorioLibro = Mockito.mock(RepositorioLibro.class);
        Mockito.when(repositorioLibro.existe(Mockito.anyString())).thenReturn(true);
        ServicioCrearLibro servicioCrearLibro = new ServicioCrearLibro(repositorioLibro);

        // Act - Assert
        BasePrueba.assertThrows(() -> servicioCrearLibro.ejecutar(libro), ExcepcionDuplicidad.class, LIBRO_YA_EXISTE);
    }

    @Test
    void validarLibroNoExistenciaPreviaTest() {
        // Arrange
        Libro libro = new LibroTestDataBuilder().build();
        RepositorioLibro repositorioLibro = Mockito.mock(RepositorioLibro.class);
        Mockito.when(repositorioLibro.existe(Mockito.anyString())).thenReturn(false);
        ServicioCrearLibro servicioCrearLibro = new ServicioCrearLibro(repositorioLibro);

        // Act - Assert
        Assertions.assertDoesNotThrow(() -> servicioCrearLibro.ejecutar(libro));
        Mockito.verify(repositorioLibro, Mockito.times(1)).crear(libro);
    }

}

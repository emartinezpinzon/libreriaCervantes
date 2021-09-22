package com.ceiba.libro.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.libro.modelo.entidad.Libro;
import com.ceiba.libro.puerto.repositorio.RepositorioLibro;
import com.ceiba.libro.servicio.testdatabuilder.LibroTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioCrearLibroTest {

    @Test
    public void validarLibroExistenciaPreviaTest() {
        // Arrange
        Libro libro = new LibroTestDataBuilder().build();
        RepositorioLibro repositorioLibro = Mockito.mock(RepositorioLibro.class);
        Mockito.when(repositorioLibro.existe(Mockito.anyString())).thenReturn(true);
        ServicioCrearLibro servicioCrearLibro = new ServicioCrearLibro(repositorioLibro);

        // Act - Assert
        BasePrueba.assertThrows(() -> servicioCrearLibro.ejecutar(libro), ExcepcionDuplicidad.class, "El usuario ya existe en el sistema");
    }
}

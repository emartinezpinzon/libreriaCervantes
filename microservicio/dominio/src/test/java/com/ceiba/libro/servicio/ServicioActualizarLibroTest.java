package com.ceiba.libro.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.libro.modelo.entidad.Libro;
import com.ceiba.libro.puerto.repositorio.RepositorioLibro;
import com.ceiba.libro.servicio.testdatabuilder.LibroTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioActualizarLibroTest {
    @Test
    public void validarLibroExistenciaPreviaTest() {
        // Arrange
        Libro libro = new LibroTestDataBuilder().conId(1L).build();
        RepositorioLibro repositorioLibro = Mockito.mock(RepositorioLibro.class);
        Mockito.when(repositorioLibro.existeExcluyendoId(Mockito.anyLong(), Mockito.anyString())).thenReturn(true);
        ServicioActualizarLibro servicioActualizarLibro = new ServicioActualizarLibro(repositorioLibro);

        // Act - Assert
        BasePrueba.assertThrows(() -> servicioActualizarLibro.ejecutar(libro), ExcepcionDuplicidad.class, "Algo");
    }

}

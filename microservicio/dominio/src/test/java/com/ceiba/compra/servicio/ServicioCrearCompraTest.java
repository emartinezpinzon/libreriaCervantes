package com.ceiba.compra.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.compra.servicio.testdatabuilder.CompraTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionLibroNoRegistrado;
import com.ceiba.libro.puerto.repositorio.RepositorioLibro;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioCrearCompraTest {

    @Test
    public void validarLibroNoExistenciaPreviaRegistrarCompraTest() {
        // Arrange
        Compra compra = new CompraTestDataBuilder().build();
        RepositorioCompra repositorioCompra = Mockito.mock(RepositorioCompra.class);
        RepositorioLibro repositorioLibro = Mockito.mock(RepositorioLibro.class);
        Mockito.when(repositorioLibro.existe(Mockito.anyLong())).thenReturn(false);
        ServicioCrearCompra servicioCrearCompra = new ServicioCrearCompra(repositorioCompra, repositorioLibro);

        // Act - Assert
        BasePrueba.assertThrows(() -> servicioCrearCompra.ejecutar(compra), ExcepcionLibroNoRegistrado.class, "El libro no está registrado");
    }
}

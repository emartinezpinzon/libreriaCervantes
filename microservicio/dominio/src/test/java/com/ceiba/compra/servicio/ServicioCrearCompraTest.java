package com.ceiba.compra.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.compra.servicio.testdatabuilder.CompraTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionLibroNoRegistrado;
import com.ceiba.libro.modelo.dto.DtoLibro;
import com.ceiba.libro.puerto.dao.DaoLibro;
import com.ceiba.libro.puerto.repositorio.RepositorioLibro;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.UUID;

@RunWith(MockitoJUnitRunner.class)
public class ServicioCrearCompraTest {

    @Mock
    private DaoLibro libro;

    @Mock
    private RepositorioCompra repositorioCompra;

    @Mock
    private RepositorioLibro repositorioLibro;

    @InjectMocks
    Compra compra = new CompraTestDataBuilder().build();

    @Test
    public void validarLibroNoExistenciaPreviaRegistrarCompraTest() {
        // Arrange
        Mockito.when(repositorioLibro.existe(Mockito.anyLong())).thenReturn(false);
        ServicioCrearCompra servicioCrearCompra = new ServicioCrearCompra(repositorioCompra, repositorioLibro, libro);

        // Act - Assert
        BasePrueba.assertThrows(() -> servicioCrearCompra.ejecutar(compra), ExcepcionLibroNoRegistrado.class, "El libro no está registrado");
    }
}

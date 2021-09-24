package com.ceiba.compra.servicio;

import com.ceiba.compra.modelo.dto.DtoCompra;
import com.ceiba.compra.puerto.dao.DaoCompra;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ServicioCalcularPrecioFinalFacturaTest {

    @InjectMocks
    private ServicioCalcularPrecioFinalFactura servicioCalcularPrecioFinalFactura;

    /**
     * Calcula el descuento de una compra con dos libros
     *
     * Solo debe aplicar el descuento del 20% al libro de educación
     *
     * El libro de educación de 100 queda costando 80
     * El libro de literatura de 20 no recibe descuentos
     *
     * La suma sería 80 + 20 = 100
     */
    @Test
    public void calcularDescuentosEducacionTest() {
        // Arrange
        List<DtoCompra> compras = new ArrayList<>();
        DtoCompra libroJava = Mockito.mock(DtoCompra.class);
        DtoCompra ficciones = Mockito.mock(DtoCompra.class);
        DaoCompra daoCompra = Mockito.mock(DaoCompra.class);

        // Act
        Mockito.when(libroJava.getCategoria()).thenReturn("Educación");
        Mockito.when(libroJava.getPrecio()).thenReturn(100D);
        compras.add(libroJava);

        Mockito.when(ficciones.getCategoria()).thenReturn("Literatura");
        Mockito.when(ficciones.getPrecio()).thenReturn(20D);
        compras.add(ficciones);

        Mockito.when(daoCompra.listar()).thenReturn(compras);

        // Assert
        Double precioFinal = servicioCalcularPrecioFinalFactura.calcularPrecioFinal(compras);
        Assert.assertEquals(100D, precioFinal, 1.0);
    }

}

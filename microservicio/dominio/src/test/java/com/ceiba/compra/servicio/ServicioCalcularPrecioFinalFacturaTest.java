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
        List<DtoCompra> educacion = new ArrayList<>();
        List<DtoCompra> otros = new ArrayList<>();
        DtoCompra libroJava = Mockito.mock(DtoCompra.class);
        DtoCompra ficciones = Mockito.mock(DtoCompra.class);

        // Act
        Mockito.when(libroJava.getCategoria()).thenReturn("Educación");
        Mockito.when(libroJava.getPrecio()).thenReturn(100D);
        educacion.add(libroJava);

        Mockito.when(ficciones.getCategoria()).thenReturn("Literatura");
        Mockito.when(ficciones.getPrecio()).thenReturn(20D);
        otros.add(ficciones);

        // Assert
        Double precioFinal = servicioCalcularPrecioFinalFactura.calcularPrecioFinal(educacion, otros);
        Assert.assertEquals(100D, precioFinal, 1.0);
    }

    /**
     * Se calcula el descuento de una compra con 2 libros no educativos
     *
     * El segundo libro recibe un descuento del 50%
     */
    @Test
    public void calcularDescuentosNoEducacionTest() {
        // Arrange
        List<DtoCompra> educacion = new ArrayList<>();
        List<DtoCompra> otros = new ArrayList<>();
        DtoCompra divinaComedia = Mockito.mock(DtoCompra.class);
        DtoCompra ficciones = Mockito.mock(DtoCompra.class);

        // Act
        Mockito.when(divinaComedia.getCategoria()).thenReturn("Literatura");
        Mockito.when(divinaComedia.getPrecio()).thenReturn(45D);
        otros.add(divinaComedia);

        Mockito.when(ficciones.getCategoria()).thenReturn("Literatura");
        Mockito.when(ficciones.getPrecio()).thenReturn(36D);
        otros.add(ficciones);

        // Assert
        Double precioFinal = servicioCalcularPrecioFinalFactura.calcularPrecioFinal(educacion, otros);
        Assert.assertEquals(63D, precioFinal, 1.0);
    }




}

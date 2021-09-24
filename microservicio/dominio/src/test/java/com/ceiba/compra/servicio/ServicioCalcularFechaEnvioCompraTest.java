package com.ceiba.compra.servicio;

import com.ceiba.compra.modelo.dto.DtoCompra;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RunWith(MockitoJUnitRunner.class)
public class ServicioCalcularFechaEnvioCompraTest {

    @InjectMocks
    private ServicioCalcularFechaEnvioCompra servicioCalcularFechaEnvioCompra;

    /**
     * Calcula el tiempo de espera para un envío internacional haciendo el pedido luego de las 9 AM
     *
     * Para el envío internacional son 5 días hábiles, excluído hoy
     */
    @Test
    public void calcularFechaEnvioInternacionalTest() {
        // Arrange
        String fecha = "2021-09-24 11:30";
        String fechaEsperada = "2021-10-01 11:30";
        DtoCompra compra = Mockito.mock(DtoCompra.class);

        // Act
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(fecha, formatter);
        LocalDateTime fechaEntregaEsperada = LocalDateTime.parse(fechaEsperada, formatter);
        Mockito.when(compra.getDistribucion()).thenReturn("Internacional");

        // Assert
        LocalDateTime fechaEntrega = servicioCalcularFechaEnvioCompra.calcularFechaEntrega(compra, dateTime);
        Assert.assertEquals(fechaEntrega, fechaEntregaEsperada);
    }

    /**
     * Calcula el tiempo de espera para un envío internacional haciendo el pedido antes de las 9 AM
     *
     * Para el envío internacional son 5 días hábiles, incluído hoy
     */
    @Test
    public void calcularFechaEnvioInternacionalIncluidoHoyTest() {
        // Arrange
        String fecha = "2021-09-24 07:30";
        String fechaEsperada = "2021-09-30 07:30";
        DtoCompra compra = Mockito.mock(DtoCompra.class);

        // Act
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(fecha, formatter);
        LocalDateTime fechaEntregaEsperada = LocalDateTime.parse(fechaEsperada, formatter);
        Mockito.when(compra.getDistribucion()).thenReturn("Internacional");

        // Assert
        LocalDateTime fechaEntrega = servicioCalcularFechaEnvioCompra.calcularFechaEntrega(compra, dateTime);
        Assert.assertEquals(fechaEntrega, fechaEntregaEsperada);
    }
}

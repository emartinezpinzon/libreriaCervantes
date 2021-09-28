package com.ceiba.compra.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.compra.modelo.dto.DtoCompra;
import com.ceiba.compra.modelo.entidad.Factura;
import com.ceiba.compra.puerto.dao.DaoCompra;
import com.ceiba.compra.puerto.repositorio.RepositorioFactura;
import com.ceiba.compra.servicio.testdatabuilder.DtoCompraTestDataBuilder;
import com.ceiba.compra.servicio.testdatabuilder.FacturaTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
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
public class ServicioCrearFacturaTest {

    private static final String COMPRAS_NO_REGISTRADAS = "No hay compras registradas";

    @Mock
    private DaoCompra daoCompra;

    @Mock
    private RepositorioFactura repositorioFactura;

    @InjectMocks
    private ServicioCrearFactura servicioCrearFactura;

    @InjectMocks
    Factura factura = new FacturaTestDataBuilder().build();

    @InjectMocks
    List<DtoCompra> compras = new ArrayList<>();

    @InjectMocks
    DtoCompra compra1 = new DtoCompraTestDataBuilder().build();

    @InjectMocks
    DtoCompra compra2 = new DtoCompraTestDataBuilder().build();

    @Test
    public void validarCrearFacturaSinComprasRegistradasTest() {
        // Arrange
        Mockito.when(daoCompra.listar()).thenReturn(compras);

        // Act - Assert
        BasePrueba.assertThrows(() -> servicioCrearFactura.ejecutar(factura), ExcepcionSinDatos.class, COMPRAS_NO_REGISTRADAS);
    }

    @Test
    public void calcularDescuentosEducacionTest() {
        // Arrange
        compra1.setCategoria("Educación");
        compras.add(compra1);
        Mockito.when(daoCompra.listar()).thenReturn(compras);

        // Act
        servicioCrearFactura.ejecutar(factura);

        // Assert
        Assert.assertEquals(80000D, factura.getPrecioFinal(), 0.1);
    }
}

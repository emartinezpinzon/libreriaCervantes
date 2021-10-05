package com.ceiba.compra.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.compra.modelo.dto.DtoCompra;
import com.ceiba.compra.modelo.entidad.Factura;
import com.ceiba.compra.puerto.dao.DaoCompra;
import com.ceiba.compra.puerto.repositorio.RepositorioFactura;
import com.ceiba.compra.servicio.testdatabuilder.DtoCompraTestDataBuilder;
import com.ceiba.compra.servicio.testdatabuilder.FacturaTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ServicioCrearFacturaTest {

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
    void validarCrearFacturaSinComprasRegistradasTest() {
        // Arrange
        Mockito.when(daoCompra.listar()).thenReturn(compras);

        // Act - Assert
        BasePrueba.assertThrows(() -> servicioCrearFactura.ejecutar(factura), ExcepcionSinDatos.class, COMPRAS_NO_REGISTRADAS);
    }

    @Test
    void calcularCompraSinDescuentoTest() {
        // Arrange
        compra1.setCategoria("Autoayuda");
        compras.add(compra1);
        Mockito.when(daoCompra.listar()).thenReturn(compras);

        // Act
        servicioCrearFactura.ejecutar(factura);

        // Assert
        assertEquals(100000D, factura.getPrecioFinal(), 0.1);
    }

    @Test
    void calcularDescuentosEducacionTest() {
        // Arrange
        compra1.setCategoria("Educación");
        compras.add(compra1);
        Mockito.when(daoCompra.listar()).thenReturn(compras);

        // Act
        servicioCrearFactura.ejecutar(factura);

        // Assert
        assertEquals(80000D, factura.getPrecioFinal(), 0.1);
    }

    @Test
    void calcularDescuentosNoEducacionTest() {
        // Arrange
        compra1.setCategoria("Literatura");
        compras.add(compra1);

        compra2.setCategoria("Literatura");
        compras.add(compra2);

        Mockito.when(daoCompra.listar()).thenReturn(compras);

        // Act
        servicioCrearFactura.ejecutar(factura);

        // Assert
        assertEquals(150000D, factura.getPrecioFinal(), 0.1);
    }
}

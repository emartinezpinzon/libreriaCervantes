package com.ceiba.compra.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.compra.modelo.dto.DtoCompra;
import com.ceiba.compra.modelo.entidad.Factura;
import com.ceiba.compra.puerto.dao.DaoCompra;
import com.ceiba.compra.puerto.repositorio.RepositorioFactura;
import com.ceiba.compra.servicio.testdatabuilder.FacturaTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
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
    Factura factura = new FacturaTestDataBuilder().build();

    @InjectMocks
    List<DtoCompra> compras = new ArrayList<>();

    @Test
    public void validarCrearFacturaSinComprasRegistradasTest() {
        // Arrange
        ServicioCrearFactura servicioCrearFactura = new ServicioCrearFactura(repositorioFactura, daoCompra);
        Mockito.when(daoCompra.listar()).thenReturn(compras);

        // Act - Assert
        BasePrueba.assertThrows(() -> servicioCrearFactura.ejecutar(factura), ExcepcionSinDatos.class, COMPRAS_NO_REGISTRADAS);
    }
}

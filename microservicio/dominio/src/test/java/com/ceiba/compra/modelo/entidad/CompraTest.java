package com.ceiba.compra.modelo.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.compra.servicio.testdatabuilder.CompraTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import org.junit.Test;

public class CompraTest {
    @Test
    public void validarObligatorioLibroIdCompraTest() {
        // Arrange
        CompraTestDataBuilder compraTestDataBuilder = new CompraTestDataBuilder().sinLibroId();

        // Act - Assert
        BasePrueba.assertThrows(() -> compraTestDataBuilder.build(), ExcepcionValorObligatorio.class, "Debe ingresar un identificador del libro");
    }

    @Test
    public void validarPositivoCantidadCompraTest() {
        // Arrange
        CompraTestDataBuilder compraTestDataBuilder = new CompraTestDataBuilder().conCantidadCero();

        // Act - Assert
        BasePrueba.assertThrows(() -> compraTestDataBuilder.build(), ExcepcionValorInvalido.class, "Debe ingresar una cantidad positiva");
    }
}

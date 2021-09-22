package com.ceiba.libro.modelo.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.libro.servicio.testdatabuilder.LibroTestDataBuilder;
import org.junit.Test;

public class LibroTest {
    @Test
    public void validarObligatorioTituloLibroTest() {
        // Arrange
        LibroTestDataBuilder libroTestDataBuilder = new LibroTestDataBuilder().sinTitulo();

        // Act - Assert
        BasePrueba.assertThrows(() -> libroTestDataBuilder.build(), ExcepcionValorObligatorio.class, "Debe ingresar el titulo del libro");
    }

    @Test
    public void validarObligatorioCategoriaLibroTest() {
        // Arrange
        LibroTestDataBuilder libroTestDataBuilder = new LibroTestDataBuilder().sinCategoria();

        // Act - Assert
        BasePrueba.assertThrows(() -> libroTestDataBuilder.build(), ExcepcionValorObligatorio.class, "Debe ingresar la categoría del libro");
    }

    @Test
    public void validarObligatorioDistribucionLibroTest() {
        // Arrange
        LibroTestDataBuilder libroTestDataBuilder = new LibroTestDataBuilder().sinDistribucion();

        // Act - Assert
        BasePrueba.assertThrows(() -> libroTestDataBuilder.build(), ExcepcionValorObligatorio.class, "Debe ingresar el tipo de distribución del libro");
    }

    @Test
    public void validarMenorDisponiblesLibroTest() {
        // Arrange
        LibroTestDataBuilder libroTestDataBuilder = new LibroTestDataBuilder().conDisponiblesNegativos();

        // Act - Assert
        BasePrueba.assertThrows(() -> libroTestDataBuilder.build(), ExcepcionValorInvalido.class, "Las cantidades disponibles no pueden ser negativas");
    }

    @Test
    public void validarPositivoPrecioLibroTest() {
        // Arrange
        LibroTestDataBuilder libroTestDataBuilder = new LibroTestDataBuilder().conPrecioCero();

        // Act - Assert
        BasePrueba.assertThrows(() -> libroTestDataBuilder.build(), ExcepcionValorInvalido.class, "El precio debe ser un valor positivo");
    }
}

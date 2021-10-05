package com.ceiba.compra.controlador;

import com.ceiba.ApplicationMock;
import org.hamcrest.core.IsNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ConsultaControladorFactura.class)
@ContextConfiguration(classes = ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ConsultaControladorFacturaTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void listar() throws Exception {
        // Arrange

        // Act - Assert
        mockMvc.perform(get("/factura")
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$", hasSize(2)))
                        .andExpect(jsonPath("$[0].id", IsNull.notNullValue()))
                        .andExpect(jsonPath("$[0].precioFinal", IsNull.notNullValue()));
    }

    @Test
    void mostrarFactura() throws Exception {
        // Arrange
        Long id = 1L;

        // Act - Assert
        mockMvc.perform(get("/factura/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                //.andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$.id", IsNull.notNullValue()))
                .andExpect(jsonPath("$.precioFinal", is(50000D)));
    }

    @Test
    void mostrarFacturaInexistente() throws Exception {
        // Arrange
        Long id = 100L;

        // Act - Assert
        mockMvc.perform(get("/factura/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is5xxServerError());
    }
}

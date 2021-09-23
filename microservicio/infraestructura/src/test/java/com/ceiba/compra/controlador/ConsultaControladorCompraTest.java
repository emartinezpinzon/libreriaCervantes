package com.ceiba.compra.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.libro.controlador.ConsultaControladorLibro;
import org.hamcrest.core.IsNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ConsultaControladorLibro.class)
public class ConsultaControladorCompraTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void listar() throws Exception {
        // Arrange

        // Act - Assert
        mockMvc.perform(get("/compra")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", IsNull.notNullValue()))
                .andExpect(jsonPath("$[0].libroId", IsNull.notNullValue()))
                .andExpect(jsonPath("$[0].cantidad", IsNull.notNullValue()))
                .andExpect(jsonPath("$[0].titulo", IsNull.notNullValue()))
                .andExpect(jsonPath("$[0].categoria", IsNull.notNullValue()))
                .andExpect(jsonPath("$[0].distribucion", IsNull.notNullValue()))
                .andExpect(jsonPath("$[0].disponibles", IsNull.notNullValue()))
                .andExpect(jsonPath("$[0].precio", IsNull.notNullValue()));
    }
}

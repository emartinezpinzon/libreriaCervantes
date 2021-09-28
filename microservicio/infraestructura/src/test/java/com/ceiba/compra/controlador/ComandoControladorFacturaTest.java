package com.ceiba.compra.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.compra.comando.ComandoFactura;
import com.ceiba.compra.servicio.testdatabuilder.ComandoFacturaTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ComandoControladorFactura.class)
public class ComandoControladorFacturaTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void crear() throws Exception {
        // Arrange
        ComandoFactura factura = new ComandoFacturaTestDataBuilder().build();

        // Act - Assert
        mockMvc.perform(post("/factura")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(factura)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 2}"));

    }
}

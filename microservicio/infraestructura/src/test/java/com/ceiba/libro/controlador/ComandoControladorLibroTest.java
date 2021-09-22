package com.ceiba.libro.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.libro.comando.ComandoLibro;
import com.ceiba.libro.servicio.testdatabuilder.ComandoLibroTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ComandoControladorLibro.class)
public class ComandoControladorLibroTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void crear() throws Exception {
        // Arrange
        ComandoLibro libro = new ComandoLibroTestDataBuilder().build();

        // Act - Assert
        mockMvc.perform(post("/libros")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(libro)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 2}"));
    }

    @Test
    public void actualizar() throws Exception {
        // Arrange
        Long id = 2L;
        ComandoLibro libro = new ComandoLibroTestDataBuilder().build();

        // Act - Assert
        mockMvc.perform(put("/libros/{id}",id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(libro)))
                        .andExpect(status().isOk());
    }
}

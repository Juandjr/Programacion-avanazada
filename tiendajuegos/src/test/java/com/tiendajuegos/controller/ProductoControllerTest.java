package com.tiendajuegos.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ProductoControllerTest {

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        // Inicializamos MockMvc manualmente apuntando al controlador.
        // Nota: Como estamos en TDD (Fase RED), ProductoController aún no existe o está vacío,
        // así que primero ve a crear la clase vacía 'ProductoController' para que no te dé error de compilación aquí.
        this.mockMvc = MockMvcBuilders.standaloneSetup(new ProductoController()).build();
    }

    @Test
    public void validarProducto_CuandoPrecioEsNegativo_DebeDevolverBadRequest() throws Exception {
        String productoJson = "{\"nombre\":\"Zelda: Tears of the Kingdom\", \"precio\": -10.00}";

        mockMvc.perform(post("/api/productos/validar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(productoJson))
                .andExpect(status().isBadRequest());
    }
}
package com.u3.lab1_JuanJ.controller;

import com.u3.lab1_JuanJ.model.Pedido;
import com.u3.lab1_JuanJ.service.PedidoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@WebMvcTest(PedidoController.class)
class PedidoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private PedidoService pedidoService;

    @Test
    void should_return_pedidos_pendientes() throws Exception {
        // Arrange: given(pedidoService.obtenerPorEstado("PENDIENTE"))
        given(pedidoService.obtenerPorEstado("PENDIENTE"))
                .willReturn(List.of(new Pedido(1L, "Ana", 25.0, "PENDIENTE")));

        // Act: mockMvc.perform(get("/api/pedidos").param("estado", "PENDIENTE"))
        var respuesta = mockMvc.perform(get("/api/pedidos").param("estado", "PENDIENTE"));

        // Assert: .andExpect(status().isOk()) .andExpect(jsonPath("$[0].cliente").value("Ana"))
        respuesta.andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].cliente").value("Ana"))
                .andExpect(jsonPath("$[0].estado").value("PENDIENTE"));
    }
}
package com.u3.lab1_JuanJ.controller;

import com.u3.lab1_JuanJ.model.Pedido;
import com.u3.lab1_JuanJ.service.PedidoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping
    public List<Pedido> porEstado(@RequestParam String estado) {
        return pedidoService.obtenerPorEstado(estado);
    }
}
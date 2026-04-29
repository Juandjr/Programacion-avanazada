package com.laboratorio.streams.controller;

import com.laboratorio.streams.model.Producto;
import com.laboratorio.streams.service.ProductoService;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService service;

    public ProductoController(ProductoService service) {
        this.service = service;
    }

    // Endpoint 1
    @GetMapping("/validos")
    public List<Producto> obtenerValidos() {
        return service.obtenerProductosValidos();
    }

    // Endpoint 2
    @GetMapping("/descuento")
    public List<Producto> descuento(@RequestParam double porcentaje) {
        return service.aplicarDescuentoTecnologia(porcentaje);
    }

    // Endpoint 3
    @GetMapping("/catalogo")
    public Map<String, List<String>> catalogo() {
        return service.generarCatalogoAgrupado();
    }
}
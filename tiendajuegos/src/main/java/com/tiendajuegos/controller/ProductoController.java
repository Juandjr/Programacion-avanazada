package com.tiendajuegos.controller;

import com.tiendajuegos.dto.ProductoDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @PostMapping("/validar")
    public ResponseEntity<String> validarProducto(@Valid @RequestBody ProductoDTO producto) {
        // Código mínimo: Si pasa la validación de Spring, devolvemos 200 OK por ahora
        return ResponseEntity.ok("Producto válido");
    }
}
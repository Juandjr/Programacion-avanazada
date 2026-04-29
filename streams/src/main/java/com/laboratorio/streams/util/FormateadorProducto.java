package com.laboratorio.streams.util;

import com.laboratorio.streams.model.Producto;

@FunctionalInterface
public interface FormateadorProducto {

    String formatear(Producto producto);

    static FormateadorProducto resumen() {
        return p -> String.format("[%s] %s - $%.2f (%d unidades)",
                p.getCategoria(),
                p.getNombre(),
                p.getPrecio(),
                p.getStock()
        );
    }

    static FormateadorProducto etiqueta() {
        return p -> String.format("SKU-%d: %s | %s",
                p.getId(),
                p.getNombre(),
                p.getCategoria()
        );
    }
}
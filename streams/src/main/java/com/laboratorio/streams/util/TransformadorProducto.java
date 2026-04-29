package com.laboratorio.streams.util;

import com.laboratorio.streams.model.Producto;

@FunctionalInterface
public interface TransformadorProducto {

    Producto transformar(Producto producto);

    static TransformadorProducto aplicarDescuento(double porcentaje) {
        return p -> {
            double nuevoPrecio = p.getPrecio() - (p.getPrecio() * porcentaje / 100);
            return new Producto(
                    p.getId(),
                    p.getNombre(),
                    p.getCategoria(),
                    nuevoPrecio,
                    p.getStock(),
                    p.getActivo()
            );
        };
    }

    static TransformadorProducto desactivar() {
        return p -> {
            p.setActivo(false);
            return p;
        };
    }
}
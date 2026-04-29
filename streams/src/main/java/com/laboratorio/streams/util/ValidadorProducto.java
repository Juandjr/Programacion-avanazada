package com.laboratorio.streams.util;

import com.laboratorio.streams.model.Producto;

@FunctionalInterface
public interface ValidadorProducto {

    boolean validar(Producto producto);

    default ValidadorProducto and(ValidadorProducto otro) {
        return p -> this.validar(p) && otro.validar(p);
    }

    static ValidadorProducto precioPositivo() {
        return p -> p.getPrecio() != null && p.getPrecio() > 0;
    }

    static ValidadorProducto stockMinimo(int minimo) {
        return p -> p.getStock() != null && p.getStock() >= minimo;
    }

    static ValidadorProducto activo() {
        return p -> Boolean.TRUE.equals(p.getActivo());
    }
}
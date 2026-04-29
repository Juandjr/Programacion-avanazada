package com.laboratorio.streams.service;

import com.laboratorio.streams.model.Producto;
import com.laboratorio.streams.repository.ProductoRepository;
import com.laboratorio.streams.util.*;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProductoService {

    private final ProductoRepository repo;

    public ProductoService(ProductoRepository repo) {
        this.repo = repo;
    }

    // Fase 2
    public List<Producto> obtenerProductosValidos() {
        ValidadorProducto validador = ValidadorProducto
                .precioPositivo()
                .and(ValidadorProducto.activo());

        return repo.findAll()
                .stream()
                .filter(validador::validar)
                .collect(Collectors.toList());
    }

    // Fase 3
    public List<Producto> aplicarDescuentoTecnologia(double porcentaje) {
        TransformadorProducto descuento = TransformadorProducto.aplicarDescuento(porcentaje);

        return repo.findAll()
                .stream()
                .filter(p -> "Tecnología".equalsIgnoreCase(p.getCategoria()))
                .map(descuento::transformar)
                .collect(Collectors.toList());
    }

    // Fase 4
    public Map<String, List<String>> generarCatalogoAgrupado() {
        FormateadorProducto fmt = FormateadorProducto.resumen();

        return repo.findAll()
                .stream()
                .collect(Collectors.groupingBy(
                        Producto::getCategoria,
                        Collectors.mapping(fmt::formatear, Collectors.toList())
                ));
    }
}
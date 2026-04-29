package com.laboratorio.streams.repository;

import com.laboratorio.streams.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}

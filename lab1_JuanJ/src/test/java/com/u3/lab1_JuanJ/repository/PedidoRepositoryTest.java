package com.u3.lab1_JuanJ.repository;

import com.u3.lab1_JuanJ.model.Pedido;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class PedidoRepositoryTest {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Test
    void should_find_pedidos_by_estado() {
        // Arrange: guarda 2 pedidos PENDIENTE y 1 pedido PAGADO
        Pedido pedido1 = new Pedido(null, "Carlos", 45.50, "PENDIENTE");
        Pedido pedido2 = new Pedido(null, "Luis", 12.00, "PENDIENTE");
        Pedido pedido3 = new Pedido(null, "Maria", 89.90, "PAGADO");

        pedidoRepository.save(pedido1);
        pedidoRepository.save(pedido2);
        pedidoRepository.save(pedido3);

        // Act: invoca pedidoRepository.findByEstado("PENDIENTE")
        List<Pedido> resultado = pedidoRepository.findByEstado("PENDIENTE");

        // Assert: verifica que el resultado contenga exactamente 2 pedidos
        assertThat(resultado).hasSize(2);
        assertThat(resultado).extracting(Pedido::getEstado).containsOnly("PENDIENTE");
    }
}
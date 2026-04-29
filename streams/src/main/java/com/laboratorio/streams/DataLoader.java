package com.laboratorio.streams;
import com.laboratorio.streams.model.Producto;
import com.laboratorio.streams.repository.ProductoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
public class DataLoader implements CommandLineRunner {
    private final ProductoRepository repo;
    public DataLoader(ProductoRepository repo) {
        this.repo = repo;
    }
    @Override
    public void run(String... args) {
        repo.saveAll(List.of(
                new Producto(null, "Laptop Pro", "Tecnología", 1299.99, 15, true),
                new Producto(null, "Mouse Gamer", "Tecnología", 49.99, 80, true),
                new Producto(null, "Teclado RGB", "Tecnología", 89.99, 50, true),
                new Producto(null, "Escritorio", "Muebles", 450.00, 10, true),
                new Producto(null, "Silla Ergon.", "Muebles", 320.00, 8, true),
                new Producto(null, "Monitor 4K", "Tecnología", 599.99, 25, true),
                new Producto(null, "Webcam HD", "Tecnología", 79.99, 40, false),
                new Producto(null, "Librero", "Muebles", 180.00, 5, false),
                new Producto(null, "Audífonos BT", "Audio", 129.99, 30, true),
                new Producto(null, "Bocina JBL", "Audio", 199.99, 20, true)
        ));
    }
}
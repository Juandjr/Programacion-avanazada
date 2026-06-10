package com.taller.tarea1.actividad2;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class ProcesadorOOP {

    public List<String> procesar(List<Producto> productos,
                                 Predicate<Producto> f,
                                 Function<Producto, String> t) {
        List<String> resultado = new ArrayList<>();
        for (Producto p : productos) {
            // Se utilizan los métodos estándar .test() y .apply()
            if (f.test(p)) {
                resultado.add(t.apply(p));
            }
        }
        return resultado;
    }

    public static void main(String[] args) {
        ProcesadorOOP proc = new ProcesadorOOP();
        List<Producto> lista = List.of(
                new Producto("Laptop", 1200),
                new Producto("Mouse", 25),
                new Producto("Monitor", 350)
        );

        // REQUISITO: Reemplazar clases anónimas por expresiones lambda
        List<String> caros = proc.procesar(lista,
                p -> p.precio() > 100,            // Lambda para Predicate<Producto>
                p -> p.nombre().toUpperCase()     // Lambda para Function<Producto, String>
        );
        System.out.println("Productos caros (en mayúsculas): " + caros);

        List<String> nombresDeBaratos = proc.procesar(lista,
                p -> p.precio() <= 100,
                Producto::nombre
        );
        System.out.println("Nombres de productos accesibles: " + nombresDeBaratos);
    }
}

record Producto(String nombre, double precio) {}
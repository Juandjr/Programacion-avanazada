package com.taller.tarea1.actividad3;

import java.util.List;

// REQUISITO: Interfaz funcional personalizada con la anotación correspondiente
@FunctionalInterface
interface CalculadoraTri {
    // Un único método abstracto que recibe monto y tasa, y devuelve el impuesto
    double calcular(double monto, double tasa);
}

// Representación de la Factura usando un record para mayor simplicidad
record Factura(String numero, double monto) {}

public class CalculadoraTributo {

    public static void main(String[] args) {
        // REQUISITO: Lista de 5 facturas
        List<Factura> facturas = List.of(
                new Factura("FAC-001", 1000.0),
                new Factura("FAC-002", 2500.50),
                new Factura("FAC-003", 500.0),
                new Factura("FAC-004", 4300.0),
                new Factura("FAC-005", 120.0)
        );

        // REQUISITO: Tres implementaciones distintas vía expresiones lambda
        CalculadoraTri calculadoraIVA = (monto, tasa) -> monto * 0.15;

        CalculadoraTri calculadoraRetencion = (monto, tasa) -> monto * 0.02;

        CalculadoraTri calculadoraVariable = (monto, tasa) -> monto * (tasa / 100);

        // REQUISITO: Invocación de cada implementación
        System.out.println("=== CÁLCULO DE IMPUESTOS SOBRE FACTURAS ===\n");

        for (Factura f : facturas) {
            System.out.printf("Factura: %s | Monto Base: $%.2f%n", f.numero(), f.monto());

            // Invocación 1: IVA 15% (Pasamos 0 de tasa porque la lambda ya lo tiene fijo)
            double iva = calculadoraIVA.calcular(f.monto(), 0);

            // Invocación 2: Retención 2% (Pasamos 0 de tasa por la misma razón)
            double retencion = calculadoraRetencion.calcular(f.monto(), 0);

            // Invocación 3: Impuesto Variable (En este ejemplo, aplicamos un impuesto de lujo del 8%)
            double tasaVariable = 8.0;
            double variable = calculadoraVariable.calcular(f.monto(), tasaVariable);

            // Mostrar resultados formateados

            System.out.printf("IVA (15%%): $%.2f%n", iva);
            System.out.printf("Retención (2%%): $%.2f%n", retencion);
            System.out.printf("Impuesto Variable (%.1f%%): $%.2f%n", tasaVariable, variable);
            System.out.println("===============================");
        }
    }
}
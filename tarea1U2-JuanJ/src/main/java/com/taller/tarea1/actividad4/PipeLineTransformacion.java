package com.taller.tarea1.actividad4;

import java.util.List;
import java.util.function.Function;

public class PipelineTransformacion {

    public static void main(String[] args) {
        List<String> nombres = List.of("   mArIa   ", "  jUAN  ", "pEdRo", "   aNa");

        // Operaciones base individuales
        Function<String, String> trim = String::trim;
        Function<String, String> toLowerCase = String::toLowerCase;
        Function<String, String> capitalize = s -> s.isEmpty() ? s : Character.toUpperCase(s.charAt(0)) + s.substring(1);

        // Nueva lógica: Se evalúa la última letra para decidir el prefijo
        Function<String, String> prependDinamico = s -> {
            if (s.isEmpty()) return s;
            // Si termina en 'a' (ignorando mayúsculas/minúsculas), es Sra., si no, Sr.
            String prefijo = s.toLowerCase().endsWith("a") ? "Sra. " : "Sr. ";
            return prefijo + s;
        };

        // CONFIGURACIÓN 1: Orden Lógico Correcto (andThen)
        Function<String, String> pipelineLogico = trim
                .andThen(toLowerCase)
                .andThen(capitalize)
                .andThen(prependDinamico);

        // CONFIGURACIÓN 2: Orden Alterado (compose)
        Function<String, String> pipelineAlterado = capitalize
                .compose(toLowerCase)
                .compose(trim)
                .compose(prependDinamico);

        // Ejecución y Muestra de Resultados
        System.out.println("### ORDEN LÓGICO (andThen) ###");
        for (String n : nombres) {
            System.out.println(pipelineLogico.apply(n));
        }

        System.out.println("\n### ORDEN ALTERADO (compose) ###");
        for (String n : nombres) {
            System.out.println(pipelineAlterado.apply(n));
        }
    }
}
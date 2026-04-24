package com.example.task1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorMensaje {

    private final ServicioMensaje servicioMensaje;

    public ControladorMensaje(ServicioMensaje servicioMensaje) {
        this.servicioMensaje = servicioMensaje;
    }

    @GetMapping("/mensaje")
    public String obtenerMensaje() {
        return servicioMensaje.obtenerMensaje();
    }

    @GetMapping("/error")
    public String generarError() {
        throw new RecursoNoEncontradoException("Recurso no encontrado");
    }
}

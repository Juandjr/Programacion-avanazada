package com.example.task1;

import org.springframework.stereotype.Service;

@Service
public class ServicioMensajeImpl implements ServicioMensaje {
    @Override
    public String obtenerMensaje() {
        return "Hola desde el servicio";
    }
}

package com.laboratorio.artifact.exception;

import java.time.LocalDateTime;
import java.util.Map;

public class ErrorResponse {

    private LocalDateTime timestamp;
    private int status;
    private String mensaje;
    private Map<String, String> detalles;
    private String path;

    // Constructor vacío
    public ErrorResponse() {}

    // Constructor completo
    public ErrorResponse(LocalDateTime timestamp, int status, String mensaje, 
                        Map<String, String> detalles, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.mensaje = mensaje;
        this.detalles = detalles;
        this.path = path;
    }

    // Constructor sin detalles
    public ErrorResponse(LocalDateTime timestamp, int status, String mensaje, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.mensaje = mensaje;
        this.path = path;
    }

    // Getters and Setters
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Map<String, String> getDetalles() {
        return detalles;
    }

    public void setDetalles(Map<String, String> detalles) {
        this.detalles = detalles;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}

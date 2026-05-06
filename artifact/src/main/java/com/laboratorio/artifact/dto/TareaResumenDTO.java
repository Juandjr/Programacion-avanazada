package com.laboratorio.artifact.dto;

public class TareaResumenDTO {

    private String estado;
    private Long cantidad;

    // Constructor vacío
    public TareaResumenDTO() {}

    // Constructor con parámetros
    public TareaResumenDTO(String estado, Long cantidad) {
        this.estado = estado;
        this.cantidad = cantidad;
    }

    // Getters and Setters
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }
}

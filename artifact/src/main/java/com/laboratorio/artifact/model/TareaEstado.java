package com.laboratorio.artifact.model;

public enum TareaEstado {
    PENDIENTE("Pendiente"),
    EN_PROGRESO("En Progreso"),
    COMPLETADA("Completada");

    private final String descripcion;

    TareaEstado(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}

package com.laboratorio.artifact.dto;

import com.laboratorio.artifact.model.TareaEstado;
import jakarta.validation.constraints.*;

public class TareaUpdateDTO {

    @NotBlank(message = "El título no puede estar en blanco")
    @Size(min = 3, max = 100, message = "El título debe tener entre 3 y 100 caracteres")
    private String titulo;

    @Size(max = 500, message = "La descripción no puede exceder 500 caracteres")
    private String descripcion;

    @NotNull(message = "El estado es requerido")
    private TareaEstado estado;

    @NotNull(message = "La prioridad es requerida")
    @Min(value = 1, message = "La prioridad mínima es 1")
    @Max(value = 5, message = "La prioridad máxima es 5")
    private Integer prioridad;

    // Constructor vacío
    public TareaUpdateDTO() {}

    // Constructor con parámetros
    public TareaUpdateDTO(String titulo, String descripcion, TareaEstado estado, Integer prioridad) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estado = estado;
        this.prioridad = prioridad;
    }

    // Getters and Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TareaEstado getEstado() {
        return estado;
    }

    public void setEstado(TareaEstado estado) {
        this.estado = estado;
    }

    public Integer getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Integer prioridad) {
        this.prioridad = prioridad;
    }
}

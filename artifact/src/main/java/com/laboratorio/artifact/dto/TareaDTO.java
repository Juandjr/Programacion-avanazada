package com.laboratorio.artifact.dto;

import com.laboratorio.artifact.model.TareaEstado;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

public class TareaDTO {

    private Long id;

    @NotBlank(message = "El título no puede estar en blanco")
    @Size(min = 3, max = 100, message = "El título debe tener entre 3 y 100 caracteres")
    private String titulo;

    @Size(max = 500, message = "La descripción no puede exceder 500 caracteres")
    private String descripcion;

    @NotNull(message = "El estado es requerido")
    private TareaEstado estado;

    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;

    @NotNull(message = "La prioridad es requerida")
    @Min(value = 1, message = "La prioridad mínima es 1")
    @Max(value = 5, message = "La prioridad máxima es 5")
    private Integer prioridad;

    // Constructor vacío
    public TareaDTO() {}

    // Constructor con parámetros
    public TareaDTO(Long id, String titulo, String descripcion, TareaEstado estado, 
                   LocalDateTime fechaCreacion, LocalDateTime fechaActualizacion, Integer prioridad) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
        this.prioridad = prioridad;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public Integer getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Integer prioridad) {
        this.prioridad = prioridad;
    }
}

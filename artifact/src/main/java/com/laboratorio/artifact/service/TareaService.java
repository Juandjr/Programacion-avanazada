package com.laboratorio.artifact.service;

import com.laboratorio.artifact.model.entity.Tarea;
import com.laboratorio.artifact.model.TareaEstado;
import com.laboratorio.artifact.dto.TareaDTO;
import com.laboratorio.artifact.dto.TareaCreateDTO;
import com.laboratorio.artifact.dto.TareaUpdateDTO;
import com.laboratorio.artifact.dto.TareaResumenDTO;
import com.laboratorio.artifact.repository.TareaRepository;
import com.laboratorio.artifact.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class TareaService {

    private final TareaRepository tareaRepository;

    public TareaService(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    // CRUD Operations
    public TareaDTO obtenerPorId(Long id) {
        Tarea tarea = tareaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tarea no encontrada con ID: " + id));
        return convertToDTO(tarea);
    }

    public List<TareaDTO> obtenerTodas() {
        return tareaRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Page<TareaDTO> obtenerTodas(Pageable pageable) {
        return tareaRepository.findAll(pageable)
                .map(this::convertToDTO);
    }

    public TareaDTO crear(TareaCreateDTO tareaCreateDTO) {
        Tarea tarea = new Tarea(
                tareaCreateDTO.getTitulo(),
                tareaCreateDTO.getDescripcion(),
                tareaCreateDTO.getEstado(),
                tareaCreateDTO.getPrioridad()
        );
        Tarea saved = tareaRepository.save(tarea);
        return convertToDTO(saved);
    }

    public TareaDTO actualizar(Long id, TareaUpdateDTO tareaUpdateDTO) {
        Tarea tarea = tareaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tarea no encontrada con ID: " + id));

        tarea.setTitulo(tareaUpdateDTO.getTitulo());
        tarea.setDescripcion(tareaUpdateDTO.getDescripcion());
        tarea.setEstado(tareaUpdateDTO.getEstado());
        tarea.setPrioridad(tareaUpdateDTO.getPrioridad());

        Tarea updated = tareaRepository.save(tarea);
        return convertToDTO(updated);
    }

    public void eliminar(Long id) {
        if (!tareaRepository.existsById(id)) {
            throw new ResourceNotFoundException("Tarea no encontrada con ID: " + id);
        }
        tareaRepository.deleteById(id);
    }

    // Business Operations
    public List<TareaDTO> obtenerPorEstado(TareaEstado estado) {
        return tareaRepository.findByEstado(estado).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Page<TareaDTO> obtenerPorEstado(TareaEstado estado, Pageable pageable) {
        return tareaRepository.findByEstado(estado, pageable)
                .map(this::convertToDTO);
    }

    public List<TareaDTO> obtenerPorEstadoOrdenado(TareaEstado estado) {
        return tareaRepository.findByEstadoOrdenado(estado).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Long contarPorEstado(TareaEstado estado) {
        return tareaRepository.countByEstado(estado);
    }

    public List<TareaDTO> buscarPorTitulo(String titulo) {
        return tareaRepository.findByTituloContainsIgnoreCase(titulo).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Page<TareaDTO> buscarPorTitulo(String titulo, Pageable pageable) {
        return tareaRepository.findByTituloContainsIgnoreCase(titulo, pageable)
                .map(this::convertToDTO);
    }

    public List<TareaResumenDTO> obtenerResumen() {
        List<Map<String, Object>> resultados = tareaRepository.obtenerResumenPorEstado();
        return resultados.stream()
                .map(r -> new TareaResumenDTO(
                        r.get("estado").toString(),
                        ((Number) r.get("cantidad")).longValue()
                ))
                .collect(Collectors.toList());
    }

    // Helper Methods
    private TareaDTO convertToDTO(Tarea tarea) {
        return new TareaDTO(
                tarea.getId(),
                tarea.getTitulo(),
                tarea.getDescripcion(),
                tarea.getEstado(),
                tarea.getFechaCreacion(),
                tarea.getFechaActualizacion(),
                tarea.getPrioridad()
        );
    }

    private Tarea convertToEntity(TareaCreateDTO dto) {
        return new Tarea(
                dto.getTitulo(),
                dto.getDescripcion(),
                dto.getEstado(),
                dto.getPrioridad()
        );
    }
}

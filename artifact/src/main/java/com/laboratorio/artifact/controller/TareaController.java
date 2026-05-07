package com.laboratorio.artifact.controller;

import com.laboratorio.artifact.dto.TareaDTO;
import com.laboratorio.artifact.dto.TareaCreateDTO;
import com.laboratorio.artifact.dto.TareaUpdateDTO;
import com.laboratorio.artifact.dto.TareaResumenDTO;
import com.laboratorio.artifact.model.TareaEstado;
import com.laboratorio.artifact.service.TareaService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tareas")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TareaController {

    private final TareaService tareaService;

    public TareaController(TareaService tareaService) {
        this.tareaService = tareaService;
    }

    // ========== CRUD BÁSICOS ==========
    @GetMapping
    public ResponseEntity<List<TareaDTO>> obtenerTodas() {
        List<TareaDTO> tareas = tareaService.obtenerTodas();
        return ResponseEntity.ok(tareas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TareaDTO> obtenerPorId(@PathVariable Long id) {
        TareaDTO tarea = tareaService.obtenerPorId(id);
        return ResponseEntity.ok(tarea);
    }

    @PostMapping
    public ResponseEntity<TareaDTO> crear(@Valid @RequestBody TareaCreateDTO tareaCreateDTO) {
        TareaDTO nuevaTarea = tareaService.crear(tareaCreateDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaTarea);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TareaDTO> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody TareaUpdateDTO tareaUpdateDTO) {
        TareaDTO tareaActualizada = tareaService.actualizar(id, tareaUpdateDTO);
        return ResponseEntity.ok(tareaActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        tareaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    // ========== ENDPOINTS ADICIONALES ==========
    @GetMapping("/filtro/estado")
    public ResponseEntity<List<TareaDTO>> obtenerPorEstado(
            @RequestParam TareaEstado estado) {
        List<TareaDTO> tareas = tareaService.obtenerPorEstado(estado);
        return ResponseEntity.ok(tareas);
    }

    @GetMapping("/filtro/estado-paginado")
    public ResponseEntity<Page<TareaDTO>> obtenerPorEstadoPaginado(
            @RequestParam TareaEstado estado,
            Pageable pageable) {
        Page<TareaDTO> tareas = tareaService.obtenerPorEstado(estado, pageable);
        return ResponseEntity.ok(tareas);
    }

    @GetMapping("/paginadas")
    public ResponseEntity<Page<TareaDTO>> obtenerTareasPaginadas(Pageable pageable) {
        Page<TareaDTO> tareas = tareaService.obtenerTodas(pageable);
        return ResponseEntity.ok(tareas);
    }

    @GetMapping("/resumen")
    public ResponseEntity<List<TareaResumenDTO>> obtenerResumen() {
        List<TareaResumenDTO> resumen = tareaService.obtenerResumen();
        return ResponseEntity.ok(resumen);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<TareaDTO>> buscarPorTitulo(
            @RequestParam String titulo) {
        List<TareaDTO> tareas = tareaService.buscarPorTitulo(titulo);
        return ResponseEntity.ok(tareas);
    }

    @GetMapping("/buscar-paginado")
    public ResponseEntity<Page<TareaDTO>> buscarPorTituloPaginado(
            @RequestParam String titulo,
            Pageable pageable) {
        Page<TareaDTO> tareas = tareaService.buscarPorTitulo(titulo, pageable);
        return ResponseEntity.ok(tareas);
    }
}

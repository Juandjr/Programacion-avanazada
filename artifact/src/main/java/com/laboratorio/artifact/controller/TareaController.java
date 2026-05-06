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

    /**
     * GET /api/tareas - Obtener todas las tareas
     * @return Lista de todas las tareas con código 200
     */
    @GetMapping
    public ResponseEntity<List<TareaDTO>> obtenerTodas() {
        List<TareaDTO> tareas = tareaService.obtenerTodas();
        return ResponseEntity.ok(tareas);
    }

    /**
     * GET /api/tareas/{id} - Obtener una tarea por ID
     * @param id ID de la tarea
     * @return Tarea encontrada con código 200 o 404 si no existe
     */
    @GetMapping("/{id}")
    public ResponseEntity<TareaDTO> obtenerPorId(@PathVariable Long id) {
        TareaDTO tarea = tareaService.obtenerPorId(id);
        return ResponseEntity.ok(tarea);
    }

    /**
     * POST /api/tareas - Crear una nueva tarea
     * @param tareaCreateDTO DTO con validaciones para crear tarea
     * @return Tarea creada con código 201
     */
    @PostMapping
    public ResponseEntity<TareaDTO> crear(@Valid @RequestBody TareaCreateDTO tareaCreateDTO) {
        TareaDTO nuevaTarea = tareaService.crear(tareaCreateDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaTarea);
    }

    /**
     * PUT /api/tareas/{id} - Actualizar una tarea existente
     * @param id ID de la tarea a actualizar
     * @param tareaUpdateDTO DTO con validaciones para actualizar tarea
     * @return Tarea actualizada con código 200
     */
    @PutMapping("/{id}")
    public ResponseEntity<TareaDTO> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody TareaUpdateDTO tareaUpdateDTO) {
        TareaDTO tareaActualizada = tareaService.actualizar(id, tareaUpdateDTO);
        return ResponseEntity.ok(tareaActualizada);
    }

    /**
     * DELETE /api/tareas/{id} - Eliminar una tarea
     * @param id ID de la tarea a eliminar
     * @return Código 204 (Sin contenido)
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        tareaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    // ========== ENDPOINTS ADICIONALES ==========

    /**
     * GET /api/tareas?estado=... - Filtrar tareas por estado
     * @param estado Estado de la tarea (PENDIENTE, EN_PROGRESO, COMPLETADA)
     * @return Lista de tareas filtradas con código 200
     */
    @GetMapping("/filtro/estado")
    public ResponseEntity<List<TareaDTO>> obtenerPorEstado(
            @RequestParam TareaEstado estado) {
        List<TareaDTO> tareas = tareaService.obtenerPorEstado(estado);
        return ResponseEntity.ok(tareas);
    }

    /**
     * GET /api/tareas?estado=...&page=0&size=5 - Filtrar con paginación
     * @param estado Estado de la tarea
     * @param pageable Información de paginación (page, size)
     * @return Página de tareas filtradas con código 200
     */
    @GetMapping("/filtro/estado-paginado")
    public ResponseEntity<Page<TareaDTO>> obtenerPorEstadoPaginado(
            @RequestParam TareaEstado estado,
            Pageable pageable) {
        Page<TareaDTO> tareas = tareaService.obtenerPorEstado(estado, pageable);
        return ResponseEntity.ok(tareas);
    }

    /**
     * GET /api/tareas/paginadas - Obtener todas las tareas con paginación
     * @param pageable Información de paginación (page, size)
     * @return Página de tareas con código 200
     */
    @GetMapping("/paginadas")
    public ResponseEntity<Page<TareaDTO>> obtenerTareasPaginadas(Pageable pageable) {
        Page<TareaDTO> tareas = tareaService.obtenerTodas(pageable);
        return ResponseEntity.ok(tareas);
    }

    /**
     * GET /api/tareas/resumen - Obtener resumen de tareas por estado
     * @return Resumen con conteo de tareas por estado con código 200
     */
    @GetMapping("/resumen")
    public ResponseEntity<List<TareaResumenDTO>> obtenerResumen() {
        List<TareaResumenDTO> resumen = tareaService.obtenerResumen();
        return ResponseEntity.ok(resumen);
    }

    /**
     * GET /api/tareas/buscar - Buscar tareas por título
     * @param titulo Título a buscar
     * @return Lista de tareas encontradas con código 200
     */
    @GetMapping("/buscar")
    public ResponseEntity<List<TareaDTO>> buscarPorTitulo(
            @RequestParam String titulo) {
        List<TareaDTO> tareas = tareaService.buscarPorTitulo(titulo);
        return ResponseEntity.ok(tareas);
    }

    /**
     * GET /api/tareas/buscar-paginado - Buscar tareas por título con paginación
     * @param titulo Título a buscar
     * @param pageable Información de paginación
     * @return Página de tareas encontradas con código 200
     */
    @GetMapping("/buscar-paginado")
    public ResponseEntity<Page<TareaDTO>> buscarPorTituloPaginado(
            @RequestParam String titulo,
            Pageable pageable) {
        Page<TareaDTO> tareas = tareaService.buscarPorTitulo(titulo, pageable);
        return ResponseEntity.ok(tareas);
    }
}

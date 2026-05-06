package com.laboratorio.artifact.repository;

import com.laboratorio.artifact.model.entity.Tarea;
import com.laboratorio.artifact.model.TareaEstado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Long> {

    // Consulta por convención
    List<Tarea> findByEstado(TareaEstado estado);

    Page<Tarea> findByEstado(TareaEstado estado, Pageable pageable);

    // Consulta personalizada con @Query
    @Query("SELECT t FROM Tarea t WHERE t.estado = :estado ORDER BY t.prioridad DESC, t.fechaCreacion DESC")
    List<Tarea> findByEstadoOrdenado(@Param("estado") TareaEstado estado);

    // Consulta para contar tareas por estado
    @Query("SELECT COUNT(t) FROM Tarea t WHERE t.estado = :estado")
    Long countByEstado(@Param("estado") TareaEstado estado);

    // Buscar por título (contiene)
    List<Tarea> findByTituloContainsIgnoreCase(String titulo);

    Page<Tarea> findByTituloContainsIgnoreCase(String titulo, Pageable pageable);

    // Consulta personalizada para obtener tareas por prioridad
    @Query("SELECT t FROM Tarea t WHERE t.prioridad >= :prioridad ORDER BY t.prioridad DESC")
    List<Tarea> findByPrioridadMinima(@Param("prioridad") Integer prioridad);

    // Consulta para resumen de tareas por estado
    @Query("SELECT new map(t.estado as estado, COUNT(t) as cantidad) FROM Tarea t GROUP BY t.estado")
    List<java.util.Map<String, Object>> obtenerResumenPorEstado();
}

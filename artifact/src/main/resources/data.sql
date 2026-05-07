INSERT INTO tareas
(titulo, descripcion, estado, prioridad, fecha_creacion, fecha_actualizacion)
VALUES
    ('Implementar login', 'Crear sistema de autenticación con Spring Security', 'PENDIENTE', 5, NOW(), NOW()),

    ('Diseñar base de datos', 'Crear esquema relacional para el proyecto', 'COMPLETADA', 4, NOW(), NOW()),

    ('Documentar API', 'Generar documentación Swagger para los endpoints', 'EN_PROGRESO', 3, NOW(), NOW()),

    ('Tarea actualizada', 'Descripción de la tarea', 'PENDIENTE', 3, NOW(), NOW()),

    ('Testing unitario', 'Escribir tests para servicios', 'PENDIENTE', 2, NOW(), NOW()),

    ('Optimizar consultas', 'Mejorar performance de queries a BD', 'EN_PROGRESO', 3, NOW(), NOW()),

    ('Crear reportes', 'Implementar generación de reportes en PDF', 'PENDIENTE', 2, NOW(), NOW()),

    ('Validar inputs', 'Agregar validaciones en todos los endpoints', 'COMPLETADA', 5, NOW(), NOW()),

    ('Integración con terceros', 'Conectar API con servicio externo de pagos', 'PENDIENTE', 4, NOW(), NOW()),

    ('Mejorar UI', 'Refactorizar componentes del frontend', 'EN_PROGRESO', 1, NOW(), NOW());
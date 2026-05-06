-- Script SQL Standalone para MySQL
-- Ejecutar este script en MySQL para crear la base de datos, tabla e insertar datos

-- 1. Crear la base de datos
CREATE DATABASE IF NOT EXISTS tareasdb;
USE tareasdb;

-- 2. Crear la tabla tareas
CREATE TABLE IF NOT EXISTS tareas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    descripcion TEXT,
    estado ENUM('PENDIENTE', 'EN_PROGRESO', 'COMPLETADA') DEFAULT 'PENDIENTE' NOT NULL,
    prioridad INT NOT NULL DEFAULT 1,
    fecha_creacion DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    fecha_actualizacion DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    KEY idx_estado (estado),
    KEY idx_prioridad (prioridad)
);

-- 3. Limpiar datos anteriores (opcional - comentar si no se desea)
-- TRUNCATE TABLE tareas;

-- 4. Insertar datos de prueba
INSERT INTO tareas (titulo, descripcion, estado, prioridad, fecha_creacion, fecha_actualizacion) VALUES
('Implementar login', 'Crear sistema de autenticación con Spring Security', 'PENDIENTE', 5, NOW(), NOW()),
('Diseñar base de datos', 'Crear esquema relacional para el proyecto', 'COMPLETADA', 4, NOW(), NOW()),
('Documentar API', 'Generar documentación Swagger para los endpoints', 'EN_PROGRESO', 3, NOW(), NOW()),
('Configurar CI/CD', 'Implementar pipeline en GitHub Actions', 'PENDIENTE', 4, NOW(), NOW()),
('Testing unitario', 'Escribir tests para servicios', 'PENDIENTE', 2, NOW(), NOW()),
('Optimizar consultas', 'Mejorar performance de queries a BD', 'EN_PROGRESO', 3, NOW(), NOW()),
('Crear reportes', 'Implementar generación de reportes en PDF', 'PENDIENTE', 2, NOW(), NOW()),
('Validar inputs', 'Agregar validaciones en todos los endpoints', 'COMPLETADA', 5, NOW(), NOW()),
('Integración con terceros', 'Conectar API con servicio externo de pagos', 'PENDIENTE', 4, NOW(), NOW()),
('Mejorar UI', 'Refactorizar componentes del frontend', 'EN_PROGRESO', 1, NOW(), NOW());

-- 5. Verificar datos insertados
SELECT * FROM tareas;

-- 6. Resumen de tareas por estado
SELECT estado, COUNT(*) as cantidad FROM tareas GROUP BY estado;

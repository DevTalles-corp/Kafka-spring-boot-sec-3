<!--
Version change: None (initial creation)
List of modified principles:
- Calidad del Código (Added)
- Arquitectura (Added)
- Convenciones de Código (Added)
- Convenciones de Repositorio (Added)
Added sections: Core Principles, Convenciones, Governance
Removed sections: None
Follow-up TODOs: RATIFICATION_DATE, Governance Rules
-->
# Bistro Constitution

## Core Principles

### I. Calidad del Código
Se debe aplicar SOLID y Clean Code en todo el proyecto. La separación de responsabilidades debe seguir un patrón de capas (controller, service, repository). El manejo global de excepciones debe implementarse con `@RestControllerAdvice` y `ProblemDetail` (RFC 7807). La validación de entrada debe realizarse con Bean Validation en los DTOs.

### II. Arquitectura
Se adoptará una arquitectura de monolito modular, resultando en un único artefacto desplegable con módulos que mantengan fronteras bien definidas. Los módulos se organizarán como sub-packages (ej., reservations, tables, notifications). Cada módulo debe encapsular su propio dominio, su repositorio y sus interfaces públicas.

## Convenciones

### I. Convenciones de Código
Los identificadores, clases y métodos deben estar escritos en inglés. Los comentarios, logs, mensajes de excepción y textos dirigidos al cliente deben estar en español. Los endpoints de la API deben estar versionados bajo `/api/v1/`. Se utilizarán DTOs para las solicitudes (requests) y respuestas (responses), nunca exponiendo directamente las entidades JPA. El mapeo entre entidades y DTOs se realizará mediante MapStruct.

### II. Convenciones de Repositorio
Los commits deben seguir el formato `clase-NN-slug`. El repositorio debe incluir un archivo `README.md` con instrucciones claras para iniciar el proyecto.

## Governance
TODO(GOVERNANCE_RULES): Define las reglas de gobernanza del proyecto, incluyendo el procedimiento de enmienda de esta constitución, la política de versionado y las expectativas de revisión de cumplimiento.

**Version**: 1.0.0 | **Ratified**: TODO(RATIFICATION_DATE) | **Last Amended**: 2026-08-13

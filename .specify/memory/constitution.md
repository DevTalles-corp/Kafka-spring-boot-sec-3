<!--
Version change: 1.0.0 → 1.1.0
List of modified principles:
- Ningún principio modificado (los cuatro principios rectores fueron reafirmados sin cambios)
Added sections:
- Governance: materializadas las reglas de gobernanza (procedimiento de enmienda, política de versionado y revisión de cumplimiento)
Removed sections: None
Resolved TODOs:
- RATIFICATION_DATE: establecido en 2026-08-13 (fecha de adopción del proyecto)
- GOVERNANCE_RULES: materializado en la sección Governance
Follow-up TODOs: None
-->
# Bistro Constitution

## Core Principles

### I. Calidad del Código

Se debe aplicar SOLID y Clean Code en todo el proyecto. La separación de responsabilidades debe seguir un patrón de capas por módulo.

**Estructura de paquetes DENTRO de cada módulo: exactamente `controller`, `service`, `repository` y `model`.** Cada uno con una única responsabilidad:

- `controller`: adaptadores de entrada HTTP (controllers), DTOs de request/response y mappers MapStruct.
- `service`: lógica de negocio y orquestación.
- `repository`: interfaces de acceso a datos (Spring Data).
- `model`: entidades JPA y enums del dominio.

NO usar `domain`, `application`, `api`, `infrastructure` ni capas de arquitectura hexagonal.

El manejo global de excepciones debe implementarse con `@RestControllerAdvice` y `ProblemDetail` (RFC 7807). La validación de entrada debe realizarse con Bean Validation en los DTOs.

### II. Arquitectura
Se adoptará una arquitectura de monolito modular, resultando en un único artefacto desplegable con módulos que mantengan fronteras bien definidas. Los módulos se organizarán como sub-packages (ej., reservations, tables, notifications). Cada módulo debe encapsular su propio dominio, su repositorio y sus interfaces públicas.

## Convenciones

### I. Convenciones de Código
Los identificadores, clases y métodos deben estar escritos en inglés. Los comentarios, logs, mensajes de excepción y textos dirigidos al cliente deben estar en español. Los endpoints de la API deben estar versionados bajo `/api/v1/`. Se utilizarán DTOs para las solicitudes (requests) y respuestas (responses), nunca exponiendo directamente las entidades JPA. El mapeo entre entidades y DTOs se realizará mediante MapStruct.

### II. Convenciones de Repositorio
Los commits deben seguir el formato `clase-NN-slug`. El repositorio debe incluir un archivo `README.md` con instrucciones claras para iniciar el proyecto.

## Governance

La presente constitución prevalece sobre cualquier otra práctica o convención del proyecto.

- **Procedimiento de enmienda**: Toda enmienda debe documentarse en este archivo mediante un Sync Impact Report y requiere aprobación explícita antes de aplicarse. Si el cambio afecta la compatibilidad de las convenciones vigentes, debe acompañarse de un plan de migración.
- **Política de versionado**: Se utiliza versionado semántico (MAJOR.MINOR.PATCH). MAJOR para eliminaciones o redefiniciones de principios de gobernanza; MINOR para nuevos principios o expansiones de guía; PATCH para aclaraciones, redacción o correcciones no sustanciales.
- **Revisión de cumplimiento**: Toda revisión de código y todo pull request deben verificar el cumplimiento de estos principios. La complejidad no justificada debe rechazarse y toda excepción debe justificarse explícitamente por escrito.

**Version**: 1.3.0 | **Ratified**: 2026-08-13 | **Last Amended**: 2026-08-13
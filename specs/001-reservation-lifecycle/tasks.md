# Tasks: Ciclo de Vida de una Reserva

## Phase 1: Setup

- [x] T001 Create Maven project skeleton
- [x] T002 Configure pom.xml with Spring Boot 4.1.0 + spring-boot-starter-webmvc
- [x] T003 Configure Lombok before MapStruct annotation processors
- [x] T004 Create BistroApplication.java
- [x] T005 Create application.yml with dev/prod profiles
- [x] T006 Create OpenApiConfig.java
- [x] T007 Create README.md

## Phase 2: Foundational

- [x] T008 Create Flyway migration V1__init.sql
- [x] T009 Create Table entity
- [x] T010 Create TableRepository with pessimistic lock
- [x] T011 Create TableService interface
- [x] T012 Create GlobalExceptionHandler
- [x] T013 Create ProblemDetailConfig
- [x] T014 Create data.sql seed

## Phase 3: User Story 1

- [x] T015 API test POST /api/v1/reservations
- [x] T016 Unit test ReservationService
- [x] T017 Create Reservation entity
- [x] T018 Create ReservationStatus enum
- [x] T019 Create ReservationRepository
- [x] T020 Create ReservationRequest DTO
- [x] T021 Create ReservationResponse DTO
- [x] T022 Create ReservationMapper
- [x] T023 Create ReservationNotFoundException
- [x] T024 Implement ReservationService
- [x] T025 Implement ReservationController POST
- [x] T026 Concurrency integration test

## Phase 4: User Story 2

- [x] T027 API test GET /api/v1/reservations/{code}
- [x] T028 Create ReservationStatusResponse DTO
- [x] T029 Add getReservationStatus to service/repo
- [x] T030 Implement ReservationController GET

## Phase 5: Polish

- [x] T031 Run quickstart S1-S6 end-to-end
- [x] T032 Verify constitution compliance
- [x] T033 Code cleanup

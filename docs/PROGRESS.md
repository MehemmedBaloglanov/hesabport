# HesabPort — İrəliləyiş jurnalı

## Hazırkı vəziyyət
- Son addım: V1 miqrasiyası (8 schema)
- Növbəti addım: ModularityTests + Shared Kernel (AggregateRoot, Identifier, DomainEvent)

## Qərarlar
- Build: Maven (wrapper 3.10.0) | Spring Boot 4.1.2 | Java 21
- DB: PostgreSQL 17, lokal port 5433 (5432-ni yerli PostgreSQL tutur)
- Miqrasiya: Flyway | Outbox: Spring Modulith JDBC (schema-initialization: true)
- Arxitektura: Modular monolith, hər modulda hexagonal struktur

## Jurnal
- 2026-10-29: Layihə yaradıldı, Docker + Testcontainers işləyir, health UP
- 2026-10-31: V1__create_schemas.sql
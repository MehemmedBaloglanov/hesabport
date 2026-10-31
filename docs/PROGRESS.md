# HesabPort — İrəliləyiş jurnalı

> Hər iş sessiyasının sonunda yenilənir. Yeni söhbətdə Claude əvvəlcə bu faylı oxuyur.

## Hazırkı vəziyyət
- Mərhələ: 1 — Təməl
- Son addım: ModularityTests (Spring Modulith verify + Documenter)
- Növbəti addım: Shared Kernel 1-ci hissə — `shared/package-info.java` (OPEN modul), `Identifier`, `UuidV7`, `UuidV7Test`
- Testlər: hamısı yaşıl (`.\mvnw.cmd test`) — contextLoads, ModularityTests

## Qərarlar
- Build: Maven (wrapper 3.10.0) | Spring Boot 4.1.2 | Java 21
- DB: PostgreSQL 17, lokal port 5433 (5432-ni yerli PostgreSQL tutur)
- Miqrasiya: Flyway (`src/main/resources/db/migration`)
- Outbox: Spring Modulith JDBC starter (JPA starter `ddl-auto: validate` ilə uyğun gəlmədi), `schema-initialization: true`
- Arxitektura: Modular monolith (Spring Modulith), hər modulda hexagonal struktur (domain / application / infrastructure)
- Hər bounded context öz DB schema-sına sahibdir: identity, clients, collection, calendar, intelligence, notifications, billing, audit
- ID-lər: tipli record-lar (`Identifier` interfeysi), UUID v7 — planlaşdırılıb
- `domain` paketləri Spring/JPA-dan asılı olmayacaq (gələcəkdə ArchUnit ilə yoxlanacaq)
- Commit formatı: `feat:`, `fix:`, `test:`, `docs:`, `chore:`

## Struktur
- `az.hesabport` — `HesabportApiApplication`
- `src/main/resources/db/migration` — `V1__create_schemas.sql`
- `src/test/.../ModularityTests` — modul sərhədləri yoxlaması
- `src/test/.../TestcontainersConfiguration` — testlərdə `postgres:17`

## Jurnal
- 2026-10-29: Layihə yaradıldı (start.spring.io, Maven); Maven/Guice xətası → Maven Wrapper
- 2026-10-29: Port toqquşması həll olundu (Docker → 5433); JPA → JDBC outbox; health UP; testlər yaşıl
- 2026-10-31: V1__create_schemas.sql (8 schema)
- 2026-10-31: ModularityTests

## Növbəti addımlar (sıra ilə)
1. Shared Kernel 1: `package-info.java` (OPEN), `Identifier`, `UuidV7`, `UuidV7Test`
2. Shared Kernel 2: `AggregateRoot`, `DomainEvent`, `DomainException`
3. ArchUnit: `domain` paketləri framework-dən asılı olmasın
4. Shared Kernel 3: value object-lər — `Money`, `Period`, `TaxId` (VÖEN), `PhoneNumber`
5. İlk modul: `clients` (Client aggregate, V2 miqrasiyası, repository, REST API)

## Açıq suallar
- Vergi son tarixləri qaydalarını kim təsdiqləyəcək? (mühasib-məsləhətçi)
- Hostinq: fərdi məlumatların ölkədə saxlanma tələbi (hüquqşünas)

## Müsahibələr (paralel)
| Tarix | Kim | Ağrı (1–5) | Əsas qeyd |
| --- | --- | --- | --- |
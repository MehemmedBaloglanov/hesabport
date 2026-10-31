# HesabPort API

Mühasibat büroları üçün sənəd toplama və vergi təqvimi platformasının backend-i.

## İşə salmaq
Tələblər: Java 21, Docker Desktop

    .\mvnw.cmd spring-boot:run    # PostgreSQL avtomatik qalxır (port 5433)
    .\mvnw.cmd test

Health: http://localhost:8080/actuator/health
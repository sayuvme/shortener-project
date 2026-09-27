# Shortener — Java/Spring Boot

Веб-приложение сервиса сокращения ссылок по приложенному пошаговому заданию. В отличие от исходного гайда проект реализован на **Java 17**, а не Kotlin.

## Стек
- Java 17
- Spring Boot 3.2.5
- Spring MVC
- Spring Data JPA / Hibernate
- Spring Security
- Thymeleaf
- PostgreSQL
- jQuery + Bootstrap

## База данных
Создайте PostgreSQL БД и пользователя:
```sql
CREATE DATABASE shortener;
CREATE USER shortener_user WITH PASSWORD 'shortener_pass';
GRANT ALL PRIVILEGES ON DATABASE shortener TO shortener_user;
ALTER DATABASE shortener OWNER TO shortener_user;
```

## Запуск
Требуется JDK 17+ и Maven 3.9+.

```bash
mvn spring-boot:run
```
Откройте http://localhost:8080

Регистрация: `/register`  
Вход: `/login`  
Личный кабинет: `/dashboard/links`

## REST API
- GET `/api/links`
- POST `/api/links`
- PUT `/api/links/{id}`
- DELETE `/api/links/{id}`

## Структура
Исходный код находится в `src/main/java/com/example/shortener`, ресурсы — в `src/main/resources`.

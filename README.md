# Demo Microservice

A simple Spring Boot microservice scaffold with production-ready features.

## Features

- Spring Boot 3.x
- REST endpoint (`/hello`)
- Actuator endpoints (`/actuator/health`, `/actuator/info`, `/actuator/metrics`)
- Centralized logging
- Basic test coverage

## Build & Run

```sh
mvn clean package
java -jar target/demo-microservice-0.0.1-SNAPSHOT.jar
```

## Endpoints

- `GET /hello` — Demo endpoint
- `GET /actuator/health` — Health check
- `GET /actuator/info` — Info
- `GET /actuator/metrics` — Metrics

## Configuration

See `src/main/resources/application.yml` for production-ready settings.
```

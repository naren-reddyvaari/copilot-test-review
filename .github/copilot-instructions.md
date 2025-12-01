# GitHub Copilot Instructions Template

## Purpose
These instructions guide GitHub Copilot to follow our project's coding standards, performance guidelines, and naming conventions.

## General Principles
- Write clean, readable, and maintainable code.
- Add meaningful comments for complex logic.
- Avoid hardcoded values; use constants or configuration files.

## Language & Framework
- Primary language: **Java**
- Frameworks: Spring Boot, Hibernate

## Naming Conventions
- Classes: PascalCase (e.g., `CustomerService`)
- Methods: camelCase (e.g., `calculateTotalAmount`)
- Constants: UPPER_CASE (e.g., `MAX_RETRY_COUNT`)
- Variables: descriptive camelCase (e.g., `customerList`)

## Performance Guidelines
- Prefer Java Streams for collection processing.
- Avoid nested loops; use efficient algorithms.
- Use pagination for database queries.
- Implement caching for frequently accessed data (e.g., Caffeine).
- Avoid string concatenation in loops; use `StringBuilder`.

## Security Practices
- Validate all user inputs.
- Use parameterized queries to prevent SQL injection.
- Do not log sensitive information.

## Logging
- Use parameterized logging (e.g., `logger.info("User {} logged in", username)`).
- Avoid excessive logging in performance-critical paths.

## Error Handling
- Use custom exceptions for business logic errors.
- Avoid swallowing exceptions; log and rethrow if necessary.

## Testing
- Write unit tests for all public methods.
- Use JUnit and Mockito for testing.

## When Suggesting Code
- Follow these guidelines strictly.
- If a rule conflicts, explain the trade-off in comments.
- Provide optimized and secure solutions.

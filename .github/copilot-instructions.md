# GitHub Copilot Instructions

This project follows global guidelines stored in a centralized repository:

- [Performance Guidelines](https://github.com/naren-reddyvaari/global-instructions/blob/main/global/performance.md)
- [General Guidelines](https://github.com/naren-reddyvaari/global-instructions/blob/main/global/general.md).
- [Naming Conventions](https://github.com/naren-reddyvaari/global-instructions/blob/main/global/naming.md)
- [Security Best Practices](https://github.com/naren-reddyvaari/global-instructions/blob/main/global/security.md)


## Key Rules (Summary)
- Use pagination for DB queries.
- Prefer `StringBuilder` for string concatenation.
- Do not log PII (see GDPR guidelines).
- Follow PascalCase for classes and camelCase for methods.
- Implement circuit breakers for external calls.
- Use parameterized logging (avoid string concatenation in logs).
- Validate all user inputs and avoid hardcoded secrets.

## How Copilot should behave
- Follow these rules when generating code, refactors, tests, or docs.
- Prefer efficient, secure, and maintainable solutions.
- If a rule must be relaxed, explain trade-offs in comments.
- When asked to *optimize* or *review*, propose diffs and reference affected files.

---

## Example Prompts for PR Reviews
- `@project Review this PR against performance and security guidelines.`
- `@project Check this PR for GDPR compliance and logging standards.`
- `@project Suggest improvements based on naming conventions and API design.`
- `@project Optimize database queries and caching per performance.md.`

---

For detailed rules, refer to the linked guideline files above.

# AGENTS.md - Developer Guidelines for This Repository

## Project Overview

This is a **Java Spring Boot** portfolio application using **Gradle** as the build tool. The project provides a REST API for a personal portfolio website.

## Technology Stack

- Java 25
- Spring Boot 4.0.3
- Gradle (Kotlin DSL)
- JUnit 5 (via Spring Boot Test)

---

## Build, Lint, and Test Commands

### Build Commands

```bash
# Build the project (compiles, tests, and packages)
./gradlew build

# Compile without running tests
./gradlew compileJava

# Compile test Java sources
./gradlew compileTestJava

# Package as JAR
./gradlew bootJar

# Clean build artifacts
./gradlew clean
```

### Test Commands

```bash
# Run all tests
./gradlew test

# Run a single test class
./gradlew test --tests "com.github.jirkasindelar323.Jirkasindelar323ApplicationTests"

# Run a single test method
./gradlew test --tests "com.github.jirkasindelar323.Jirkasindelar323ApplicationTests.contextLoads"

# Run tests with verbose output
./gradlew test --info

# Run tests in continuous mode (watch for changes)
./gradlew test --continuous

# Run only failed tests
./gradlew test --rerun
```

### Run Commands

```bash
# Run the application
./gradlew bootRun
```

### Other Commands

```bash
# Show dependency tree
./gradlew dependencies

# Generate IntelliJ project files
./gradlew idea

# Check for dependency updates
./gradlew dependencyUpdates
```

---

## Code Style Guidelines

### General Principles

- Use **4 spaces** for indentation (not tabs)
- Use **camelCase** for variable and method names
- Use **PascalCase** for class and interface names
- Use **UPPER_SNAKE_CASE** for constants
- Keep lines under **120 characters** when practical
- **No trailing whitespace**
- Use **Unix line endings** (LF)

### File Organization

- One public class per file
- File name must match the class name
- Package declaration at the top
- Follow this order within a file:
  1. Package declaration
  2. Import statements (grouped: java.*, javax.*, org.*, com.*)
  3. Class/interface declarations

### Naming Conventions

| Element | Convention | Example |
|---------|------------|---------|
| Classes | PascalCase | `PortfolioController` |
| Methods | camelCase | `getPersonalInfo()` |
| Variables | camelCase | `portfolioService` |
| Constants | UPPER_SNAKE_CASE | `MAX_RETRY_COUNT` |
| Packages | lowercase | `com.github.jirkasindelar323.service` |
| REST endpoints | kebab-case in URLs | `/api/projects` |

### Import Guidelines

- **Do not use wildcard imports** (e.g., `import java.util.*`)
- **Fully qualify** all imports
- **Group imports** in this order:
  1. Java standard library (`java.*`)
  2. javax packages
  3. Third-party libraries (`org.*`, `com.*`)
  4. Internal project packages
- **Sort alphabetically** within each group

```java
// Correct
import com.github.jirkasindelar323.model.Project;
import com.github.jirkasindelar323.service.PortfolioService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
```

### Type Usage

- **Prefer concrete types** over interfaces for simple DTOs
- Use **records** (Java 16+) for immutable DTOs when appropriate
- Use **generics** for type-safe collections
- Always specify generic types (no raw types)

```java
// Good
List<Project> projects = List.of(new Project(...));

// Avoid
List projects = new ArrayList();
```

### Spring Framework Conventions

- Use **constructor injection** for dependencies (not field injection)
- Use standard Spring annotations: `@Service`, `@RestController`, `@GetMapping`, etc.
- Follow RESTful URL patterns: `/api/resource-name`
- Use `@RequestMapping` at class level for shared path prefix

```java
// Good - Constructor injection
@RestController
@RequestMapping("/api")
public class PortfolioController {

    private final PortfolioService portfolioService;

    public PortfolioController(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }
}
```

### Error Handling

- Use appropriate HTTP status codes
- Return meaningful error messages
- Consider using `@ControllerAdvice` for global exception handling
- Log errors appropriately

### Records (for DTOs)

With Java 25 and Spring Boot, prefer records for immutable DTOs:

```java
public record Project(
    String name,
    String description,
    String techStack,
    String githubUrl,
    String liveUrl
) {}
```

### Test Conventions

- Place tests in `src/test/java` under the same package as the class being tested
- Use `@SpringBootTest` for integration tests
- Use `@Test` from JUnit 5 (`org.junit.jupiter.api.Test`)
- Name test methods descriptively: `shouldReturnProjectList()`

```java
@SpringBootTest
class PortfolioControllerTests {

    @Test
    void contextLoads() {
    }
}
```

---

## Project Structure

```
src/
├── main/
│   ├── java/com/github/jirkasindelar323/
│   │   ├── Jirkasindelar323Application.java  # Main entry point
│   │   ├── config/                            # Configuration classes
│   │   ├── controller/                        # REST controllers
│   │   ├── model/                             # DTOs/entities
│   │   └── service/                           # Business logic
│   └── resources/
│       └── application.yaml                   # App configuration
└── test/
    └── java/                                  # Test classes
```

---

## Notes for Agents

- **Always run tests** before committing changes (`./gradlew test`)
- **Verify the build** passes before considering work complete (`./gradlew build`)
- This project uses **Spring Boot 4.0.3** - be aware of any breaking changes from older versions
- The codebase is small - keep changes focused and minimal
- Use **constructor injection** exclusively for dependency injection
- **Check this file before starting work** and update it when things change

---

## Full-Stack Context

This backend is part of a complete portfolio website project:

| Component | Repository | Purpose |
|-----------|------------|---------|
| Frontend | github.com/jirkasindelar323/portfolio-frontend | React/TypeScript UI |
| Backend | portfolio (this repo) | API serving portfolio data |
| Deployment | Railway | Hosting both FE + BE |
| Secrets | GitHub Secrets + Railway Variables | API keys, tokens, config |

### Current Intentions & Plans
*(Update when working on new features)*

- **Frontend**: Display personal info, projects, and skills from backend API
- **Backend**: Serves data at `/api/info`, `/api/projects`, `/api/skills`
- **Deployment**: Both deployed on Railway with environment variables

### Synchronization Protocol
- When deploying: Note URL changes in this file
- When adding secrets: Document which service holds what (GitHub vs Railway)
- When creating new features: Note the intention and affected components

### API Contract (keep in sync with frontend)
```
GET /api/info → { name, pronunciation, title, bio, email, github, linkedin, location }
GET /api/projects → [{ name, description, techStack, githubUrl, liveUrl }]
GET /api/skills → [{ name, category, proficiency }]
```

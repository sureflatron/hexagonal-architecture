# Hexagonal Architecture Example

This project demonstrates the implementation of the Hexagonal Architecture (also known as Ports and Adapters pattern) in a Java-based application. It aims to create a loosely coupled architecture that separates the core logic of the application from external concerns like databases, web interfaces, or other communication protocols.

## Key Technologies

- **Java**: The primary programming language used for developing the application.
- **Spring Boot**: Simplifies the development of new Spring applications through convention over configuration. It's used for dependency injection, web layer, and data access configurations.
- **Maven**: A build automation tool used for managing project's build, reporting, and documentation from a central piece of information.
- **SQL**: Structured Query Language used for managing and manipulating the relational database.

## Hexagonal Architecture Overview

Hexagonal Architecture divides the application into inside and outside parts. The inside part consists of the application's business logic, while the outside part interacts with external agents like databases, web clients, or other services.

### Components

- **Domain Model**: Represents the business logic and business rules of the application.
- **Ports**: Interfaces that define the contract for the application's core logic to communicate with external agents.
    - **Inbound Ports**: Used by external agents to send commands or queries to the application (e.g., `UserService`).
    - **Outbound Ports**: Used by the application to communicate with external resources (e.g., `UserRepository`).
- **Adapters**: Implementations of the ports that translate between the external world and the application's core logic.
    - **Primary/Driving Adapters**: Interact with the application through inbound ports (e.g., REST controllers).
    - **Secondary/Driven Adapters**: Implement outbound ports to interact with external agents like databases (e.g., `JpaUserRepository`).
# Enhancements with DTOs, Pagination, HATEOAS, and ModelMapper

This project has been enhanced to include several advanced features that improve the API's functionality and userMysqlEntity experience. These enhancements include the use of Data Transfer Objects (DTOs), pagination, Hypermedia as the Engine of Application State (HATEOAS), and the ModelMapper library.

## Using DTOs

DTOs (Data Transfer Objects) are implemented to encapsulate the data and separate the presentation layer from the business logic. This approach ensures that the internal structure of the application remains secure and the data exposed to the client is controlled and potentially customized for different scenarios.

## Pagination

To improve the performance and usability of the API, pagination has been added to the userMysqlEntity listing endpoints. This allows clients to request a specific subset of data, reducing the amount of data transferred over the network and improving response times.

## HATEOAS

HATEOAS (Hypermedia as the Engine of Application State) is incorporated to make the API more discoverable and self-descriptive. It adds hyperlinks to the API responses, guiding the clients through the available actions without prior knowledge of the API structure.

## ModelMapper

The ModelMapper library is utilized to simplify the conversion between domain models and DTOs. This reduces the amount of boilerplate code required for object mapping and minimizes the risk of mapping errors, making the codebase cleaner and more maintainable.

## Updated Project Structure

The project structure has been updated to accommodate these enhancements:

- `src/main/java/com/kelsonthony/hexagonalarchitecture/hexagonalarchitectureexample/dtos`: Contains the DTOs used for data transfer between the API and clients.
- `src/main/java/com/kelsonthony/hexagonalarchitecture/hexagonalarchitectureexample/infrastructure/adapter/in`: Updated to include controllers that utilize DTOs, pagination, and HATEOAS.
- `src/main/java/com/kelsonthony/hexagonalarchitecture/hexagonalarchitectureexample/application/service`: Updated service implementations to use ModelMapper for object mapping.

## Running the Enhanced Application

The steps to run the application remain the same. Ensure Java and Maven are installed, clone the repository, navigate to the project directory, and execute:

```bash
mvn spring-boot:run
## Project Structure

- `src/main/java/com/kelsonthony/hexagonalarchitecture/hexagonalarchitectureexample/domain`: Contains the core business logic and models.
- `src/main/java/com/kelsonthony/hexagonalarchitecture/hexagonalarchitectureexample/domain/port/in`: Defines inbound ports.
- `src/main/java/com/kelsonthony/hexagonalarchitecture/hexagonalarchitectureexample/domain/port/out`: Defines outbound ports.
- `src/main/java/com/kelsonthony/hexagonalarchitecture/hexagonalarchitectureexample/infrastructure/adapter/out`: Contains implementations of outbound ports (secondary adapters).
- `src/main/java/com/kelsonthony/hexagonalarchitecture/hexagonalarchitectureexample/application/service`: Implements the inbound ports (primary adapters) and contains application services.

## Running the Application

Ensure you have Java and Maven installed. Clone the repository, navigate to the project directory, and run:

```bash
mvn spring-boot:run
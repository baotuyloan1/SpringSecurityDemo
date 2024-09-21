# Spring Security Demo Project

## Objective

This project is designed to showcase how to integrate **Spring Security** into a Spring Boot application to secure RESTful APIs. It includes basic functionalities such as authentication, authorization, and session/cookie management.

## Key Features

- **Authentication**: Implements Username and Password authentication using Spring Security.
- **Authorization**: Role-based access control (RBAC) to restrict access to specific APIs based on user roles (Admin, User).
- **JWT (JSON Web Token)**: Utilizes JWT for managing login sessions, authenticating requests, and securing APIs.
- **HTTP Security Configuration**: Configures Spring Security to protect RESTful endpoints and require authentication for secured APIs.
- **Exception Handling**: Manages and returns appropriate error messages when users attempt to access invalid or unauthorized endpoints.

## Technologies Used

- **Spring Boot**: Framework for building the application.
- **Spring Security**: Security framework for authentication and authorization.
- **JWT**: For token-based authentication.
- **Maven**: For dependency management.

## Getting Started

1. Clone the repository.
2. Navigate to the project directory.
3. Run the application using `mvn spring-boot:run`.
4. Access the APIs as per the provided documentation.

## Contributing

Contributions are welcome! Please create a pull request or open an issue for any enhancements or bug fixes.


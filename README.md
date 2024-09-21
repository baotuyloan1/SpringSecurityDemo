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

## Diagram

![img_8.png](img_8.png)
![img_9.png](img_9.png)
## Tutorial

1. if we use default config of spring security, we need to provide username and password for Basis Auth to use RestController ![img_3.png](img_3.png)
</br>  ![img_4.png](img_4.png) When we use base64 decode, we will receive ![img_5.png](img_5.png) user and the generated security password
</br>   **!!! IMPORTANT: It's just encoding to base64, not encrypting**
</br> If we don't use the generated security password, the response will return a 401 Unauthorized code ![img_2.png](img_2.png)
</br> if you want to modify username and password, just create a bean like this ![img_6.png](img_6.png)
</br> then use can use ![img_7.png](img_7.png) instead of use username and random password default.
## Discuss between encoding, encrypting and hashing function:
1. Encoding is a function is always possible to reverse somehow, it can be just a mathematical transformation that doesn't need a secret to be known and can revert it to find out the input
2. Encrypting is transforming an input into an output but to go back from the output to the input you always a secret. So not everyone is able to find out which was the input after encryption function.
It's still a transformation function. It's a particular encoding, but it implies that you always **need a secret** to go back to the input. The secret is something that not necessarily everyone knows
3. Hashing function: from an input you can always go to an output. But from the output, you can never by any means find the input again. Hash functions are the preferred way to store temporarily or permanently passwords

## IMPORTANT NOTE: SpringDataJpa for column with CamelCase: https://stackoverflow.com/questions/47316832/spring-data-jpa-naming-strategy-using-camel-case answered Jun 8, 2018 at 2:03 by asolakhyan
## Managing users
1. we do have only one authentication manager but can have one or multiple authentication providers
2. UserDetailService and PasswordEncoder are used in DaoAuthenticationProvider 
3. GrantedAuthority can be represented as either Authorities or Role
4. Authorities is an action (verb) that the user can do in your application (read, write, delete, execute...)
5. Role is a badge that's usually represented by a subject like admin, manager, client, visitor
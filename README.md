# JWT Authentication Tutorial

This Spring Boot application demonstrates JSON Web Token (JWT) authentication. It provides an API endpoint for authentication using JWT.

## Overview

The `HomeController` class is a Spring `@RestController` that handles incoming requests related to user authentication using JWT. It contains two endpoints:

1. **GET `/`**: Returns a welcome message indicating the start of the JWT Tutorial.

2. **POST `/authenticate`**: Accepts a `JwtRequest` containing a username and password. It authenticates the user's credentials using Spring Security's `AuthenticationManager`. If the credentials are valid, it generates a JWT token using the `JwtUtility` and returns it as a `JwtResponse`.

## Usage

### Home Endpoint
- Access the root endpoint (`/`) to receive a welcome message indicating the start of the JWT tutorial.

### Authentication Endpoint
- Use a POST request to `/authenticate` with a JSON body containing `username` and `password` fields in a `JwtRequest`.
- If the credentials are valid, the endpoint generates a JWT token using the `JwtUtility` and returns it wrapped in a `JwtResponse`.

## Components

- **MyUserDetailsService**: A service responsible for fetching user details from a data source.
- **JwtUtility**: A utility class to handle JWT token generation and parsing.
- **AuthenticationManager**: Provided by Spring Security for user authentication.

## How to Use

1. **Integration**: Integrate this service into your application to enable JWT-based authentication.
2. **Authentication**: Send a POST request to `/authenticate` with valid user credentials in the `JwtRequest` body.
3. **Token Handling**: Upon successful authentication, retrieve the JWT token from the `JwtResponse` for subsequent authorized requests.

## Contributing

Contributions to enhance security, add more endpoints, or improve functionality are welcome. Feel free to fork this repository, make changes, and create a pull request.

## License

This project is licensed under the [MIT License](LICENSE).


# JWTdemo

making a request to genrate a token and using the token to access a protected route 



![Screenshot (83)](https://user-images.githubusercontent.com/38097150/129947163-02877435-1d07-43fe-bd9d-aa59b9072489.png)
![Screenshot (84)](https://user-images.githubusercontent.com/38097150/129947176-0358d2da-66ef-420d-b472-881842260dc0.png)

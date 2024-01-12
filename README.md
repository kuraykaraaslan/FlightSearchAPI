![Amedeus Logo](static/logo.jpg)

# Amadeus API

The Amadeus API is a Spring Boot application designed to facilitate the search and retrieval of flight information. It provides a RESTful API that allows users to perform various operations related to flights and airports.

## Table of Contents

- [Project Information](#project-information)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [Configuration](#configuration)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Project Information

- **Group ID:** com.amadeus
- **Artifact ID:** Amadeus
- **Version:** 0.0.1
- **Java Version:** 21

## Prerequisites

- Java Development Kit (JDK) 21
- Apache Maven
- PostgreSQL Database (or another supported database)

## Getting Started

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/Amadeus.git
   cd Amadeus

2. Build the project:

   ```bash
   mvn clean install

3. Run the project:

   ```bash
    mvn spring-boot:run

## Configuration

The Amadeus API uses the following environment variables:

| Variable Name | Description | Default Value |
| ------------- | ----------- | ------------- |
| `AMADEUS_DB_URL` | The URL of the database | `jdbc:postgresql://localhost:5432/amadeus` |
| `AMADEUS_DB_USERNAME` | The username of the database | `postgres` |
| `AMADEUS_DB_PASSWORD` | The password of the database | `postgres` |

## Usage

The Amadeus API provides a RESTful API that allows users to perform various operations related to flights and airports.

### Endpoints

| Endpoint | Description |
| -------- | ----------- |
| `GET /airports` | Returns a list of all airports |
| `GET /airports/{id}` | Returns the airport with the specified ID |
| `GET /airports/{id}/flights` | Returns a list of all flights departing from the airport with the specified ID |
| `GET /flights` | Returns a list of all flights |
| `GET /flights/{id}` | Returns the flight with the specified ID |
| `GET /flights/{id}/airports` | Returns a list of all airports that the flight with the specified ID departs from and arrives at |

### Examples

#### Get all airports

```bash
curl http://localhost:8080/airports
```

#### Get an airport by ID

```bash
curl http://localhost:8080/airports/1
```

#### Get all flights departing from an airport

```bash
curl http://localhost:8080/airports/1/flights
```

#### Get all flights

```bash
curl http://localhost:8080/flights
```

#### Get a flight by ID

```bash
curl http://localhost:8080/flights/1
```

#### Get all airports that a flight departs from and arrives at

```bash
curl http://localhost:8080/flights/1/airports
```

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## License

This project is licensed under the terms of the [MIT License](LICENSE).


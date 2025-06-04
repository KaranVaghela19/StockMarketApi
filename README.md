# Stock Market API - Spring Boot Application
This Spring Boot application provides real-time stock market data using the TwelveData API. It supports multiple stock symbols, calculates percentage change, and includes Swagger API documentation.

## Features
- Fetch live stock data
- Calculate percentage change (Open → Close)
- RESTful API endpoints
- Spring Security for authentication
- Swagger UI for API docs
- Caching with Caffeine

## Technology Used
- Java 17+
- Spring Boot 3.x
- Spring Web
- Spring Security
- Springdoc OpenAPI
- Caffeine Cache
- TwelveData API
- Maven

## Prerequisites
- Java 17 or higher
- Maven
- Internet (for API calls)

## How to Run locally
- Clone the repo
git clone https://github.com/KaranVaghela19/StockMarketApi.git

-cd your repo

# Build the project
mvn clean install

# Run the application
mvn spring-boot:run

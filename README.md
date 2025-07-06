# MLB Team Stats Tracker

This Spring Boot application tracks MLB team standings in real time by integrating with the MLB Stats API. It uses a PostgreSQL database to store team statistics and supports automated updates via a message queue.

Features
- REST API to send or retrieve team data (POST /mq/send, GET /teams)
- ActiveMQ Integration: Triggers automated stats updates using a message queue
- External API Calls: Pulls live standings data from MLB’s Stats API
- Flyway Migrations: Automatically creates and updates the teams table on app startup
- JPA Repository: Simplified interaction with the database using TeamsRepo
- PostgreSQL Support: Stores team names, win/loss records, and win percentage

Tech Stack
- Java 17
- Spring Boot
- PostgreSQL
- ActiveMQ
- Flyway
- JSON (org.json)
- JPA/Hibernate

How It Works
- Database Setup: teams table is automatically created using Flyway migrations.
- API Request: Send a POST request to /mq/send with "update" or a game ID to trigger an update.
- Message Queue: ActiveMQ listens for the message and routes it to a consumer.
- Data Fetch: The consumer calls the MLB Stats API and updates the database with current standings.
- Data Access: Use GET /teams to view the latest team data.

Example
- POST http://localhost:8080/mq/send
- Body: "update"

This triggers a fetch from the MLB API and stores the latest win/loss records in the database.

Getting Started
- Clone the repo: git clone https://github.com/matthewkrakower/summerproject.git
- Set up PostgreSQL and create a baseball database.
- Configure application.properties with your database credentials and ActiveMQ broker.
- Run the app: ./mvnw spring-boot:run

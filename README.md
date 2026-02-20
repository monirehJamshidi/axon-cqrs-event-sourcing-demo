# Axon CQRS Event Sourcing Demo


This project demonstrates a CQRS + Event Sourcing architecture implemented using Spring Boot and Axon Framework with separated Command (Write) and Query (Read) microservices.

The system manages a simple Person domain while showcasing production-level architectural patterns such as event-driven communication, projections, and eventual consistency.



## 🧠 Architecture Overview

The system is split into two independent microservices:

axon-cqrs-event-sourcing-demo ├── person-command-service └── person-query-service

## ✅ Command Service (Write Side)

- Handles commands

- Contains Aggregate and business rules

- Stores events in Event Store

- Publishes domain events

## ✅ Query Service (Read Side)

- Builds read model using projections

- Handles queries via QueryGateway

- Optimized for fast data retrieval

## ⚙️ Technologies

- Java

- Spring Boot

- Axon Framework

- CQRS

- Event Sourcing

- REST APIs

- Lombok
 Transaction Demo API

 Overview

This project demonstrates transaction management in Spring Boot using a simple banking scenario.

The application allows creating users and accounts, depositing and withdrawing money, and transferring funds between accounts. The main goal is to demonstrate how `@Transactional` guarantees data consistency when a failure occurs during a money transfer.

 Features

 Create users
 Create bank accounts
 Deposit money
 Withdraw money
 Transfer money between accounts
 Transaction rollback demonstration
 Global exception handling
 DTO-based API responses
 Bean Validation
 Unit tests with JUnit and Mockito

 Technologies

 Java 21
 Spring Boot
 Spring Data JPA
 PostgreSQL
 Hibernate
 Maven
 JUnit 5
 Mockito

 Transaction Example

The transfer operation is transactional.

If an exception occurs after withdrawing money from the sender but before depositing it into the receiver's account, the transaction is rolled back and both account balances remain unchanged.

 API Endpoints

 Users

 POST `/api/users`
 GET `/api/users`
 GET `/api/users/{id}`

 Accounts

 POST `/api/users/{userId}/accounts`
 POST `/api/{id}/deposit/{amount}`
 POST `/api/{id}/withdraw/{amount}`
 GET `/api/{id}/balance`

 Transfers

 POST `/api/transfers`

 Running the Project

Requirements:

 Java 21
 PostgreSQL

Clone the repository and configure the database connection in `application.properties`.

Run:


mvn spring-boot:run

 Learning Goals

This project focuses on:

 Spring transactions
 Rollback behavior
 Service layer design
 Exception handling
 Entity relationships
 DTO mapping

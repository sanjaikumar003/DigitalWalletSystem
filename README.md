# 💳 Digital Wallet System

A Spring Boot based Digital Wallet backend system that allows users to securely manage wallet transactions.

Users can:
- Register a user account
- Login using JWT authentication
- Add money to wallet
- Transfer money between users
- Check wallet balance
- Record transactions

---

## 🛠 Tech Stack

- Java 17
- Spring Boot 3
- Spring Data JPA
- Hibernate
- Spring Security
- JWT Authentication
- BCrypt Password Encryption
- MySQL
- Swagger (OpenAPI)
- Maven
- JUnit & Mockito

---

## 🚀 Features

- User Registration
- Secure Login (JWT)
- Wallet Auto Creation
- Add Money to Wallet
- Transfer Money Between Users
- Check Wallet Balance
- Transaction Recording
- DTO Pattern
- Validation & Error Handling
- REST APIs documented using Swagger

---

## 📌 API Endpoints

### User
POST /users

### Authentication
POST /auth/login

### Wallet
POST /wallet/add  
POST /wallet/transfer  
GET /wallet/{userId}

---

## 🧠 Concepts Implemented

- Layered Architecture (Controller → Service → Repository)
- DTO Pattern
- Transaction Management (@Transactional)
- Password Encryption (BCrypt)
- JWT Authentication
- REST API Design
- Swagger Documentation
- Database Relationships
- Unit Testing (Mockito + JUnit)

---

## 📘 API Documentation

Swagger UI

http://localhost:8082/swagger-ui/index.html

---

## ▶ Run Project

Clone repository

git clone https://github.com/sanjaikumar003/DigitalWalletSystem.git

Go to project folder

cd DigitalWalletSystem

Run application

./mvnw spring-boot:run

Application runs on

http://localhost:8082
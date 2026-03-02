# 💳 Digital Wallet System

A Spring Boot based Digital Wallet backend system that allows users to:

- Create users
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
- MySQL
- Swagger (OpenAPI)
- Maven

---

## 🚀 Features

- User Creation
- Wallet Auto Creation
- Add Money
- Transfer Money
- Transaction Recording
- Validation & Error Handling
- REST APIs documented using Swagger

---

## 📌 API Endpoints

### User
POST /users

### Wallet
POST /wallet/add  
POST /wallet/transfer  
GET /wallet/{userId}

---

## 🧠 Concepts Implemented

- Layered Architecture (Controller → Service → Repository)
- DTO Pattern
- Transaction Management (@Transactional)
- REST API Design
- Swagger Documentation
- Database Relationships

---

## ▶ Run Project

```bash
./mvnw spring-boot:run
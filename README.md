# 🛒 Java Spring E-commerce

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=JSON%20web%20tokens)

A **simple E-commerce application** developed with **Java 21** and **Spring Boot**, utilizing a **monolithic architecture** with a focus on best practices, layer separation, and the use of DTOs (Data Transfer Objects).
The project includes user registration, product management, shopping carts, and order processing, with persistence in a **PostgreSQL** relational database.

---

## 📌 Features

### 👤 Users

- User registration
- Access profiles (USER / ADMIN)
- Structure prepared for Spring Security authentication

### 📦 Products

- Product registration
- Product listing
- Updates and deletions
- Inventory/Stock control

### 🧺 Shopping Cart

- Add products to the cart
- Update quantities
- Remove products
- View cart contents

### 📑 Orders

- Create orders from the shopping cart
- Total value calculation
- Order history per user

---

## 🛠️ Technologies Used

- **Java 21**
- **Spring Boot**
- **Spring Web**
- **Spring Data JPA**
- **Spring Security**
- **PostgreSQL**
- **Gradle (Groovy DSL)**
- **Hibernate**
- **REST API**
- **DTO Pattern**

---

## 🏗️ Architecture

The project follows a **layered monolithic architecture**, adhering to industry best practices:
**Controller → Service → Repository → Database**

### 📂 Package Structure

```shell
com.example.javaspringecommerce
│
├── config      # Configurations (Security, Beans, etc.)
├── controller  # REST Controllers
├── domain      # JPA Entities
├── dto         # Data Transfer Objects
├── repository  # JPA Repositories
├── service     # Business Logic
└── EcommerceApplication.java
```









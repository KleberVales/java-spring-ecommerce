# 🛒 Java Spring E-commerce

Aplicação **E-commerce simples** desenvolvida com **Java 21** e **Spring Boot**, utilizando arquitetura **monolítica**, com foco em boas práticas, separação de camadas e uso de DTOs.

O projeto contempla cadastro de usuários, produtos, carrinho de compras e pedidos, com persistência em banco de dados relacional **PostgreSQL**.

## 📌 Funcionalidades

### 👤 Usuários

- Cadastro de usuário
- Perfis de acesso (USER / ADMIN)
- Estrutura preparada para autenticação com Spring Security

### 📦 Produtos

- Cadastro de produtos
- Listagem de produtos
- Atualização e remoção
- Controle de estoque

### 🧺 Carrinho de Compras

- Adicionar produto ao carrinho
- Atualizar quantidade
- Remover produto
- Visualizar carrinho

### 📑 Pedidos

- Criação de pedidos a partir do carrinho
- Cálculo do valor total
- Histórico de pedidos por usuário

---

## 🛠️ Tecnologias Utilizadas

- **Java 21**
- **Spring Boot**
- **Spring Web**
- **Spring Data JPA**
- **Spring Security** (em evolução)
- **PostgreSQL**
- **Gradle (Groovy DSL)**
- **Hibernate**
- **REST API**
- **DTO Pattern**
  
---

## 🏗️ Arquitetura

Projeto **monolítico em camadas**, seguindo boas práticas:
controller → service → repository → database,

### 📂 Estrutura de Pacotes


```shell


com.example.javaspringecommerce
│
├── config # Configurações (Security, Beans, etc)
├── controller # Controllers REST
├── domain # Entidades JPA
├── dto # Data Transfer Objects
├── repository # Repositórios JPA
├── service # Regras de negócio
└── EcommerceApplication.java

```

---

## 🗄️ Banco de Dados

### PostgreSQL

Configuração em `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/ecommerce
spring.datasource.username=postgres
spring.datasource.password=postgres

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```


---

- Simple E-commerce System

    - Product registration, shopping cart, and order management.

    - Integration with relational databases (Postgres).

    - Ability to add authentication and user profiles.

# 🍝 Sapore d'Italia - Console Restaurant Management App

Welcome to **Sapore d'Italia** — a simple Java-based console application simulating a restaurant ordering system. It demonstrates fundamental **Object-Oriented Programming (OOP)** concepts, **JDBC** integration with **PostgreSQL**, and basic **CRUD** operations for menu items, users, and orders.

## 📌 Features

- View restaurant menu items  
- Add, update, and delete dishes from the menu  
- Create, update, and remove users  
- Place and manage orders  
- VIP user support and balance tracking  
- All data is stored and managed in a **PostgreSQL** database

## 🛠️ Technologies Used

- **Java**
- **PostgreSQL**
- **JDBC (Java Database Connectivity)**
- OOP Principles: Inheritance, Encapsulation, Abstraction
- Console-based UI using `Scanner`
- Design pattern: **Mediator Pattern**

## 🗄️ Database Tables

The application automatically creates the following tables in PostgreSQL:

- **Users**: stores name, balance, and VIP status  
- **Menu**: stores dish name, price, description, and preparation time  
- **Orders**: links users with dishes, quantity, cost, and cooking timer

## 🚀 Getting Started

### Prerequisites

- Java 17+ installed
- PostgreSQL installed and running
- PostgreSQL JDBC driver added to classpath

### Setup

1. Clone the repository or copy the project files  
2. Set up your PostgreSQL database (default DB name: `postgres`)  
3. Update DB credentials in `ItalianRestaurant.java` if needed:

```java
private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/postgres";
private static final String USERNAME = "postgres";
private static final String PASSWORD = "0000";
This project was created as a learning experience for:

Practicing Java OOP

Understanding basic database interaction with JDBC

Learning console UI development

Implementing a simple Mediator pattern

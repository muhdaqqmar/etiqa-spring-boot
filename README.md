# 📚 Spring Boot API

A Spring Boot RESTful API built for **customer, product, and order management** with PostgreSQL. This project demonstrates clean architecture using **Spring Boot 3.5.5**, **JPA/Hibernate**, **PostgreSQL**, and **Swagger/OpenAPI** documentation.

---

## 🚀 Features
- **Customer Management**: Create, update, patch, and retrieve customers.
- **Family Members**: Link family members to customers.
- **Product Management**: Manage products (CRUD operations).
- **Order Management**: Place and update orders linking customers and products.
- **Validation & Error Handling**: Centralized exception handling with validation messages.
- **Swagger Documentation**: API docs available at `/swagger-ui.html`.
- **Dockerized Database**: PostgreSQL via Docker Compose.

---

## 🏗 Architecture Overview

**Layers**
- **Entities** → `Customer`, `Product`, `Orders`, `FamilyMember`
- **DTOs** → `OrderDTO`, `FamilyMemberDTO`, `FetchDataDTO`
- **Repositories** → Spring Data JPA (`CustomerRepository`, `ProductRepository`, `OrdersRepository`, `FamilyMembersRepository`)
- **Services** → Business logic (`CustomerService`, `ProductService`, `OrderService`)
- **Controllers** → REST endpoints (`CustomerController`, `ProductController`, `OrderController`)
- **Exceptions** → `ResourceNotFoundException`, `GlobalExceptionHandler`
- **Config** → `swaggerConfig`

---

## ⚙️ Tech Stack
- **Java 17**
- **Spring Boot 3.5.5**
- **Spring Data JPA**
- **PostgreSQL 15** (via Docker Compose)
- **SpringDoc OpenAPI 2.8.11**
- **Lombok**
- **Maven**

---

## 🗄 Database Setup

### Run PostgreSQL with Docker Compose
```bash
docker-compose up -d
```

**Database Config (`application.properties`)**
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/books
spring.datasource.username=app
spring.datasource.password=password
```

---

## ▶️ Running the Application

### 1. Clone the repository
```bash
git clone https://github.com/muhdaqqmar/etiqa-spring-boot.git
cd etiqa-spring-boot
```

### 2. Build the project
```bash
mvn clean install
```

### 3. Run the application
```bash
mvn spring-boot:run
```

Application will start at:
```
http://localhost:8080
```

Swagger API Docs:
```
http://localhost:8080/swagger-ui.html
```

---

## 📖 API Endpoints

### Customers (`/api/v1/customer`)
- `GET /` → Get all customers
- `GET /{id}` → Get customer by ID
- `POST /` → Create customer
- `PUT /{id}` → Update customer
- `PATCH /{id}` → Partially update customer
- `GET /familyMembers/{id}` → Get family members of a customer
- `POST /{customerId}/family-members` → Add family member

### Products (`/api/v1/product`)
- `GET /` → Get all products
- `GET /{id}` → Get product by ID
- `POST /` → Create product
- `PUT /{id}` → Update product
- `PATCH /{id}` → Partially update product

### Orders (`/api/v1/orders`)
- `GET /` → Get all orders
- `GET /{id}` → Get order by ID
- `POST /` → Create order
- `PUT /{id}` → Update order
- `PATCH /{id}` → Partially update order

---

## ⚠️ Error Handling
- **404 Not Found** → Returned when entity (Customer/Product/Order) does not exist.
- **400 Bad Request** → Validation errors (e.g., missing required fields).
- **500 Internal Server Error** → Generic server error with message.

Handled centrally via `GlobalExceptionHandler`.

---

## 🔮 Future Improvements
- ✅ Add unit & integration tests.
- ✅ Implement pagination for large datasets.
- ✅ Secure endpoints with Spring Security & JWT.
- ✅ Add CI/CD pipeline.

---

👨‍💻 Developed by **Muhammad Aqqmar**


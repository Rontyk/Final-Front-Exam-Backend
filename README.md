# Front Final Backend API

This project is a backend API for an e-commerce application. It provides functionality for user management, product browsing, orders, wishlist management, and reviews.

---

## **Technologies Used**

- **Java 21**: Programming language.
- **Spring Boot**: Framework for application development.
- **Spring Security**: For authentication and authorization.
- **JWT**: For secure token-based authentication.
- **Hibernate/JPA**: For database interactions.
- **PostgreSQL**: Database.
- **Lombok**: To reduce boilerplate code.
- **Gradle**: Build tool.

---

## **Features**

### **User Management**
- Register and login using JWT-based authentication.
- Role-based access control (ADMIN, USER).

### **Product Management**
- List products by category.
- View product details, including reviews and ratings.

### **Orders**
- Users can create orders from their wishlist.
- View order details, including the status, products, and total price.
- Users can only view their own orders.

### **Wishlist**
- Add products to the wishlist.
- Convert the wishlist to an order.

### **Reviews**
- Add reviews and ratings for products.
- View product reviews and average ratings.

---

## **Setup Instructions**

### **Prerequisites**

- Java 21 installed.
- PostgreSQL database.
- Gradle installed.

### **Installation**

1. Clone the repository:
   ```bash
   git clone https://github.com/Rontyk/Final-Front-Exam-Backend.git
   cd Final-Front-Exam-Backend
   ```

2. Configure the database:
   - Update `application.properties` with your PostgreSQL credentials.
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/final-exam
   spring.datasource.username=user
   spring.datasource.password=123
   ```


### **Database Initialization**

- Use the provided SQL scripts in the `src/main/resources/db` directory to initialize your database schema and insert mock data.

---

## **API Endpoints**

### **Authentication**

- **POST** `/auth/register`: Register a new user.
- **POST** `/auth/login`: Authenticate and receive a JWT token.

### **Products**

- **GET** `/products`: Get a list of all products.
- **GET** `/products/{id}`: Get details of a specific product.

### **Wishlist**

- **GET** `/wishlist`: View the user's wishlist.
- **POST** `/wishlist`: Add a product to the wishlist.
- **POST** `/wishlist/to-order`: Convert wishlist items to an order.

### **Orders**

- **GET** `/orders/my-orders`: View the user's orders.

### **Reviews**

- **GET** `/products/{id}`: View reviews of a product.

---

## **Project Structure**

### **Core Packages**

1. **`entities`**: Contains JPA entity classes for database modeling.
2. **`dto`**: Contains Data Transfer Objects for API requests and responses.
3. **`repositories`**: Interfaces for database interaction using JPA.
4. **`services`**: Contains business logic for the application.
5. **`controllers`**: Handles incoming API requests.
6. **`security`**: Configuration and filters for JWT authentication.

---

## **Sample Data**

### **Default Roles**
- ADMIN
- USER

### **Sample Product**
```json
{
    "id": 1,
    "name": "iPhone 14",
    "price": 999.99,
    "description": "Latest Apple smartphone",
    "stock": 50
}
```

### **Sample Order Response**
```json
[
    {
        "id": 1,
        "name": "iPhone 14",
        "status": "completed",
        "quantity": 2,
        "price": 1999.98
    },
    {
        "id": 2,
        "name": "MacBook Pro",
        "status": "completed",
        "quantity": 1,
        "price": 1999.99
    }
]
```


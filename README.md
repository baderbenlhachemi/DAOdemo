# Employee Management System

This is a simple Employee Management System built using Java and SQL. The project follows a layered architecture pattern, which includes the following layers:

1. **Domain Layer**: This layer contains the `Employee` class, which is a simple Java class that represents the `Employee` entity in our application.

2. **DAO Layer**: This layer is responsible for interacting with the database. It contains the `EmployeeDao` interface and its implementation `EmployeeDaoImpl`. The `EmployeeDao` interface extends the `Dao` interface, which defines the basic CRUD operations. The `EmployeeDaoImpl` class implements these operations using JDBC.

3. **Service Layer**: This layer contains the `EmployeeService` interface and its implementation `EmployeeServiceImpl`. The `EmployeeService` interface defines the same CRUD operations as the `Dao` interface. The `EmployeeServiceImpl` class implements these operations by delegating the work to an instance of `EmployeeDao`.

4. **Controller Layer**: This layer contains the `EmployeeController` class, which is responsible for handling user requests and delegating the work to the `EmployeeService`.

5. **Main Application**: This is the entry point of our application. It uses the `EmployeeController` to perform CRUD operations on `Employee` entities.

## How Each Layer Interacts with the Other

- The **Main Application** interacts with the **Controller Layer**. It creates an instance of `EmployeeController` and uses it to perform CRUD operations on `Employee` entities.

- The **Controller Layer** interacts with the **Service Layer**. The `EmployeeController` has an instance of `EmployeeService`, which it uses to perform CRUD operations. When the `EmployeeController` receives a request from the Main Application, it delegates the work to the `EmployeeService`.

- The **Service Layer** interacts with the **DAO Layer**. The `EmployeeServiceImpl` has an instance of `EmployeeDao`, which it uses to interact with the database. When the `EmployeeServiceImpl` receives a request from the `EmployeeController`, it delegates the work to the `EmployeeDao`.

- The **DAO Layer** interacts with the **Database**. The `EmployeeDaoImpl` uses JDBC to execute SQL queries against the database.

- The **Domain Layer** is used by all other layers. The `Employee` class is used to represent `Employee` entities throughout the application.

## How to Run the Application

1. Clone the repository.
2. Open the project in your favorite IDE (the project is set up for IntelliJ IDEA).
3. Make sure you have a MySQL server running and adjust the database connection parameters in the `Database` class if necessary.
4. Run the `Main` class.

Please note that this is a simple example and does not include any error handling or input validation. It's meant to demonstrate the basic structure of a layered architecture in a Java application.

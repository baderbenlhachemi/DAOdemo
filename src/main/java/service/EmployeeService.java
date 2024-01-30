package service;

import domain.Employee;

import java.sql.SQLException;
import java.util.List;

// Service layer to perform the CRUD operations.
// The service layer will act as an intermediary between the controller (or main application layer) and the DAO layer.
// This layer will contain the business logic of the application, and it will use the DAO to interact with the database.
public interface EmployeeService {
    Employee get(int id) throws SQLException;
    List<Employee> getAll() throws SQLException;
    int insert(Employee employee) throws SQLException;
    int update(Employee employee) throws SQLException;
    int delete(Employee employee) throws SQLException;
}

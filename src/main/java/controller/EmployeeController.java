package controller;

import domain.Employee;
import service.EmployeeService;
import service.EmployeeServiceImpl;

import java.sql.SQLException;
import java.util.List;

// The controller will be responsible for handling user requests and delegating the work to the service layer.
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController() {
        this.employeeService = new EmployeeServiceImpl();
    }

    public Employee getEmployee(int id) throws SQLException {
        return employeeService.get(id);
    }

    public List<Employee> getAllEmployees() throws SQLException {
        return employeeService.getAll();
    }

    public int insertEmployee(Employee employee) throws SQLException {
        return employeeService.insert(employee);
    }

    public int updateEmployee(Employee employee) throws SQLException {
        return employeeService.update(employee);
    }

    public int deleteEmployee(Employee employee) throws SQLException {
        return employeeService.delete(employee);
    }
}

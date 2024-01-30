import controller.EmployeeController;
import database.Database;
import domain.Employee;

import java.sql.Connection;
import java.sql.SQLException;

// The main method will be responsible for creating an instance of the controller to perform CRUD operations on the Employee entity.
// the Main application is now only responsible for interacting with the EmployeeController, which in turn interacts with the EmployeeService and EmployeeDao to perform the actual operations.
public class Main {
    public static void main(String[] args) throws SQLException {

        // Check database connection
        Connection con = Database.getConnection();

        if (con != null) {
            System.out.println("Database Connection Successful");
        } else {
            System.out.println("Database Connection Failed");
        }

        EmployeeController employeeController = new EmployeeController();

        // Get an employee
        Employee employee1 = employeeController.getEmployee(2);
        System.out.println(employee1);

        // Get all employees
        System.out.println(employeeController.getAllEmployees());

        // Insert a new employee
        Employee newEmployee = new Employee(0, 302, "Bob", "Ross", 3);
        int insertResult = employeeController.insertEmployee(newEmployee);
        System.out.println(insertResult);

        // Update an employee
        Employee employeeToUpdate = new Employee(3, 302, "Bobby", "Ross", 3);
        int updateResult = employeeController.updateEmployee(employeeToUpdate);
        System.out.println(updateResult);

        // Delete an employee
        Employee employeeToDelete = employeeController.getEmployee(8);
        int deleteResult = employeeController.deleteEmployee(employeeToDelete);
        System.out.println(deleteResult);

    }
}

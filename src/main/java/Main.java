import database.Database;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        // Check database connection
        Connection con = Database.getConnection();

        if (con != null) {
            System.out.println("Database Connection Successful");
        } else {
            System.out.println("Database Connection Failed");
        }

        // Get an employee
        /*EmployeeDao employeeDao1 = new EmployeeDaoImpl();
        Employee employee1 = employeeDao1.get(1);
        System.out.println(employee1);*/

        // Get all employees
        /*EmployeeDao employeeDao5 = new EmployeeDaoImpl();
        employeeDao5.getAll();*/

        // Insert a new employee
        /*EmployeeDao employeeDao2 = new EmployeeDaoImpl();
        Employee employee2 = new Employee(0, 302, "Bob", "Ross", 3);
        int result = employeeDao2.insert(employee2);
        System.out.println(result);*/

        // Update an employee
        /*EmployeeDao employeeDao3 = new EmployeeDaoImpl();
        Employee employee3 = new Employee(3, 302, "Bobby", "Ross", 3);
        employeeDao3.update(employee3);
        System.out.println(employee3);*/

        // Delete an employee
        /*EmployeeDao employeeDao4 = new EmployeeDaoImpl();
        Employee employee4 = employeeDao4.get(8);
        employeeDao4.delete(employee4);
        System.out.println(employee4);
        int result = employeeDao4.delete(employee4);
        System.out.println(result);*/

    }
}

package dao;

import database.Database;
import domain.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

// Concrete DAO class : an implementation of the EmployeeDao interface.
// It uses JDBC to interact with a MySQL database.
// Each method prepares a SQL statement, executes it against the database, and processes the result.
public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public Employee get(int id) throws SQLException {
        Connection con = Database.getConnection(); // Establishing a connection to the db (stored in the con variable).
        Employee employee = null;

        String sql = "SELECT id, employee_id, first_name, last_name, dept_id FROM employees WHERE id = ?";

        PreparedStatement ps = con.prepareStatement(sql); // A PreparedStatement is then created from the connection and the SQL query. The PreparedStatement allows us to execute SQL statements with parameters, which can help prevent SQL injection attacks.

        ps.setInt(1, id); // The setInt method is used to set the value of the first parameter (the ? in the SQL query) to the value of the id variable.

        ResultSet rs = ps.executeQuery(); // The executeQuery method is used to execute the SQL query and return the result in a ResultSet object.

        if (rs.next()) { // The next method of the ResultSet object is used to move the cursor to the first row of the result set. If there is a row, the method returns true, and the data is retrieved from the result set.
            int oldId = rs.getInt("id");
            int employeeId = rs.getInt("employee_id");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            int deptId = rs.getInt("dept_id");

            employee = new Employee(oldId, employeeId, firstName, lastName, deptId);
        }

        return employee; // Finally, the method returns the Employee object. If no record was found in the database, null is returned.
    }

    @Override
    public List<Employee> getAll() throws SQLException {
        Connection con = Database.getConnection();

        String sql = "SELECT id, employee_id, first_name, last_name, dept_id FROM employees";

        PreparedStatement ps = con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("id");
            int employeeId = rs.getInt("employee_id");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            int deptId = rs.getInt("dept_id");

            Employee employee = new Employee(id, employeeId, firstName, lastName, deptId);

            System.out.println(employee);
        }

        return null;
    }

    @Override
    public int insert(Employee employee) throws SQLException {
        Connection con = Database.getConnection();

        String sql = "INSERT INTO employees (employee_id, first_name, last_name, dept_id) VALUES (?, ?, ?, ?)";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, employee.getEmployeeId());
        ps.setString(2, employee.getFirstName());
        ps.setString(3, employee.getLastName());
        ps.setInt(4, employee.getDeptId());

        int result = ps.executeUpdate();

        ps.close();
        con.close();

        return result;
    }

    @Override
    public int update(Employee employee) throws SQLException {
        Connection con = Database.getConnection();

        String sql = "UPDATE employees SET employee_id = ?, first_name = ?, last_name = ?, dept_id = ? WHERE id = ?";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, employee.getEmployeeId());
        ps.setString(2, employee.getFirstName());
        ps.setString(3, employee.getLastName());
        ps.setInt(4, employee.getDeptId());
        ps.setInt(5, employee.getId());

        int result = ps.executeUpdate();

        ps.close();
        con.close();

        return result;
    }

    @Override
    public int delete(Employee employee) throws SQLException {
        Connection con = Database.getConnection();

        String sql = "DELETE FROM employees WHERE id = ?";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, employee.getId());

        int result = ps.executeUpdate();

        ps.close();
        con.close();

        return result;
    }
}

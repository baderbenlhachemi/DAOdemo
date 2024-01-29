package dao;

import database.Database;
import domain.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public Employee get(int id) throws SQLException {
        Connection con = Database.getConnection();
        Employee employee = null;

        String sql = "SELECT id, employee_id, first_name, last_name, dept_id FROM employees WHERE id = ?";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            int oldId = rs.getInt("id");
            int employeeId = rs.getInt("employee_id");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            int deptId = rs.getInt("dept_id");

            employee = new Employee(oldId, employeeId, firstName, lastName, deptId);
        }

        return employee;
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

package service;

import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import domain.Employee;

import java.sql.SQLException;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDao employeeDao; // Uses an instance of EmployeeDao to perform the corresponding database operation.

    public EmployeeServiceImpl() {
        this.employeeDao = new EmployeeDaoImpl();
    }

    @Override
    public Employee get(int id) throws SQLException {
        return employeeDao.get(id);
    }

    @Override
    public List<Employee> getAll() throws SQLException {
        return employeeDao.getAll();
    }

    @Override
    public int insert(Employee employee) throws SQLException {
        return employeeDao.insert(employee);
    }

    @Override
    public int update(Employee employee) throws SQLException {
        return employeeDao.update(employee);
    }

    @Override
    public int delete(Employee employee) throws SQLException {
        return employeeDao.delete(employee);
    }
}

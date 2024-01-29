package dao;

import java.sql.SQLException;
import java.util.List;

//  DAO Interface : an interface that defines the basic CRUD operations to be performed on a domain object.
public interface Dao<T> {

    // The methods insert, update, and delete in the Dao interface return an int because they are designed to return the number of rows affected by the operation in the database.
    // In JDBC, the executeUpdate method, which is used for executing INSERT, UPDATE, or DELETE statements, returns an integer representing the number of rows affected by the SQL statement.
    // This is useful to check if the operation was successful or not.

    T get(int id) throws SQLException;
    List<T> getAll() throws SQLException;
    int insert(T t) throws SQLException;
    int update(T t) throws SQLException;
    int delete(T t) throws SQLException;
}

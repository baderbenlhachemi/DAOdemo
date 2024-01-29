package database;

import java.sql.Connection;
import java.sql.SQLException;

// Utility class that provides a method to get a Connection to the MySQL database.
// It uses the DriverManager.getConnection method with a hardcoded URL, username, and password.
public class Database {

    private static String url = "jdbc:mysql://localhost:3306/daotutorial";
    private static String username = "root";
    private static String password = "password";

    private Database() {
    }

    public static Connection getConnection() throws SQLException {
        Connection connection = null; // initialize connection
        connection = java.sql.DriverManager.getConnection(url, username, password);

        return connection;
    }
}

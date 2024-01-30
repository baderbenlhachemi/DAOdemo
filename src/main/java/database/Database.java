package database;

import java.sql.Connection;
import java.sql.SQLException;

// Utility class that provides a method to get a Connection to the MySQL database.
// It uses the DriverManager.getConnection method with a hardcoded URL, username, and password.
public class Database {

    private static String url = "jdbc:mysql://localhost:3306/daotutorial";
    private static String username = "root";
    private static String password = "password";

    // private constructor used to prevent the instantiation of the Database class.
    //It doesn't make sense to create an instance of this class, because it doesn't hold any state and all its methods are static.
    //By making the constructor private, it ensures that this class cannot be instantiated from outside the class.
    //This is a way to enforce the Singleton pattern, ensuring that only one instance of the class can exist in the JVM at any time.
    private Database() {
    }

    public static Connection getConnection() throws SQLException {
        Connection connection = null; // initialize connection
        connection = java.sql.DriverManager.getConnection(url, username, password);

        return connection;
    }
}

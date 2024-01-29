package database;

import java.sql.Connection;
import java.sql.SQLException;

public class Database {

    private static String url = "jdbc:mysql://localhost:3306/daotutorial";
    private static String username = "root";
    private static String password = "password";

    private Database() {
    }

    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        connection = java.sql.DriverManager.getConnection(url, username, password);

        return connection;
    }
}

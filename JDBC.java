import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC {
    private static JDBC instance;
    private Connection connection;
    private String url = "jdbc:mysql://localhost:3306/little_toon"; // Database URL
    private String user = "root"; // Database user
    private String password = "WJ28@krhps"; // Database password

    // Private constructor to prevent instantiation from outside the class
    private JDBC() {
        try {
            // Attempt to establish a connection
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database successfully!");
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database.");
            e.printStackTrace(); // Print stack trace for any SQL errors
        }
    }

    // Get the singleton instance of DatabaseConnection
    public static JDBC getInstance() {
        if (instance == null) {
            instance = new JDBC();
        }
        return instance;
    }

    // Get the established connection
    public Connection getConnection() {
        return connection;
    }
}

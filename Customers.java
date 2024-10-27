import java.sql.Connection;
import java.sql.Statement;

public class Customers {
    
    public static void createTables() {
        String dropTableSQL = "DROP TABLE IF EXISTS `customers`;";
        String createTableSQL = """
            CREATE TABLE `customers` (
              `CustomerID` int NOT NULL AUTO_INCREMENT,
              `Name` varchar(225) DEFAULT NULL,
              `Email` varchar(225) DEFAULT NULL,
              `Address` text,
              `Password` varchar(225) DEFAULT NULL,
              PRIMARY KEY (`CustomerID`),
              UNIQUE KEY `CustomerID_UNIQUE` (`CustomerID`)
            ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
        """;
        
        try (Connection conn = JDBC.getInstance().getConnection(); Statement stmt = conn.createStatement()) {
            // Execute DROP TABLE first
            stmt.executeUpdate(dropTableSQL);
            System.out.println("Existing 'customers' table dropped successfully.");
            
            // Execute CREATE TABLE
            stmt.executeUpdate(createTableSQL);
            System.out.println("Table 'customers' created successfully.");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        createTables();
    }
}

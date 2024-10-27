import java.sql.Connection;
import java.sql.Statement;

public class Orders {
    
    public static void createOrdersTable() {
        String dropTableSQL = "DROP TABLE IF EXISTS `orders`;";
        String createTableSQL = """
            CREATE TABLE `orders` (
              `orderID` int NOT NULL,
              `customerID` int NOT NULL,
              `order_date` datetime DEFAULT NULL,
              `order_status` text,
              `total` decimal(10,0) DEFAULT NULL,
              `payment_method` varchar(225) DEFAULT NULL,
              `order_notes` varchar(250) DEFAULT NULL,
              PRIMARY KEY (`orderID`, `customerID`),
              UNIQUE KEY `ORDERSID_UNIQUE` (`orderID`),
              UNIQUE KEY `CustomerID_UNIQUE` (`customerID`)
            ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
        """;
        
        try (Connection conn = JDBC.getInstance().getConnection(); Statement stmt = conn.createStatement()) {
            // Execute DROP TABLE first
            stmt.executeUpdate(dropTableSQL);
            System.out.println("Existing 'orders' table dropped successfully.");
            
            // Execute CREATE TABLE
            stmt.executeUpdate(createTableSQL);
            System.out.println("Table 'orders' created successfully.");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        createOrdersTable();
    }
}

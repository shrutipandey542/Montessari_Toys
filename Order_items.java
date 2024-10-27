import java.sql.Connection;
import java.sql.Statement;

public class Order_items {
    
    public static void createOrderItemsTable() {
        String dropTableSQL = "DROP TABLE IF EXISTS `order_items`;";
        String createTableSQL = """
            CREATE TABLE `order_items` (
              `order_item_id` int NOT NULL,
              `order_id` int NOT NULL,
              `toy_id` int NOT NULL,
              `quantity` int DEFAULT NULL,
              `discount_amount` decimal(10,0) DEFAULT NULL,
              `total` decimal(10,0) DEFAULT NULL,
              PRIMARY KEY (`order_item_id`, `order_id`, `toy_id`),
              UNIQUE KEY `order_item_id_UNIQUE` (`order_item_id`),
              UNIQUE KEY `order_id_UNIQUE` (`order_id`),
              UNIQUE KEY `toy_id_UNIQUE` (`toy_id`)
            ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
        """;
        
        try (Connection conn = JDBC.getInstance().getConnection(); Statement stmt = conn.createStatement()) {
            // Execute DROP TABLE first
            stmt.executeUpdate(dropTableSQL);
            System.out.println("Existing 'order_items' table dropped successfully.");
            
            // Execute CREATE TABLE
            stmt.executeUpdate(createTableSQL);
            System.out.println("Table 'order_items' created successfully.");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        createOrderItemsTable();
    }
}

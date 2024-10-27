import java.sql.Connection;
import java.sql.Statement;

public class Review {
    
    public static void createReviewTable() {
        String dropTableSQL = "DROP TABLE IF EXISTS `review`;";
        String createTableSQL = """
            CREATE TABLE `review` (
              `review_id` int NOT NULL,
              `order_id` int NOT NULL,
              `product_id` int NOT NULL,
              `customer_id` int NOT NULL,
              `rating` varchar(225) DEFAULT NULL,
              `review_date` datetime DEFAULT NULL,
              `review_note` text,
              PRIMARY KEY (`review_id`, `order_id`, `product_id`, `customer_id`),
              UNIQUE KEY `order_id_UNIQUE` (`order_id`),
              UNIQUE KEY `product_id_UNIQUE` (`product_id`),
              UNIQUE KEY `customer_id_UNIQUE` (`customer_id`),
              UNIQUE KEY `review_id_UNIQUE` (`review_id`)
            ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
        """;
        
        try (Connection conn = JDBC.getInstance().getConnection(); Statement stmt = conn.createStatement()) {
            // Execute DROP TABLE first
            stmt.executeUpdate(dropTableSQL);
            System.out.println("Existing 'review' table dropped successfully.");
            
            // Execute CREATE TABLE
            stmt.executeUpdate(createTableSQL);
            System.out.println("Table 'review' created successfully.");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        createReviewTable();
    }
}

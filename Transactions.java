import java.sql.Connection;
import java.sql.Statement;

public class Transactions {

    public static void createTransactionsTable() {
        String dropTableSQL = "DROP TABLE IF EXISTS `transactions`;";
        String createTableSQL = """
            CREATE TABLE `transactions` (
              `transid` varchar(225) NOT NULL,
              `username` varchar(60) DEFAULT NULL,
              `time` datetime DEFAULT NULL,
              `amount` decimal(10,0) DEFAULT NULL,
              PRIMARY KEY (`transid`)
            ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
        """;

        try (Connection conn = JDBC.getInstance().getConnection(); Statement stmt = conn.createStatement()) {
            // Execute DROP TABLE first
            stmt.executeUpdate(dropTableSQL);
            System.out.println("Existing 'transactions' table dropped successfully.");
            
            // Execute CREATE TABLE
            stmt.executeUpdate(createTableSQL);
            System.out.println("Table 'transactions' created successfully.");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        createTransactionsTable();
    }
}

import java.sql.Connection;
import java.sql.Statement;

public class Toys {

    public static void createToysTable() {
        String dropTableSQL = "DROP TABLE IF EXISTS `toys`;";
        String createTableSQL = """
            CREATE TABLE `toys` (
              `ToyID` int NOT NULL AUTO_INCREMENT,
              `ToyName` varchar(225) DEFAULT NULL,
              `Description` text,
              `Price` decimal(10,2) DEFAULT NULL,
              `Agewise_Category` varchar(50) DEFAULT NULL,
              `ImageURL` varchar(225) DEFAULT NULL,
              `StockQuantity` int DEFAULT NULL,
              PRIMARY KEY (`ToyID`),
              UNIQUE KEY `ToyID_UNIQUE` (`ToyID`)
            ) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
        """;
        String insertDataSQL = """
            INSERT INTO `toys` VALUES 
            (1,'Wooden Blocks','Colorful blocks for stacking and sorting, promoting creativity and spatial awareness.',2000.00,'1-3 yrs','https://images-cdn.ubuy.co.in/634e4c49bec1d13a9643f245-fopnets-large-wooden-blocks-construction.jpg',3),
            (2,'Shape sorter','A classic toy that helps children recognize shapes while enhancing fine motor skills.',1600.00,'1-3 yrs','https://images-cdn.ubuy.co.in/6681a19350a5e017eb6200dd-montessori-toys-for-1-2-3-year-old-boys.jpg',2),
            (3,'Montessari Pincer Toys','Tools like tongs or tweezers that encourage fine motor skill development through grasping.',1200.00,'2-4 yrs','https://m.media-amazon.com/images/I/51ZCv8tL1GL.jpg',1),
            (4,'Lacing Beads','Beads that can be threaded onto a string, improving hand-eye coordination and dexterity.',1500.00,'3-5 yrs','https://5.imimg.com/data5/SELLER/Default/2021/11/CO/TM/IV/66242031/colorful-wooden-bead-500x500.jpg',2),
            (5,'Number Rods','Visual aids for counting and simple arithmetic, helping children grasp early math concepts.',3200.00,'3-5 yrs','https://montessorijob.net/wp-content/uploads/2021/12/nymber-rods.jpg',4),
            (6,'Threading Cards','Cards with holes for lacing activities, enhancing fine motor skills and concentration.',2000.00,'3-5 yrs','https://cdn.montessoriservices.com/product/1200/v390_ms11_p_1.jpg',3),
            (7,'Montessari puzzle','Wooden puzzles that challenge problem-solving skills and shape recognition.',1800.00,'3-5 yrs','https://m.media-amazon.com/images/I/81RZZT1kVJL.jpg',2),
            (8,'Counting Bears','Colorful bear counters for counting, sorting, and simple math games, engaging tactile learning.',1600.00,'3-5 yrs','https://images-cdn.ubuy.co.in/647306944a20687a4e29f81c-jumbo-counting-bears-with-stacking-cups.jpg',1),
            (9,'Sensory Bin Materials','Various textured items for sensory exploration, encouraging creativity and imaginative play.',2800.00,'3-5 yrs','https://i.etsystatic.com/7183648/r/il/af3a69/3411687470/il_570xN.3411687470_2xem.jpg',3),
            (10,'Creative Art Set','Includes crayons, paints, and papers to inspire artistic expression and creativity.',2500.00,'4-5 yrs','https://m.media-amazon.com/images/I/81BFwCOTCLL._AC_UF1000,1000_QL80_.jpg',2),
            (11,'Montessari Alphabet Cards','Cards featuring letters to aid in early literacy and phonetic awareness through matching games.',1200.00,'3-5 yrs','https://m.media-amazon.com/images/I/615nq2UipJL._AC_UF1000,1000_QL80_.jpg',3),
            (12,'Practical Life Tools','Miniature kitchen tools or gardening sets that teach everyday skills and responsibilities.',2200.00,'2-5 yrs','https://www.howwemontessori.com/.a/6a0147e1d4f40f970b022ad38e9c39200d-pi',2),
            (13,'Balance Boards','A board for balancing activities that strengthens core muscles and improves coordination.',3800.00,'4-5 yrs','https://images-cdn.ubuy.co.in/633ffda97d5f5942600b8e2a-belleur-wooden-balance-board-kid-wobble.jpg',4),
            (14,'Nature Exploration Kit','Tools like magnifying glasses and bug catchers for outdoor exploration and learning about nature.',2800.00,'3-5 yrs','https://m.media-amazon.com/images/I/7118LT8h6RL.jpg',4),
            (15,'Musical Instruments Set','A collection of simple instruments like maracas and tambourines to explore rhythm and sound.',4000.00,'3-5 yrs','https://images-cdn.ubuy.co.in/633fff50bf19b1732f226fcf-baby-toys-musical-instruments.jpg',5);
        """;

        try (Connection conn = JDBC.getInstance().getConnection(); Statement stmt = conn.createStatement()) {
            // Execute DROP TABLE first
            stmt.executeUpdate(dropTableSQL);
            System.out.println("Existing 'toys' table dropped successfully.");
            
            // Execute CREATE TABLE
            stmt.executeUpdate(createTableSQL);
            System.out.println("Table 'toys' created successfully.");
            
            // Insert initial data into the table
            stmt.executeUpdate(insertDataSQL);
            System.out.println("Initial data inserted into 'toys' table successfully.");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        createToysTable();
    }
}

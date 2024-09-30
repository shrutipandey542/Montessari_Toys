-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: little_toon
-- ------------------------------------------------------
-- Server version	8.0.39

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customers` (
  `CustomerID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(225) DEFAULT NULL,
  `Email` varchar(225) DEFAULT NULL,
  `Address` text,
  `Password` varchar(225) DEFAULT NULL,
  PRIMARY KEY (`CustomerID`),
  UNIQUE KEY `CustomerID_UNIQUE` (`CustomerID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_items`
--

DROP TABLE IF EXISTS `order_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_items` (
  `order_item_id` int NOT NULL,
  `order_id` int NOT NULL,
  `toy_id` int NOT NULL,
  `quantity` int DEFAULT NULL,
  `discount_amount` decimal(10,0) DEFAULT NULL,
  `total` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`order_item_id`,`order_id`,`toy_id`),
  UNIQUE KEY `order_item_id_UNIQUE` (`order_item_id`),
  UNIQUE KEY `order_id_UNIQUE` (`order_id`),
  UNIQUE KEY `toy_id_UNIQUE` (`toy_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_items`
--

LOCK TABLES `order_items` WRITE;
/*!40000 ALTER TABLE `order_items` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `orderID` int NOT NULL,
  `customerID` int NOT NULL,
  `order_date` datetime DEFAULT NULL,
  `order_status` text,
  `total` decimal(10,0) DEFAULT NULL,
  `payment_method` varchar(225) DEFAULT NULL,
  `order_notes` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`orderID`,`customerID`),
  UNIQUE KEY `ORDERSID_UNIQUE` (`orderID`),
  UNIQUE KEY `CustomerID_UNIQUE` (`customerID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `review`
--

DROP TABLE IF EXISTS `review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `review` (
  `review_id` int NOT NULL,
  `order_id` int NOT NULL,
  `product_id` int NOT NULL,
  `customer_id` int NOT NULL,
  `rating` varchar(225) DEFAULT NULL,
  `review_date` datetime DEFAULT NULL,
  `review_note` text,
  PRIMARY KEY (`review_id`,`order_id`,`product_id`,`customer_id`),
  UNIQUE KEY `order_id_UNIQUE` (`order_id`),
  UNIQUE KEY `product_id_UNIQUE` (`product_id`),
  UNIQUE KEY `customer_id_UNIQUE` (`customer_id`),
  UNIQUE KEY `review_id_UNIQUE` (`review_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review`
--

LOCK TABLES `review` WRITE;
/*!40000 ALTER TABLE `review` DISABLE KEYS */;
/*!40000 ALTER TABLE `review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `toys`
--

DROP TABLE IF EXISTS `toys`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `toys`
--

LOCK TABLES `toys` WRITE;
/*!40000 ALTER TABLE `toys` DISABLE KEYS */;
INSERT INTO `toys` VALUES (1,'Wooden Blocks','Colorful blocks for stacking and sorting, promoting creativity and spatial awareness.',2000.00,'1-3 yrs','https://images-cdn.ubuy.co.in/634e4c49bec1d13a9643f245-fopnets-large-wooden-blocks-construction.jpg',3),(2,'Shape sorter','A classic toy that helps children recognize shapes while enhancing fine motor skills.',1600.00,'1-3 yrs','https://images-cdn.ubuy.co.in/6681a19350a5e017eb6200dd-montessori-toys-for-1-2-3-year-old-boys.jpg',2),(3,'Montessari Pincer Toys','Tools like tongs or tweezers that encourage fine motor skill development through grasping.',1200.00,'2-4 yrs','https://m.media-amazon.com/images/I/51ZCv8tL1GL.jpg',1),(4,'Lacing Beads','Beads that can be threaded onto a string, improving hand-eye coordination and dexterity.',1500.00,'3-5 yrs','https://5.imimg.com/data5/SELLER/Default/2021/11/CO/TM/IV/66242031/colorful-wooden-bead-500x500.jpg',2),(5,'Number Rods','Visual aids for counting and simple arithmetic, helping children grasp early math concepts.',3200.00,'3-5 yrs','https://montessorijob.net/wp-content/uploads/2021/12/nymber-rods.jpg',4),(6,'Threading Cards','Cards with holes for lacing activities, enhancing fine motor skills and concentration.',2000.00,'3-5 yrs','https://cdn.montessoriservices.com/product/1200/v390_ms11_p_1.jpg',3),(7,'Montessari puzzle','Wooden puzzles that challenge problem-solving skills and shape recognition.',1800.00,'3-5 yrs','https://m.media-amazon.com/images/I/81RZZT1kVJL.jpg',2),(8,'Counting Bears','Colorful bear counters for counting, sorting, and simple math games, engaging tactile learning.',1600.00,'3-5 yrs','https://images-cdn.ubuy.co.in/647306944a20687a4e29f81c-jumbo-counting-bears-with-stacking-cups.jpg',1),(9,'Sensory Bin Materials','Various textured items for sensory exploration, encouraging creativity and imaginative play.',2800.00,'3-5 yrs','https://i.etsystatic.com/7183648/r/il/af3a69/3411687470/il_570xN.3411687470_2xem.jpg',3),(10,'Creative Art Set','Includes crayons, paints, and papers to inspire artistic expression and creativity.',2500.00,'4-5 yrs','https://m.media-amazon.com/images/I/81BFwCOTCLL._AC_UF1000,1000_QL80_.jpg',2),(11,'Montessari Alphabet Cards','Cards featuring letters to aid in early literacy and phonetic awareness through matching games.',1200.00,'3-5 yrs','https://m.media-amazon.com/images/I/615nq2UipJL._AC_UF1000,1000_QL80_.jpg',3),(12,'Practical Life Tools','Miniature kitchen tools or gardening sets that teach everyday skills and responsibilities.',2200.00,'2-5 yrs','https://www.howwemontessori.com/.a/6a0147e1d4f40f970b022ad38e9c39200d-pi',2),(13,'Balance Boards','A board for balancing activities that strengthens core muscles and improves coordination.',3800.00,'4-5 yrs','https://images-cdn.ubuy.co.in/633ffda97d5f5942600b8e2a-belleur-wooden-balance-board-kid-wobble.jpg',4),(14,'Nature Exploration Kit','Tools like magnifying glasses and bug catchers for outdoor exploration and learning about nature.',2800.00,'3-5 yrs','https://m.media-amazon.com/images/I/7118LT8h6RL.jpg',4),(15,'Musical Instruments Set','A collection of simple instruments like maracas and tambourines to explore rhythm and sound.',4000.00,'3-5 yrs','https://images-cdn.ubuy.co.in/633fff50bf19b1732f226fcf-baby-toys-musical-instruments.jpg',5);
/*!40000 ALTER TABLE `toys` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transactions`
--

DROP TABLE IF EXISTS `transactions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transactions` (
  `transid` varchar(225) NOT NULL,
  `username` varchar(60) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `amount` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`transid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transactions`
--

LOCK TABLES `transactions` WRITE;
/*!40000 ALTER TABLE `transactions` DISABLE KEYS */;
/*!40000 ALTER TABLE `transactions` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-09-29  5:39:05

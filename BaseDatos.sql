-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: localhost    Database: project_account
-- ------------------------------------------------------
-- Server version	8.0.40

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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `id_account` varchar(255) NOT NULL,
  `account_number` varchar(255) NOT NULL,
  `id_customer` varchar(255) DEFAULT NULL,
  `opening_balance` decimal(38,2) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `type_account` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_account`),
  UNIQUE KEY `UK66gkcp94endmotfwb8r4ocxm9` (`account_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES ('ea4246d3-acba-4f1a-a518-76baf09f8ebc','1231231236','fccb5a3f-12f9-4480-92c7-82c9668aa3c6',2300.00,'true','Corriente');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `id_customer` varchar(255) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `age` int NOT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `id_person` varchar(255) DEFAULT NULL,
  `identification` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_customer`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES ('fccb5a3f-12f9-4480-92c7-82c9668aa3c6','Esmeraldas - La Joya',25,'Male',NULL,'1105678240','Carlos Jaramillo','093454672893','345678901','true');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movement`
--

DROP TABLE IF EXISTS `movement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movement` (
  `id_movement` varchar(255) NOT NULL,
  `amount` decimal(38,2) DEFAULT NULL,
  `balance` decimal(38,2) DEFAULT NULL,
  `date` datetime(6) DEFAULT NULL,
  `detail_movement` varchar(255) DEFAULT NULL,
  `type_movement` varchar(255) DEFAULT NULL,
  `id_account` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_movement`),
  KEY `FKcibulkllyh235a178x3c83ep6` (`id_account`),
  CONSTRAINT `FKcibulkllyh235a178x3c83ep6` FOREIGN KEY (`id_account`) REFERENCES `account` (`id_account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movement`
--

LOCK TABLES `movement` WRITE;
/*!40000 ALTER TABLE `movement` DISABLE KEYS */;
INSERT INTO `movement` VALUES ('0793db79-2491-46c4-96e1-42555492c446',-500.00,1100.00,'2025-03-15 16:45:25.897599','RETIRO 500','Retiro','ea4246d3-acba-4f1a-a518-76baf09f8ebc'),('0d12eb88-e77d-4e4e-b457-86ef22838034',-155.00,945.00,'2025-03-16 11:05:53.637971','RETIRO 155','Retiro','ea4246d3-acba-4f1a-a518-76baf09f8ebc'),('555f0d71-56a5-4268-9f6b-9feee58e7cbe',700.00,1300.00,'2025-03-15 17:24:45.675855','DEPOSITO 700','Deposito','ea4246d3-acba-4f1a-a518-76baf09f8ebc'),('908c00f3-c16c-40f1-a75f-ce836d490fee',500.00,1600.00,'2025-03-15 16:05:46.735867','DEPOSITO 500','Deposito','ea4246d3-acba-4f1a-a518-76baf09f8ebc'),('94f997a4-4511-49ad-aa1f-74b35fdece75',-200.00,1100.00,'2025-03-15 17:25:20.571330','RETIRO 200','Retiro','ea4246d3-acba-4f1a-a518-76baf09f8ebc'),('bf357078-97c8-4038-a00a-0af6c407221f',-10.00,2090.00,'2025-03-16 12:10:22.661524','RETIRO 10','Retiro','ea4246d3-acba-4f1a-a518-76baf09f8ebc'),('c6196d84-d558-46fa-a22e-49549a5245f6',500.00,1100.00,'2025-03-15 16:00:49.989904','DEPOSITO 500','Deposito','ea4246d3-acba-4f1a-a518-76baf09f8ebc'),('d8731be8-7aa8-4e46-b191-0dd8ce0f0083',-500.00,600.00,'2025-03-15 17:19:21.979768','RETIRO 500','Retiro','ea4246d3-acba-4f1a-a518-76baf09f8ebc');
/*!40000 ALTER TABLE `movement` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-03-16 12:56:08

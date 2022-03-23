CREATE DATABASE  IF NOT EXISTS `crypto` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `crypto`;
-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: crypto
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `client` (
  `id_client` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `id_client_detail` int DEFAULT NULL,
  `id_carteira` int DEFAULT NULL,
  `dt_cadastro` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_client`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (2,'Guilherme','boscolo.dev@gmail.com',13,1,'22/03/2022 08:49:54'),(3,'Joao','joao.felipe@gmail.com',14,2,'22/03/2022 08:52:08'),(4,'Nelci','nelci@hotmail.com',16,5,'22/03/2022 23:18:35');
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client_detail`
--

DROP TABLE IF EXISTS `client_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `client_detail` (
  `id_client_detail` int NOT NULL AUTO_INCREMENT,
  `id_client` int DEFAULT NULL,
  `id_carteira` int DEFAULT NULL,
  `id_crypto` int DEFAULT NULL,
  PRIMARY KEY (`id_client_detail`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client_detail`
--

LOCK TABLES `client_detail` WRITE;
/*!40000 ALTER TABLE `client_detail` DISABLE KEYS */;
INSERT INTO `client_detail` VALUES (1,2,1,13),(2,3,2,14),(3,2,2,13),(4,2,1,14),(5,3,1,14),(6,4,5,16);
/*!40000 ALTER TABLE `client_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `crypto`
--

DROP TABLE IF EXISTS `crypto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `crypto` (
  `id_Crypto` int NOT NULL AUTO_INCREMENT,
  `rede` varchar(45) DEFAULT NULL,
  `sigla` varchar(5) DEFAULT NULL,
  `dt_Cadastro` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_Crypto`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crypto`
--

LOCK TABLES `crypto` WRITE;
/*!40000 ALTER TABLE `crypto` DISABLE KEYS */;
INSERT INTO `crypto` VALUES (14,'Bitcoin','BTC','15/03/2022 16:15:09'),(16,'Cardano','ADA','15/03/2022 16:15:23'),(17,'Etherium','ETH','15/03/2022 16:15:44'),(18,'Shiba','Inu','23/03/2022 08:01:27'),(19,'Shiba','Inu','23/03/2022 08:02:08'),(20,'Polkadot','POLK','23/03/2022 08:02:52'),(21,'Axie','AXS','23/03/2022 08:03:17'),(22,'Teste','TST','23/03/2022 08:03:33'),(23,'Teste2','TST2','23/03/2022 08:07:14');
/*!40000 ALTER TABLE `crypto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'crypto'
--

--
-- Dumping routines for database 'crypto'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-03-23  8:14:30

-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: shop
-- ------------------------------------------------------
-- Server version	5.7.22-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `image`
--

DROP TABLE IF EXISTS `image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `image` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `image`
--

LOCK TABLES `image` WRITE;
/*!40000 ALTER TABLE `image` DISABLE KEYS */;
INSERT INTO `image` VALUES (1,'GlideShopImage_war_exploded/upload/1.jpg','Nike Air Force 1'),(2,'GlideShopImage_war_exploded/upload/2.jpg','Air Jordan 1 Mid'),(3,'GlideShopImage_war_exploded/upload/3.jpg','Air Jordan 4 Retro (GS)'),(4,'GlideShopImage_war_exploded/upload/4.jpg','Nike Air Force 1 \'07 PRM WW'),(5,'GlideShopImage_war_exploded/upload/5.jpg','Nike Air Force 1 Mid \'07'),(6,'GlideShopImage_war_exploded/upload/6.jpg','Nike Swoosh'),(7,'GlideShopImage_war_exploded/upload/7.jpg','Jordan Dri-FIT Jumpman'),(8,'GlideShopImage_war_exploded/upload/8.jpg','Jordan Everyday Max'),(9,'GlideShopImage_war_exploded/upload/9.jpg','Nike SB Dunk Low Pro PRM'),(10,'GlideShopImage_war_exploded/upload/10.jpg','Nike SB Dunk Low Pro'),(11,'GlideShopImage_war_exploded/upload/11.jpg','Chuck Taylor All Star Crater'),(12,'GlideShopImage_war_exploded/upload/12.jpg','Chuck Taylor All Star Crater 中性'),(13,'GlideShopImage_war_exploded/upload/13.jpg','OLD SKOOL'),(14,'GlideShopImage_war_exploded/upload/14.jpg','SK8-HI PRO'),(15,'GlideShopImage_war_exploded/upload/15.jpg','iPhone 12'),(16,'GlideShopImage_war_exploded/upload/16.jpg','iMac '),(17,'GlideShopImage_war_exploded/upload/17.jpg','MacBook Air');
/*!40000 ALTER TABLE `image` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-25 10:36:36

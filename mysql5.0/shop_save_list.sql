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
-- Table structure for table `save_list`
--

DROP TABLE IF EXISTS `save_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `save_list` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `price` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `save_list`
--

LOCK TABLES `save_list` WRITE;
/*!40000 ALTER TABLE `save_list` DISABLE KEYS */;
INSERT INTO `save_list` VALUES (1,'Nike Air Force 1','6','https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/gsuin11ptg5qgktmzoat/air-force-1-07-%E7%94%B7%E5%AD%90%E8%BF%90%E5%8A%A8%E9%9E%8B-jnTp8zLd.jpg'),(2,'Air Jordan 1 Mid','8','https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,b_rgb:f5f5f5/cbc54212-3c42-4241-98bf-e738b551c2c0/air-jordan-1-mid-%E7%94%B7%E5%AD%90%E8%BF%90%E5%8A%A8%E9%9E%8B-XLDrzl.jpg'),(3,'Nike SB Dunk Low Pro PRM','14','https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/qul5s7ompp4zutmaxcgt/sb-dunk-low-pro-prm-?-????-Z5tsJK.jpg'),(4,'OLD SKOOL','14','https://img3.vans.com.cn/public/images/a6/13/b0/bd75f3a97bfbb20bd5e0513ababb3ec1cbf0359d.jpg?1600757948');
/*!40000 ALTER TABLE `save_list` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-25 10:36:37

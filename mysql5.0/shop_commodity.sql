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
-- Table structure for table `commodity`
--

DROP TABLE IF EXISTS `commodity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `commodity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `price` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commodity`
--

LOCK TABLES `commodity` WRITE;
/*!40000 ALTER TABLE `commodity` DISABLE KEYS */;
INSERT INTO `commodity` VALUES (1,'Nike Air Force 1','6','https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/gsuin11ptg5qgktmzoat/air-force-1-07-%E7%94%B7%E5%AD%90%E8%BF%90%E5%8A%A8%E9%9E%8B-jnTp8zLd.jpg'),(2,'Air Jordan 1 Mid','8','https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,b_rgb:f5f5f5/cbc54212-3c42-4241-98bf-e738b551c2c0/air-jordan-1-mid-%E7%94%B7%E5%AD%90%E8%BF%90%E5%8A%A8%E9%9E%8B-XLDrzl.jpg'),(3,'Air Jordan 4 Retro (GS)','13','https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/0643996f-f6b8-406d-91d2-31defaccceae/air-jordan-4-retro-%E5%A4%8D%E5%88%BB%E7%94%B7%E5%AD%90%E8%BF%90%E5%8A%A8%E9%9E%8B-k97M74.jpg'),(4,'Nike Air Force 1 \'07 PRM WW','9','https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/48ae2181-2553-425b-9339-f94bf9c5b3a6/air-force-1-07-prm-ww-%E7%94%B7%E5%AD%90%E8%BF%90%E5%8A%A8%E9%9E%8B-GvTj9F.jpg'),(5,'Nike Air Force 1 Mid \'07','15','https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/hptrv15ajac5d1adsjmc/air-force-1-mid-07-%E7%94%B7%E5%AD%90%E8%BF%90%E5%8A%A8%E9%9E%8B-ktgkbM.jpg'),(6,'Nike Swoosh','11','https://static.nike.com/a/images/t_PDP_1280_v1/f_auto,b_rgb:f5f5f5/dnfjd2kpy5lgubufjkfi/swoosh-%E5%A4%B4%E5%B8%A6%EF%BC%881%E6%9D%A1%EF%BC%89-4bnPSR.jpg'),(7,'Jordan Dri-FIT Jumpman','10','https://static.nike.com/a/images/t_PDP_1280_v1/f_auto,b_rgb:f5f5f5/at98zeytemgvu98kiegt/jordan-jumpman-%E5%A4%B4%E5%B8%A6%EF%BC%881-%E6%9D%A1%EF%BC%89-6h3qHg.jpg'),(8,'Jordan Everyday Max','11','https://static.nike.com/a/images/t_PDP_1280_v1/f_auto,b_rgb:f5f5f5/c08c9099-7bae-422f-a249-2e0b63f06bc0/jordan-everyday-max-crew-%E8%BF%90%E5%8A%A8%E8%A2%9C%EF%BC%883-%E5%8F%8C%EF%BC%89-gsxZ8Q.jpg'),(9,'Nike SB Dunk Low Pro PRM','14','https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/qul5s7ompp4zutmaxcgt/sb-dunk-low-pro-prm-%E7%94%B7-%E5%A5%B3%E8%BF%90%E5%8A%A8%E9%9E%8B-Z5tsJK.jpg'),(10,'Nike SB Dunk Low Pro','17','https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/rygbcrpldmgnbksxzxeo/sb-dunk-low-pro-%E7%94%B7-%E5%A5%B3%E6%BB%91%E6%9D%BF%E9%9E%8B-1pcPJv.jpg'),(11,'Chuck Taylor All Star Crater','10','https://image.converse.com.cn/resources/product/169416C600/169416C600_1H_NEW.png?2020120301'),(12,'Chuck Taylor All Star Crater 中性','12','https://image.converse.com.cn/resources/product/168843C467/168843C467_1L_NEW.png?2020120301'),(13,'OLD SKOOL','14','https://img3.vans.com.cn/public/images/a6/13/b0/bd75f3a97bfbb20bd5e0513ababb3ec1cbf0359d.jpg?1600757948#h'),(14,'SK8-HI PRO','13','https://img1.vans.com.cn/public/images/fe/71/79/ae6a1efa758d0d4a6a745d6cf29beaa6439d0f88.jpg?1601000159#h'),(15,'iPhone 12','14','https://store.storeimages.cdn-apple.com/8756/as-images.apple.com/is/iphone-12-family-select-2020?wid=940&amp;hei=1112&amp;fmt=jpeg&amp;qlt=80&amp;op_usm=0.5,0.5&amp;.v=1604343709000'),(16,'iMac ','7','https://store.storeimages.cdn-apple.com/8756/as-images.apple.com/is/imac-21-retina-selection-hero-201903?wid=904&hei=840&fmt=jpeg&qlt=80&op_usm=0.5,0.5&.v=1553120924619'),(17,'MacBook Air','11','https://store.storeimages.cdn-apple.com/8756/as-images.apple.com/is/macbook-air-space-gray-select-201810?wid=904&hei=840&fmt=jpeg&qlt=80&op_usm=0.5,0.5&.v=1603332211000');
/*!40000 ALTER TABLE `commodity` ENABLE KEYS */;
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

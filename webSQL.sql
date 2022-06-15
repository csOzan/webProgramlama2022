CREATE DATABASE  IF NOT EXISTS `eticaretveritabanı` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `eticaretveritabanı`;
-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: 195.142.192.140    Database: eticaretveritabanı
-- ------------------------------------------------------
-- Server version	8.0.29-0ubuntu0.20.04.3

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
-- Table structure for table `kategoriler`
--

DROP TABLE IF EXISTS `kategoriler`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kategoriler` (
  `kategori_id` int NOT NULL AUTO_INCREMENT,
  `kategori_isim` varchar(45) NOT NULL,
  `kategori_logo_konumu` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`kategori_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kategoriler`
--

LOCK TABLES `kategoriler` WRITE;
/*!40000 ALTER TABLE `kategoriler` DISABLE KEYS */;
INSERT INTO `kategoriler` VALUES (1,'Aksesuar',NULL),(2,'Ayakkabı',NULL),(3,'Eşofman',NULL);
/*!40000 ALTER TABLE `kategoriler` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kullaniciler`
--

DROP TABLE IF EXISTS `kullaniciler`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kullaniciler` (
  `kullanici_id` int NOT NULL AUTO_INCREMENT,
  `kullanici_rol` varchar(45) NOT NULL,
  `kullanici_isim` varchar(45) NOT NULL,
  `kullanici_soyisim` varchar(45) NOT NULL,
  `kullanici_mail` varchar(100) NOT NULL,
  `kullanici_sifre` varchar(60) NOT NULL,
  PRIMARY KEY (`kullanici_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kullaniciler`
--

LOCK TABLES `kullaniciler` WRITE;
/*!40000 ALTER TABLE `kullaniciler` DISABLE KEYS */;
INSERT INTO `kullaniciler` VALUES (1,'standart','Ahmet','Yirmibeş','ahmetyirmibes@yahoo.com','123456'),(2,'yönetici','İlker','Okumuş','ilkerokumus@mymail.com','656456'),(3,'standart','Hülya','Pasakahyaoğlu','pasakahyaogluhulya@gmail.com','646862'),(4,'standart','Burcu','Hür','burcuhur212@outlook.com','789646'),(5,'standart','Gürçağ','Elibol','elibol2131@hotmail.com','325251'),(6,'standart','Elif','Kara','eliffkarra@hotmail.com','342452'),(7,'yönetici','Ramis','Dikyol','ramisdikyol42@outlook.com','324523'),(8,'standart','Özgür','Nasıroğlu','ozgurnasiroglu@gmail.com','342235'),(9,'standart','Kenan','Altunöz','kenanalunoz@gmail.com','546574'),(10,'standart','Hacer','Taşar','hacertasar@outlook.com','906509'),(11,'standart','Fatih','Selvi','fatihselvi@gmail.com','945933'),(12,'standart','Atıl','Akkol','atılakkol@gmail.com','493052'),(13,'standart','Süleyman','Kütükoğlu','suleyman@suleyman.com','123');
/*!40000 ALTER TABLE `kullaniciler` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `siparisler`
--

DROP TABLE IF EXISTS `siparisler`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `siparisler` (
  `siparis_id` int NOT NULL AUTO_INCREMENT,
  `kullanici_id` int NOT NULL,
  `urun_id` int NOT NULL,
  `siparis_tarih` datetime NOT NULL,
  PRIMARY KEY (`siparis_id`),
  KEY `urun_idx` (`urun_id`),
  KEY `kullanici_idx` (`kullanici_id`),
  CONSTRAINT `kullanici` FOREIGN KEY (`kullanici_id`) REFERENCES `kullaniciler` (`kullanici_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `urun` FOREIGN KEY (`urun_id`) REFERENCES `urunler` (`urun_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `siparisler`
--

LOCK TABLES `siparisler` WRITE;
/*!40000 ALTER TABLE `siparisler` DISABLE KEYS */;
/*!40000 ALTER TABLE `siparisler` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `urunler`
--

DROP TABLE IF EXISTS `urunler`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `urunler` (
  `urun_id` int NOT NULL AUTO_INCREMENT,
  `urun_isim` varchar(45) NOT NULL,
  `urun_kategori_id` int NOT NULL,
  `urun_sayısı` varchar(45) DEFAULT '0',
  `urun_ucreti` decimal(50,2) NOT NULL,
  `urun_fotograf_konumu` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`urun_id`),
  KEY `kategori_idx` (`urun_kategori_id`),
  CONSTRAINT `kategori` FOREIGN KEY (`urun_kategori_id`) REFERENCES `kategoriler` (`kategori_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `urunler`
--

LOCK TABLES `urunler` WRITE;
/*!40000 ALTER TABLE `urunler` DISABLE KEYS */;
INSERT INTO `urunler` VALUES (4,'Nike Air 270',2,'2',1300.00,NULL),(5,'Nike Eşofman Üst',3,'6',699.00,NULL),(6,'Swatch Mor Saat',1,'4',4999.00,NULL),(7,'Adidas Russian Esofman',3,'5',989.00,NULL),(8,'Adidas Superstar',2,'3',1500.00,NULL),(9,'Pandora Bileklik',1,'6',15000.00,NULL),(10,'Nike Bileklik',1,'4',3000.00,NULL),(11,'North Face Outdoor Ayakkabı',2,'5',2700.00,NULL),(12,'Nike Eşofman Üstü',3,'4',900.00,NULL);
/*!40000 ALTER TABLE `urunler` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'eticaretveritabanı'
--

--
-- Dumping routines for database 'eticaretveritabanı'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-15  2:23:35

-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: ebs
-- ------------------------------------------------------
-- Server version	8.0.36

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
-- Table structure for table `consumption`
--

DROP TABLE IF EXISTS `consumption`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `consumption` (
  `user_id` int NOT NULL,
  `month_year` varchar(7) NOT NULL,
  `unit_consume` int DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `bill_amt` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT 'unpaid',
  `reward` varchar(45) DEFAULT NULL,
  `penalty` varchar(45) DEFAULT NULL,
  `met_no` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`user_id`,`month_year`),
  CONSTRAINT `consumption_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consumption`
--

LOCK TABLES `consumption` WRITE;
/*!40000 ALTER TABLE `consumption` DISABLE KEYS */;
/*!40000 ALTER TABLE `consumption` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `contact` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `meterno` varchar(130) DEFAULT NULL,
  `month_year` varchar(45) DEFAULT NULL,
  `unit_consume` varchar(45) DEFAULT NULL,
  `conn_date` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=99 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'abhishek10@gmail.com','9326923789','asd','',NULL,NULL,NULL),(2,'abhishek10@gmail.com','8108731206','asd','',NULL,NULL,NULL),(3,'abhishek10@gmail.com','9769847925','asd','',NULL,NULL,NULL),(4,'yy@gmail.com','9632587412','asd','',NULL,NULL,NULL),(5,'abhishek@gmail.com','7898789652','asdasd','',NULL,NULL,NULL),(6,'aa@gmauil.com','7777789212','asdasd','',NULL,NULL,NULL),(7,'prasad@gmail.com','8408731206','patil','',NULL,NULL,NULL),(8,'abhipatil@gmail.com','7852146938','asd','',NULL,NULL,NULL),(9,'abhi_patil@gmail.com','9632563242','asd','',NULL,NULL,NULL),(10,'abhis_patil@gmail.com','7415263986','asd','',NULL,NULL,NULL),(11,'pr@gmail.com','4896324121','asd','',NULL,NULL,NULL),(12,'oo@gmail.com','9996663331','asd','',NULL,NULL,NULL),(13,'tg@gmail.com','9876543212','asd','',NULL,NULL,NULL),(14,'ll@gmail.com','0000011923','asd','',NULL,NULL,NULL),(15,'po@gmail.com','4444555562','asd','',NULL,NULL,NULL),(16,'jj@gmail.com','8888999963','asd','',NULL,NULL,NULL),(17,'gg@gmail.com','3333222210','asd','',NULL,NULL,NULL),(18,'ff@.com','6666444453','asd','',NULL,NULL,NULL),(19,'rr@gmail.com','3333666621','asd','',NULL,NULL,NULL),(20,'oo','85214','e22573706cfe9748cc0e45a526c2bfef','',NULL,NULL,NULL),(21,'patil','852147','c246ad314ab52745b71bb00f4608c82a','8589',NULL,NULL,NULL),(22,'asd','asd','7815696ecbf1c96e6894b779456d330e','6637',NULL,NULL,NULL),(23,'asd','asd','7815696ecbf1c96e6894b779456d330e','6439',NULL,NULL,NULL),(24,'asd','123','7815696ecbf1c96e6894b779456d330e','6992',NULL,NULL,NULL),(25,'asd','asd','78','3367',NULL,NULL,NULL),(26,'asd','asd','7815696ecbf1c96e6894b779456d330e','2816',NULL,NULL,NULL),(27,'asd','asd','49f0bad299687c62334182178bfd75d8','6450',NULL,NULL,NULL),(28,'asd','asdas','7815696ecbf1c96e6894b779456d330e','06411',NULL,NULL,NULL),(29,'asd','asdas','7815696ecbf1c96e6894b779456d330e','0641115882',NULL,NULL,NULL),(30,'asd','asd','7815696ecbf1c96e6894b779456d330e','5225',NULL,NULL,NULL),(31,'asd','asd','7815696ecbf1c96e6894b779456d330e','8541',NULL,NULL,NULL),(32,'asd','asd','81dc9bdb52d04dc20036dbd8313ed055','d41d8cd98f00b204e9800998ecf8427e',NULL,NULL,NULL),(33,'rr','2345','633de4b0c14ca52ea2432a3c8a5c4c31','d41d8cd98f00b204e9800998ecf8427e',NULL,NULL,NULL),(34,'dfg','234','099b3b060154898840f0ebdfb46ec78f','d41d8cd98f00b204e9800998ecf8427e',NULL,NULL,NULL),(35,'gg','123','f589a6959f3e04037eb2b3eb0ff726ac','d41d8cd98f00b204e9800998ecf8427e',NULL,NULL,NULL),(36,'ff','1234','633de4b0c14ca52ea2432a3c8a5c4c31','d41d8cd98f00b204e9800998ecf8427e',NULL,NULL,NULL),(37,'gg','123','c387c982a132d05cbd5f88840aef2c8157740049','d41d8cd98f00b204e9800998ecf8427e',NULL,NULL,NULL),(38,'tt','123','dca2ae07437f431d5f518a8e8b2ce1e6400e6bea','4f714c73db5191f3a71a380cba8843ed',NULL,NULL,NULL),(39,'patil','234','3777601fdba3fe60e662fe93ad715e9272ab7c4b','d41d8cd98f00b204e9800998ecf8427e',NULL,NULL,NULL),(40,'prasasd','8108731206','448640622c937277220efe5c85025f0f08b990e8','d41d8cd98f00b204e9800998ecf8427e',NULL,NULL,NULL),(41,'oo','9326923789','f41f04957264a0c902b417410c89e428c815d7c8','d41d8cd98f00b204e9800998ecf8427e',NULL,NULL,NULL),(42,'asd','asd','f41f04957264a0c902b417410c89e428c815d7c8','d41d8cd98f00b204e9800998ecf8427e',NULL,NULL,NULL),(43,'asd','asd','d854cb152652c42273a652ba8583217da795a32b','d41d8cd98f00b204e9800998ecf8427e',NULL,NULL,NULL),(44,'yy','9926923789','9166eeff1e5056d4b9be3fc9a74f67e3149ef467','d41d8cd98f00b204e9800998ecf8427e',NULL,NULL,NULL),(45,'asd','147852369','9166eeff1e5056d4b9be3fc9a74f67e3149ef467','d41d8cd98f00b204e9800998ecf8427e',NULL,NULL,NULL),(46,'asd','asdbronw','f3453b32e2d74c5332268ef526a97aa04e3ca684','d41d8cd98f00b204e9800998ecf8427e',NULL,NULL,NULL),(47,'asd','asd','5fd057a6ff9dc7a124fa5c814765a498e5aa024a','d41d8cd98f00b204e9800998ecf8427e',NULL,NULL,NULL),(48,'asd','asd','f10e2821bbbea527ea02200352313bc059445190','da39a3ee5e6b4b0d3255bfef95601890afd80709',NULL,NULL,NULL),(49,'ff','234','b2a801fc1f6cdddb5df949c5126817cb5c8562ce','da39a3ee5e6b4b0d3255bfef95601890afd80709',NULL,NULL,NULL),(50,'asd','123','7815696ecbf1c96e6894b779456d330e','4864',NULL,NULL,NULL),(51,'asd','444','7815696ecbf1c96e6894b779456d330e','6767',NULL,NULL,NULL),(52,'jj','234','621faa91bdc4745869f28c3eea2928e06796f8cd','7426',NULL,NULL,NULL),(53,'gg','234','29b13d6be1f494e5a10cd5aa392685e23fedff87','da39a3ee5e6b4b0d3255bfef95601890afd80709',NULL,NULL,NULL),(54,'avv','6516','8578173555a47d4ea49e697badfda270dee0858f','da39a3ee5e6b4b0d3255bfef95601890afd80709',NULL,NULL,NULL),(55,'hh','123','f10e2821bbbea527ea02200352313bc059445190','da39a3ee5e6b4b0d3255bfef95601890afd80709',NULL,NULL,NULL),(56,'gg','123','f10e2821bbbea527ea02200352313bc059445190','da39a3ee5e6b4b0d3255bfef95601890afd80709',NULL,NULL,NULL),(57,'ff','asd','40bd001563085fc35165329ea1ff5c5ecbdbbeef','da39a3ee5e6b4b0d3255bfef95601890afd80709',NULL,NULL,NULL),(58,'asd','123','f10e2821bbbea527ea02200352313bc059445190','da39a3ee5e6b4b0d3255bfef95601890afd80709',NULL,NULL,NULL),(59,'asdrt','123','f10e2821bbbea527ea02200352313bc059445190','da39a3ee5e6b4b0d3255bfef95601890afd80709',NULL,NULL,NULL),(60,'att','123','8c1017982b2032cc059203e3d83dd0ee2e7a86b3','2a66ad41020da3ba6874714b006806d7c3e20805',NULL,NULL,NULL),(61,'fh','123','9a900f538965a426994e1e90600920aff0b4e8d2','82f752807893c63f06db6a25fe56160403214fb3',NULL,NULL,NULL),(62,'gg','123','f10e2821bbbea527ea02200352313bc059445190','5d838259e3c1b7c312e3c82dc30df1f526c31a77',NULL,NULL,NULL),(63,'asd','asd','f3226f91f77a87d909b8920adc91f9a301a7316b','56d73159a409620deb41d77cfefb381141d1d599',NULL,NULL,NULL),(64,'123','qaw','9a900f538965a426994e1e90600920aff0b4e8d2','6f62570437644d4721b266a162d20cc35889917f',NULL,NULL,NULL),(65,'123','123','7d956a6104bb41ca5c78fe7ac803d07753e701a9','6e56295615be063470ce266abb0f949f84090ccd',NULL,NULL,NULL),(66,'43','123','d435a6cdd786300dff204ee7c2ef942d3e9034e2','c8f2fec40d1522e4acf878fb17cacab7e869c2a0',NULL,NULL,NULL),(67,'asd','asd','f10e2821bbbea527ea02200352313bc059445190','8fae76b6d7e9f75979157002ac375aaa5babae59',NULL,NULL,NULL),(68,'aa@gmail.com','1563247822','f10e2821bbbea527ea02200352313bc059445190','3466c26c112f97e2b66594c7fa0000ab3d020e16',NULL,NULL,NULL),(69,'tt@gmail.com','1234554331','23fa12c6b4e9e3805a5e9d5dded3e78665fc1899','40ef75836dc7b2a61350f8e7e02a43a35f11a9b6',NULL,NULL,NULL),(70,'connor@gmail.com','4444444444','23fa12c6b4e9e3805a5e9d5dded3e78665fc1899','cb2cf5bb4a7e2f49a824a4be4969166be67270cd',NULL,NULL,NULL),(71,'yz@gmaail.com','1233444421','f10e2821bbbea527ea02200352313bc059445190','233393c4b1323936f055066ec565931adf738732',NULL,NULL,NULL),(72,'se@gmail.com','3333333332','f10e2821bbbea527ea02200352313bc059445190','d98826f75b0a3529d13d6bbde4c9b4c4690d555d',NULL,NULL,NULL),(73,'qq@gmail.com','8888888888','cd3f0c85b158c08a2b113464991810cf2cdfc387','732217de58820ef4dc0353a910df674a58084629',NULL,NULL,NULL),(74,'bc@gmail.com','6666666666','8c1017982b2032cc059203e3d83dd0ee2e7a86b3','01dc0cdf42fad09d711aeaa596c813946f884a8bc41ba94908ba4adb8748d116b8b102c9776d97dfc214360008ff656b82c7e3b0adf67ecf45e9beda2a4d0d30',NULL,NULL,NULL),(75,'ty@gmail.com','9999999999','a9993e364706816aba3e25717850c26c9cd0d89d','48884e69bbe15197bb9714b233b37202014e5a02',NULL,NULL,NULL),(76,'gh@gmail.com','5555555555','0c05aa56405c447e6678b7f3127febde5c3a9238','7340ca224c5c8d2b89562159a4d81d9225a20e65',NULL,NULL,NULL),(77,'rrr@gmail.com','7777777777','c64d3fcde20c5cd03142171e5ac47a87aa3c8ace','7939d77c5f0b439628d26abbcbf1cbcf90412b31',NULL,NULL,NULL),(78,'fz@gmail.com','3333332165','a9993e364706816aba3e25717850c26c9cd0d89d','75ab5e4e3b692fd9658d0a25da1bada758e2f817',NULL,NULL,NULL),(79,'tty@gmail.com','3232321236','a9993e364706816aba3e25717850c26c9cd0d89d','b5d4d427daafb74c01da5f875db9d87a6fac559b',NULL,NULL,NULL),(80,'patilabhishek007@gmail.com','9636932511','7110eda4d09e062aa5e4a390b0a572ac0d2c0220','d985e5dfb7a2aea378da758ac98e256d6eee917d',NULL,NULL,NULL),(81,'ravan1208@gmail.com','1156324598','8e545e1c31f91f777c894b3bd2c2e7d7044cc9dd','59dc237df3d441b6d490394e32cd6a41b3358d2f',NULL,NULL,NULL),(82,'abhishek','2316549853','a9993e364706816aba3e25717850c26c9cd0d89d','49748','2025-03-16','198',NULL),(83,'abhishek patil','3323652360','a9993e364706816aba3e25717850c26c9cd0d89d','29257','2025-03-16','214',NULL),(84,'prasad','1236547892','a9993e364706816aba3e25717850c26c9cd0d89d','18273','2025-03-16','109',NULL),(85,'pratik','0002130120','a9993e364706816aba3e25717850c26c9cd0d89d','52524',NULL,NULL,NULL),(86,NULL,NULL,NULL,NULL,'2025-03','131',NULL),(87,NULL,NULL,NULL,NULL,'2025-03','185',NULL),(88,NULL,NULL,NULL,NULL,'2025-03','131',NULL),(89,NULL,NULL,NULL,NULL,'2025-03','253',NULL),(90,'akash','9326923780','a9993e364706816aba3e25717850c26c9cd0d89d','68579','2025-03-16','229',NULL),(91,'abhi','7412589632','a9993e364706816aba3e25717850c26c9cd0d89d','90226','2025-03-16','122',NULL),(92,'sid','1111444420','a9993e364706816aba3e25717850c26c9cd0d89d','44647','2025-03-16','171',NULL),(93,'prakash','8108731205','a9993e364706816aba3e25717850c26c9cd0d89d','29438','2025-03-16','187',NULL),(94,'satish patil','3693216547','a9993e364706816aba3e25717850c26c9cd0d89d','39589',NULL,NULL,NULL),(95,'siddhesh','7896325412','a9993e364706816aba3e25717850c26c9cd0d89d','82501',NULL,NULL,'2025-03-18'),(96,'sham','1236547895','a9993e364706816aba3e25717850c26c9cd0d89d','57125',NULL,NULL,'2025-03-18'),(97,'jitesh','3698521470','a9993e364706816aba3e25717850c26c9cd0d89d','84460',NULL,NULL,'2025-03-18'),(98,'rohit','5698741230','a9993e364706816aba3e25717850c26c9cd0d89d','64993',NULL,NULL,'2025-03-18');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-03-18  2:19:04

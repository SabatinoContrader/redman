CREATE DATABASE  IF NOT EXISTS `redman` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `redman`;
-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: localhost    Database: redman
-- ------------------------------------------------------
-- Server version	8.0.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `funzioni`
--

DROP TABLE IF EXISTS `funzioni`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `funzioni` (
  `idfunzione` int(11) NOT NULL AUTO_INCREMENT,
  `infofunzione` varchar(45) NOT NULL,
  PRIMARY KEY (`idfunzione`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funzioni`
--

LOCK TABLES `funzioni` WRITE;
/*!40000 ALTER TABLE `funzioni` DISABLE KEYS */;
INSERT INTO `funzioni` VALUES (1,'calcolo area'),(2,'calcolo perimetro'),(3,'calcolo volume'),(4,'calcola temperatura'),(5,'calcola pressione'),(6,'controlla carrello'),(7,'controlla quota'),(8,'controlla motore');
/*!40000 ALTER TABLE `funzioni` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gruppi`
--

DROP TABLE IF EXISTS `gruppi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `gruppi` (
  `idgruppo` int(11) NOT NULL AUTO_INCREMENT,
  `infogruppo` varchar(45) NOT NULL,
  PRIMARY KEY (`idgruppo`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gruppi`
--

LOCK TABLES `gruppi` WRITE;
/*!40000 ALTER TABLE `gruppi` DISABLE KEYS */;
INSERT INTO `gruppi` VALUES (1,'GRUPPO1'),(2,'GRUPPO2'),(3,'GRUPPO3'),(4,'GRUPPO4'),(5,'GRUPPO5');
/*!40000 ALTER TABLE `gruppi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gruppi_has_funzioni`
--

DROP TABLE IF EXISTS `gruppi_has_funzioni`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `gruppi_has_funzioni` (
  `gruppi_idgruppo` int(11) NOT NULL,
  `funzioni_idfunzione` int(11) NOT NULL,
  PRIMARY KEY (`gruppi_idgruppo`,`funzioni_idfunzione`),
  KEY `fk_gruppi_has_funzioni_funzioni1_idx` (`funzioni_idfunzione`),
  KEY `fk_gruppi_has_funzioni_gruppi1_idx` (`gruppi_idgruppo`),
  CONSTRAINT `fk_gruppi_has_funzioni_funzioni1` FOREIGN KEY (`funzioni_idfunzione`) REFERENCES `funzioni` (`idfunzione`),
  CONSTRAINT `fk_gruppi_has_funzioni_gruppi1` FOREIGN KEY (`gruppi_idgruppo`) REFERENCES `gruppi` (`idgruppo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gruppi_has_funzioni`
--

LOCK TABLES `gruppi_has_funzioni` WRITE;
/*!40000 ALTER TABLE `gruppi_has_funzioni` DISABLE KEYS */;
INSERT INTO `gruppi_has_funzioni` VALUES (1,1),(5,1),(1,2),(3,2),(5,2),(1,3),(2,4),(3,4),(5,4),(4,5),(4,6),(5,7),(2,8);
/*!40000 ALTER TABLE `gruppi_has_funzioni` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (6);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequences`
--

DROP TABLE IF EXISTS `hibernate_sequences`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `hibernate_sequences` (
  `sequence_name` varchar(255) NOT NULL,
  `next_val` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`sequence_name`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequences`
--

LOCK TABLES `hibernate_sequences` WRITE;
/*!40000 ALTER TABLE `hibernate_sequences` DISABLE KEYS */;
INSERT INTO `hibernate_sequences` VALUES ('default',2);
/*!40000 ALTER TABLE `hibernate_sequences` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nodi`
--

DROP TABLE IF EXISTS `nodi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `nodi` (
  `idnodo` int(11) NOT NULL AUTO_INCREMENT,
  `idresponsabile` int(11) DEFAULT NULL,
  `idutentesemplice` int(11) DEFAULT NULL,
  `infonodo` varchar(45) NOT NULL,
  `statonodo` varchar(45) NOT NULL,
  `gruppi_idgruppo` int(11) NOT NULL,
  `utenti` int(11) DEFAULT NULL,
  `user_idutente` int(11) DEFAULT NULL,
  PRIMARY KEY (`idnodo`),
  KEY `fk_nodi_gruppi1_idx` (`gruppi_idgruppo`),
  KEY `idutente_idx` (`idresponsabile`,`idutentesemplice`),
  KEY `idutentesemplice` (`idutentesemplice`),
  KEY `FKew8m4p95rq92uiemj7egghbuq` (`utenti`),
  KEY `FKovpwuk92akwftbad6sjcsgdkb` (`user_idutente`),
  CONSTRAINT `FKew8m4p95rq92uiemj7egghbuq` FOREIGN KEY (`utenti`) REFERENCES `utenti` (`idutente`),
  CONSTRAINT `FKovpwuk92akwftbad6sjcsgdkb` FOREIGN KEY (`user_idutente`) REFERENCES `utenti` (`idutente`),
  CONSTRAINT `fk_nodi_gruppi1` FOREIGN KEY (`gruppi_idgruppo`) REFERENCES `gruppi` (`idgruppo`),
  CONSTRAINT `nodi_ibfk_1` FOREIGN KEY (`idresponsabile`) REFERENCES `utenti` (`idutente`),
  CONSTRAINT `nodi_ibfk_2` FOREIGN KEY (`idutentesemplice`) REFERENCES `utenti` (`idutente`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nodi`
--

LOCK TABLES `nodi` WRITE;
/*!40000 ALTER TABLE `nodi` DISABLE KEYS */;
INSERT INTO `nodi` VALUES (1,2,3,'Cpu = 1ghz; Ram = 1GB; Hdd = 4gb;','ON',1,NULL,NULL),(2,2,3,'Cpu = 1ghz; Ram = 1GB; Hdd = 4gb;','ON',2,NULL,NULL),(3,2,4,'Cpu = 1ghz; Ram = 1GB; Hdd = 4gb;','ON',3,NULL,NULL),(4,2,4,'Cpu = 2ghz; Ram = 2GB; Hdd = 8gb;','ON',4,NULL,NULL),(5,8,5,'Cpu = 1ghz; Ram = 2GB; Hdd = 8gb;','OFF',5,NULL,NULL),(8,9,7,'Cpu = 3ghz; Ram = 3GB; Hdd = 16gb;','OFF',3,NULL,NULL),(9,8,4,'Cpu = 3ghz; Ram = 3GB; Hdd = 16gb;','ON',1,NULL,NULL),(10,8,4,'Cpu = 3ghz; Ram = 3GB; Hdd = 16gb;','ON',2,NULL,NULL),(11,9,5,'Cpu = 3ghz; Ram = 3GB; Hdd = 16gb;','ON',3,NULL,NULL),(12,9,6,'Cpu = 3ghz; Ram = 3GB; Hdd = 16gb;','ON',4,NULL,NULL),(13,9,7,'Cpu = 3ghz; Ram = 3GB; Hdd = 16gb;','ON',5,NULL,NULL),(14,2,5,'Cpu = 3ghz; Ram = 3GB; Hdd = 16gb;','ON',1,NULL,NULL),(15,2,4,'Cpu = 3ghz; Ram = 3GB; Hdd = 16gb;','ON',2,NULL,NULL),(16,2,7,'Cpu = 3ghz; Ram = 3GB; Hdd = 16gb;','ON',3,NULL,NULL),(17,2,3,'Cpu = 3ghz; Ram = 3GB; Hdd = 16gb;','ON',4,NULL,NULL),(18,2,3,'Cpu = 3ghz; Ram = 3GB; Hdd = 16gb;','ON',5,NULL,NULL),(19,2,4,'Cpu = 3ghz; Ram = 3GB; Hdd = 16gb;','ON',1,NULL,NULL),(20,2,6,'Cpu = 3ghz; Ram = 3GB; Hdd = 16gb;','ON',2,NULL,NULL),(21,NULL,NULL,'Cpu = 3ghz; Ram = 3GB; Hdd = 16gb;','OFF',3,NULL,NULL),(22,NULL,NULL,'Cpu = 3ghz; Ram = 3GB; Hdd = 16gb;','OFF',4,NULL,NULL),(25,2,3,'Cpu = 1ghz; Ram = 1GB; Hdd = 4gb;','ON',1,NULL,NULL),(26,NULL,NULL,'Cpu = 1ghz; Ram = 1GB; Hdd = 4gb;','OFF',1,NULL,NULL),(27,8,4,'Cpu = 1ghz; Ram = 1GB; Hdd = 400gb;','STANDBY',4,NULL,NULL),(28,NULL,NULL,'Cpu = 1ghz; Ram = 1GB; Hdd = 256gb;','OFF',3,NULL,NULL),(31,NULL,NULL,'Cpu = 1ghz; Ram = 1GB; Hdd = 8gb;','ON',2,NULL,NULL);
/*!40000 ALTER TABLE `nodi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nodi_list`
--

DROP TABLE IF EXISTS `nodi_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `nodi_list` (
  `id_nodo` int(11) NOT NULL,
  `nodi_idnodo` int(11) NOT NULL,
  UNIQUE KEY `UK_onu4lnomejaq3m06a4qwlt168` (`nodi_idnodo`),
  KEY `FKbkjbl73eyts7n01fpmmiwyabt` (`id_nodo`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nodi_list`
--

LOCK TABLES `nodi_list` WRITE;
/*!40000 ALTER TABLE `nodi_list` DISABLE KEYS */;
/*!40000 ALTER TABLE `nodi_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tasks`
--

DROP TABLE IF EXISTS `tasks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tasks` (
  `idtask` int(11) NOT NULL AUTO_INCREMENT,
  `idnodo` int(11) DEFAULT NULL,
  `idutente` int(11) DEFAULT NULL,
  `infotask` varchar(45) NOT NULL,
  `statotask` varchar(45) NOT NULL,
  PRIMARY KEY (`idtask`),
  KEY `fk_tasks_nodi1_idx` (`idnodo`),
  KEY `fk_tasks_utenti_idx` (`idutente`),
  CONSTRAINT `fk_tasks_nodi1` FOREIGN KEY (`idnodo`) REFERENCES `nodi` (`idnodo`),
  CONSTRAINT `fk_tasks_utenti` FOREIGN KEY (`idutente`) REFERENCES `utenti` (`idutente`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tasks`
--

LOCK TABLES `tasks` WRITE;
/*!40000 ALTER TABLE `tasks` DISABLE KEYS */;
INSERT INTO `tasks` VALUES (1,1,2,'TASK1','EXE'),(2,1,2,'TASK2','EXE'),(3,4,2,'TASK3','EXE'),(4,2,2,'TASK4','IN PROGRESS'),(5,2,2,'TASK5','IN PROGRESS'),(6,3,2,'TASK6','FAULT'),(7,3,2,'TASK7','EXE'),(8,4,2,'TASK8','IN PROGRESS'),(9,5,8,'TASK9','EXE'),(10,5,8,'TASK10','IN PROGRESS'),(11,8,9,'TASK11','IN PROGRESS'),(12,8,9,'TASK12','EXE'),(13,9,8,'TASK13','IN PROGRESS'),(14,9,8,'TASK14','EXE'),(15,9,8,'TASK15','IN PROGRESS'),(16,4,2,'TASK16','IN PROGRESS'),(17,4,2,'TASK17','EXE'),(18,NULL,2,'TASK18','OFF'),(19,NULL,2,'TASK19','OFF'),(20,NULL,2,'TASK20','OFF'),(21,NULL,9,'TASK21','OFF'),(22,NULL,9,'TASK22','OFF'),(23,NULL,9,'TASK23','OFF'),(24,NULL,8,'TASK24','OFF'),(25,NULL,8,'TASK25','OFF');
/*!40000 ALTER TABLE `tasks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `id_utente` int(11) DEFAULT NULL,
  `id_responsabile` int(11) NOT NULL,
  PRIMARY KEY (`id_responsabile`),
  KEY `FK17blgnyxyjqbg2xt2m8bcy2px` (`id_utente`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utenti`
--

DROP TABLE IF EXISTS `utenti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `utenti` (
  `idutente` int(11) NOT NULL AUTO_INCREMENT,
  `ruolo` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`idutente`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utenti`
--

LOCK TABLES `utenti` WRITE;
/*!40000 ALTER TABLE `utenti` DISABLE KEYS */;
INSERT INTO `utenti` VALUES (1,'Amministratore','admin','admin'),(2,'Responsabile di rete','responsabile','responsabile'),(3,'Utente semplice','user','user'),(4,'Utente semplice','user1','user1'),(5,'Utente semplice','user2','user2'),(6,'Utente semplice','user3','user3'),(7,'Utente semplice','user4','user4'),(8,'Responsabile di rete','responsabile1','responsabile1'),(9,'Responsabile di rete','responsabile2','responsabile2'),(10,'Responsabile di rete','responsabile3','responsabile3'),(11,'Responsabile di rete','responsabile4','responsabile4'),(12,'Responsabile di rete','responsabile5','responsabile5'),(13,'Utente semplice','user5','user5'),(14,'Utente semplice','user6','user6'),(15,'Utente semplice','user7','user7'),(29,'Responsabile di rete','responsabile6','responsabile6'),(31,'Responsabile di rete','igdiugia','isgusd');
/*!40000 ALTER TABLE `utenti` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-08-27 12:45:14

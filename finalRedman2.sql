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
  PRIMARY KEY (`idnodo`),
  KEY `fk_nodi_gruppi1_idx` (`gruppi_idgruppo`),
  KEY `idutente_idx` (`idresponsabile`,`idutentesemplice`),
  KEY `idutentesemplice` (`idutentesemplice`),
  CONSTRAINT `fk_nodi_gruppi1` FOREIGN KEY (`gruppi_idgruppo`) REFERENCES `gruppi` (`idgruppo`),
  CONSTRAINT `nodi_ibfk_1` FOREIGN KEY (`idresponsabile`) REFERENCES `utenti` (`idutente`),
  CONSTRAINT `nodi_ibfk_2` FOREIGN KEY (`idutentesemplice`) REFERENCES `utenti` (`idutente`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nodi`
--

LOCK TABLES `nodi` WRITE;
/*!40000 ALTER TABLE `nodi` DISABLE KEYS */;
INSERT INTO `nodi` VALUES (1,2,3,'Cpu = 1ghz; Ram = 1GB; Hdd = 4gb;','ON',1),(2,2,3,'Cpu = 1ghz; Ram = 1GB; Hdd = 4gb;','ON',2),(3,2,4,'Cpu = 1ghz; Ram = 1GB; Hdd = 4gb;','ON',3),(4,2,4,'Cpu = 2ghz; Ram = 2GB; Hdd = 8gb;','ON',4),(5,8,5,'Cpu = 1ghz; Ram = 2GB; Hdd = 8gb;','OFF',5),(8,9,7,'Cpu = 3ghz; Ram = 3GB; Hdd = 16gb;','OFF',3),(9,8,4,'Cpu = 3ghz; Ram = 3GB; Hdd = 16gb;','ON',1),(10,8,4,'Cpu = 3ghz; Ram = 3GB; Hdd = 16gb;','ON',2),(11,9,5,'Cpu = 3ghz; Ram = 3GB; Hdd = 16gb;','ON',3),(12,9,6,'Cpu = 3ghz; Ram = 3GB; Hdd = 16gb;','ON',4),(13,9,7,'Cpu = 3ghz; Ram = 3GB; Hdd = 16gb;','ON',5),(14,2,5,'Cpu = 3ghz; Ram = 3GB; Hdd = 16gb;','ON',1),(15,2,4,'Cpu = 3ghz; Ram = 3GB; Hdd = 16gb;','ON',2),(16,2,7,'Cpu = 3ghz; Ram = 3GB; Hdd = 16gb;','ON',3),(17,2,3,'Cpu = 3ghz; Ram = 3GB; Hdd = 16gb;','ON',4),(18,2,3,'Cpu = 3ghz; Ram = 3GB; Hdd = 16gb;','ON',5),(19,2,4,'Cpu = 3ghz; Ram = 3GB; Hdd = 16gb;','ON',1),(20,2,6,'Cpu = 3ghz; Ram = 3GB; Hdd = 16gb;','ON',2);
/*!40000 ALTER TABLE `nodi` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utenti`
--

LOCK TABLES `utenti` WRITE;
/*!40000 ALTER TABLE `utenti` DISABLE KEYS */;
INSERT INTO `utenti` VALUES (1,'amministratore','admin','admin'),(2,'responsabile di rete','responsabile','responsabile'),(3,'utente semplice','user','user'),(4,'utente semplice','user1','user1'),(5,'utente semplice','user2','user2'),(6,'utente semplice','user3','user3'),(7,'utente semplice','user4','user4'),(8,'responsabile di rete','responsabile1','responsabile1'),(9,'responsabile di rete','responsabile2','responsabile2');
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

-- Dump completed on 2018-08-06 13:32:37

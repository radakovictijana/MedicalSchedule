/*
SQLyog Community v13.1.7 (64 bit)
MySQL - 10.4.32-MariaDB : Database - ordinacija
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ordinacija` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;

USE `ordinacija`;

/*Table structure for table `dijagnoza` */

DROP TABLE IF EXISTS `dijagnoza`;

CREATE TABLE `dijagnoza` (
  `dijagnozaId` int(11) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(50) NOT NULL,
  `sifra` varchar(50) NOT NULL,
  PRIMARY KEY (`dijagnozaId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `dijagnoza` */

insert  into `dijagnoza`(`dijagnozaId`,`naziv`,`sifra`) values 
(1,'Dijagnoza 1','sifra 1'),
(2,'Dijagnoza 2','sifra 2');

/*Table structure for table `doktor` */

DROP TABLE IF EXISTS `doktor`;

CREATE TABLE `doktor` (
  `doktorId` int(11) NOT NULL AUTO_INCREMENT,
  `imeDoktora` varchar(255) DEFAULT NULL,
  `prezimeDoktora` varchar(255) DEFAULT NULL,
  `JMBGDoktora` varchar(13) DEFAULT NULL,
  `specijalizacija` varchar(255) DEFAULT NULL,
  `telefonDoktora` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`doktorId`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `doktor` */

insert  into `doktor`(`doktorId`,`imeDoktora`,`prezimeDoktora`,`JMBGDoktora`,`specijalizacija`,`telefonDoktora`) values 
(1,'Tamara','Lazic','1234567654321','Neurologija','067453682'),
(3,'Lara','Zarkovic','9873246789352','Ginekologija','064213679'),
(4,'Marija','Gacic','0902346570981','Ginekologija','06754293'),
(5,'Miroslav','Gvozdenović','0902346570881','Neurologija','062345123'),
(6,'Lana','Jankovic','2312448020495','Oftamologija','064327485'),
(9,'Zarko','Zalic','0987654321234','Dermatologija','06537809'),
(11,'marko','marko','0987654321230','Ginekologija','7689'),
(12,'Petar','Petrovic','1234564321234','Dermatologija','06727642'),
(13,'Predrag','Nenadovic','3421346547896','Plasticna hirurgija','076089324');

/*Table structure for table `izvestaj` */

DROP TABLE IF EXISTS `izvestaj`;

CREATE TABLE `izvestaj` (
  `izvestajId` int(11) NOT NULL AUTO_INCREMENT,
  `datum` date DEFAULT NULL,
  `opis` varchar(50) DEFAULT NULL,
  `doktorId` int(11) DEFAULT NULL,
  `pacijentId` int(11) DEFAULT NULL,
  PRIMARY KEY (`izvestajId`),
  KEY `fk_ordinacija_doktorID` (`doktorId`),
  KEY `fk_ordinacija_pacijentID` (`pacijentId`),
  CONSTRAINT `fk_ordinacija_doktorID` FOREIGN KEY (`doktorId`) REFERENCES `doktor` (`doktorId`) ON UPDATE CASCADE,
  CONSTRAINT `fk_ordinacija_pacijentID` FOREIGN KEY (`pacijentId`) REFERENCES `pacijent` (`pacijentId`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `izvestaj` */

insert  into `izvestaj`(`izvestajId`,`datum`,`opis`,`doktorId`,`pacijentId`) values 
(38,'2024-01-01','Pacijent se javlja na bolove u grudima',9,3);

/*Table structure for table `pacijent` */

DROP TABLE IF EXISTS `pacijent`;

CREATE TABLE `pacijent` (
  `pacijentId` int(11) NOT NULL AUTO_INCREMENT,
  `imePacijenta` varchar(255) DEFAULT NULL,
  `prezimePacijenta` varchar(255) DEFAULT NULL,
  `adresaPacijenta` varchar(255) DEFAULT NULL,
  `JMBGPacijenta` varchar(13) DEFAULT NULL,
  `telefonPacijenta` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`pacijentId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `pacijent` */

insert  into `pacijent`(`pacijentId`,`imePacijenta`,`prezimePacijenta`,`adresaPacijenta`,`JMBGPacijenta`,`telefonPacijenta`) values 
(1,'Marko','Markovic','Bulevar Oslobodjenja 2','0804948901233','065432178'),
(2,'Biljana','Lalic','Jupiterova 45','2312678952343','065123456'),
(3,'Tijana','Markovic','Solarski Trg 10','1234567890987','064327883'),
(4,'Mirko','Mikic','Ratarska 10','1232123454326','06478909'),
(5,'Sara','Lakic','Gospodara Vucica 2','0908234563356','06348954'),
(6,'Sanja','Boricic','Dositejeva 12','2304321575578','06543735'),
(7,'Vanja','Veljkovic','Severni Bedem 23','5377484976777','06532784'),
(8,'Marko','Madzic','Masarikova 10','0974274284364','06437239');

/*Table structure for table `stavkeizvestaja` */

DROP TABLE IF EXISTS `stavkeizvestaja`;

CREATE TABLE `stavkeizvestaja` (
  `redniBroj` int(10) unsigned NOT NULL,
  `izvestajId` int(11) NOT NULL,
  `dijagnozaId` int(11) NOT NULL,
  PRIMARY KEY (`redniBroj`,`izvestajId`),
  KEY `fk_ordinacija_izvestaj` (`izvestajId`),
  KEY `fk_ordinacija_dijagnoza` (`dijagnozaId`),
  CONSTRAINT `fk_ordinacija_dijagnoza` FOREIGN KEY (`dijagnozaId`) REFERENCES `dijagnoza` (`dijagnozaId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ordinacija_izvestaj` FOREIGN KEY (`izvestajId`) REFERENCES `izvestaj` (`izvestajId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `stavkeizvestaja` */

/*Table structure for table `tehnicar` */

DROP TABLE IF EXISTS `tehnicar`;

CREATE TABLE `tehnicar` (
  `tehnicarId` int(11) NOT NULL AUTO_INCREMENT,
  `ime` varchar(30) NOT NULL,
  `prezime` varchar(30) NOT NULL,
  `korisnickoIme` varchar(30) NOT NULL,
  `lozinka` varchar(30) NOT NULL,
  PRIMARY KEY (`tehnicarId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `tehnicar` */

insert  into `tehnicar`(`tehnicarId`,`ime`,`prezime`,`korisnickoIme`,`lozinka`) values 
(1,'Pera','Peric','pera','pera'),
(2,'Tijana','Radakovic','tijana','tijana');

/*Table structure for table `termin` */

DROP TABLE IF EXISTS `termin`;

CREATE TABLE `termin` (
  `terminId` int(11) NOT NULL AUTO_INCREMENT,
  `datum` date NOT NULL,
  `intervencija` varchar(50) NOT NULL,
  `doktorId` int(11) NOT NULL,
  `pacijentId` int(11) NOT NULL,
  `tehnicarId` int(11) NOT NULL,
  PRIMARY KEY (`terminId`),
  KEY `fk_ordinacija_pacijent` (`pacijentId`),
  KEY `fk_ordinacija_doktor` (`doktorId`),
  KEY `fk_ordinacija_tehnicar` (`tehnicarId`),
  CONSTRAINT `fk_ordinacija_doktor` FOREIGN KEY (`doktorId`) REFERENCES `doktor` (`doktorId`),
  CONSTRAINT `fk_ordinacija_pacijent` FOREIGN KEY (`pacijentId`) REFERENCES `pacijent` (`pacijentId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_ordinacija_tehnicar` FOREIGN KEY (`tehnicarId`) REFERENCES `tehnicar` (`tehnicarId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `termin` */

insert  into `termin`(`terminId`,`datum`,`intervencija`,`doktorId`,`pacijentId`,`tehnicarId`) values 
(2,'2024-08-12','Pregled',5,1,1),
(3,'2024-08-12','Kontrola',1,1,1),
(4,'2024-08-15','Pregled',6,3,1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

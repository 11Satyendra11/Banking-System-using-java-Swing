-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.1.34-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win32
-- HeidiSQL Version:             9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for banksystem
DROP DATABASE IF EXISTS `banksystem`;
CREATE DATABASE IF NOT EXISTS `banksystem` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `banksystem`;

-- Dumping structure for table banksystem.accounts
DROP TABLE IF EXISTS `accounts`;
CREATE TABLE IF NOT EXISTS `accounts` (
  `id_Account` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `email` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `account_type` char(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  PRIMARY KEY (`id_Account`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;

-- Dumping data for table banksystem.accounts: ~5 rows (approximately)
DELETE FROM `accounts`;
/*!40000 ALTER TABLE `accounts` DISABLE KEYS */;
INSERT INTO `accounts` (`id_Account`, `email`, `password`, `account_type`, `username`) VALUES
	(1, 'csatyendra02@gmail.com', 'd41d8cd98f00b204e9800998ecf8427e', 'C', 'satya'),
	(6, '111@gmail.com', 'd41d8cd98f00b204e9800998ecf8427e', 'M', ''),
	(7, '1@gmail.com', 'd41d8cd98f00b204e9800998ecf8427e', 'A', ''),
	(10, 'rooon@gmail.com', 'astro1', 'C', 'rooom'),
	(23, 'saty@gmail.com', 'd41d8cd98f00b204e9800998ecf8427e', 'C', 'saty');
/*!40000 ALTER TABLE `accounts` ENABLE KEYS */;

-- Dumping structure for table banksystem.balancetable
DROP TABLE IF EXISTS `balancetable`;
CREATE TABLE IF NOT EXISTS `balancetable` (
  `id_Balance` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `balance` float unsigned NOT NULL DEFAULT '0',
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`id_Balance`),
  KEY `FK_BalanceTable_accounts_email` (`email`),
  CONSTRAINT `FK_BalanceTable_accounts_email` FOREIGN KEY (`email`) REFERENCES `accounts` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

-- Dumping data for table banksystem.balancetable: ~2 rows (approximately)
DELETE FROM `balancetable`;
/*!40000 ALTER TABLE `balancetable` DISABLE KEYS */;
INSERT INTO `balancetable` (`id_Balance`, `balance`, `email`) VALUES
	(1, 116, 'csatyendra02@gmail.com'),
	(17, 898, 'rooon@gmail.com');
/*!40000 ALTER TABLE `balancetable` ENABLE KEYS */;

-- Dumping structure for table banksystem.clienttable
DROP TABLE IF EXISTS `clienttable`;
CREATE TABLE IF NOT EXISTS `clienttable` (
  `id_client` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `accountNo` varchar(50) NOT NULL,
  `firstName` varchar(50) DEFAULT NULL,
  `lastName` varchar(50) DEFAULT NULL,
  `photo` blob,
  `dateOfBirth` varchar(50) DEFAULT NULL,
  `accountType` char(50) NOT NULL,
  `gender` char(50) DEFAULT NULL,
  `telephone` varchar(50) DEFAULT NULL,
  `house` varchar(100) DEFAULT NULL,
  `neighbourhood` varchar(100) DEFAULT NULL,
  `city` varchar(100) DEFAULT NULL,
  `country` varchar(100) DEFAULT NULL,
  `zipcode` varchar(100) DEFAULT NULL,
  `occupation` varchar(50) DEFAULT NULL,
  `mobile` varchar(50) DEFAULT NULL,
  `accountDepositType` char(50) DEFAULT NULL,
  `nationality` varchar(50) DEFAULT NULL,
  `Married` char(50) DEFAULT NULL,
  `spouceName` varchar(50) DEFAULT NULL,
  `birthPlace` varchar(50) DEFAULT NULL,
  `children` int(11) DEFAULT NULL,
  `bankAgency` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `iban` varchar(50) NOT NULL,
  `BIC` varchar(50) NOT NULL,
  PRIMARY KEY (`id_client`),
  UNIQUE KEY `accountNo` (`accountNo`),
  UNIQUE KEY `BIC` (`BIC`),
  UNIQUE KEY `iban` (`iban`),
  KEY `FK_clienttable_accounts_email` (`email`),
  CONSTRAINT `FK_clienttable_accounts_email` FOREIGN KEY (`email`) REFERENCES `accounts` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- Dumping data for table banksystem.clienttable: ~2 rows (approximately)
DELETE FROM `clienttable`;
/*!40000 ALTER TABLE `clienttable` DISABLE KEYS */;
INSERT INTO `clienttable` (`id_client`, `accountNo`, `firstName`, `lastName`, `photo`, `dateOfBirth`, `accountType`, `gender`, `telephone`, `house`, `neighbourhood`, `city`, `country`, `zipcode`, `occupation`, `mobile`, `accountDepositType`, `nationality`, `Married`, `spouceName`, `birthPlace`, `children`, `bankAgency`, `email`, `iban`, `BIC`) VALUES
	(1, 'e4424234', 'Satyendra', 'Chandan', NULL, '1991-02-07', 'C', 'M', '766023707', 'App,46, Residence Saint Mark', 'Saint Mark', 'Rouen', 'France', '76000', 'Student', '766023707', 'saving', 'Indian', 'yes', 'Kristina', 'Mumbai', 2, 'Rouen', 'csatyendra02@gmail.com', 'FR528423223154041SWISSFR78731', '23223'),
	(3, 'SWISSFR78731', 'roon', 'ronny', NULL, NULL, 'C', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'rooon@gmail.com', 'FR528420091154041SWISSFR78731', '20091'),
	(6, 'SWISSFR34981', NULL, NULL, NULL, NULL, 'C', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'saty@gmail.com', 'FR74872721150861SWISSFR34981', '72721');
/*!40000 ALTER TABLE `clienttable` ENABLE KEYS */;

-- Dumping structure for table banksystem.manager
DROP TABLE IF EXISTS `manager`;
CREATE TABLE IF NOT EXISTS `manager` (
  `id_Manager` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `firstName` varchar(50) DEFAULT NULL,
  `lastName` varchar(50) DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  `emailClient` varchar(50) NOT NULL,
  `accountType` char(50) NOT NULL,
  PRIMARY KEY (`id_Manager`),
  KEY `FK_Manager_accounts_email` (`email`),
  KEY `FK_Manager_clienttable_email` (`emailClient`),
  CONSTRAINT `FK_Manager_accounts_email` FOREIGN KEY (`email`) REFERENCES `accounts` (`email`),
  CONSTRAINT `FK_Manager_clienttable_email` FOREIGN KEY (`emailClient`) REFERENCES `clienttable` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table banksystem.manager: ~0 rows (approximately)
DELETE FROM `manager`;
/*!40000 ALTER TABLE `manager` DISABLE KEYS */;
/*!40000 ALTER TABLE `manager` ENABLE KEYS */;

-- Dumping structure for table banksystem.officeadvisor
DROP TABLE IF EXISTS `officeadvisor`;
CREATE TABLE IF NOT EXISTS `officeadvisor` (
  `id_OfficeAdvisor` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `firstName` varchar(50) DEFAULT NULL,
  `lastName` varchar(50) DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  `emailClient` varchar(50) NOT NULL,
  `accountType` char(50) NOT NULL,
  PRIMARY KEY (`id_OfficeAdvisor`),
  KEY `FK_OfficeAdvisor_accounts_email` (`email`),
  KEY `FK_officeadvisor_clienttable_email` (`emailClient`),
  CONSTRAINT `FK_OfficeAdvisor_accounts_email` FOREIGN KEY (`email`) REFERENCES `accounts` (`email`),
  CONSTRAINT `FK_officeadvisor_clienttable_email` FOREIGN KEY (`emailClient`) REFERENCES `clienttable` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table banksystem.officeadvisor: ~0 rows (approximately)
DELETE FROM `officeadvisor`;
/*!40000 ALTER TABLE `officeadvisor` DISABLE KEYS */;
/*!40000 ALTER TABLE `officeadvisor` ENABLE KEYS */;

-- Dumping structure for table banksystem.transactiontable
DROP TABLE IF EXISTS `transactiontable`;
CREATE TABLE IF NOT EXISTS `transactiontable` (
  `id_bankBalance` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `transactionName` varchar(100) NOT NULL,
  `debit` float unsigned DEFAULT '0',
  `credit` float unsigned DEFAULT '0',
  `dateOfTransaction` date NOT NULL,
  `email` varchar(50) NOT NULL,
  `iban` varchar(50) NOT NULL,
  `bic` varchar(50) NOT NULL,
  `accountNo` varchar(100) NOT NULL,
  `accountNoRecipient` varchar(50) NOT NULL,
  `emailIDRecipient` varchar(50) DEFAULT NULL,
  `bicRecipient` varchar(50) NOT NULL,
  PRIMARY KEY (`id_bankBalance`),
  KEY `FK_transactiontable_accounts_email` (`email`),
  KEY `FK_transactiontable_clienttable_bic` (`bic`),
  KEY `FK_transactiontable_clienttable_accountNo` (`accountNo`),
  KEY `FK_transactiontable_clienttable_iban` (`iban`),
  CONSTRAINT `FK_transactiontable_accounts_email` FOREIGN KEY (`email`) REFERENCES `accounts` (`email`),
  CONSTRAINT `FK_transactiontable_clienttable_accountNo` FOREIGN KEY (`accountNo`) REFERENCES `clienttable` (`accountNo`),
  CONSTRAINT `FK_transactiontable_clienttable_bic` FOREIGN KEY (`bic`) REFERENCES `clienttable` (`BIC`),
  CONSTRAINT `FK_transactiontable_clienttable_iban` FOREIGN KEY (`iban`) REFERENCES `clienttable` (`iban`)
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=latin1;

-- Dumping data for table banksystem.transactiontable: ~69 rows (approximately)
DELETE FROM `transactiontable`;
/*!40000 ALTER TABLE `transactiontable` DISABLE KEYS */;
INSERT INTO `transactiontable` (`id_bankBalance`, `transactionName`, `debit`, `credit`, `dateOfTransaction`, `email`, `iban`, `bic`, `accountNo`, `accountNoRecipient`, `emailIDRecipient`, `bicRecipient`) VALUES
	(1, 'dsfsdfsdfs', 200, 0, '2019-01-05', 'csatyendra02@gmail.com', 'FR528423223154041SWISSFR78731', '23223', 'e4424234', '3232323232', 'ddsdasda@gmail.com', '232232'),
	(2, 'd d', 0, 1, '2019-01-23', 'csatyendra02@gmail.com', 'FR528423223154041SWISSFR78731', '23223', 'e4424234', 'e4424234', NULL, '23223'),
	(3, 'ww ww', 0, 22, '2019-01-23', 'csatyendra02@gmail.com', 'FR528423223154041SWISSFR78731', '23223', 'e4424234', 'e4424234', 'csatyendra02@gmail.com', '23223'),
	(4, 'ww ww', 0, 22, '2019-01-23', 'csatyendra02@gmail.com', 'FR528423223154041SWISSFR78731', '23223', 'e4424234', 'e4424234', 'csatyendra02@gmail.com', '23223'),
	(5, 'qq qq', 200, 0, '2019-01-23', 'csatyendra02@gmail.com', 'FR528423223154041SWISSFR78731', '23223', 'e4424234', '3434342342', 'doggy@gmail.com', '32323'),
	(6, 'roon ronny', 1000, 0, '2019-01-23', 'csatyendra02@gmail.com', 'FR528423223154041SWISSFR78731', '23223', 'e4424234', 'FR528420091154041SWISSFR78731', 'rooon@gmail.com', '20091'),
	(7, 'roon ronny', 200, 0, '2019-01-23', 'csatyendra02@gmail.com', 'FR528423223154041SWISSFR78731', '23223', 'e4424234', 'FR528420091154041SWISSFR78731', 'rooon@gmail.com', '20091'),
	(8, 'roon ronny', 200, 0, '2019-01-23', 'rooon@gmail.com', 'FR528420091154041SWISSFR78731', '20091', 'SWISSFR78731', 'e4424234', 'csatyendra02@gmail.com', '23223'),
	(9, 'roon ronny', 100, 0, '2019-01-23', 'csatyendra02@gmail.com', 'FR528423223154041SWISSFR78731', '23223', 'e4424234', 'FR528420091154041SWISSFR78731', 'rooon@gmail.com', '20091'),
	(10, 'roon ronny', 0, 100, '2019-01-23', 'rooon@gmail.com', 'FR528420091154041SWISSFR78731', '20091', 'SWISSFR78731', 'e4424234', 'csatyendra02@gmail.com', '23223'),
	(11, 'satya chan', 200, 0, '2019-01-23', 'rooon@gmail.com', 'FR528420091154041SWISSFR78731', '20091', 'SWISSFR78731', '32323323232', 'csatyendra02@gmail.com', '23223'),
	(12, 'satya chan', 0, 200, '2019-01-23', 'csatyendra02@gmail.com', 'FR528423223154041SWISSFR78731', '23223', 'e4424234', 'SWISSFR78731', 'rooon@gmail.com', '20091'),
	(13, 'a a', 2, 0, '2019-01-23', 'rooon@gmail.com', 'FR528420091154041SWISSFR78731', '20091', 'SWISSFR78731', '2323', '', '323'),
	(14, 'satya chandan', 0, 20, '2019-01-23', 'csatyendra02@gmail.com', 'FR528423223154041SWISSFR78731', '23223', 'e4424234', 'e4424234', 'csatyendra02@gmail.com', '23223'),
	(26, 'dd dd', 0, 20, '2019-01-23', 'csatyendra02@gmail.com', 'FR528423223154041SWISSFR78731', '23223', 'e4424234', 'e4424234', 'csatyendra02@gmail.com', '23223'),
	(27, 'dd dd', 0, 20, '2019-01-23', 'csatyendra02@gmail.com', 'FR528423223154041SWISSFR78731', '23223', 'e4424234', 'e4424234', 'csatyendra02@gmail.com', '23223'),
	(28, 'dd dd', 0, 20, '2019-01-23', 'csatyendra02@gmail.com', 'FR528423223154041SWISSFR78731', '23223', 'e4424234', 'e4424234', 'csatyendra02@gmail.com', '23223'),
	(29, 'dd dd', 0, 20, '2019-01-23', 'csatyendra02@gmail.com', 'FR528423223154041SWISSFR78731', '23223', 'e4424234', 'e4424234', 'csatyendra02@gmail.com', '23223'),
	(30, 'dd dd', 0, 20, '2019-01-23', 'csatyendra02@gmail.com', 'FR528423223154041SWISSFR78731', '23223', 'e4424234', 'e4424234', 'csatyendra02@gmail.com', '23223'),
	(31, 'dd dd', 0, 20, '2019-01-23', 'csatyendra02@gmail.com', 'FR528423223154041SWISSFR78731', '23223', 'e4424234', 'e4424234', 'csatyendra02@gmail.com', '23223'),
	(32, 'dd dd', 0, 20, '2019-01-23', 'csatyendra02@gmail.com', 'FR528423223154041SWISSFR78731', '23223', 'e4424234', 'e4424234', 'csatyendra02@gmail.com', '23223'),
	(34, 'dd dd', 20, 0, '2019-01-23', 'csatyendra02@gmail.com', 'FR528423223154041SWISSFR78731', '23223', 'e4424234', '', '', ''),
	(35, 'dff dfd', 323, 0, '2019-01-23', 'csatyendra02@gmail.com', 'FR528423223154041SWISSFR78731', '23223', 'e4424234', 'dfdssf', '', 'dfsd'),
	(36, 'dff dfd', 323, 0, '2019-01-23', 'csatyendra02@gmail.com', 'FR528423223154041SWISSFR78731', '23223', 'e4424234', 'dfdssf', '', '44332'),
	(37, 'dff dfd', 323, 0, '2019-01-23', 'csatyendra02@gmail.com', 'FR528423223154041SWISSFR78731', '23223', 'e4424234', 'dfdssf', '', ''),
	(38, 'dff dfd', 0, 323, '2019-01-23', 'csatyendra02@gmail.com', 'FR528423223154041SWISSFR78731', '23223', 'e4424234', 'e4424234', 'csatyendra02@gmail.com', '23223'),
	(39, 'dff dfd', 0, 323, '2019-01-23', 'csatyendra02@gmail.com', 'FR528423223154041SWISSFR78731', '23223', 'e4424234', 'e4424234', 'csatyendra02@gmail.com', '23223'),
	(40, 'dff dfd', 0, 323, '2019-01-23', 'csatyendra02@gmail.com', 'FR528423223154041SWISSFR78731', '23223', 'e4424234', 'e4424234', 'csatyendra02@gmail.com', '23223'),
	(41, 'dff dfd', 0, 323, '2019-01-23', 'csatyendra02@gmail.com', 'FR528423223154041SWISSFR78731', '23223', 'e4424234', 'e4424234', 'csatyendra02@gmail.com', '23223'),
	(42, 'dff dfd', 0, 323, '2019-01-23', 'csatyendra02@gmail.com', 'FR528423223154041SWISSFR78731', '23223', 'e4424234', 'e4424234', 'csatyendra02@gmail.com', '23223'),
	(43, 'dff dfd', 0, 323, '2019-01-23', 'csatyendra02@gmail.com', 'FR528423223154041SWISSFR78731', '23223', 'e4424234', 'e4424234', 'csatyendra02@gmail.com', '23223'),
	(44, 'dff dfd', 0, 323, '2019-01-23', 'csatyendra02@gmail.com', 'FR528423223154041SWISSFR78731', '23223', 'e4424234', 'e4424234', 'csatyendra02@gmail.com', '23223'),
	(45, 'dff dfd', 0, 323, '2019-01-23', 'csatyendra02@gmail.com', 'FR528423223154041SWISSFR78731', '23223', 'e4424234', 'e4424234', 'csatyendra02@gmail.com', '23223'),
	(46, 'dff dfd', 0, 323, '2019-01-23', 'csatyendra02@gmail.com', 'FR528423223154041SWISSFR78731', '23223', 'e4424234', 'e4424234', 'csatyendra02@gmail.com', '23223'),
	(47, 'dd dd', 33, 0, '2019-01-23', 'csatyendra02@gmail.com', 'FR528423223154041SWISSFR78731', '23223', 'e4424234', 'dfsd', '', 'dfd'),
	(48, 'dd dd', 33, 0, '2019-01-23', 'csatyendra02@gmail.com', 'FR528423223154041SWISSFR78731', '23223', 'e4424234', 'dfsd', '', ''),
	(49, 'dd dd', 33, 0, '2019-01-23', 'csatyendra02@gmail.com', 'FR528423223154041SWISSFR78731', '23223', 'e4424234', '', '', ''),
	(50, 'dd ', 20, 0, '2019-01-23', 'csatyendra02@gmail.com', 'FR528423223154041SWISSFR78731', '23223', 'e4424234', 'dfd', '', 'fdfdf'),
	(51, 'dd ', 20, 0, '2019-01-23', 'csatyendra02@gmail.com', 'FR528423223154041SWISSFR78731', '23223', 'e4424234', 'dfd', '', 'fdfdf'),
	(52, 'dd ', 20, 0, '2019-01-23', 'csatyendra02@gmail.com', 'FR528423223154041SWISSFR78731', '23223', 'e4424234', '', '', ''),
	(53, ' ', 1, 0, '2019-01-23', 'csatyendra02@gmail.com', 'FR528423223154041SWISSFR78731', '23223', 'e4424234', '', '', '1'),
	(54, ' ', 2, 0, '2019-01-23', 'csatyendra02@gmail.com', 'FR528423223154041SWISSFR78731', '23223', 'e4424234', '', '', ''),
	(55, ' ', 2, 0, '2019-01-23', 'csatyendra02@gmail.com', 'FR528423223154041SWISSFR78731', '23223', 'e4424234', '', '', ''),
	(56, ' ', 3, 0, '2019-01-23', 'csatyendra02@gmail.com', 'FR528423223154041SWISSFR78731', '23223', 'e4424234', '', '', ''),
	(57, ' ', 3, 0, '2019-01-23', 'csatyendra02@gmail.com', 'FR528423223154041SWISSFR78731', '23223', 'e4424234', '', '', ''),
	(58, ' ', 3, 0, '2019-01-23', 'csatyendra02@gmail.com', 'FR528423223154041SWISSFR78731', '23223', 'e4424234', '', '', ''),
	(59, 'fdfsdfsdf dfsdfs', 3, 0, '2019-01-23', 'csatyendra02@gmail.com', 'FR528423223154041SWISSFR78731', '23223', 'e4424234', 'dsfdfs', '', ''),
	(60, 'fdfsdfsdf dfsdfs', 3, 0, '2019-01-23', 'csatyendra02@gmail.com', 'FR528423223154041SWISSFR78731', '23223', 'e4424234', 'dsfdfs', '', ''),
	(61, 'fdfsdfsdf dfsdfs', 3, 0, '2019-01-23', 'csatyendra02@gmail.com', 'FR528423223154041SWISSFR78731', '23223', 'e4424234', '', '', ''),
	(62, ' ', 4, 0, '2019-01-23', 'csatyendra02@gmail.com', 'FR528423223154041SWISSFR78731', '23223', 'e4424234', '', '', ''),
	(63, 'dfdfd fdfs', 4, 0, '2019-01-23', 'csatyendra02@gmail.com', 'FR528423223154041SWISSFR78731', '23223', 'e4424234', '', '', ''),
	(64, 'dfdfd fdfs', 4, 0, '2019-01-23', 'csatyendra02@gmail.com', 'FR528423223154041SWISSFR78731', '23223', 'e4424234', '', '', ''),
	(65, 'dfdf ', 3, 0, '2019-01-23', 'csatyendra02@gmail.com', 'FR528423223154041SWISSFR78731', '23223', 'e4424234', '', '', ''),
	(66, ' ', 3, 0, '2019-01-23', 'csatyendra02@gmail.com', 'FR528423223154041SWISSFR78731', '23223', 'e4424234', '', '', '3'),
	(67, ' ', 3, 0, '2019-01-23', 'csatyendra02@gmail.com', 'FR528423223154041SWISSFR78731', '23223', 'e4424234', '', '', ''),
	(68, ' ', 2, 0, '2019-01-23', 'csatyendra02@gmail.com', 'FR528423223154041SWISSFR78731', '23223', 'e4424234', '', '', ''),
	(69, 'ewew rer', 2, 0, '2019-01-23', 'csatyendra02@gmail.com', 'FR528423223154041SWISSFR78731', '23223', 'e4424234', '', '', ''),
	(70, ' ', 2, 0, '2019-01-23', 'csatyendra02@gmail.com', 'FR528423223154041SWISSFR78731', '23223', 'e4424234', '', '', ''),
	(71, ' ', 2, 0, '2019-01-23', 'csatyendra02@gmail.com', 'FR528423223154041SWISSFR78731', '23223', 'e4424234', '', '', ''),
	(72, '33 ', 2, 0, '2019-01-23', 'csatyendra02@gmail.com', 'FR528423223154041SWISSFR78731', '23223', 'e4424234', '', '', ''),
	(73, '33 44', 2, 0, '2019-01-23', 'csatyendra02@gmail.com', 'FR528423223154041SWISSFR78731', '23223', 'e4424234', '', '', ''),
	(74, '33 44', 2, 0, '2019-01-23', 'csatyendra02@gmail.com', 'FR528423223154041SWISSFR78731', '23223', 'e4424234', '555', '', ''),
	(75, '33 44', 2, 0, '2019-01-23', 'csatyendra02@gmail.com', 'FR528423223154041SWISSFR78731', '23223', 'e4424234', '555', '', '444'),
	(76, '33 44', 2, 0, '2019-01-23', 'csatyendra02@gmail.com', 'FR528423223154041SWISSFR78731', '23223', 'e4424234', '555', '', '444'),
	(77, '33 44', 2, 0, '2019-01-23', 'csatyendra02@gmail.com', 'FR528423223154041SWISSFR78731', '23223', 'e4424234', '555', '', '444'),
	(78, '33 44', 2, 0, '2019-01-23', 'csatyendra02@gmail.com', 'FR528423223154041SWISSFR78731', '23223', 'e4424234', '', '', '444'),
	(79, '33 44', 2, 0, '2019-01-23', 'csatyendra02@gmail.com', 'FR528423223154041SWISSFR78731', '23223', 'e4424234', '', '', '444'),
	(80, 'Satyendra Chandan', 0, 1, '2019-01-29', 'csatyendra02@gmail.com', 'FR528423223154041SWISSFR78731', '23223', 'e4424234', 'e4424234', 'csatyendra02@gmail.com', '23223'),
	(81, 'gajodar gajodar', 1, 0, '2019-01-29', 'csatyendra02@gmail.com', 'FR528423223154041SWISSFR78731', '23223', 'e4424234', '232243242424', 'gajodar@gmail.com', '4222');
/*!40000 ALTER TABLE `transactiontable` ENABLE KEYS */;

-- Dumping structure for table banksystem.transfermoney
DROP TABLE IF EXISTS `transfermoney`;
CREATE TABLE IF NOT EXISTS `transfermoney` (
  `idTransfer` int(11) NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(50) NOT NULL,
  `LastName` varchar(50) NOT NULL,
  `bic` varchar(50) NOT NULL,
  `amount` float NOT NULL,
  `iban` varchar(50) NOT NULL,
  PRIMARY KEY (`idTransfer`)
) ENGINE=InnoDB AUTO_INCREMENT=90 DEFAULT CHARSET=latin1;

-- Dumping data for table banksystem.transfermoney: ~82 rows (approximately)
DELETE FROM `transfermoney`;
/*!40000 ALTER TABLE `transfermoney` DISABLE KEYS */;
INSERT INTO `transfermoney` (`idTransfer`, `FirstName`, `LastName`, `bic`, `amount`, `iban`) VALUES
	(1, 'dffdfd', 'dfdfdf', '42323', 20000, '313142133131212'),
	(4, 'satyendra', 'chandan', 'rouen', 232331, 'FR528420091154041SWISSFR78732'),
	(5, 'dango', 'chand', '34342', 499, '34343425245245'),
	(6, 'dhc', '', '', 0, ''),
	(7, 'jonny', 'walker', '23223', 2000, '32323323232'),
	(8, 'dom', 'dom', '23223', 323, '32323323232'),
	(9, 'dom', 'dom', '23223', 323, '32323323232'),
	(10, 'dom', 'dom', '23223', 323, '32323323232'),
	(11, 'dom', 'dom', '23223', 323, '32323323232'),
	(12, 'dom', 'dom', '23223', 32, '32323323232'),
	(13, 'doom', 'doom', '23223', 33, '32323323232'),
	(14, 'doom', 'doom1', '23223', 44, '32323323232'),
	(15, 'ddoo', 'dd', '23223', 33, '32323323232'),
	(16, 'dd', 'dd', '23223', 22, '32323323232'),
	(17, 'dfdf', 'dfdf', '23223', 323, '32323323232'),
	(18, 'dfdf', 'dfdf', '23223', 323, '32323323232'),
	(19, 'dsd', 'dds', '23223', 33, '32323323232'),
	(20, 'eee', 'eee', '23223', 232, '32323323232'),
	(21, 'ss', 'ss', '23223', 1, '32323323232'),
	(22, 'ss', 'ss', '23223', 1, '32323323232'),
	(23, 'dd', 'd', '23223', 1, '32323323232'),
	(24, 'd', 'd', '23223', 1, '32323323232'),
	(25, 'd', 'd', '23223', 1, '32323323232'),
	(26, 'qq', 'qq', '32323', 3, '323232323'),
	(27, 'qq', 'qq', '2133131', 22, '1211311'),
	(28, 'ww', 'ww', '23223', 22, '32323323232'),
	(29, 'qq', 'qq', '32323', 200, '3434342342'),
	(30, 'roon', 'ronny', '20091', 1000, 'FR528420091154041SWISSFR78731'),
	(31, 'roon', 'ronny', '20091', 200, 'FR528420091154041SWISSFR78731'),
	(32, 'roon', 'ronny', '20091', 100, 'FR528420091154041SWISSFR78731'),
	(33, 'satya', 'chan', '23223', 200, '32323323232'),
	(34, 'a', 'a', '323', 2, '2323'),
	(35, 'satya', 'chandan', '23223', 20, '32323323232'),
	(36, 'satya', 'chandan', '', 20, '32323323232'),
	(37, 'satya', 'chandan', '', 20, '32323323232'),
	(38, 'satya', 'chandan', '', 20, '32323323232'),
	(39, 'satya', 'chandan', '', 20, '32323323232'),
	(40, 'dd', 'dd', '', 20, '32323323232'),
	(41, 'dd', 'dd', '', 20, ''),
	(42, 'dd', 'dd', '', 0, '32323323232'),
	(43, 'dff', 'dfd', 'dfsd', 323, 'dfdssf'),
	(44, 'dff', 'dfd', '44332', 323, 'dfdssf'),
	(45, 'dff', 'dfd', '', 323, 'dfdssf'),
	(46, 'dff', 'dfd', '23223', 323, '32323323232'),
	(47, 'dff', 'dfd', '23223', 323, '32323323232'),
	(48, 'dff', 'dfd', '23223', 323, '32323323232'),
	(49, 'dff', 'dfd', '23223', 323, '32323323232'),
	(50, 'dff', 'dfd', '23223', 323, '32323323232'),
	(51, 'dff', 'dfd', '23223', 323, '32323323232'),
	(52, 'dff', 'dfd', '23223', 323, '32323323232'),
	(53, 'dff', 'dfd', '23223', 323, '32323323232'),
	(54, 'dff', 'dfd', '23223', 323, '32323323232'),
	(55, 'dd', 'dd', 'dfd', 33, 'dfsd'),
	(56, 'dd', 'dd', '', 33, 'dfsd'),
	(57, 'dd', 'dd', '', 33, ''),
	(58, 'dd', '', 'fdfdf', 20, 'dfd'),
	(59, 'dd', '', 'fdfdf', 20, 'dfd'),
	(60, 'dd', '', '', 20, ''),
	(61, '', '', '1', 1, ''),
	(62, '', '', '', 2, ''),
	(63, '', '', '', 2, ''),
	(64, '', '', '', 3, ''),
	(65, '', '', '', 3, ''),
	(66, '', '', '', 3, ''),
	(67, 'fdfsdfsdf', 'dfsdfs', '', 3, 'dsfdfs'),
	(68, 'fdfsdfsdf', 'dfsdfs', '', 3, 'dsfdfs'),
	(69, 'fdfsdfsdf', 'dfsdfs', '', 3, ''),
	(70, '', '', '', 4, ''),
	(71, 'dfdfd', 'fdfs', '', 4, ''),
	(72, 'dfdfd', 'fdfs', '', 4, ''),
	(73, 'dfdf', '', '', 3, ''),
	(74, '', '', '3', 3, ''),
	(75, '', '', '', 3, ''),
	(76, '', '', '', 2, ''),
	(77, 'ewew', 'rer', '', 2, ''),
	(78, '', '', '', 2, ''),
	(79, '', '', '', 2, ''),
	(80, '33', '', '', 2, ''),
	(81, '33', '44', '', 2, ''),
	(82, '33', '44', '', 2, '555'),
	(83, '33', '44', '444', 2, '555'),
	(84, '33', '44', '444', 2, '555'),
	(85, '33', '44', '444', 2, '555'),
	(86, '33', '44', '444', 2, ''),
	(87, '33', '44', '444', 2, ''),
	(88, 'Satyendra', 'Chandan', '23223', 1, '32323323232'),
	(89, 'gajodar', 'gajodar', '4222', 1, '232243242424');
/*!40000 ALTER TABLE `transfermoney` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

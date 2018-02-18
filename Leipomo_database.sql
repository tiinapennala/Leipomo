-- --------------------------------------------------------
-- Host:                         localhost
-- Server version:               5.5.47-MariaDB-1~wheezy-log - mariadb.org binary distribution
-- Server OS:                    debian-linux-gnu
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for XXX
CREATE DATABASE IF NOT EXISTS `XXX` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `XXX`;

-- Dumping structure for table XXX.tuotteet
CREATE TABLE IF NOT EXISTS `tuotteet` (
  `tuotenro` int(11) NOT NULL AUTO_INCREMENT,
  `nimi` varchar(50) NOT NULL,
  `tyyppi` varchar(30) NOT NULL,
  `hinta` double NOT NULL,
  `kuvaus` varchar(500) DEFAULT NULL,
  `lopetettu` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`tuotenro`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

-- Dumping data for table XXX.tuotteet: ~20 rows (approximately)
/*!40000 ALTER TABLE `tuotteet` DISABLE KEYS */;
INSERT INTO `tuotteet` (`tuotenro`, `nimi`, `tyyppi`, `hinta`, `kuvaus`, `lopetettu`) VALUES
	(1, 'Suklaa passionkakku', 'Kakku', 25, '16 annosta', 0),
	(2, 'Saaristolaisleipä', 'Leipä', 7, '7-8 annosta', 0),
	(3, 'Macaron', 'Makea leivos', 2.1, 'Laktoositon', 0),
	(4, 'Mansikkakakku', 'Täytekakku', 35, '15-20 henk.', 0),
	(5, 'Berliininmunkki', 'Makea leivos', 2, '', 0),
	(6, 'Karjalanpiirakka', 'Suolainen leivos', 1.2, '', 0),
	(7, 'Mansikkamarenkileivos', 'Makea leivos', 4.5, 'Laktoositon, gluteeniton', 0),
	(8, 'Red Velvet cup cake', 'Makea leivos', 3.5, '', 0),
	(9, 'Korvapuusti', 'Makea leivos', 2, '', 0),
	(10, 'Mustikkapulla', 'Pulla / Makea leivos', 1.5, '', 0),
	(11, 'Maalaiskinkkusämpylä', 'Sämpylä', 4.5, 'Laktoositon', 0),
	(12, 'Rouhesämpylä', 'Sämpylä', 1, '', 0),
	(13, 'Perunarieska', 'Leipä', 1, '', 1),
	(14, 'Kauraleipä', 'Leipä', 3, 'Laktoositon', 0),
	(15, 'testi', 'testailu', 3, '', 1),
	(16, 'testausta', 'mikkihiiri', 1, '', 1),
	(17, 'Ruislevain', 'leipä', 3.7, '', 0),
	(18, 'Omenarahkamuru', 'Makea leivos', 1.5, '', 1),
	(19, 'juustokakku', 'kakku', 49, 'mansikkaa päällä 1 hengen kakku', 0),
	(20, 'Raparperikakku', 'Kakku', 4, '', 0);
/*!40000 ALTER TABLE `tuotteet` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

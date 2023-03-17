/*
SQLyog Community v9.10 
MySQL - 5.5.13 : Database - video_club
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`video_club` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `video_club`;

/*Table structure for table `alquiler` */

DROP TABLE IF EXISTS `alquiler`;

CREATE TABLE `alquiler` (
  `idAlquiler` int(11) NOT NULL AUTO_INCREMENT,
  `idClientes` int(10) unsigned NOT NULL,
  `fechaInicioAlquiler` varchar(50) DEFAULT NULL,
  `horaInicioAlquiler` varchar(50) DEFAULT NULL,
  `fechaFinAlquiler` varchar(50) DEFAULT NULL,
  `montoTotalAlquiler` decimal(10,0) DEFAULT NULL,
  `cantidadEjemplaresAlquilados` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`idAlquiler`),
  KEY `Alquiler_FKIndex1` (`idClientes`),
  CONSTRAINT `alquiler_ibfk_1` FOREIGN KEY (`idClientes`) REFERENCES `clientes` (`idClientes`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

/*Data for the table `alquiler` */

LOCK TABLES `alquiler` WRITE;

insert  into `alquiler`(`idAlquiler`,`idClientes`,`fechaInicioAlquiler`,`horaInicioAlquiler`,`fechaFinAlquiler`,`montoTotalAlquiler`,`cantidadEjemplaresAlquilados`) values (6,1,'26/9/2012','4:23:35','1/8/2012','30000',2),(7,5,'27/9/2012','7:47:35','4/10/2012','30000',2),(8,1,'27/9/2012','4:49:5','1/8/2012','60000',4),(9,1,'28/9/2012','3:26:8','1/8/2012','40000',2),(10,6,'2/10/2012','6:45:8','1/8/2012','999',999),(11,6,'2/10/2012','6:50:32','7/10/2012','40000',4);

UNLOCK TABLES;

/*Table structure for table `clientes` */

DROP TABLE IF EXISTS `clientes`;

CREATE TABLE `clientes` (
  `idClientes` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `CIclientes` varchar(12) DEFAULT NULL,
  `NombreCliente` varchar(50) DEFAULT NULL,
  `ApellidoCliente` varchar(50) DEFAULT NULL,
  `DireccionCliente` varchar(100) DEFAULT NULL,
  `TelefonoCliente` varchar(10) NOT NULL,
  `CorreoCliente` varchar(50) DEFAULT NULL,
  `tipoCliente` varchar(6) DEFAULT NULL,
  `sexoCliente` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`idClientes`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

/*Data for the table `clientes` */

LOCK TABLES `clientes` WRITE;

insert  into `clientes`(`idClientes`,`CIclientes`,`NombreCliente`,`ApellidoCliente`,`DireccionCliente`,`TelefonoCliente`,`CorreoCliente`,`tipoCliente`,`sexoCliente`) values (1,'5610549','Mario','Rodriguez','Mcal Estigarribia c/ Fulgencio Yegros','0982268513','m_ruben_rodriguez@hotmail.es','Socio','Masculino'),(2,'3655332','Vicente','Paredes','Mcal Estigarribia c/ Fulgencio Yegros - Limpio','0982514190','vicentedavid@hotmail.com','Socio','Masculino'),(3,'987678','Gerardo','Alarcon','Fulgencio yegros c/ San Jose - Limpio','096784903','','Socio','Masculino'),(4,'3287495','Eulalia','Hidalgo','Fulgencio Yegros c/ Mcal Estigarribia - Limpio','0983345917','jessy_comercial@hotmail.com','Socio','Femenino'),(5,'6135535','Yennifer','Fleita','San Jose c/ 1º de marzo - Limpio','0984555173','','Socio','Femenino'),(6,'4834502','Jose','Otazu','Costa Azul - Limpio','0982347626','joseotazu@hotmail.com','Socio','Masculino'),(7,'5596036','samantha','sirai','limpio','4444444','samanthasirai@hotmail.com','Socio','Femenino');

UNLOCK TABLES;

/*Table structure for table `detalle_pelicula` */

DROP TABLE IF EXISTS `detalle_pelicula`;

CREATE TABLE `detalle_pelicula` (
  `pel_cod` int(12) NOT NULL,
  `alq_nro` int(12) NOT NULL,
  `det_cantidad` int(11) NOT NULL,
  `det_fechadevolucion` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `detalle_pelicula` */

LOCK TABLES `detalle_pelicula` WRITE;

UNLOCK TABLES;

/*Table structure for table `detalledevolucion` */

DROP TABLE IF EXISTS `detalledevolucion`;

CREATE TABLE `detalledevolucion` (
  `idEjemplar` int(11) NOT NULL,
  `idDevolucion` int(10) unsigned NOT NULL,
  `cantidadLineaDetalleDevolucion` int(10) unsigned DEFAULT NULL,
  `diasDeMora` int(10) unsigned DEFAULT NULL,
  `DeudaLinea` int(11) DEFAULT NULL,
  `idDetalleDevolucion` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idDetalleDevolucion`),
  KEY `Ejemplar_has_Devolucion_FKIndex1` (`idEjemplar`),
  KEY `Ejemplar_has_Devolucion_FKIndex2` (`idDevolucion`),
  CONSTRAINT `detalledevolucion_ibfk_1` FOREIGN KEY (`idEjemplar`) REFERENCES `ejemplar` (`idEjemplar`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `detalledevolucion_ibfk_2` FOREIGN KEY (`idDevolucion`) REFERENCES `devolucion` (`idDevolucion`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

/*Data for the table `detalledevolucion` */

LOCK TABLES `detalledevolucion` WRITE;

insert  into `detalledevolucion`(`idEjemplar`,`idDevolucion`,`cantidadLineaDetalleDevolucion`,`diasDeMora`,`DeudaLinea`,`idDetalleDevolucion`) values (12,10,1,57,114000,1),(1,10,1,57,57000,2),(12,11,1,57,114000,3),(1,11,1,57,57000,4),(12,12,1,57,114000,5),(1,12,1,57,57000,6),(1,12,1,57,57000,7),(2,12,1,57,57000,8),(7,12,1,57,114000,9),(5,12,1,57,114000,10),(64,13,1,32,32000,11),(65,13,1,32,32000,12),(2,13,1,32,32000,13),(3,13,1,32,32000,14),(1,14,1,39,39000,15),(2,14,1,39,39000,16),(7,14,1,39,78000,17),(5,14,1,39,78000,18),(12,14,1,39,78000,19),(1,14,1,39,39000,20);

UNLOCK TABLES;

/*Table structure for table `detallesalquiler` */

DROP TABLE IF EXISTS `detallesalquiler`;

CREATE TABLE `detallesalquiler` (
  `idEjemplar` int(11) NOT NULL,
  `idAlquiler` int(11) NOT NULL,
  `cantidadLineaDetalleAlquiler` int(10) unsigned DEFAULT NULL,
  `importeLineaDetalleAlquiler` decimal(10,0) DEFAULT NULL,
  `iddetallealquiler` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`iddetallealquiler`),
  KEY `Ejemplar_has_Alquiler_FKIndex1` (`idEjemplar`),
  KEY `Ejemplar_has_Alquiler_FKIndex2` (`idAlquiler`),
  CONSTRAINT `detallesalquiler_ibfk_1` FOREIGN KEY (`idEjemplar`) REFERENCES `ejemplar` (`idEjemplar`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `detallesalquiler_ibfk_2` FOREIGN KEY (`idAlquiler`) REFERENCES `alquiler` (`idAlquiler`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

/*Data for the table `detallesalquiler` */

LOCK TABLES `detallesalquiler` WRITE;

insert  into `detallesalquiler`(`idEjemplar`,`idAlquiler`,`cantidadLineaDetalleAlquiler`,`importeLineaDetalleAlquiler`,`iddetallealquiler`) values (12,6,1,'20000',1),(1,6,1,'10000',2),(45,7,1,'20000',3),(32,7,1,'10000',4),(1,8,1,'10000',5),(2,8,1,'10000',6),(7,8,1,'20000',7),(5,8,1,'20000',8),(76,9,1,'20000',9),(77,9,1,'20000',10),(64,11,1,'10000',11),(65,11,1,'10000',12),(2,11,1,'10000',13),(3,11,1,'10000',14);

UNLOCK TABLES;

/*Table structure for table `detalleventa` */

DROP TABLE IF EXISTS `detalleventa`;

CREATE TABLE `detalleventa` (
  `idVenta` int(11) NOT NULL,
  `idEjemplar` int(11) NOT NULL,
  `cantidadLineaDetalleVenta` int(10) unsigned DEFAULT NULL,
  `importeDetalleVenta` decimal(10,0) DEFAULT NULL,
  `iddetalleventa` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`iddetalleventa`),
  KEY `Venta_has_Ejemplar_FKIndex1` (`idVenta`),
  KEY `Venta_has_Ejemplar_FKIndex2` (`idEjemplar`),
  CONSTRAINT `detalleventa_ibfk_1` FOREIGN KEY (`idVenta`) REFERENCES `venta` (`idVenta`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `detalleventa_ibfk_2` FOREIGN KEY (`idEjemplar`) REFERENCES `ejemplar` (`idEjemplar`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `detalleventa` */

LOCK TABLES `detalleventa` WRITE;

UNLOCK TABLES;

/*Table structure for table `devolucion` */

DROP TABLE IF EXISTS `devolucion`;

CREATE TABLE `devolucion` (
  `idDevolucion` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `idClientes` int(10) unsigned NOT NULL,
  `fechaDevolucion` varchar(50) DEFAULT NULL,
  `horaDevolucion` varchar(50) DEFAULT NULL,
  `cantidadEjemplaresDevueltos` int(10) unsigned DEFAULT NULL,
  `diasDeMoraDevolucion` int(10) unsigned DEFAULT NULL,
  `deudaTotalDevolucion` int(11) DEFAULT NULL,
  PRIMARY KEY (`idDevolucion`),
  KEY `Devolucion_FKIndex1` (`idClientes`),
  CONSTRAINT `devolucion_ibfk_1` FOREIGN KEY (`idClientes`) REFERENCES `clientes` (`idClientes`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

/*Data for the table `devolucion` */

LOCK TABLES `devolucion` WRITE;

insert  into `devolucion`(`idDevolucion`,`idClientes`,`fechaDevolucion`,`horaDevolucion`,`cantidadEjemplaresDevueltos`,`diasDeMoraDevolucion`,`deudaTotalDevolucion`) values (10,1,'27/9/2012','4:3:45',2,57,171000),(11,1,'27/9/2012','4:22:11',2,57,171000),(12,1,'27/9/2012','4:50:19',2,57,513000),(13,6,'2/10/2012','6:52:24',999,32,128000),(14,1,'9/11/2012','7:22:7',4,39,351000);

UNLOCK TABLES;

/*Table structure for table `ejemplar` */

DROP TABLE IF EXISTS `ejemplar`;

CREATE TABLE `ejemplar` (
  `idEjemplar` int(11) NOT NULL AUTO_INCREMENT,
  `idPelicula` int(11) NOT NULL,
  `formatoEjemplar` varchar(8) DEFAULT NULL,
  `precioAlquilerEjemplar` decimal(10,0) DEFAULT NULL,
  `PrecioVentaEjemplar` decimal(10,0) DEFAULT NULL,
  `estadoEjemplar` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idEjemplar`),
  KEY `Ejemplar_FKIndex1` (`idPelicula`),
  CONSTRAINT `ejemplar_ibfk_1` FOREIGN KEY (`idPelicula`) REFERENCES `pelicula` (`idPelicula`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2069 DEFAULT CHARSET=latin1;

/*Data for the table `ejemplar` */

LOCK TABLES `ejemplar` WRITE;

insert  into `ejemplar`(`idEjemplar`,`idPelicula`,`formatoEjemplar`,`precioAlquilerEjemplar`,`PrecioVentaEjemplar`,`estadoEjemplar`) values (1,1,'DVD','10000','40000','libre'),(2,1,'DVD','10000','40000','libre'),(3,1,'DVD','10000','40000','libre'),(4,1,'DVD','10000','40000','libre'),(5,1,'Blu-Ray','20000','80000','libre'),(6,1,'Blu-Ray','20000','80000','libre'),(7,1,'Blu-Ray','20000','80000','libre'),(8,2,'DVD','10000','40000','libre'),(9,2,'DVD','10000','40000','libre'),(10,2,'DVD','10000','40000','libre'),(11,2,'DVD','10000','40000','libre'),(12,2,'Blu-Ray','20000','80000','libre'),(13,2,'Blu-Ray','20000','80000','libre'),(14,2,'Blu-Ray','20000','80000','libre'),(15,2,'Blu-Ray','20000','80000','libre'),(16,3,'DVD','10000','40000','libre'),(17,3,'DVD','10000','40000','libre'),(18,3,'DVD','10000','40000','libre'),(19,3,'DVD','20000','80000','libre'),(20,3,'Blu-Ray','20000','80000','Vendido'),(21,3,'Blu-Ray','20000','80000','libre'),(22,3,'Blu-Ray','20000','80000','libre'),(23,3,'Blu-Ray','20000','80000','libre'),(32,5,'DVD','10000','40000','alquilado'),(33,5,'DVD','10000','40000','libre'),(34,5,'DVD','10000','40000','libre'),(35,5,'DVD','10000','40000','libre'),(36,5,'Blu-Ray','20000','80000','libre'),(37,5,'Blu-Ray','20000','80000','libre'),(38,5,'Blu-Ray','20000','80000','libre'),(39,5,'Blu-Ray','20000','80000','libre'),(40,6,'Blu-Ray','20000','80000','libre'),(41,7,'DVD','10000','40000','libre'),(42,7,'DVD','10000','40000','libre'),(43,7,'DVD','10000','40000','libre'),(44,7,'DVD','10000','40000','libre'),(45,7,'Blu-Ray','20000','80000','alquilado'),(46,7,'Blu-Ray','20000','80000','libre'),(47,7,'Blu-Ray','20000','80000','libre'),(48,7,'Blu-Ray','20000','80000','libre'),(49,8,'DVD','10000','40000','libre'),(50,8,'DVD','10000','40000','libre'),(51,8,'DVD','10000','40000','libre'),(52,8,'DVD','10000','40000','libre'),(53,8,'Blu-Ray','20000','80000','libre'),(54,8,'Blu-Ray','20000','80000','libre'),(55,8,'Blu-Ray','20000','80000','libre'),(56,8,'Blu-Ray','20000','80000','libre'),(57,6,'DVD','10000','40000','libre'),(58,6,'DVD','10000','40000','libre'),(59,6,'DVD','10000','40000','libre'),(60,6,'Blu-Ray','20000','80000','libre'),(61,6,'Blu-Ray','20000','80000','libre'),(62,6,'Blu-Ray','20000','80000','libre'),(63,6,'Blu-Ray','20000','80000','libre'),(64,9,'DVD','10000','40000','libre'),(65,9,'DVD','10000','40000','libre'),(66,9,'DVD','10000','40000','libre'),(67,9,'DVD','10000','40000','libre'),(68,9,'Blu-Ray','20000','80000','libre'),(69,9,'Blu-Ray','20000','80000','libre'),(70,9,'Blu-Ray','20000','80000','libre'),(71,9,'Blu-Ray','20000','80000','libre'),(72,10,'DVD','10000','40000','libre'),(73,10,'DVD','10000','40000','libre'),(74,10,'DVD','10000','40000','libre'),(75,10,'DVD','10000','40000','libre'),(76,10,'Blu-Ray','20000','80000','alquilado'),(77,10,'Blu-Ray','20000','80000','alquilado'),(78,10,'Blu-Ray','20000','80000','Vendido'),(79,10,'Blu-Ray','20000','80000','libre'),(80,11,'DVD','10000','40000','libre'),(81,11,'DVD','10000','40000','libre'),(82,11,'DVD','10000','40000','libre'),(83,11,'DVD','10000','40000','libre'),(84,11,'Blu-Ray','20000','80000','libre'),(85,11,'Blu-Ray','20000','80000','libre'),(86,11,'Blu-Ray','20000','80000','libre'),(87,11,'Blu-Ray','20000','80000','libre'),(88,12,'DVD','10000','40000','libre'),(89,12,'DVD','10000','40000','libre'),(90,12,'DVD','10000','40000','libre'),(91,12,'DVD','10000','40000','libre'),(92,12,'Blu-Ray','20000','80000','libre'),(93,12,'Blu-Ray','20000','80000','libre'),(94,12,'Blu-Ray','20000','80000','libre'),(95,12,'Blu-Ray','20000','80000','libre'),(96,1,'DVD','10000','40000','libre'),(97,1,'DVD','10000','40000','libre'),(98,1,'DVD','10000','40000','libre'),(99,1,'DVD','20000','80000','libre'),(100,1,'DVD','20000','80000','libre'),(101,1,'DVD','20000','80000','libre'),(2053,1,'DVD','10000','40000','Libre'),(2054,4,'DVD','10000','40000','libre'),(2055,4,'DVD','10000','40000','libre'),(2056,4,'DVD','10000','40000','libre'),(2057,4,'DVD','10000','40000','libre'),(2058,5,'Blu-Ray','20000','80000','libre'),(2059,5,'Blu-Ray','20000','80000','libre'),(2060,5,'Blu-Ray','20000','80000','libre'),(2061,5,'Blu-Ray','20000','80000','libre'),(2062,10,'DVD','10000','40000','libre'),(2063,10,'DVD','10000','40000','libre'),(2064,10,'Blu-Ray','10000','40000','libre'),(2065,10,'Blu-Ray','10000','40000','libre'),(2066,1,'DVD','10000','40000','libre'),(2067,1,'DVD','10000','40000','libre'),(2068,3,'DVD','10000','40000','libre');

UNLOCK TABLES;

/*Table structure for table `empleados` */

DROP TABLE IF EXISTS `empleados`;

CREATE TABLE `empleados` (
  `emp_cod` int(10) NOT NULL AUTO_INCREMENT,
  `emp_nombre` varchar(45) NOT NULL,
  `emp_apellido` varchar(45) NOT NULL,
  `emp_tel` varchar(45) NOT NULL,
  `emp_direc` varchar(45) NOT NULL,
  PRIMARY KEY (`emp_cod`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `empleados` */

LOCK TABLES `empleados` WRITE;

UNLOCK TABLES;

/*Table structure for table `genero` */

DROP TABLE IF EXISTS `genero`;

CREATE TABLE `genero` (
  `idGenero` int(11) NOT NULL AUTO_INCREMENT,
  `descripcionGenero` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`idGenero`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

/*Data for the table `genero` */

LOCK TABLES `genero` WRITE;

insert  into `genero`(`idGenero`,`descripcionGenero`) values (1,'Aventura'),(2,'Comedia'),(3,'Ciencia Ficción'),(4,'Drama'),(5,'Familiar'),(6,'Terror');

UNLOCK TABLES;

/*Table structure for table `pelicula` */

DROP TABLE IF EXISTS `pelicula`;

CREATE TABLE `pelicula` (
  `idPelicula` int(11) NOT NULL AUTO_INCREMENT,
  `PaisPelicula` varchar(50) DEFAULT NULL,
  `idGenero` int(11) NOT NULL,
  `tituloPelicula` varchar(100) DEFAULT NULL,
  `duracionPelicula` varchar(10) DEFAULT NULL,
  `directorPelicula` varchar(50) DEFAULT NULL,
  `actoresPelicula` varchar(800) DEFAULT NULL,
  `sinopsisPelicula` varchar(800) DEFAULT NULL,
  `Stock_Pelicula` int(11) DEFAULT NULL,
  PRIMARY KEY (`idPelicula`),
  KEY `Pelicula_FKIndex1` (`idGenero`),
  KEY `Pelicula_FKIndex2` (`PaisPelicula`),
  CONSTRAINT `pelicula_ibfk_1` FOREIGN KEY (`idGenero`) REFERENCES `genero` (`idGenero`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

/*Data for the table `pelicula` */

LOCK TABLES `pelicula` WRITE;

insert  into `pelicula`(`idPelicula`,`PaisPelicula`,`idGenero`,`tituloPelicula`,`duracionPelicula`,`directorPelicula`,`actoresPelicula`,`sinopsisPelicula`,`Stock_Pelicula`) values (1,'Estados Unidos (2011)',3,'TRANSFORMERS EL LADO OSCURO DE LA LUNA','150 min.','Michael Bay.','Rosie Huntington-whiteley, Shia Labeouf,\n Patrick Dempsey, Hugo Weaving , John\n Malkovich Y Josh Duhamel.','Los Autobots, liderados por Optimus Prime vuelven a la acción\n luchando con los malvados Decepticons, que están decididos \na\n vengar su derrota en 2009. En esta nueva película, los Autobots y los\n Decepticons se involucran en \nuna peligrosa carrera espacial entre los\n EE.UU. y Rusia, y una vez más Sam Witwicky tiene que acudir en\n ayuda \nde sus amigos. Hay nuevos personajes también, incluyendo un\n nuevo villano.',15),(2,'Estados Unidos (2011)',6,'MASACRE EN CADENA','87 min','Deon Taylor','Nikki Reed,Brad Dourif,\nKeith David, Betsy Russell, \nLing Bai','Seis amigos reciben una misteriosa cadena vía SMS y en sus cuentas \nde e-mail de un \nmaníaco que esta cazando, a los que la rompen. \n¿Qun iba pensar que una cadena debía tomarse en serio?, o \n¿que no \nreenviarla podría tener consecuencias fatales? \nJessie (Nikki Reed) deberá descubrir quién es el maníaco y cómo \nempezó \nla cadena, para tratar de salvar su vida.',8),(3,'Uruguay (2011)',6,'LA CASA MUDA','83 min.','Gustavo Hernández','\nFlorencia Colucci, Gustavo Alonso, Abel Trinaldi, \nMaria Salazar','Laura (Florencia Colucci) y su \npadre Wilson (Gustavo Alonso) son \ncontratados para restaurar una lejana casona de campo, cuyo dueño \nçnNéstor (Abel Tripaldi) quiere poner a la venta. Comienzan a trabajar y \ntodo transcurre con normalidad \nhasta que Laura scucha un sonido \nque procede de fuera y se intensifica en el piso superior de la casa. \nnWilson sube a inspeccionar mientras ella se queda esperando \nabajo... \nBasado en un suceso real ocurrido en\n 1944, en una vieja casa de \ncampo donde fueron que encontraron los cuerpos de dos hombres \nbrutalmente\n  torturados, sin lengua ni ojos. Las inquantes \nfotografías que se encontraron fueron la clave para resolver \n  el \nsangriento crimen.',8),(4,'Estados Unidos (2011)',4,'SIN LIMITE','105 min','Neil Burger','Bradley Cooper,\n Abbie Cornish, Robert De Niro,\n Anna Friel, Andrew Howard, Johnny Whitworth,\n Robert John Burke, Tomas Arana\n ','Un escritor (Bradley Cooper), que sufre una crisis de creatividad, \nprueba un día una nueva droga que lo pone\n  en condiciones de usar al \nmáximo todas sus facultades mentales; es una especie de píldora inteligente \ngracias a \n  la cual consigue triunfar en Nueva York. Un poderoso financiero de Wall Street (De Niro) \nsiente una extraordinaria\n   curiosidad por averiguar qué se esconde detrás de \ntanto éxito... ',5),(5,'Estados Unidos (2011)',2,'LOS PINGÜINOS DE PAPÁ','95 min.','Mark Waters','Jim Carrey, Carla \nGugino, Madeline Carroll, \nOphelia Lovibond, Angela Lansbury, Kelli Barrett, \nPhilip Baker Hall y James Tupper.','El Sr. \nPoppvive en una pequeña y aburrida ciudad llamada\n Stillwater. Quizá por eso se ha convertido en un soñador y en un\n especi\nalista en temas del Ártico y de la Antártida. Un día, en una\n estación de radio, obtiene como premio la oportunidad de dialogar\n con el almirante Drake sobre su expedición a la Antártida, y éste le\n dice que pronto recibirá una sorpresa? lo que nadie podía suponer \nes que, el almirante enviaría una caja con un ¡pingüino de la \nmismísima Antártida! Cambiando radicalmente la tranquila vida del \nSr. Popper, y transformando a Stillwater en una fantástica y \npermanente aventura llena de pingüinos.',8),(6,'Estados Unidos (2011)',2,'EL GUARDIAN DEL ZOOLOGICO','110 min.','Frank Coraci','Kevin James, Rosario Dawson.','\"No le hables a los animales... A menos que ellos te hablen primero\".\n En Zookeeper, los animales en el zoológico de Franklin Park aman\n a su guardián, Griffin Keyes (Kevin James), un hombre de buen\n corazón. Aarse cuenta que con este trabajo nunca podrá\n conquistar a la chica de sus sueños, Griffin decide dejar el zoológico\n y encontrar un trabajo más glamoroso. Pero los animales, en estado\n de pánico, deciden romper su código de larga tradición de silencio y\n revelar su mayor secreto: ¡pueden hablar! Y para evitar que Griffin\n se vaya, deciden enseñarle las reglas del cortejo? al estilo animal.',8),(7,'Estados Unidos (2008)',3,'DURA DE LIGAR','100 min.','Stephen Belber','Jennifer Aniston, Steve Zahn','Mike trabaja en el motel de sus padres en un pequeño pueblito\n perdido en medio de Estados Unidos. Un día llega ahí Sue, quien es\n una vendedora freelance de arte barato, con quien sostiene una\n aventura. Él es dulce y no tiene más ambiciones que pasar tiempo\n con ella, pero la chica simplemente continúa con su vida como si\n nada. Cuando Mike se da cuenta de lo enamorado que está de Sue\n, decide buscarla por todo el país para lograr conquistarle una\n manera o de otra.',8),(8,'Estados Unidos (2011)',2,'QUIERO MATAR A MI JEFE','100 min.','Seth Gordon','Colin Farrell, Jason Bateman, Jennifer Aniston','Para Nick, Kurt y Dale, la única solución para hacer su rutina diaria\n más tolerable sería hacer desaparecer a sus intolerables jefes. No\n pueden dejar el trabajo, así que, con la ayuda de unas copas de más\n y el consejo poco fiable de un ex convicto buscavidas, los tres\n amigos conciben un enrevesado y al parecer infalible plan para\n deshacerse de sus respectivos jefes?para siempre. Sólo hay un\n problema: incluso los planes mejor ideados sólo son tan infalibles\n como los cerebros que los crearon.',8),(9,'Estados Unidos (2011)',2,'KUNG FU PANDA 2','90 min.','Jennifer Yuh','Jack Black, Angelina Jolie Y Jackie Chan.','Po ahora está viviendo su sueño siendo el Guerrero Dragón,\n protegiendo el Valle de la Paz junto a sus amigos, los maestros del\n Kunu (Tigresa, Grulla, Mantis, Víbora y Mono). Pero la nueva vida\n de Po está amenazada por la aparición de un villano formidable, que\n planea usar una pavorosa arma secreta, imparable para la conquista\n de China y destruir el Kung Fu.',8),(10,'Estados Unidos (2011)',5,'CAPITAN AMERICA: EL PRIMER VENGADOR','100 min.','Joe Johnston','Chris Evans, Hugo Weaving, Stanley Tucci.','Al ser considerado no apto para el servicio militar, Steve Roger \nse presenta como voluntario para un proyecto de investigación ultra \nsecreto. Cuando ingresa a este proyecto asume una nueva identidad, \nla de Capitán América, un superhéroe que destinará su vida a \ndefender los ideales Americanos.',12),(11,'Estados Unidos (2011)',6,'SCREAM 4','87 min.','Wes Craven.','Neve Campbell, David Arquette,Courteney Cox, \nEmma Roberts,Hayden Panettiere, Rory Culkin.','Sidney Prescott regresa a Woodsboro, durante una gira de \npromoción de su nuevo libre autoayuda. Cuando llega al pueblo \nse reencuentra con Dewey, quien ahora es el comisario, y con Gale, \nsu flamante esposa. Pero en cuanto Sidney pone un pie en \nWoodsboro, el viejo asesino que la marcó profundamente cuando \nera una adolescente también reaparece. \nCon la ayuda de su prima Jill y algunos de sus compañeros de \nescuela, Sidney intentará mantenerse con vida, al menos el tiempo \nsuficiente para descifrar las nuevas reglas del juego y desenmascarar \nal nuevo asesino.',8),(12,'Estados Unidos (2011)',4,'TRISTE SAN VALENTIN','105 min.','Derek Cianfrance','Ryan Gosling, Michelle Williams. Faith Wladyka,\nJohn Doman.',' Narra la historia de los momentos que pasan entre el amor perdido y\n del amor recuperado. Abrumados por recuerdos románticos, Dean y\n Cindy pasan una noche intentando salvar su matrimonio. Ryan \nGosling y Michelle Williams protagonizan este retrato de una pareja \nque se hunde.',8);

UNLOCK TABLES;

/*Table structure for table `peliculas` */

DROP TABLE IF EXISTS `peliculas`;

CREATE TABLE `peliculas` (
  `pel_cod` int(12) NOT NULL AUTO_INCREMENT,
  `tip_cod` int(10) NOT NULL,
  `pel_nombre` varchar(45) NOT NULL,
  `pel_duracion` time DEFAULT NULL,
  `pel_precio` varchar(40) NOT NULL,
  `pel_existencia` varchar(20) NOT NULL,
  `pel_descri` varchar(45) NOT NULL,
  PRIMARY KEY (`pel_cod`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `peliculas` */

LOCK TABLES `peliculas` WRITE;

UNLOCK TABLES;

/*Table structure for table `socios` */

DROP TABLE IF EXISTS `socios`;

CREATE TABLE `socios` (
  `soc_cod` int(10) NOT NULL AUTO_INCREMENT,
  `soc_nombre` varchar(45) NOT NULL,
  `soc_apellido` varchar(45) NOT NULL,
  `soc_telefono` varchar(45) NOT NULL,
  `soc_direc` varchar(45) NOT NULL,
  PRIMARY KEY (`soc_cod`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `socios` */

LOCK TABLES `socios` WRITE;

UNLOCK TABLES;

/*Table structure for table `tipo_pelicula` */

DROP TABLE IF EXISTS `tipo_pelicula`;

CREATE TABLE `tipo_pelicula` (
  `tip_cod` int(12) NOT NULL AUTO_INCREMENT,
  `tip_descri` varchar(45) NOT NULL,
  PRIMARY KEY (`tip_cod`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tipo_pelicula` */

LOCK TABLES `tipo_pelicula` WRITE;

UNLOCK TABLES;

/*Table structure for table `usuario` */

DROP TABLE IF EXISTS `usuario`;

CREATE TABLE `usuario` (
  `Login` varchar(20) NOT NULL,
  `Contrasena` varchar(8) NOT NULL,
  `nombres` varchar(50) DEFAULT NULL,
  `apellidos` varchar(50) DEFAULT NULL,
  `cargo` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Login`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `usuario` */

LOCK TABLES `usuario` WRITE;

insert  into `usuario`(`Login`,`Contrasena`,`nombres`,`apellidos`,`cargo`) values ('dledezma','123456','Deysi','Ledezma','vendedor'),('dsoriano','123456','Diana','Soriano','vendedor'),('jose','123456','josema','otazu','administrador'),('mario','123456','Ruben','Rodriguez','administrador');

UNLOCK TABLES;

/*Table structure for table `venta` */

DROP TABLE IF EXISTS `venta`;

CREATE TABLE `venta` (
  `idVenta` int(11) NOT NULL AUTO_INCREMENT,
  `idClientes` int(10) unsigned NOT NULL,
  `fechaVenta` varchar(50) DEFAULT NULL,
  `horaVenta` varchar(50) DEFAULT NULL,
  `montoTotalVenta` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`idVenta`),
  KEY `Venta_FKIndex1` (`idClientes`),
  CONSTRAINT `venta_ibfk_1` FOREIGN KEY (`idClientes`) REFERENCES `clientes` (`idClientes`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `venta` */

LOCK TABLES `venta` WRITE;

insert  into `venta`(`idVenta`,`idClientes`,`fechaVenta`,`horaVenta`,`montoTotalVenta`) values (1,1,'26/9/2012','10:19:44','120000'),(2,1,'27/9/2012','4:52:10','80000'),(3,1,'28/9/2012','3:27:39','160000'),(4,6,'21/10/2012','2:21:59','0');

UNLOCK TABLES;

/*Table structure for table `vistaclientesalquiler` */

DROP TABLE IF EXISTS `vistaclientesalquiler`;

/*!50001 DROP VIEW IF EXISTS `vistaclientesalquiler` */;
/*!50001 DROP TABLE IF EXISTS `vistaclientesalquiler` */;

/*!50001 CREATE TABLE  `vistaclientesalquiler`(
 `NroAlquiler` int(11) ,
 `NroCedula` varchar(12) ,
 `Cliente` varchar(101) ,
 `FechaInicio` varchar(50) ,
 `HoraInicio` varchar(50) ,
 `FechaFin` varchar(50) ,
 `CantidadAlquilado` int(10) unsigned 
)*/;

/*Table structure for table `vistapelicula` */

DROP TABLE IF EXISTS `vistapelicula`;

/*!50001 DROP VIEW IF EXISTS `vistapelicula` */;
/*!50001 DROP TABLE IF EXISTS `vistapelicula` */;

/*!50001 CREATE TABLE  `vistapelicula`(
 `Codigo` int(11) ,
 `Pelicula` varchar(100) ,
 `Genero` varchar(30) ,
 `Pais` varchar(50) ,
 `Duraccion` varchar(10) ,
 `Stock` int(11) 
)*/;

/*View structure for view vistaclientesalquiler */

/*!50001 DROP TABLE IF EXISTS `vistaclientesalquiler` */;
/*!50001 DROP VIEW IF EXISTS `vistaclientesalquiler` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vistaclientesalquiler` AS (select `i`.`idAlquiler` AS `NroAlquiler`,`c`.`CIclientes` AS `NroCedula`,concat(`c`.`NombreCliente`,_latin1',',`c`.`ApellidoCliente`) AS `Cliente`,`i`.`fechaInicioAlquiler` AS `FechaInicio`,`i`.`horaInicioAlquiler` AS `HoraInicio`,`i`.`fechaFinAlquiler` AS `FechaFin`,`i`.`cantidadEjemplaresAlquilados` AS `CantidadAlquilado` from (`clientes` `c` join `alquiler` `i`) where (`c`.`idClientes` = `i`.`idClientes`)) */;

/*View structure for view vistapelicula */

/*!50001 DROP TABLE IF EXISTS `vistapelicula` */;
/*!50001 DROP VIEW IF EXISTS `vistapelicula` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vistapelicula` AS (select `p`.`idPelicula` AS `Codigo`,`p`.`tituloPelicula` AS `Pelicula`,`g`.`descripcionGenero` AS `Genero`,`p`.`PaisPelicula` AS `Pais`,`p`.`duracionPelicula` AS `Duraccion`,`p`.`Stock_Pelicula` AS `Stock` from (`pelicula` `p` join `genero` `g`) where (`g`.`idGenero` = `p`.`idGenero`)) */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

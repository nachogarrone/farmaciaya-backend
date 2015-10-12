CREATE TABLE `user` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(250) NOT NULL,
  `firstname` varchar(30) NOT NULL,
  `lastname` varchar(30) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `birthdate` datetime DEFAULT NULL,
  `email` varchar(60) NOT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

CREATE TABLE `medicamento` (
  `id_medicamento` INT NOT NULL,
  `nombre` VARCHAR(100) NOT NULL,
  `concentracion` VARCHAR(45) NULL,
  `forma` VARCHAR(100) NULL,
  `forma_simplificada` VARCHAR(100) NULL,
  `presentacion` VARCHAR(120) NULL,
  `fracciones` INT NULL,
  `vencimiento` DATETIME NULL,
  `id_sanitario` VARCHAR(45) NULL,
  `nombre_titular` VARCHAR(120) NULL,
  `precio` DOUBLE NULL,
  PRIMARY KEY (`id_medicamento`));
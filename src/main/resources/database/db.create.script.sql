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
  `token` VARCHAR(250) NULL,
  `token_created` DATETIME NULL,
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

CREATE TABLE `farmacia` (
  `id_farmacia` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(80) NOT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  `localidad` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_farmacia`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=latin1;

CREATE TABLE `farmacia_medicamento` (
  `id_farmacia` int(11) NOT NULL,
  `id_medicamento` int(11) NOT NULL,
  `stock` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_farmacia`,`id_medicamento`),
  KEY `farmacia_medicamento_id_medicamento_idx` (`id_medicamento`),
  CONSTRAINT `farmacia_medicamento_id_farmacia` FOREIGN KEY (`id_farmacia`) REFERENCES `farmacia` (`id_farmacia`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `farmacia_medicamento_id_medicamento` FOREIGN KEY (`id_medicamento`) REFERENCES `medicamento` (`id_medicamento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

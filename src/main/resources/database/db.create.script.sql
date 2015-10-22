CREATE TABLE `compra` (
  `compra_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `farmacia_id` int(11) NOT NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY (`compra_id`),
  KEY `fk_compra_user_idx` (`user_id`),
  KEY `fk_compra_farmacia_idx` (`farmacia_id`),
  CONSTRAINT `fk_compra_farmacia` FOREIGN KEY (`farmacia_id`) REFERENCES `farmacia` (`farmacia_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_compra_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

CREATE TABLE `compra_articulos` (
  `compra_id` int(11) NOT NULL,
  `medicamento_id` int(11) NOT NULL,
  PRIMARY KEY (`compra_id`,`medicamento_id`),
  KEY `fk_compra_articulos_medicamento_idx` (`medicamento_id`),
  CONSTRAINT `fk_compra_articulos_medicamento` FOREIGN KEY (`medicamento_id`) REFERENCES `medicamento` (`medicamento_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `farmacia` (
  `farmacia_id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(80) NOT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  `localidad` varchar(45) DEFAULT NULL,
  `latitud` float(10,6) DEFAULT NULL,
  `longitud` float(10,6) DEFAULT NULL,
  PRIMARY KEY (`farmacia_id`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=latin1;

CREATE TABLE `farmacia_medicamento` (
  `farmacia_id` int(11) NOT NULL,
  `medicamento_id` int(11) NOT NULL,
  `stock` int(11) DEFAULT NULL,
  PRIMARY KEY (`farmacia_id`,`medicamento_id`),
  KEY `farmacia_medicamento_id_medicamento_idx` (`medicamento_id`),
  CONSTRAINT `farmacia_medicamento_id_farmacia` FOREIGN KEY (`farmacia_id`) REFERENCES `farmacia` (`farmacia_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `farmacia_medicamento_id_medicamento` FOREIGN KEY (`medicamento_id`) REFERENCES `medicamento` (`medicamento_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `medicamento` (
  `medicamento_id` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `concentracion` varchar(45) DEFAULT NULL,
  `forma` varchar(100) DEFAULT NULL,
  `forma_simplificada` varchar(100) DEFAULT NULL,
  `presentacion` varchar(120) DEFAULT NULL,
  `fracciones` int(11) DEFAULT NULL,
  `vencimiento` datetime DEFAULT NULL,
  `id_sanitario` varchar(45) DEFAULT NULL,
  `nombre_titular` varchar(120) DEFAULT NULL,
  `precio` double DEFAULT NULL,
  PRIMARY KEY (`medicamento_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(250) NOT NULL,
  `firstname` varchar(30) NOT NULL,
  `lastname` varchar(30) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `birthdate` datetime DEFAULT NULL,
  `email` varchar(60) NOT NULL,
  `token` varchar(250) DEFAULT NULL,
  `token_created` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

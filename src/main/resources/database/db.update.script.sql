ALTER TABLE `user` ADD COLUMN `token` VARCHAR(250) NULL;
ALTER TABLE `user` ADD COLUMN `token_created` DATETIME NULL;

CREATE TABLE `farmacia_medicamento` (
  `id_farmacia` int(11) NOT NULL,
  `id_medicamento` int(11) NOT NULL,
  `stock` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_farmacia`,`id_medicamento`),
  KEY `farmacia_medicamento_id_medicamento_idx` (`id_medicamento`),
  CONSTRAINT `farmacia_medicamento_id_farmacia` FOREIGN KEY (`id_farmacia`) REFERENCES `farmacia` (`id_farmacia`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `farmacia_medicamento_id_medicamento` FOREIGN KEY (`id_medicamento`) REFERENCES `medicamento` (`id_medicamento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
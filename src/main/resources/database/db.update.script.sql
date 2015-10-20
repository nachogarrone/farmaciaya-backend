ALTER TABLE `farmacia`
ADD COLUMN `latitud` FLOAT(10,6) NULL AFTER `localidad`,
ADD COLUMN `longitud` FLOAT(10,6) NULL AFTER `latitud`;
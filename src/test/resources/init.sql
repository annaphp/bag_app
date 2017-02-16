

DROP TABLE IF EXISTS `bag_type`;

CREATE TABLE `bag_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
);


DROP TABLE IF EXISTS `bag`;
CREATE TABLE `bag` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bag_type_id` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

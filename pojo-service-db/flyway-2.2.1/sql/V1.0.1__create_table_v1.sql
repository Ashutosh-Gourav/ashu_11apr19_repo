
DROP TABLE IF EXISTS `g4o_userDetails`;

CREATE TABLE `g4o_userDetails` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `email` TEXT COLLATE utf8_unicode_ci,
  `password` TEXT COLLATE utf8_unicode_ci,
  `mobileNumber` VARCHAR (12),
  `userFullName`VARCHAR (20),
  `registeredAddress` VARCHAR (64),
   `status`VARCHAR(8),
  PRIMARY KEY (`id`)
) DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
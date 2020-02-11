CREATE TABLE `g4odb`.`fcmRegistrationTable` (
  `id`                   BIGINT(20) NOT NULL AUTO_INCREMENT,
  `fcmRegistrationToken` TEXT       NOT NULL,
  `deviceId`             TEXT
                         COLLATE utf8_unicode_ci,
  `personId`               BIGINT(20) DEFAULT NULL,
  `isUser`               BOOLEAN DEFAULT FALSE ,
  PRIMARY KEY (`id`));
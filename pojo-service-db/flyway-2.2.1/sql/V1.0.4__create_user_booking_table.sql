CREATE TABLE `g4o_user_booking` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `poojabookingrequestId` VARCHAR(64),
  `userId` VARCHAR(20),
  `poojaAddress` TEXT COLLATE utf8_unicode_ci,
  `poojaId` INT(10) DEFAULT NULL ,
  `BookingRequestTime` TIMESTAMP NOT NULL,
  `poojaStartTime` TIMESTAMP NOT NULL ,
  `poojalanguage` VARCHAR(12),
  `prepBy` VARCHAR(64)NOT NULL ,
  `poojaAddressLongitude` FLOAT(10) NOT NULL,
  `poojaAddressLatitude` FLOAT(10) NOT NULL,
  `assignedPriestId` INT(10) DEFAULT NULL,
  `assignedPriestName` VARCHAR (30) DEFAULT NULL,
  `assignedPriestPhNumber` INT(10) DEFAULT NULL,
  `status` VARCHAR(12)  DEFAULT 'inactive',
  `offeredPrice` int,

  PRIMARY KEY (`id`)
) DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
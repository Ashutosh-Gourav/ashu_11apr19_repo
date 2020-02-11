CREATE TABLE `g4o_poojaDetails` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` TEXT COLLATE utf8_unicode_ci,
  `procedure` TEXT COLLATE utf8_unicode_ci,
  `importance` TEXT COLLATE utf8_unicode_ci,
  `cost` FLOAT ,
   `avgDuration` TIME ,
   `poojaItems` TEXT COLLATE utf8_unicode_ci ,
  PRIMARY KEY (`id`)
) DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
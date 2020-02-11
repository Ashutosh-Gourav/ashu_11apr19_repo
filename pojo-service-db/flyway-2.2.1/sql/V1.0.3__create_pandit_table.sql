CREATE TABLE `g4o_priest` (
  `id`                  BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name`                TEXT
                        COLLATE utf8_unicode_ci,
  `poojaList`           TEXT
                        COLLATE utf8_unicode_ci,
  `phoneNumber`         VARCHAR(10),
  `priestEmail`         TEXT
                        COLLATE utf8_unicode_ci,
  `address`             TEXT
                        COLLATE utf8_unicode_ci,
  `priestPassword`      VARCHAR(20),
  `registeredLatitude`  FLOAT,
  `registeredLongitude` FLOAT,
  `lang`                VARCHAR(12),
  `dob`                 DATE,
  `experience`          INT(2),
  `proofId`             VARCHAR(20),
  `idProofType`         VARCHAR(20),
  `idImage`             BLOB,
  `lastSeenLatitude`    FLOAT,
  `lastSeenLongitude`   FLOAT,
  `priestImage`         MEDIUMBLOB,
  `status`              VARCHAR(12),
  `isVerified`          BOOLEAN DEFAULT false,

  PRIMARY KEY (`id`)
)
  DEFAULT CHARSET =utf8
  COLLATE =utf8_unicode_ci;
CREATE TABLE `node`
(
    `address`  VARCHAR(15) NOT NULL COLLATE 'utf8_general_ci',
    `nodeName` VARCHAR(20) NOT NULL COLLATE 'utf8_general_ci',
    `username` VARCHAR(20) NOT NULL COLLATE 'utf8_general_ci',
    `pass`     VARCHAR(20) NOT NULL COLLATE 'utf8_general_ci',
    `id`       INT(11)     NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (`id`) USING BTREE
)
    COLLATE = 'utf8_general_ci'
    ENGINE = InnoDB
;

CREATE TABLE `record`
(
    `created`  DATETIME NOT NULL,
    `temp`     INT(3) NOT NULL,
    `humidity` INT(3) NOT NULL,
    `pressure` INT(4) NOT NULL,
    PRIMARY KEY (`created`) USING BTREE
)
    COLLATE = 'utf8_general_ci'
    ENGINE = InnoDB
;

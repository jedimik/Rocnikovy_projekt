USE `resource_profile`;

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users`
(
    `username` VARCHAR(45) PRIMARY KEY NOT NULL,
    `password` VARCHAR(45) NOT NULL,
    `role` VARCHAR(12)
);

INSERT INTO `users` (`username`, `password`, `role`) VALUES ('root', 'password', 'ADMIN');


CREATE TABLE `tbl_reserved`(
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `phone` BIGINT NOT NULL,
    `date` DATETIME NOT NULL,
    `details` TEXT NULL,
    `people` BIGINT NOT NULL,
    `idclient` BIGINT NOT NULL
);
ALTER TABLE
    `tbl_reserved` ADD INDEX `tbl_reserved_idclient_index`(`idclient`);
CREATE TABLE `tbl_sellItems`(
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `idsell` BIGINT NOT NULL,
    `idproduct` BIGINT NOT NULL
);
ALTER TABLE
    `tbl_sellItems` ADD INDEX `tbl_sellitems_idsell_index`(`idsell`);
ALTER TABLE
    `tbl_sellItems` ADD INDEX `tbl_sellitems_idproduct_index`(`idproduct`);
CREATE TABLE `tbl_sells`(
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `idclient` BIGINT NOT NULL,
    `total` DOUBLE NOT NULL,
    `datesell` BIGINT NOT NULL,
    `idreserv` BIGINT NOT NULL
);
ALTER TABLE
    `tbl_sells` ADD INDEX `tbl_sells_idclient_index`(`idclient`);
ALTER TABLE
    `tbl_sells` ADD INDEX `tbl_sells_idreserv_index`(`idreserv`);
CREATE TABLE `tbl_users`(
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `nuser` VARCHAR(255) NOT NULL,
    `phone` VARCHAR(255) NOT NULL,
    `email` BIGINT NOT NULL,
    `password` BIGINT NOT NULL
);
CREATE TABLE `tbl_menu`(
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `nmenu` VARCHAR(255) NOT NULL,
    `details` TEXT NOT NULL
);
CREATE TABLE `tbl_client`(
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `nclient` VARCHAR(255) NOT NULL,
    `phone` VARCHAR(255) NOT NULL,
    `email` BIGINT NOT NULL
);
CREATE TABLE `tbl_product`(
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `nproduct` VARCHAR(255) NOT NULL,
    `price` DOUBLE NOT NULL,
    `details` TEXT NOT NULL,
    `idmenu` BIGINT NOT NULL
);
ALTER TABLE
    `tbl_product` ADD INDEX `tbl_product_idmenu_index`(`idmenu`);
ALTER TABLE
    `tbl_sellItems` ADD CONSTRAINT `tbl_sellitems_idproduct_foreign` FOREIGN KEY(`idproduct`) REFERENCES `tbl_product`(`id`);
ALTER TABLE
    `tbl_sellItems` ADD CONSTRAINT `tbl_sellitems_idsell_foreign` FOREIGN KEY(`idsell`) REFERENCES `tbl_sells`(`id`);
ALTER TABLE
    `tbl_reserved` ADD CONSTRAINT `tbl_reserved_idclient_foreign` FOREIGN KEY(`idclient`) REFERENCES `tbl_client`(`id`);
ALTER TABLE
    `tbl_product` ADD CONSTRAINT `tbl_product_idmenu_foreign` FOREIGN KEY(`idmenu`) REFERENCES `tbl_menu`(`id`);
ALTER TABLE
    `tbl_sells` ADD CONSTRAINT `tbl_sells_idclient_foreign` FOREIGN KEY(`idclient`) REFERENCES `tbl_client`(`id`);
ALTER TABLE
    `tbl_sells` ADD CONSTRAINT `tbl_sells_idreserv_foreign` FOREIGN KEY(`idreserv`) REFERENCES `tbl_reserved`(`id`);
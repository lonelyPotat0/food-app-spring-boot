CREATE TABLE IF NOT EXISTS `tbl_user` (
    `user_id` INT NOT NULL AUTO_INCREMENT,
    `fullname` VARCHAR(50) NOT NULL,
    `phone` VARCHAR(11) NOT NULL,
    `address` VARCHAR(255) NOT NULL,
    `password` VARCHAR(255) NOT NULL,
    `role` VARCHAR(25) NOT NULL,
    `email` VARCHAR(100) NOT NULL,
    `create_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `update_at` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`user_id`)
);

CREATE TABLE IF NOT EXISTS `tbl_shop` (
    `shop_id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255) NOT NULL,
    `address` VARCHAR(255) NOT NULL,
    `phone` VARCHAR(11) NOT NULL,
    `email` VARCHAR(100) NOT NULL,
    `user_id` INT NOT NULL,
    `create_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `update_at` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`shop_id`)
);

CREATE TABLE IF NOT EXISTS `tbl_category` (
    `category_id` INT NOT NULL AUTO_INCREMENT,
    `category_name` VARCHAR(50) NOT NULL,
    `create_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `update_at` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`category_id`)
);

CREATE TABLE IF NOT EXISTS `tbl_menu` (
    `menu_id` INT NOT NULL AUTO_INCREMENT,
    `shop_id` INT NOT NULL,
    `category_id` INT NOT NULL,
    `name` VARCHAR(50) NOT NULL,
    `price` FLOAT NOT NULL,
    `image` VARCHAR(255) NOT NULL,
    `create_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `update_at` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`menu_id`)
);

CREATE TABLE IF NOT EXISTS `tbl_order` (
    `order_id` INT NOT NULL AUTO_INCREMENT,
    `customer_id` INT NOT NULL,
    `delivery_address` VARCHAR(255) NOT NULL,
    `grand_total` FLOAT NOT NULL,
    `processed_by` INT NOT NULL,
    `create_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `update_at` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`order_id`)
);

CREATE TABLE IF NOT EXISTS `tbl_payment` (
    `paymeny_id` INT NOT NULL AUTO_INCREMENT,
    `amount` INT NOT NULL,
    `paid_by` INT NOT NULL,
    `procesed_by` INT NOT NULL,
    `order_id` INT NOT NULL,
    `create_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `update_at` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`paymeny_id`)
);

CREATE TABLE IF NOT EXISTS `tbl_order_detail` (
    `order_detail_id` INT NOT NULL AUTO_INCREMENT,
    `order_id` INT NOT NULL,
    `menu_id` INT NOT NULL,
    `number_served` INT NOT NULL,
    `amount` FLOAT NOT NULL,
    `total_amount` FLOAT NOT NULL,
    `delivered` BOOLEAN DEFAULT false,
    `customer_id` INT NOT NULL,
    `create_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `update_at` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`order _detail_id`)
);

-- CREATE TABLE IF NOT EXISTS `tbl_cart` (
-- 	`cart_id` INT NOT NULL AUTO_INCREMENT,
-- 	`user_id` INT NOT NULL,
--     `create_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
--     `update_at` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
-- 	PRIMARY KEY (`cart_id`)
-- );

CREATE TABLE IF NOT EXISTS `tbl_cart_item` (
    `cart_item_id` INT NOT NULL AUTO_INCREMENT,
	`menu_id` INT NOT NULL,
	`quantity` INT NOT NULL,
    `user_id` INT NOT NULL,
    `create_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `update_at` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`cart_item_id`)
);

CREATE TABLE IF NOT EXISTS `tbl_customer_review` (
    `review_id` INT NOT NULL AUTO_INCREMENT,
    `rating` INT NOT NULL,
    `comment` VARCHAR(255),
    `menu_id` INT NOT NULL,
    `customer_id` INT NOT NULL,
    `create_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `update_at` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`review_id`)
);

CREATE TABLE IF NOT EXISTS `tbl_role` (
    `role_id` INT,
    `role_name` VARCHAR(15),
    `role_decription` VARCHAR(20),
    `create_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `update_at` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
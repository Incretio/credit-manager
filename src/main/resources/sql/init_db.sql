DROP DATABASE IF EXISTS credit_manager;
CREATE DATABASE credit_manager CHARACTER SET utf8 COLLATE utf8_general_ci;

DROP TABLE IF EXISTS credit_manager.credits;

CREATE TABLE credit_manager.credits (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `first_payment` double DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `object_price` double DEFAULT NULL,
  `payout_period_months` int(11) DEFAULT NULL,
  `start_credit_rate` double DEFAULT NULL,
  `start_date` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ay946bi5kb6hedbhd9hgpjj3l` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

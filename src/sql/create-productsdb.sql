DROP SCHEMA IF EXISTS easyfilminDB;
DROP USER IF EXISTS 'spq'@'localhost';

CREATE SCHEMA easyfilminDB;
CREATE USER IF NOT EXISTS 'spq'@'localhost' IDENTIFIED BY 'spq';

GRANT ALL ON easyfilminDB.* TO 'spq'@'localhost';

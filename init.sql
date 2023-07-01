CREATE DATABASE IF NOT EXISTS csv;

USE csv;

CREATE TABLE IF NOT EXISTS blood_sugar (
    id INT NOT NULL AUTO_INCREMENT,
    device VARCHAR(45) NOT NULL,
    serial_number VARCHAR(45) NOT NULL,
    timestamp DATETIME NOT NULL,
    device_type INT NOT NULL,
    past_blood_sugar INT,
    scan_blood_sugar INT,
    PRIMARY KEY (id)
);

-- V1__Create_User_Table.sql
CREATE TABLE user (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      -- id VARCHAR(255) AUTO_INCREMENT PRIMARY KEY,
                       name VARCHAR(255) NOT NULL,
                       email VARCHAR(255) NOT NULL UNIQUE

);

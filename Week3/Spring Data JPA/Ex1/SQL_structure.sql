CREATE DATABASE ormlearn;
USE ormlearn;

CREATE TABLE country (
  code VARCHAR(2) PRIMARY KEY,
  name VARCHAR(100)
);

INSERT INTO country (code, name) VALUES ('IN', 'India'), ('US', 'United States');

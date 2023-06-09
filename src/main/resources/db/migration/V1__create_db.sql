CREATE DATABASE IF NOT EXISTS SpaceDB;

USE SpaceDB;

CREATE TABLE Client (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(200) NOT NULL CHECK (LENGTH(name) >= 3 AND LENGTH(name) <= 200),
  PRIMARY KEY (id)
);

CREATE TABLE Planet (
  id VARCHAR(50) CHARACTER SET ascii COLLATE ascii_bin NOT NULL,
  name VARCHAR(500) NOT NULL CHECK (LENGTH(name) >= 1 AND LENGTH(name) <= 500 AND name REGEXP '^[A-Z0-9]+$'),
  PRIMARY KEY (id)
);

CREATE TABLE Ticket (
  id INT NOT NULL AUTO_INCREMENT,
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  client_id INT NOT NULL,
  from_planet_id VARCHAR(50) CHARACTER SET ascii COLLATE ascii_bin NOT NULL,
  to_planet_id VARCHAR(50) CHARACTER SET ascii COLLATE ascii_bin NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (client_id) REFERENCES Client(id),
  FOREIGN KEY (from_planet_id) REFERENCES Planet(id),
  FOREIGN KEY (to_planet_id) REFERENCES Planet(id)
);
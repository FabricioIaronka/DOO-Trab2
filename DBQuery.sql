-- Create the database
CREATE DATABASE RallyManagement;

-- Use the newly created database
USE RallyManagement;

-- Championship table
CREATE TABLE championship (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    year INT NOT NULL
);

-- Teams table
CREATE TABLE teams (
    id INT AUTO_INCREMENT PRIMARY KEY,
    champ_id INT NOT NULL,
    name VARCHAR(50) NOT NULL,
    FOREIGN KEY (champ_id) REFERENCES championship(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

-- Participant table
CREATE TABLE participant (
    id INT AUTO_INCREMENT PRIMARY KEY,
    champ_id INT NOT NULL,
    team_id INT NOT NULL,
    name VARCHAR(50) NOT NULL,
    license_lvl INT NOT NULL,
    experience_hours INT NOT NULL,
    FOREIGN KEY (champ_id) REFERENCES championship(id)
        ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (team_id) REFERENCES teams(id)
        ON DELETE CASCADE ON UPDATE CASCADE
);

-- Driver type table 
CREATE TABLE driver (
    participant_id INT PRIMARY KEY,
    FOREIGN KEY (participant_id) REFERENCES participant(id)
        ON DELETE CASCADE ON UPDATE CASCADE
);

-- Navigator type table 
CREATE TABLE navigator (
    participant_id INT PRIMARY KEY,
    have_equipment BOOLEAN NOT NULL,
    FOREIGN KEY (participant_id) REFERENCES participant(id)
        ON DELETE CASCADE ON UPDATE CASCADE
);

-- Parent races table
CREATE TABLE races (
    id INT AUTO_INCREMENT PRIMARY KEY,
    champ_id INT NOT NULL,
    name VARCHAR(50) NOT NULL,
    date DATE NOT NULL,
    local VARCHAR(100) NOT NULL,
    length INT NOT NULL,
    FOREIGN KEY (champ_id) REFERENCES championship(id)
        ON DELETE CASCADE ON UPDATE CASCADE
);

-- Gravel race type table
CREATE TABLE gravel (
    race_id INT PRIMARY KEY,
    qnt_gravel INT NOT NULL,
    qnt_sand INT NOT NULL,
    qnt_tarmac INT NOT NULL,
    FOREIGN KEY (race_id) REFERENCES races(id)
        ON DELETE CASCADE ON UPDATE CASCADE
);

-- Tarmac race type table
CREATE TABLE tarmac (
    race_id INT PRIMARY KEY,
    abrasion INT NOT NULL,
    FOREIGN KEY (race_id) REFERENCES races(id)
        ON DELETE CASCADE ON UPDATE CASCADE
);

-- LapTime table
CREATE TABLE laptime (
    id INT AUTO_INCREMENT PRIMARY KEY,
    champ_id INT NOT NULL,
    team_id INT NOT NULL,
    time DOUBLE NOT NULL,
    FOREIGN KEY (champ_id) REFERENCES championship(id)
        ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (team_id) REFERENCES teams(id)
        ON DELETE CASCADE ON UPDATE CASCADE
);

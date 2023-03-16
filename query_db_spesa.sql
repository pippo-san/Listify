DROP DATABASE if EXISTS db_spesa;
CREATE DATABASE if NOT EXISTS db_spesa;
USE db_spesa;

CREATE TABLE utente(
username VARCHAR(30) PRIMARY KEY,
nome VARCHAR(30) NOT NULL,
cognome VARCHAR(30) NOT NULL,
email VARCHAR(50) NOT NULL,
pass VARCHAR(250) NOT NULL);

CREATE TABLE gruppo(
id_gruppo INT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(30) NOT NULL,
descrizione VARCHAR(200));

CREATE TABLE famiglia(
id_gruppo INT,
username VARCHAR(30),
FOREIGN KEY(id_gruppo) REFERENCES gruppo(id_gruppo),
FOREIGN KEY(username) REFERENCES utente(username));

CREATE TABLE elenco(
id_elenco INT AUTO_INCREMENT PRIMARY KEY,
nome_elenco VARCHAR(30) NOT NULL,
id_gruppo INT,
data_elenco DATE,
FOREIGN KEY(id_gruppo) REFERENCES gruppo(id_gruppo));

CREATE TABLE lista(
id_lista INT AUTO_INCREMENT PRIMARY KEY,
nome_lista VARCHAR(30) NOT NULL,
data_lista DATE,
id_gruppo INT,
FOREIGN KEY(id_gruppo) REFERENCES gruppo(id_gruppo));

CREATE TABLE oggetto(
id_oggetto INT AUTO_INCREMENT PRIMARY KEY,
nome_oggetto VARCHAR(30) NOT NULL,
note VARCHAR(200),
controllo TINYINT,
id_lista INT,
FOREIGN KEY(id_lista) REFERENCES lista(id_lista));

-- -------------------------
-- Schéma PUBLIC
-- -------------------------

-- Création de la table des utilisateurs (identifiants + nom du schéma à utiliser)
CREATE TABLE IF NOT EXISTS login_user (
    id SERIAL PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    schema_name VARCHAR(50) NOT NULL,
    global_role VARCHAR(50) NOT NULL,

);

-- Données de test (utilisateurs)
-- Remplace les mots de passe par des valeurs bcryptées réelles
INSERT INTO login_user (username, password, schema_name) VALUES
  ('admin1', '{bcrypt}$2a$10$hashedpassword1...', 'etab1'),
  ('admin2', '{bcrypt}$2a$10$hashedpassword2...', 'etab2');

-- -------------------------
-- Schéma ETAB1
-- -------------------------

-- Création du schéma établissement 1
CREATE SCHEMA IF NOT EXISTS etab1;

-- Création de la table des élèves pour etab1
CREATE TABLE IF NOT EXISTS etab1.eleve (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(100) NOT NULL
);

-- Données de test
INSERT INTO etab1.eleve (nom) VALUES ('Alice'), ('Charlie');

-- -------------------------
-- Schéma ETAB2
-- -------------------------

-- Création du schéma établissement 2
CREATE SCHEMA IF NOT EXISTS etab2;

-- Création de la table des élèves pour etab2
CREATE TABLE IF NOT EXISTS etab2.eleve (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(100) NOT NULL
);

-- Données de test
INSERT INTO etab2.eleve (nom) VALUES ('Bob'), ('David');

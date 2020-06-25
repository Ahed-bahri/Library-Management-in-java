-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost
-- Généré le : mer. 17 juin 2020 à 12:30
-- Version du serveur :  10.4.11-MariaDB
-- Version de PHP : 7.2.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `bibo`
--

-- --------------------------------------------------------

--
-- Structure de la table `adherant`
--

CREATE TABLE `adherant` (
  `ID` varchar(20) NOT NULL,
  `Nom` varchar(20) NOT NULL,
  `Prenom` varchar(20) NOT NULL,
  `Adresse` varchar(30) NOT NULL,
  `Type` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `adherant`
--

INSERT INTO `adherant` (`ID`, `Nom`, `Prenom`, `Adresse`, `Type`) VALUES
('5436', 'TOSHIBA', 'HUAWEI', 'SOUSSE', 'Visiteur'),
('A0218', 'Shna', 'Alma', 'Sfax', 'Etudiant'),
('AHED26', 'Bahri', 'Ahed', '02 Rue Kadisia', 'Etudiant'),
('Ben031', 'Mlayhy', 'Kamilia', 'Chat Mariem', 'Enseignant'),
('Boss28', 'Bahri', 'Chedly', 'Madina', 'Etudiant'),
('Chakira99', 'Ben Aicha', 'Chahir', 'Nostra Villa', 'Etudiant'),
('Chna61', 'chnaider', 'Alma', 'Mahdia', 'Enseignant'),
('Heni94', 'Bahri', 'Heni', '02 Rue Kadisia', 'Etudiant'),
('Henta84', 'Henteti', 'Lina', 'Mouradi', 'Etudiant'),
('Loumi45', 'Beloumi', 'Hichem', 'Tunis center', 'Visiteur');

-- --------------------------------------------------------

--
-- Structure de la table `books`
--

CREATE TABLE `books` (
  `BookId` varchar(50) NOT NULL,
  `BookName` varchar(50) NOT NULL,
  `Author` varchar(50) NOT NULL,
  `Type` varchar(30) NOT NULL,
  `Available` varchar(50) NOT NULL,
  `Locate` varchar(20) NOT NULL,
  `NumberExmp` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `books`
--

INSERT INTO `books` (`BookId`, `BookName`, `Author`, `Type`, `Available`, `Locate`, `NumberExmp`) VALUES
('A0124', 'Changeling Of Hope', 'Elijah', 'Livre', 'NO', 'Rayon6', 5),
('A0215', 'Serpent Of My Imagination', 'James', 'Document', 'YES', 'Salle9', 15),
('A0218', 'Cracking the Interview', 'Ela', 'Livre', 'YES', 'Salle8', 15),
('AO124', 'Crack The Code Yes', 'Bahrito', 'Livre', 'NO', 'Salle4', 20),
('B65AR', 'Men Of Twilight', 'Daniel', 'Document', 'YES', 'Salle10', 5),
('BALK65', 'Aliens And Humans', 'mike', 'Magazines', 'YES', 'Salle10', 7),
('CJSD4', 'Separated By The Sea', 'Matthew', 'Magazines', 'YES', 'Salle10', 1),
('IFJ', 'Root of Root', 'Testa', 'IDK', 'YES', 'RANG30', 9),
('MQL56', 'Root Of The Sea', 'Jackson', 'Magazines', 'YES', 'Rayon94', 8);

-- --------------------------------------------------------

--
-- Structure de la table `connect`
--

CREATE TABLE `connect` (
  `login` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `connect`
--

INSERT INTO `connect` (`login`, `password`) VALUES
('admin', 'admin'),
('root', 'root');

-- --------------------------------------------------------

--
-- Structure de la table `issue`
--

CREATE TABLE `issue` (
  `ID` varchar(10) NOT NULL,
  `Prenom` varchar(50) NOT NULL,
  `Type` varchar(20) NOT NULL,
  `BookId` varchar(10) NOT NULL,
  `BookName` varchar(50) NOT NULL,
  `Adresse` varchar(100) NOT NULL,
  `IssueDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `issue`
--

INSERT INTO `issue` (`ID`, `Prenom`, `Type`, `BookId`, `BookName`, `Adresse`, `IssueDate`) VALUES
('AHED26', 'Ahed', 'Livre', 'A0124', 'Changeling Of Hope', '02 Rue Kadisia', '2020-03-24');

-- --------------------------------------------------------

--
-- Structure de la table `returndetail`
--

CREATE TABLE `returndetail` (
  `StudentId` varchar(20) NOT NULL,
  `StudentName` varchar(20) NOT NULL,
  `BookId` varchar(50) NOT NULL,
  `BookName` varchar(50) NOT NULL,
  `IssuedOn` date NOT NULL,
  `ReturnedOn` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `returndetail`
--

INSERT INTO `returndetail` (`StudentId`, `StudentName`, `BookId`, `BookName`, `IssuedOn`, `ReturnedOn`) VALUES
('9090', 'Tesla', 'IFJ', 'Root of Root', '2020-06-16', '2020-06-16'),
('AHED26', 'Ahed', 'MQL56', 'Root Of The Sea', '2020-03-16', '2020-03-24'),
('Bah96', 'Khouloud', 'A0124', 'Changeling Of Hope', '2020-03-18', '2020-03-24'),
('Ben031', 'Asma', 'A0215', 'Serpent Of My Imagination', '2020-03-24', '2020-03-28'),
('Boss28', 'Chedly', 'A8124', 'Crack The Code', '2020-04-11', '2020-04-11'),
('chna61', 'Alma', 'A0218', 'Cracking the Interview', '2020-06-17', '2020-06-17'),
('Loumi45', 'Hichem', 'CJSD4', 'Separated By The Sea', '2020-03-17', '2020-03-24');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `adherant`
--
ALTER TABLE `adherant`
  ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `books`
--
ALTER TABLE `books`
  ADD PRIMARY KEY (`BookId`);

--
-- Index pour la table `issue`
--
ALTER TABLE `issue`
  ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `returndetail`
--
ALTER TABLE `returndetail`
  ADD PRIMARY KEY (`StudentId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

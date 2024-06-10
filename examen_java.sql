-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : lun. 10 juin 2024 à 20:21
-- Version du serveur : 10.4.32-MariaDB
-- Version de PHP : 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `examen_java`
--

-- --------------------------------------------------------

--
-- Structure de la table `classe`
--

CREATE TABLE `classe` (
  `id_cl` int(10) NOT NULL,
  `niveau` varchar(50) NOT NULL,
  `filiere` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `classe`
--

INSERT INTO `classe` (`id_cl`, `niveau`, `filiere`) VALUES
(1, 'L1', 'GLRS'),
(2, 'L2', 'TTL'),
(3, 'L1', 'GLRS'),
(4, 'L2', 'ETSE'),
(5, 'L3', 'IAGE'),
(6, 'L3', 'GLRS'),
(7, 'L3', 'TTL'),
(8, 'L1', 'IAGE'),
(9, 'L1', 'TTL'),
(10, 'L3', 'GLRS');

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

CREATE TABLE `etudiant` (
  `id_et` int(11) NOT NULL,
  `nomComplet_et` varchar(50) DEFAULT NULL,
  `matricule_et` varchar(50) DEFAULT NULL,
  `tuteur_et` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `etudiant`
--

INSERT INTO `etudiant` (`id_et`, `nomComplet_et`, `matricule_et`, `tuteur_et`) VALUES
(1, 'Rassoul Seck', 'N001', 'Adjaratou Fatou'),
(2, 'KHADIJA SADJI', 'N002', 'FATIMA SADJI'),
(3, 'OUMAR', 'N003', 'SY'),
(4, 'NAKHADY MANE', 'NAKHADY', 'YAKHYA'),
(5, 'JOEL BERTRAN KOUE', 'N004', 'CHARLOTTE'),
(6, 'AMADOU DEME', 'N8', 'MAMY'),
(7, 'JOEL KOUE', 'N11', 'CHARLOTTE');

-- --------------------------------------------------------

--
-- Structure de la table `inscription`
--

CREATE TABLE `inscription` (
  `id_in` int(10) NOT NULL,
  `annee_in` varchar(50) NOT NULL,
  `matricule_et` varchar(50) DEFAULT NULL,
  `id_cl` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `inscription`
--

INSERT INTO `inscription` (`id_in`, `annee_in`, `matricule_et`, `id_cl`) VALUES
(1, '2024', 'N001', 1),
(2, '2024', 'NAKHADY', 2),
(3, '2023', 'N001', 1),
(4, '2022', 'N004', 2),
(5, '2023', NULL, 1),
(6, '10', NULL, 3),
(7, '2022', 'N8', 9),
(8, '2021', 'N11', 10);

-- --------------------------------------------------------

--
-- Structure de la table `professeurs`
--

CREATE TABLE `professeurs` (
  `id_pr` int(11) NOT NULL,
  `nci` varchar(50) NOT NULL,
  `nomComplet` varchar(25) NOT NULL,
  `grade` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Déchargement des données de la table `professeurs`
--

INSERT INTO `professeurs` (`id_pr`, `nci`, `nomComplet`, `grade`) VALUES
(4, 'N298', 'MALLE', 'INGENIEUR'),
(5, 'N29282', 'BAILA WANE', 'DOCTEUR'),
(7, 'N2028', 'DIABANG', 'DOCTEUR'),
(8, 'N8272', 'KANDE DIABY', 'INGENIEUR'),
(9, 'N493382', 'SECKOU DIALLO', 'INGENIEUR'),
(10, 'N344', 'SOPHIE', 'INGENIEUR'),
(11, 'N9282', 'SADJI', 'DOCTEUR'),
(12, 'N28292', 'MANE NAKHADY', 'DOCTEUR');

-- --------------------------------------------------------

--
-- Structure de la table `professeur_classe`
--

CREATE TABLE `professeur_classe` (
  `id_pr` int(11) DEFAULT NULL,
  `id_cl` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `professeur_classe`
--

INSERT INTO `professeur_classe` (`id_pr`, `id_cl`) VALUES
(4, 1),
(4, 2),
(5, 7),
(5, 9),
(8, 1);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `classe`
--
ALTER TABLE `classe`
  ADD PRIMARY KEY (`id_cl`);

--
-- Index pour la table `etudiant`
--
ALTER TABLE `etudiant`
  ADD PRIMARY KEY (`id_et`),
  ADD UNIQUE KEY `matricule_et` (`matricule_et`);

--
-- Index pour la table `inscription`
--
ALTER TABLE `inscription`
  ADD PRIMARY KEY (`id_in`),
  ADD KEY `matricule_et` (`matricule_et`),
  ADD KEY `fk_classe` (`id_cl`);

--
-- Index pour la table `professeurs`
--
ALTER TABLE `professeurs`
  ADD PRIMARY KEY (`id_pr`),
  ADD UNIQUE KEY `nci` (`nci`);

--
-- Index pour la table `professeur_classe`
--
ALTER TABLE `professeur_classe`
  ADD KEY `id_pr` (`id_pr`),
  ADD KEY `id_cl` (`id_cl`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `classe`
--
ALTER TABLE `classe`
  MODIFY `id_cl` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT pour la table `etudiant`
--
ALTER TABLE `etudiant`
  MODIFY `id_et` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT pour la table `inscription`
--
ALTER TABLE `inscription`
  MODIFY `id_in` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT pour la table `professeurs`
--
ALTER TABLE `professeurs`
  MODIFY `id_pr` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `inscription`
--
ALTER TABLE `inscription`
  ADD CONSTRAINT `fk_classe` FOREIGN KEY (`id_cl`) REFERENCES `classe` (`id_cl`),
  ADD CONSTRAINT `inscription_ibfk_1` FOREIGN KEY (`matricule_et`) REFERENCES `etudiant` (`matricule_et`);

--
-- Contraintes pour la table `professeur_classe`
--
ALTER TABLE `professeur_classe`
  ADD CONSTRAINT `professeur_classe_ibfk_1` FOREIGN KEY (`id_pr`) REFERENCES `professeurs` (`id_pr`),
  ADD CONSTRAINT `professeur_classe_ibfk_2` FOREIGN KEY (`id_cl`) REFERENCES `classe` (`id_cl`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

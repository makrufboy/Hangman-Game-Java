-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 04 Des 2019 pada 03.56
-- Versi Server: 10.1.26-MariaDB
-- PHP Version: 7.1.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hangman`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `kategori`
--

CREATE TABLE `kategori` (
  `id_kategori` int(20) NOT NULL,
  `id_player` int(20) NOT NULL,
  `nama_kategori` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `kategori`
--

INSERT INTO `kategori` (`id_kategori`, `id_player`, `nama_kategori`) VALUES
(1, 1, 'hewan'),
(2, 2, 'buah');

-- --------------------------------------------------------

--
-- Struktur dari tabel `list`
--

CREATE TABLE `list` (
  `hewan` varchar(30) NOT NULL,
  `bunga` varchar(30) NOT NULL,
  `buah` varchar(30) NOT NULL,
  `id_list` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `list`
--

INSERT INTO `list` (`hewan`, `bunga`, `buah`, `id_list`) VALUES
('Alligator, Anteater, Armadillo', '', '', NULL),
('Alligator', 'Aster', 'Ambarella', NULL),
('Bear', 'Asoka', 'Banana', NULL),
('Camel', 'Bluebell', 'Blackberry', NULL),
('Deer', 'Camellia', 'Cherry', NULL),
('Eagle', 'Clovet', 'Date', NULL),
('Fish', 'Delphinium', 'Fruit star', NULL),
('Giraffe', 'Edelweiss', 'Grape', NULL),
('Hamster', 'Fressia', 'Jackfruit', NULL),
('Jaguar', 'Gardenia', 'Jicama', NULL),
('Kangaroo', 'Hibiscus', 'Kiwi', NULL),
('Leopard', 'Jasmine', 'Lemon', NULL),
('Monkey', 'Kangaroo Paw', 'Mango', NULL),
('Octopus', 'Lily', 'Noni', NULL),
('Panda', 'Lotus', '', NULL),
('Rabbit', 'Mimosa', 'Olive', NULL),
('Scorpion', 'Nasturtium', 'Papaya', NULL),
('Tiger', 'Oleander', 'Plum', NULL),
('Vulture', 'Poppy', 'Raspberry', NULL),
('Walrus', 'Queen', 'Snakefruit', NULL),
('Zebra', 'Rose', '', NULL),
('Wolf', 'Sunflower', 'Tangerine', NULL),
('Turtle', 'Tulip', 'Watermelon', NULL),
('Swan', 'Vinca', 'Mangosteen', NULL),
('Rooster', 'Wolfsbane', 'Melon', NULL),
('Porcupine', 'Yarrow', 'Pear', NULL),
('Pig', 'Zinnia', 'Strawberry', NULL),
('Alligator', 'Aster', 'Ambarella', NULL),
('Bear', 'Asoka', 'Banana', NULL),
('Camel', 'Bluebell', 'Blackberry', NULL),
('Deer', 'Camellia', 'Cherry', NULL),
('Eagle', 'Clovet', 'Date', NULL),
('Fish', 'Delphinium', 'Fruit star', NULL),
('Giraffe', 'Edelweiss', 'Grape', NULL),
('Hamster', 'Fressia', 'Jackfruit', NULL),
('Jaguar', 'Gardenia', 'Jicama', NULL),
('Kangaroo', 'Hibiscus', 'Kiwi', NULL),
('Leopard', 'Jasmine', 'Lemon', NULL),
('Monkey', 'Kangaroo Paw', 'Mango', NULL),
('Octopus', 'Lily', 'Noni', NULL),
('Panda', 'Lotus', '', NULL),
('Rabbit', 'Mimosa', 'Olive', NULL),
('Scorpion', 'Nasturtium', 'Papaya', NULL),
('Tiger', 'Oleander', 'Plum', NULL),
('Vulture', 'Poppy', 'Raspberry', NULL),
('Walrus', 'Queen', 'Snakefruit', NULL),
('Zebra', 'Rose', '', NULL),
('Wolf', 'Sunflower', 'Tangerine', NULL),
('Turtle', 'Tulip', 'Watermelon', NULL),
('Swan', 'Vinca', 'Mangosteen', NULL),
('Rooster', 'Wolfsbane', 'Melon', NULL),
('Porcupine', 'Yarrow', 'Pear', NULL),
('Pig', 'Zinnia', 'Strawberry', NULL);

-- --------------------------------------------------------

--
-- Struktur dari tabel `player`
--

CREATE TABLE `player` (
  `id_player` int(20) NOT NULL,
  `nama_player` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `player`
--

INSERT INTO `player` (`id_player`, `nama_player`) VALUES
(1, 'myth'),
(2, 'lol');

-- --------------------------------------------------------

--
-- Struktur dari tabel `score`
--

CREATE TABLE `score` (
  `id_score` int(20) NOT NULL,
  `id_player` int(20) NOT NULL,
  `point` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `score`
--

INSERT INTO `score` (`id_score`, `id_player`, `point`) VALUES
(1, 1, '200'),
(2, 2, '250');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `kategori`
--
ALTER TABLE `kategori`
  ADD PRIMARY KEY (`id_kategori`),
  ADD KEY `id_player` (`id_player`);

--
-- Indexes for table `player`
--
ALTER TABLE `player`
  ADD PRIMARY KEY (`id_player`);

--
-- Indexes for table `score`
--
ALTER TABLE `score`
  ADD PRIMARY KEY (`id_score`),
  ADD KEY `id_player` (`id_player`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `kategori`
--
ALTER TABLE `kategori`
  MODIFY `id_kategori` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `player`
--
ALTER TABLE `player`
  MODIFY `id_player` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `score`
--
ALTER TABLE `score`
  MODIFY `id_score` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `kategori`
--
ALTER TABLE `kategori`
  ADD CONSTRAINT `kategori_ibfk_1` FOREIGN KEY (`id_player`) REFERENCES `player` (`id_player`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `score`
--
ALTER TABLE `score`
  ADD CONSTRAINT `score_ibfk_1` FOREIGN KEY (`id_player`) REFERENCES `player` (`id_player`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

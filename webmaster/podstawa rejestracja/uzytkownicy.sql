-- phpMyAdmin SQL Dump
-- version 4.4.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Czas generowania: 28 Gru 2015, 18:21
-- Wersja serwera: 5.6.26
-- Wersja PHP: 5.6.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `osadnicy`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `uzytkownicy`
--

CREATE TABLE IF NOT EXISTS `uzytkownicy` (
  `id` int(11) NOT NULL,
  `user` text COLLATE utf8_polish_ci NOT NULL,
  `pass` text COLLATE utf8_polish_ci NOT NULL,
  `email` text COLLATE utf8_polish_ci NOT NULL,
  `drewno` int(11) NOT NULL,
  `kamien` int(11) NOT NULL,
  `zboze` int(11) NOT NULL,
  `dnipremium` int(11) NOT NULL
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `uzytkownicy`
--

INSERT INTO `uzytkownicy` (`id`, `user`, `pass`, `email`, `drewno`, `kamien`, `zboze`, `dnipremium`) VALUES
(1, 'adam', '$2y$10$4sZdn0EaurMzGCAla1Up7OJ8vDmhJjKdsyCtQIAIuJ3AuxQ0m0Tly', 'adam@gmail.com', 213, 5675, 342, 0),
(2, 'marek', 'asdfg', 'marek@gmail.com', 324, 1123, 4325, 15),
(3, 'anna', 'zxcvb', 'anna@gmail.com', 4536, 17, 120, 25),
(4, 'andrzej', 'asdfg', 'andrzej@gmail.com', 5465, 132, 189, 0),
(5, 'justyna', 'yuiop', 'justyna@gmail.com', 245, 890, 554, 0),
(6, 'kasia', 'hjkkl', 'kasia@gmail.com', 267, 980, 109, 12),
(7, 'beata', 'fgthj', 'beata@gmail.com', 565, 356, 447, 77),
(8, 'jakub', 'ertyu', 'jakub@gmail.com', 2467, 557, 876, 0),
(9, 'janusz', 'cvbnm', 'janusz@gmail.com', 65, 456, 2467, 0),
(10, 'roman', 'dfghj', 'roman@gmail.com', 97, 226, 245, 23),
(11, 'mirek', '$2y$10$vmSNIWWZApqXydGJ5q9XC.63kF4JvvURC0l2Ns4Qh3nNc55OL.Y6W', 'zelent.miroslaw@gmail.com', 100, 100, 100, 14);

--
-- Indeksy dla zrzutów tabel
--

--
-- Indexes for table `uzytkownicy`
--
ALTER TABLE `uzytkownicy`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `uzytkownicy`
--
ALTER TABLE `uzytkownicy`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=12;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

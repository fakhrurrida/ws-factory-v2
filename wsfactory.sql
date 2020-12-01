-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 29 Nov 2020 pada 10.41
-- Versi server: 10.4.14-MariaDB
-- Versi PHP: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `wsfactory`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `bahan`
--

CREATE TABLE `bahan` (
  `ID_bahan` int(11) NOT NULL,
  `nama_bahan` varchar(255) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `satuan` varchar(255) NOT NULL,
  `kadaluarsa` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `bahan`
--

INSERT INTO `bahan` (`ID_bahan`, `nama_bahan`, `jumlah`, `satuan`, `kadaluarsa`) VALUES
(1, 'Hershey', 0, 'Ayam', '0000-00-00'),
(2, '2', 2003, 'Air', '0000-00-00');

-- --------------------------------------------------------

--
-- Struktur dari tabel `cokelat_factory`
--

CREATE TABLE `cokelat_factory` (
  `ID_cokelat` int(11) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `nama_cokelat` varchar(50) NOT NULL,
  `url_foto` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `cokelat_factory`
--

INSERT INTO `cokelat_factory` (`ID_cokelat`, `jumlah`, `nama_cokelat`, `url_foto`) VALUES
(1, 200, '', ''),
(2, 1, 'Tob', 'https://google.com'),
(3, 0, 'Toblerone', 'https::/google.co,id'),
(4, 0, 'Silver Queen', 'https://google.co.uk'),
(5, 0, 'Silver King', 'https://google.co.uk'),
(6, 0, 'Silver King', 'https://google.co.uk'),
(7, 0, 'Silver King', 'https://google.co.uk'),
(8, 0, 'Silver King', 'https://google.co.uk'),
(9, 0, 'Silver Fang', 'https://google.co.uk'),
(10, 0, 'Silver Fang', 'https://google.co.uk'),
(11, 0, 'Silver Fang', 'https://google.co.uk'),
(12, 0, 'Silver Fang', 'https://google.co.uk'),
(13, 0, 'Silver Fang', 'https://google.co.uk');

-- --------------------------------------------------------

--
-- Struktur dari tabel `request`
--

CREATE TABLE `request` (
  `ID_request` int(11) NOT NULL,
  `ID_cokelat` int(11) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `jml_pending` int(11) NOT NULL,
  `jml_delivered` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `request`
--

INSERT INTO `request` (`ID_request`, `ID_cokelat`, `jumlah`, `jml_pending`, `jml_delivered`) VALUES
(1, 2, 1, 0, 1);

-- --------------------------------------------------------

--
-- Struktur dari tabel `resep`
--

CREATE TABLE `resep` (
  `ID_cokelat` int(11) NOT NULL,
  `ID_bahan` int(11) NOT NULL,
  `jumlah` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `resep`
--

INSERT INTO `resep` (`ID_cokelat`, `ID_bahan`, `jumlah`) VALUES
(1, 1, 2),
(2, 1, 1),
(13, 1, 3);

-- --------------------------------------------------------

--
-- Struktur dari tabel `saldo`
--

CREATE TABLE `saldo` (
  `saldo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `saldo`
--

INSERT INTO `saldo` (`saldo`) VALUES
(200000);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `bahan`
--
ALTER TABLE `bahan`
  ADD UNIQUE KEY `ID_bahan` (`ID_bahan`);

--
-- Indeks untuk tabel `cokelat_factory`
--
ALTER TABLE `cokelat_factory`
  ADD UNIQUE KEY `ID_cokelat` (`ID_cokelat`);

--
-- Indeks untuk tabel `request`
--
ALTER TABLE `request`
  ADD UNIQUE KEY `ID_request` (`ID_request`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `cokelat_factory`
--
ALTER TABLE `cokelat_factory`
  MODIFY `ID_cokelat` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

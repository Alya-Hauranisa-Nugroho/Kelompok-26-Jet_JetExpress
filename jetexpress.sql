-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Nov 07, 2026 at 10:12 AM
-- Server version: 8.0.30
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `jetexpress`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id_user` int NOT NULL,
  `jobdesk` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id_user`, `jobdesk`) VALUES
(1, 'Manajer Operasional Konter'),
(8, 'Manajer Operasional Konter'),
(9, 'Administrasi dan Keuangan'),
(16, 'Manajer Operasional Konter'),
(17, 'Administrasi dan Keuangan'),
(24, 'Manajer Operasional Konter'),
(30, 'Manajer Operasional Konter'),
(37, 'Manajer Operasional Konter'),
(44, 'Manajer Operasional Konter'),
(51, 'Manajer Operasional Konter'),
(58, 'Manajer Operasional Konter'),
(59, 'Administrasi dan Keuangan'),
(65, 'Manajer Operasional Konter');

-- --------------------------------------------------------

--
-- Table structure for table `konter`
--

CREATE TABLE `konter` (
  `id_konter` int NOT NULL,
  `nama_konter` varchar(50) NOT NULL,
  `alamat_konter` varchar(255) NOT NULL,
  `kecamatan` varchar(50) NOT NULL,
  `call_center` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `konter`
--

INSERT INTO `konter` (`id_konter`, `nama_konter`, `alamat_konter`, `kecamatan`, `call_center`) VALUES
(1, 'JetExpress Samarinda Kota', 'Jl. Gajah Mada No. 15, Samarinda Kota, Samarinda, Kalimantan Timur', 'Samarinda Kota', '0541-741201'),
(2, 'JetExpress Samarinda Ilir', 'Jl. Ir. H. Juanda No. 40, Samarinda Ilir, Samarinda, Kalimantan Timur', 'Samarinda Ilir', '0541-741202'),
(3, 'JetExpress Samarinda Ulu', 'Jl. M. Yamin No. 21, Samarinda Ulu, Samarinda, Kalimantan Timur', 'Samarinda Ulu', '0541-741203'),
(4, 'JetExpress Samarinda Utara', 'Jl. KH. Wahid Hasyim No. 9, Samarinda Utara, Samarinda, Kalimantan Timur', 'Samarinda Utara', '0541-741204'),
(5, 'JetExpress Samarinda Seberang', 'Jl. Bendahara No. 8, Samarinda Seberang, Samarinda, Kalimantan Timur', 'Samarinda Seberang', '0541-741205'),
(6, 'JetExpress Sungai Kunjang', 'Jl. Untung Suropati No. 30, Sungai Kunjang, Samarinda, Kalimantan Timur', 'Sungai Kunjang', '0541-741206'),
(7, 'JetExpress Sungai Pinang', 'Jl. Dr. Soetomo No. 22, Sungai Pinang, Samarinda, Kalimantan Timur', 'Sungai Pinang', '0541-741207'),
(8, 'JetExpress Sambutan', 'Jl. Sentosa Raya No. 5, Sambutan, Samarinda, Kalimantan Timur', 'Sambutan', '0541-741208'),
(9, 'JetExpress Loa Janan Ilir', 'Jl. Poros Samarinda-Balikpapan No. 12, Loa Janan Ilir, Samarinda, Kalimantan Timur', 'Loa Janan Ilir', '0541-741209'),
(10, 'JetExpress Palaran', 'Jl. Pelabuhan Palaran No. 3, Palaran, Samarinda, Kalimantan Timur', 'Palaran', '0541-741219');

-- --------------------------------------------------------

--
-- Table structure for table `kurir`
--

CREATE TABLE `kurir` (
  `id_user` int NOT NULL,
  `nomor_kendaraan` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `kurir`
--

INSERT INTO `kurir` (`id_user`, `nomor_kendaraan`) VALUES
(29, 'KT 1335 EX'),
(43, 'KT 1622 NL'),
(63, 'KT 1681 VY'),
(42, 'KT 2537 YU'),
(64, 'KT 3195 NG'),
(22, 'KT 3623 EV'),
(28, 'KT 3840 BX'),
(23, 'KT 4222 NA'),
(50, 'KT 4597 EF'),
(55, 'KT 4634 YT'),
(56, 'KT 5518 LG'),
(36, 'KT 5595 UV'),
(6, 'KT 6062 AM'),
(69, 'KT 7245 JW'),
(49, 'KT 7959 VE'),
(15, 'KT 8183 TJ'),
(13, 'KT 8507 TS'),
(57, 'KT 8767 YV'),
(7, 'KT 9166 DP'),
(14, 'KT 9376 SP'),
(70, 'KT 9502 HM'),
(35, 'KT 9930 YF');

-- --------------------------------------------------------

--
-- Table structure for table `ongkir`
--

CREATE TABLE `ongkir` (
  `id_ongkir` int NOT NULL,
  `jarak_min` int NOT NULL,
  `jarak_max` int NOT NULL,
  `tarif_dasar` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `ongkir`
--

INSERT INTO `ongkir` (`id_ongkir`, `jarak_min`, `jarak_max`, `tarif_dasar`) VALUES
(1, 0, 10, 9000),
(2, 11, 25, 12000),
(3, 26, 50, 15000),
(4, 51, 150, 20000),
(5, 151, 300, 26000),
(6, 301, 600, 34000),
(7, 601, 1000, 42000),
(8, 1001, 1500, 52000),
(9, 1501, 2000, 62000),
(10, 2001, 2500, 74000),
(11, 2501, 3000, 90000),
(12, 3001, 4000, 107000),
(13, 4001, 5000, 127000);

-- --------------------------------------------------------

--
-- Table structure for table `paket`
--

CREATE TABLE `paket` (
  `id_paket` int NOT NULL,
  `nama_barang` varchar(100) NOT NULL,
  `berat` decimal(4,2) NOT NULL,
  `jenis_barang` varchar(20) NOT NULL,
  `nama_pengirim` varchar(100) NOT NULL,
  `no_telp_pengirim` varchar(15) NOT NULL,
  `alamat_pengirim` varchar(255) NOT NULL,
  `nama_penerima` varchar(100) NOT NULL,
  `no_telp_penerima` varchar(15) NOT NULL,
  `alamat_penerima` varchar(255) NOT NULL,
  `id_pengiriman` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `paket`
--

INSERT INTO `paket` (`id_paket`, `nama_barang`, `berat`, `jenis_barang`, `nama_pengirim`, `no_telp_pengirim`, `alamat_pengirim`, `nama_penerima`, `no_telp_penerima`, `alamat_penerima`, `id_pengiriman`) VALUES
(1, 'Sertifikat', '0.38', 'Dokumen', 'Fajar Pahlevi', '089685749525', 'Jl. Pangeran Antasari No. 90, RT 36, Loa Janan Ilir, Samarinda', 'Irfan Putra', '089692321566', 'Jl. Jelawat No. 97, RT 17, Loa Janan Ilir, Samarinda', 1),
(2, 'Kampas rem', '1.65', 'Sparepart', 'Wulan Hakim', '087872903586', 'Jl. Kemakmuran No. 12, RT 11, Samarinda Ulu, Samarinda', 'Wahyu Hasan', '085778999658', 'Jl. Gatot Subroto No. 5, Makassar', 2),
(3, 'Buku pelajaran', '1.72', 'Buku', 'Rahmat Halim', '085779974347', 'Jl. Slamet Riyadi No. 99, RT 08, Samarinda Seberang, Samarinda', 'Siti Anwar', '089587892505', 'Jl. Dahlia No. 76, RT 25, Samarinda Seberang, Samarinda', 3),
(4, 'Gelang manik', '1.78', 'Aksesoris', 'Nur Santoso', '085832499024', 'Jl. Mangkupalas No. 28, RT 38, Sungai Pinang, Samarinda', 'Rizki Rahayu', '082170048482', 'Jl. AW Sjahranie No. 71, RT 11, Samarinda Ilir, Samarinda', 4),
(5, 'Kaos distro', '2.90', 'Pakaian', 'Arif Nugroho', '085283477995', 'Jl. Melati No. 81, RT 03, Palaran, Samarinda', 'Dian Noor', '085776473564', 'Jl. Diponegoro No. 124, Jayapura', 5),
(6, 'Filter oli', '2.21', 'Sparepart', 'Ayu Anwar', '085272828591', 'Jl. Cendana No. 5, RT 01, Samarinda Seberang, Samarinda', 'Hendra Wijaya', '088119974432', 'Jl. Merdeka No. 50, RT 36, Samarinda Seberang, Samarinda', 6),
(7, 'Mobil remote', '4.01', 'Mainan', 'Wahyu Susanto', '085251188351', 'Jl. Jelawat No. 23, RT 32, Sungai Kunjang, Samarinda', 'Rosa Saputra', '081155976396', 'Jl. Juanda No. 18, RT 01, Samarinda Ulu, Samarinda', 7),
(8, 'Lampu meja', '3.26', 'Perabot', 'Irfan Maulana', '087869571428', 'Jl. Melati No. 85, RT 31, Samarinda Kota, Samarinda', 'Fajar Putra', '085868891888', 'Jl. Juanda No. 9, RT 09, Samarinda Ulu, Samarinda', 8),
(9, 'Lipstik', '1.00', 'Kosmetik', 'Muhammad Rahman', '087782870673', 'Jl. Jelawat No. 22, RT 07, Palaran, Samarinda', 'Rosa Putra', '085856658690', 'Jl. Pahlawan No. 27, RT 14, Palaran, Samarinda', 9),
(10, 'Kerupuk ikan', '2.79', 'Makanan', 'Aisyah Mahendra', '088157073289', 'Jl. Perjuangan No. 22, RT 28, Palaran, Samarinda', 'Putri Pahlevi', '085711811890', 'Jl. Gunung Lingai No. 57, RT 25, Samarinda Utara, Samarinda', 10),
(11, 'Aki motor kecil', '3.41', 'Sparepart', 'Joko Salim', '088195351976', 'Jl. Kemakmuran No. 46, RT 02, Samarinda Kota, Samarinda', 'Dian Ramadhan', '089541541992', 'Jl. Juanda No. 31, RT 14, Samarinda Utara, Samarinda', 11),
(12, 'Skincare set', '0.37', 'Kosmetik', 'Sri Salim', '082183920258', 'Jl. Ahmad Yani No. 81, RT 27, Sungai Kunjang, Samarinda', 'Maya Firmansyah', '081312763902', 'Jl. Juanda No. 83, RT 07, Samarinda Ulu, Samarinda', 12),
(13, 'Buku pelajaran', '1.60', 'Buku', 'Eko Gunawan', '081365095231', 'Jl. Merdeka No. 105, Balikpapan', 'Hendra Syahputra', '087867300790', 'Jl. Damanhuri No. 55, RT 05, Samarinda Ilir, Samarinda', 13),
(14, 'Boneka', '1.55', 'Mainan', 'Ratna Basri', '085258026052', 'Jl. Melati No. 54, RT 17, Sungai Pinang, Samarinda', 'Dian Susanto', '085851780902', 'Jl. Merdeka No. 143, Palembang', 14),
(15, 'Lego set', '0.51', 'Mainan', 'Ahmad Lubis', '088257072007', 'Jl. Sudirman No. 87, Sangatta', 'Arif Hartono', '081158341019', 'Jl. Kemakmuran No. 83, RT 28, Palaran, Samarinda', 15),
(16, 'Rak dapur kecil', '9.84', 'Perabot', 'Bayu Hidayat', '088193056510', 'Jl. Sudirman No. 85, Batam', 'Rosa Salim', '082192211969', 'Jl. Merdeka No. 34, RT 25, Samarinda Kota, Samarinda', 16),
(17, 'Kampas rem', '2.67', 'Sparepart', 'Sri Utami', '081265653827', 'Jl. Juanda No. 89, RT 05, Samarinda Ilir, Samarinda', 'Dimas Kurniawan', '085895842268', 'Jl. Juanda No. 10, RT 38, Samarinda Utara, Samarinda', 17),
(18, 'Sertifikat', '0.52', 'Dokumen', 'Agus Rahayu', '087831371293', 'Jl. Merdeka No. 62, RT 29, Sungai Pinang, Samarinda', 'Rudi Wijaya', '082135947348', 'Jl. Ahmad Yani No. 1, Tenggarong', 18),
(19, 'Buku pelajaran', '1.40', 'Buku', 'Eko Salim', '088128479467', 'Jl. Sudirman No. 71, Banda Aceh', 'Andi Kurniawan', '085384127728', 'Jl. Cendana No. 25, RT 22, Samarinda Ilir, Samarinda', 19),
(20, 'Keyboard mekanik', '1.23', 'Elektronik', 'Dimas Kurniawan', '085870972846', 'Jl. Ahmad Yani No. 93, Bandung', 'Ayu Ramadhan', '085351195868', 'Jl. Dahlia No. 9, RT 39, Samarinda Ulu, Samarinda', 20),
(21, 'Sunscreen', '0.33', 'Kosmetik', 'Irfan Syahputra', '089779905894', 'Jl. Pangeran Antasari No. 9, RT 19, Sungai Kunjang, Samarinda', 'Fitri Siregar', '085715735440', 'Jl. Veteran No. 24, Makassar', 21),
(22, 'Mobil remote', '2.72', 'Mainan', 'Intan Pratama', '089729556961', 'Jl. Jelawat No. 47, RT 13, Sambutan, Samarinda', 'Wulan Hasan', '082196630662', 'Jl. Pelita No. 72, RT 34, Samarinda Kota, Samarinda', 22),
(23, 'Smartwatch', '0.74', 'Elektronik', 'Maya Halim', '089568534190', 'Jl. Diponegoro No. 118, Surabaya', 'Linda Amin', '085322002047', 'Jl. Pahlawan No. 16, RT 03, Sambutan, Samarinda', 23),
(24, 'Kamus', '2.69', 'Buku', 'Dimas Ridwan', '089671024246', 'Jl. Pemuda No. 68, Yogyakarta', 'Rizki Anwar', '087722318315', 'Jl. Jelawat No. 92, RT 16, Palaran, Samarinda', 24),
(25, 'Kaos distro', '2.58', 'Pakaian', 'Eko Syahputra', '085811815285', 'Jl. AW Sjahranie No. 98, RT 25, Palaran, Samarinda', 'Rudi Lestari', '085874567639', 'Jl. Melati No. 66, RT 28, Palaran, Samarinda', 25),
(26, 'Lampu meja', '11.76', 'Perabot', 'Rahmat Wijaya', '081175705310', 'Jl. Pelita No. 35, RT 26, Samarinda Ulu, Samarinda', 'Dedi Wijaya', '082169550658', 'Jl. Pahlawan No. 23, RT 26, Samarinda Ulu, Samarinda', 26),
(27, 'Kopi bubuk', '1.20', 'Makanan', 'Ayu Hakim', '088121223621', 'Jl. Mangkupalas No. 58, RT 03, Sungai Pinang, Samarinda', 'Hendra Saputra', '085213817462', 'Jl. Slamet Riyadi No. 5, RT 20, Samarinda Kota, Samarinda', 27),
(28, 'Busi motor', '7.61', 'Sparepart', 'Rizki Santoso', '085166193684', 'Jl. Slamet Riyadi No. 1, RT 01, Samarinda Utara, Samarinda', 'Sri Pratama', '081330099906', 'Jl. Perjuangan No. 22, RT 25, Samarinda Kota, Samarinda', 28),
(29, 'Set panci', '2.26', 'Perabot', 'Indah Ramadhan', '089526509367', 'Jl. Damanhuri No. 75, RT 40, Loa Janan Ilir, Samarinda', 'Nur Rahman', '082128165629', 'Jl. Ahmad Yani No. 53, Palangkaraya', 29),
(30, 'Mobil remote', '0.98', 'Mainan', 'Ayu Kusuma', '089579552744', 'Jl. Pahlawan No. 86, RT 26, Sambutan, Samarinda', 'Agus Wibowo', '089636299847', 'Jl. Pemuda No. 88, Makassar', 30),
(31, 'Kampas rem', '1.54', 'Sparepart', 'Bayu Saputra', '085151624168', 'Jl. Damanhuri No. 49, RT 17, Samarinda Seberang, Samarinda', 'Agus Kurniawan', '081149471331', 'Jl. Diponegoro No. 105, Balikpapan', 31),
(32, 'Novel', '1.80', 'Buku', 'Rosa Hidayat', '082141316614', 'Jl. Pahlawan No. 12, Medan', 'Eko Kurniawan', '087833894407', 'Jl. Kemakmuran No. 8, RT 08, Samarinda Ilir, Samarinda', 32),
(33, 'Boneka', '4.50', 'Mainan', 'Andi Firmansyah', '085382973542', 'Jl. Dahlia No. 68, RT 09, Sambutan, Samarinda', 'Ayu Hasan', '087837460878', 'Jl. Ahmad Yani No. 51, RT 03, Samarinda Utara, Samarinda', 33),
(34, 'Kerupuk ikan', '2.71', 'Makanan', 'Taufik Maulana', '085794541594', 'Jl. Pangeran Antasari No. 9, RT 13, Samarinda Utara, Samarinda', 'Nur Nugroho', '089555469660', 'Jl. Mangkupalas No. 16, RT 04, Sungai Kunjang, Samarinda', 34),
(35, 'Tas selempang', '1.31', 'Aksesoris', 'Nur Setiawan', '081346564788', 'Jl. Pahlawan No. 99, RT 07, Samarinda Ilir, Samarinda', 'Rosa Firmansyah', '085825677591', 'Jl. Jelawat No. 33, RT 14, Loa Janan Ilir, Samarinda', 35),
(36, 'Bolu kemojo', '1.02', 'Makanan', 'Dian Putra', '085375621662', 'Jl. Slamet Riyadi No. 66, RT 26, Sungai Kunjang, Samarinda', 'Rosa Salim', '089763104400', 'Jl. Sudirman No. 59, Tenggarong', 36),
(37, 'Skincare set', '0.85', 'Kosmetik', 'Indah Susanto', '085894914852', 'Jl. Kemakmuran No. 67, RT 21, Samarinda Utara, Samarinda', 'Sri Hasan', '088215302065', 'Jl. Gatot Subroto No. 39, Pekanbaru', 37),
(38, 'Rak dapur kecil', '4.91', 'Perabot', 'Eko Rahayu', '089690745957', 'Jl. Pangeran Antasari No. 85, RT 24, Sungai Kunjang, Samarinda', 'Andi Putra', '089772361418', 'Jl. Jelawat No. 3, RT 19, Sungai Kunjang, Samarinda', 38),
(39, 'Celana jeans', '2.39', 'Pakaian', 'Rina Putra', '088257502703', 'Jl. Pelita No. 37, RT 26, Samarinda Kota, Samarinda', 'Hendra Ridwan', '087783314443', 'Jl. Perjuangan No. 6, RT 16, Samarinda Kota, Samarinda', 39),
(40, 'Lampu meja', '8.81', 'Perabot', 'Fitri Wijaya', '081133631177', 'Jl. Merdeka No. 22, RT 12, Samarinda Utara, Samarinda', 'Yuni Firmansyah', '085211672453', 'Jl. Pangeran Antasari No. 75, RT 35, Samarinda Utara, Samarinda', 40),
(41, 'Kemeja batik', '2.07', 'Pakaian', 'Maya Putra', '085838189927', 'Jl. Gatot Subroto No. 80, Jakarta', 'Andi Rahayu', '082167966682', 'Jl. Damanhuri No. 64, RT 34, Samarinda Kota, Samarinda', 41),
(42, 'Set panci', '9.75', 'Perabot', 'Rahmat Amin', '088278466354', 'Jl. Diponegoro No. 75, Balikpapan', 'Fitri Lestari', '085272478367', 'Jl. Perjuangan No. 57, RT 39, Samarinda Kota, Samarinda', 42),
(43, 'Kopi bubuk', '1.35', 'Makanan', 'Nur Kurniawan', '085217519380', 'Jl. Pelita No. 96, RT 32, Samarinda Ulu, Samarinda', 'Indah Halim', '085255131008', 'Jl. Sudirman No. 96, Jakarta', 43),
(44, 'Topi', '1.27', 'Aksesoris', 'Fitri Pratama', '089558427402', 'Jl. Diponegoro No. 76, Sangatta', 'Rosa Halim', '087816172851', 'Jl. Jelawat No. 20, RT 28, Sungai Kunjang, Samarinda', 44),
(45, 'Lampu meja', '5.49', 'Perabot', 'Yusuf Salim', '081391752186', 'Jl. Perjuangan No. 70, RT 08, Loa Janan Ilir, Samarinda', 'Rina Ridwan', '081312066859', 'Jl. Merdeka No. 29, Denpasar', 45),
(46, 'Kemeja batik', '1.94', 'Pakaian', 'Rahmat Nugroho', '081299734224', 'Jl. Perjuangan No. 34, RT 20, Loa Janan Ilir, Samarinda', 'Andi Lubis', '087786712302', 'Jl. Veteran No. 17, Banda Aceh', 46),
(47, 'Lego set', '4.76', 'Mainan', 'Putri Basri', '087822897913', 'Jl. Melati No. 80, RT 04, Loa Janan Ilir, Samarinda', 'Fitri Pahlevi', '087848726196', 'Jl. Perjuangan No. 75, RT 39, Loa Janan Ilir, Samarinda', 47),
(48, 'Sunscreen', '0.75', 'Kosmetik', 'Fajar Pahlevi', '089538770344', 'Jl. Gatot Subroto No. 129, Pekanbaru', 'Arif Wijaya', '088163545076', 'Jl. Pangeran Antasari No. 94, RT 25, Samarinda Seberang, Samarinda', 48),
(49, 'Bolu kemojo', '2.73', 'Makanan', 'Taufik Maulana', '081176016120', 'Jl. Perjuangan No. 21, RT 27, Palaran, Samarinda', 'Taufik Salim', '089669527677', 'Jl. Veteran No. 139, Palangkaraya', 49),
(50, 'Kopi bubuk', '2.84', 'Makanan', 'Maya Wibowo', '089540561258', 'Jl. Pahlawan No. 40, RT 18, Samarinda Ilir, Samarinda', 'Irfan Anwar', '085388297449', 'Jl. Sudirman No. 134, Manado', 50),
(51, 'Sunscreen', '1.98', 'Kosmetik', 'Rahmat Siregar', '081131091240', 'Jl. Pahlawan No. 98, Balikpapan', 'Nur Salim', '089681755029', 'Jl. Ahmad Yani No. 69, RT 08, Palaran, Samarinda', 51),
(52, 'Set panci', '8.72', 'Perabot', 'Fitri Kusuma', '081282571368', 'Jl. Veteran No. 31, Mataram', 'Rosa Kusuma', '087835225542', 'Jl. Dahlia No. 77, RT 30, Palaran, Samarinda', 52),
(53, 'Novel', '1.15', 'Buku', 'Sri Lestari', '085192821969', 'Jl. AW Sjahranie No. 63, RT 29, Samarinda Ilir, Samarinda', 'Dedi Rahayu', '087871244767', 'Jl. Pelita No. 67, RT 13, Sambutan, Samarinda', 53),
(54, 'Kaos distro', '1.83', 'Pakaian', 'Muhammad Pahlevi', '085328868607', 'Jl. Melati No. 44, RT 20, Loa Janan Ilir, Samarinda', 'Sri Santoso', '089747652400', 'Jl. Pahlawan No. 122, Surabaya', 54),
(55, 'Smartwatch', '1.08', 'Elektronik', 'Yusuf Firmansyah', '085722238510', 'Jl. Slamet Riyadi No. 64, RT 33, Samarinda Utara, Samarinda', 'Andi Anwar', '088128240439', 'Jl. Pemuda No. 49, Batam', 55),
(56, 'Set panci', '3.49', 'Perabot', 'Rina Santoso', '085378388014', 'Jl. Merdeka No. 76, Bontang', 'Irfan Halim', '087873695975', 'Jl. Cendana No. 6, RT 37, Sambutan, Samarinda', 56),
(57, 'Skincare set', '1.61', 'Kosmetik', 'Rosa Hakim', '088192162835', 'Jl. Pemuda No. 20, Makassar', 'Dedi Permata', '089720000085', 'Jl. Gunung Lingai No. 47, RT 10, Samarinda Utara, Samarinda', 57),
(58, 'Dompet kulit', '1.22', 'Aksesoris', 'Dimas Putra', '087858967724', 'Jl. Perjuangan No. 55, RT 02, Palaran, Samarinda', 'Rina Basri', '085232756584', 'Jl. Pahlawan No. 89, Jakarta', 58),
(59, 'Serum wajah', '1.17', 'Kosmetik', 'Rina Saputra', '089525347922', 'Jl. Damanhuri No. 20, RT 26, Sambutan, Samarinda', 'Aisyah Firmansyah', '085169214821', 'Jl. Pahlawan No. 66, Medan', 59),
(60, 'Dompet kulit', '1.78', 'Aksesoris', 'Aisyah Utami', '085290082930', 'Jl. Pelita No. 37, RT 32, Samarinda Seberang, Samarinda', 'Rosa Santoso', '089616092097', 'Jl. Gatot Subroto No. 79, Makassar', 60),
(61, 'Buku pelajaran', '2.08', 'Buku', 'Fitri Hidayat', '087825241143', 'Jl. Pahlawan No. 84, RT 16, Samarinda Seberang, Samarinda', 'Linda Rahayu', '089764490608', 'Jl. Pemuda No. 94, Bandung', 61),
(62, 'Ijazah legalisir', '0.39', 'Dokumen', 'Andi Basri', '089640366343', 'Jl. Damanhuri No. 44, RT 31, Samarinda Seberang, Samarinda', 'Rahmat Ridwan', '085847277612', 'Jl. Pahlawan No. 61, Jakarta', 62),
(63, 'Map surat', '0.44', 'Dokumen', 'Agus Nugroho', '088296731829', 'Jl. Gatot Subroto No. 53, Tanjung Redeb', 'Rina Hartono', '088270011892', 'Jl. Juanda No. 6, RT 19, Sungai Pinang, Samarinda', 63),
(64, 'Map surat', '0.22', 'Dokumen', 'Sri Siregar', '089713841997', 'Jl. Pahlawan No. 139, Semarang', 'Putri Hidayat', '082162985066', 'Jl. Slamet Riyadi No. 67, RT 15, Loa Janan Ilir, Samarinda', 64),
(65, 'Modul kuliah', '2.93', 'Buku', 'Nia Ridwan', '088215805108', 'Jl. Pemuda No. 131, Makassar', 'Bayu Amin', '085768888409', 'Jl. Cendana No. 64, RT 28, Sungai Kunjang, Samarinda', 65),
(66, 'Sunscreen', '0.70', 'Kosmetik', 'Dimas Syahputra', '088222726281', 'Jl. Dahlia No. 86, RT 13, Sambutan, Samarinda', 'Linda Santoso', '082177935736', 'Jl. Diponegoro No. 49, Makassar', 66),
(67, 'Amplang khas Samarinda', '2.64', 'Makanan', 'Hendra Salim', '085766344237', 'Jl. Gatot Subroto No. 148, Bontang', 'Wulan Lubis', '081335113418', 'Jl. Juanda No. 48, RT 14, Samarinda Utara, Samarinda', 67),
(68, 'Ijazah legalisir', '0.48', 'Dokumen', 'Bayu Basri', '089637949322', 'Jl. Sudirman No. 113, Makassar', 'Fitri Basri', '089562631585', 'Jl. Perjuangan No. 97, RT 32, Samarinda Ulu, Samarinda', 68),
(69, 'Boneka', '0.83', 'Mainan', 'Nia Salim', '087791992882', 'Jl. Dahlia No. 98, RT 13, Sungai Kunjang, Samarinda', 'Putri Lestari', '085150790446', 'Jl. AW Sjahranie No. 55, RT 18, Sungai Kunjang, Samarinda', 69),
(70, 'Lego set', '0.70', 'Mainan', 'Dimas Saputra', '085156969062', 'Jl. Perjuangan No. 83, RT 36, Sambutan, Samarinda', 'Andi Ramadhan', '089516280106', 'Jl. Pahlawan No. 64, RT 36, Sambutan, Samarinda', 70),
(71, 'Novel', '1.84', 'Buku', 'Ratna Ramadhan', '088232605920', 'Jl. Merdeka No. 75, Surabaya', 'Rahmat Putra', '085248570890', 'Jl. Dahlia No. 7, RT 34, Samarinda Kota, Samarinda', 71),
(72, 'Berkas lamaran', '0.73', 'Dokumen', 'Siti Firmansyah', '085132089393', 'Jl. Melati No. 94, RT 32, Sungai Pinang, Samarinda', 'Rina Wijaya', '085841145165', 'Jl. Gatot Subroto No. 87, Jakarta', 72),
(73, 'Charger fast charging', '1.92', 'Elektronik', 'Irfan Amin', '085220413721', 'Jl. Perjuangan No. 27, RT 36, Samarinda Ilir, Samarinda', 'Budi Syahputra', '082117510984', 'Jl. Sudirman No. 114, Palembang', 73),
(74, 'Dompet kulit', '0.78', 'Aksesoris', 'Yuni Noor', '089782829151', 'Jl. Pangeran Antasari No. 5, RT 23, Samarinda Ilir, Samarinda', 'Hendra Pratama', '081311717974', 'Jl. Merdeka No. 47, Denpasar', 74),
(75, 'Earphone bluetooth', '0.80', 'Elektronik', 'Andi Noor', '089796781429', 'Jl. Merdeka No. 111, Sangatta', 'Bayu Pratama', '085857171810', 'Jl. Mangkupalas No. 35, RT 32, Samarinda Utara, Samarinda', 75),
(76, 'Amplang khas Samarinda', '2.30', 'Makanan', 'Putri Amin', '082129785416', 'Jl. Perjuangan No. 26, RT 13, Sungai Pinang, Samarinda', 'Ahmad Wibowo', '087885774397', 'Jl. Pemuda No. 102, Denpasar', 76),
(77, 'Kerupuk ikan', '2.96', 'Makanan', 'Joko Anwar', '088298423506', 'Jl. Dahlia No. 87, RT 04, Samarinda Ulu, Samarinda', 'Bayu Pratama', '085332592860', 'Jl. AW Sjahranie No. 33, RT 27, Samarinda Kota, Samarinda', 77),
(78, 'Busi motor', '5.34', 'Sparepart', 'Andi Setiawan', '085843139761', 'Jl. Slamet Riyadi No. 27, RT 38, Sungai Pinang, Samarinda', 'Joko Maulana', '087873422941', 'Jl. Ahmad Yani No. 138, Surabaya', 78),
(79, 'Berkas lamaran', '0.21', 'Dokumen', 'Siti Utami', '081290322656', 'Jl. Cendana No. 92, RT 22, Sambutan, Samarinda', 'Rina Gunawan', '085125857636', 'Jl. Pemuda No. 145, Jakarta', 79),
(80, 'Earphone bluetooth', '3.18', 'Elektronik', 'Linda Syahputra', '087757025573', 'Jl. Gunung Lingai No. 71, RT 21, Palaran, Samarinda', 'Dewi Rahman', '085895053934', 'Jl. Pelita No. 5, RT 07, Palaran, Samarinda', 80),
(81, 'Boneka', '2.70', 'Mainan', 'Irfan Saputra', '089713302736', 'Jl. Pahlawan No. 80, RT 35, Samarinda Utara, Samarinda', 'Fajar Syahputra', '089783240890', 'Jl. Diponegoro No. 78, Denpasar', 81),
(82, 'Mobil remote', '3.45', 'Mainan', 'Rudi Hasan', '085830776662', 'Jl. Pahlawan No. 99, RT 19, Samarinda Kota, Samarinda', 'Ahmad Utami', '087714381426', 'Jl. AW Sjahranie No. 68, RT 02, Samarinda Seberang, Samarinda', 82),
(83, 'Kamus', '0.75', 'Buku', 'Budi Rahman', '089653417849', 'Jl. Merdeka No. 86, Balikpapan', 'Eko Pratama', '089711602448', 'Jl. Cendana No. 30, RT 25, Samarinda Seberang, Samarinda', 83),
(84, 'Smartwatch', '2.85', 'Elektronik', 'Hendra Utami', '081336307788', 'Jl. Sudirman No. 116, Mataram', 'Nia Wijaya', '081196517075', 'Jl. Gunung Lingai No. 62, RT 08, Samarinda Kota, Samarinda', 84),
(85, 'Kamus', '2.33', 'Buku', 'Nia Gunawan', '082171625209', 'Jl. Pahlawan No. 53, Tenggarong', 'Nia Anwar', '089549559366', 'Jl. Kemakmuran No. 5, RT 25, Loa Janan Ilir, Samarinda', 85),
(86, 'Berkas lamaran', '0.78', 'Dokumen', 'Aisyah Basri', '087815728497', 'Jl. Jelawat No. 63, RT 21, Samarinda Ulu, Samarinda', 'Indah Salim', '089636280991', 'Jl. Mangkupalas No. 88, RT 03, Samarinda Ulu, Samarinda', 86),
(87, 'Lipstik', '1.63', 'Kosmetik', 'Dian Siregar', '089594401974', 'Jl. Slamet Riyadi No. 66, RT 07, Samarinda Ulu, Samarinda', 'Aisyah Hidayat', '085760855805', 'Jl. Jelawat No. 74, RT 26, Samarinda Ulu, Samarinda', 87),
(88, 'Lipstik', '0.72', 'Kosmetik', 'Agus Ridwan', '087821957782', 'Jl. Pahlawan No. 118, Palembang', 'Sri Hidayat', '085742205913', 'Jl. Gunung Lingai No. 15, RT 14, Sambutan, Samarinda', 88),
(89, 'Modul kuliah', '1.39', 'Buku', 'Nur Hasan', '081237854735', 'Jl. Gunung Lingai No. 25, RT 31, Palaran, Samarinda', 'Arif Ridwan', '081231367525', 'Jl. Veteran No. 134, Denpasar', 89),
(90, 'Rak dapur kecil', '11.49', 'Perabot', 'Rina Lestari', '085181255242', 'Jl. AW Sjahranie No. 31, RT 07, Samarinda Seberang, Samarinda', 'Rina Utami', '087888331249', 'Jl. Dahlia No. 69, RT 21, Samarinda Seberang, Samarinda', 90),
(91, 'Lego set', '4.66', 'Mainan', 'Hendra Ridwan', '085222059667', 'Jl. Diponegoro No. 27, Bontang', 'Taufik Syahputra', '089523109838', 'Jl. Pangeran Antasari No. 79, RT 22, Samarinda Utara, Samarinda', 91),
(92, 'Parfum', '1.45', 'Kosmetik', 'Taufik Kurniawan', '085139490342', 'Jl. Jelawat No. 91, RT 37, Loa Janan Ilir, Samarinda', 'Linda Putra', '082165362669', 'Jl. Kemakmuran No. 44, RT 17, Loa Janan Ilir, Samarinda', 92),
(93, 'Gelang manik', '1.27', 'Aksesoris', 'Ayu Salim', '081216803677', 'Jl. Jelawat No. 99, RT 01, Samarinda Ulu, Samarinda', 'Maya Susanto', '082172370232', 'Jl. Pemuda No. 20, Kupang', 93),
(94, 'Gelang manik', '1.03', 'Aksesoris', 'Siti Kurniawan', '085886396657', 'Jl. Melati No. 16, RT 33, Samarinda Kota, Samarinda', 'Budi Pratama', '089653742672', 'Jl. Sudirman No. 36, Denpasar', 94),
(95, 'Parfum', '1.28', 'Kosmetik', 'Hendra Putra', '085863363161', 'Jl. Perjuangan No. 12, RT 01, Samarinda Kota, Samarinda', 'Ani Mahendra', '085724520275', 'Jl. Merdeka No. 80, Tenggarong', 95),
(96, 'Lipstik', '0.64', 'Kosmetik', 'Nur Wibowo', '085855075963', 'Jl. Cendana No. 1, RT 10, Samarinda Ilir, Samarinda', 'Rosa Kurniawan', '081147814390', 'Jl. Jelawat No. 39, RT 20, Samarinda Ilir, Samarinda', 96),
(97, 'Kaos distro', '1.55', 'Pakaian', 'Joko Rahman', '089584395478', 'Jl. Sudirman No. 35, Surabaya', 'Arif Santoso', '089579555171', 'Jl. Jelawat No. 14, RT 22, Loa Janan Ilir, Samarinda', 97),
(98, 'Boneka', '3.13', 'Mainan', 'Hendra Lubis', '089736658843', 'Jl. Sudirman No. 126, Kupang', 'Arif Pahlevi', '082136541537', 'Jl. Jelawat No. 12, RT 03, Samarinda Seberang, Samarinda', 98),
(99, 'Lampu meja', '14.91', 'Perabot', 'Arif Mahendra', '089521439774', 'Jl. Damanhuri No. 79, RT 26, Samarinda Kota, Samarinda', 'Bayu Anwar', '081358869083', 'Jl. Diponegoro No. 70, Sangatta', 99),
(100, 'Parfum', '1.66', 'Kosmetik', 'Hendra Kurniawan', '089732012805', 'Jl. Pangeran Antasari No. 28, RT 12, Samarinda Seberang, Samarinda', 'Arif Maulana', '085292364180', 'Jl. Pemuda No. 15, Banda Aceh', 100),
(101, 'Boneka', '4.19', 'Mainan', 'Rosa Santoso', '087810368386', 'Jl. Dahlia No. 5, RT 16, Sungai Kunjang, Samarinda', 'Indah Maulana', '085286339224', 'Jl. Veteran No. 68, Bandung', 101),
(102, 'Kopi bubuk', '1.06', 'Makanan', 'Ahmad Rahayu', '085833480492', 'Jl. Merdeka No. 92, Sangatta', 'Muhammad Wijaya', '087712517651', 'Jl. Dahlia No. 34, RT 32, Sungai Pinang, Samarinda', 102),
(103, 'Skincare set', '1.15', 'Kosmetik', 'Agus Basri', '089788650386', 'Jl. Damanhuri No. 69, RT 19, Samarinda Kota, Samarinda', 'Bayu Amin', '085274769944', 'Jl. Veteran No. 54, Bandung', 103),
(104, 'Earphone bluetooth', '2.12', 'Elektronik', 'Aisyah Lestari', '088175722160', 'Jl. Pelita No. 33, RT 28, Loa Janan Ilir, Samarinda', 'Aisyah Hidayat', '081372056557', 'Jl. Pahlawan No. 27, Bandung', 104),
(105, 'Novel', '0.73', 'Buku', 'Andi Utami', '085246287563', 'Jl. Pahlawan No. 83, Banjarmasin', 'Siti Ridwan', '087810422564', 'Jl. Pelita No. 66, RT 28, Sungai Pinang, Samarinda', 105),
(106, 'Parfum', '1.53', 'Kosmetik', 'Siti Hasan', '087835904333', 'Jl. Cendana No. 13, RT 12, Sungai Pinang, Samarinda', 'Yusuf Pahlevi', '085137718669', 'Jl. Pahlawan No. 15, RT 20, Sungai Pinang, Samarinda', 106),
(107, 'Sertifikat', '0.96', 'Dokumen', 'Rahmat Lestari', '087788842688', 'Jl. Perjuangan No. 65, RT 24, Sambutan, Samarinda', 'Linda Hidayat', '089698316991', 'Jl. Merdeka No. 22, Medan', 107),
(108, 'Kaos distro', '2.69', 'Pakaian', 'Rosa Susanto', '088143671449', 'Jl. Cendana No. 75, RT 03, Samarinda Seberang, Samarinda', 'Wahyu Rahayu', '085790684319', 'Jl. Diponegoro No. 88, Jakarta', 108),
(109, 'Celana jeans', '2.51', 'Pakaian', 'Dian Ridwan', '081374360865', 'Jl. Perjuangan No. 10, RT 14, Samarinda Ulu, Samarinda', 'Linda Syahputra', '081245669541', 'Jl. Ahmad Yani No. 4, Balikpapan', 109),
(110, 'Boneka', '2.21', 'Mainan', 'Putri Ramadhan', '089653403215', 'Jl. Gunung Lingai No. 54, RT 33, Sambutan, Samarinda', 'Nia Setiawan', '082155327163', 'Jl. Sudirman No. 127, Medan', 110),
(111, 'Buku pelajaran', '0.92', 'Buku', 'Maya Halim', '089637713932', 'Jl. Gatot Subroto No. 91, Pekanbaru', 'Eko Saputra', '088292094348', 'Jl. Pelita No. 80, RT 20, Samarinda Ulu, Samarinda', 111),
(112, 'Kerupuk ikan', '3.17', 'Makanan', 'Ahmad Ramadhan', '085385903710', 'Jl. Diponegoro No. 125, Denpasar', 'Irfan Susanto', '082127657494', 'Jl. Pahlawan No. 43, RT 01, Samarinda Kota, Samarinda', 112),
(113, 'Ijazah legalisir', '0.88', 'Dokumen', 'Wulan Hasan', '081343140820', 'Jl. Diponegoro No. 40, Balikpapan', 'Dimas Lestari', '081176867739', 'Jl. Kemakmuran No. 83, RT 16, Loa Janan Ilir, Samarinda', 113);

-- --------------------------------------------------------

--
-- Table structure for table `pengantaran`
--

CREATE TABLE `pengantaran` (
  `id_pengantaran` int NOT NULL,
  `longitude_tujuan` decimal(11,8) NOT NULL,
  `latitude_tujuan` decimal(10,8) NOT NULL,
  `waktu_penugasan` date NOT NULL,
  `status_pengantaran` enum('Ditugaskan','Dalam Perjalanan','Berhasil','Gagal') NOT NULL,
  `bukti_foto` varchar(255) DEFAULT NULL,
  `catatan_kurir` text,
  `id_user` int NOT NULL,
  `id_pengiriman` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `pengantaran`
--

INSERT INTO `pengantaran` (`id_pengantaran`, `longitude_tujuan`, `latitude_tujuan`, `waktu_penugasan`, `status_pengantaran`, `bukti_foto`, `catatan_kurir`, `id_user`, `id_pengiriman`) VALUES
(1, '117.08512219', '-0.58006698', '2026-09-02', 'Berhasil', 'bukti/JE24423415.jpg', 'Diterima oleh keluarga penerima', 63, 1),
(2, '117.15630428', '-0.51079037', '2026-09-02', 'Berhasil', 'bukti/JE13529623.jpg', 'Diterima langsung oleh penerima', 50, 4),
(3, '117.15360687', '-0.46928815', '2026-09-03', 'Berhasil', 'bukti/JE27487409.jpg', 'Diterima langsung oleh penerima', 43, 7),
(4, '117.15320457', '-0.47487979', '2026-09-03', 'Berhasil', 'bukti/JE33557996.jpg', '', 6, 8),
(5, '117.22243725', '-0.59653105', '2026-09-04', 'Berhasil', 'bukti/JE69593594.jpg', 'Dititipkan ke satpam', 70, 9),
(6, '117.14841991', '-0.42541207', '2026-09-04', 'Berhasil', 'bukti/JE70687035.jpg', NULL, 70, 10),
(7, '117.16656409', '-0.43919383', '2026-09-03', 'Berhasil', 'bukti/JE66543041.jpg', 'Diterima langsung oleh penerima', 7, 11),
(8, '117.15619505', '-0.51076323', '2026-09-04', 'Berhasil', 'bukti/JE72246287.jpg', 'Diterima oleh keluarga penerima', 13, 13),
(9, '117.22202442', '-0.59833443', '2026-09-06', 'Berhasil', 'bukti/JE24807223.jpg', NULL, 70, 15),
(10, '117.15281489', '-0.43309584', '2026-09-05', 'Berhasil', 'bukti/JE82015752.jpg', 'Diterima oleh keluarga penerima', 15, 17),
(11, '117.15525105', '-0.46363010', '2026-09-06', 'Berhasil', 'bukti/JE43828121.jpg', 'Dititipkan ke satpam', 22, 20),
(12, '117.14917727', '-0.49762754', '2026-09-07', 'Berhasil', 'bukti/JE58036869.jpg', NULL, 57, 22),
(13, '117.20482815', '-0.53476270', '2026-09-07', 'Berhasil', 'bukti/JE57772419.jpg', 'Dititipkan ke satpam', 56, 23),
(14, '117.21221945', '-0.59467703', '2026-09-07', 'Gagal', NULL, 'Alamat tidak ditemukan', 69, 24),
(15, '117.23076167', '-0.59256233', '2026-09-07', 'Berhasil', 'bukti/JE94664338.jpg', 'Dititipkan ke satpam', 70, 25),
(16, '117.16152359', '-0.47396966', '2026-09-08', 'Berhasil', 'bukti/JE47371830.jpg', 'Diterima langsung oleh penerima', 23, 26),
(17, '117.15848523', '-0.49244529', '2026-09-08', 'Berhasil', 'bukti/JE16828135.jpg', NULL, 50, 27),
(18, '117.14609298', '-0.50556455', '2026-09-08', 'Dalam Perjalanan', NULL, NULL, 28, 28),
(19, '117.15263699', '-0.43105528', '2026-09-09', 'Berhasil', 'bukti/JE61553073.jpg', 'Diterima oleh keluarga penerima', 55, 33),
(20, '117.09474243', '-0.53152766', '2026-09-09', 'Berhasil', 'bukti/JE44916676.jpg', NULL, 28, 34),
(21, '117.08061018', '-0.56178632', '2026-09-09', 'Berhasil', 'bukti/JE84342000.jpg', 'Dititipkan ke satpam', 13, 35),
(22, '117.10110637', '-0.54064117', '2026-09-10', 'Dalam Perjalanan', NULL, NULL, 42, 38),
(23, '117.16175319', '-0.49196427', '2026-09-11', 'Berhasil', 'bukti/JE24665960.jpg', NULL, 7, 39),
(24, '117.16168178', '-0.42957698', '2026-09-11', 'Berhasil', 'bukti/JE17801037.jpg', 'Diterima langsung oleh penerima', 29, 40),
(25, '117.15834217', '-0.49537070', '2026-09-11', 'Berhasil', 'bukti/JE76201502.jpg', 'Diterima langsung oleh penerima', 7, 41),
(26, '117.15714320', '-0.50880504', '2026-09-11', 'Berhasil', 'bukti/JE73692578.jpg', 'Diterima langsung oleh penerima', 6, 42),
(27, '117.09486350', '-0.53800472', '2026-09-11', 'Gagal', NULL, 'Penerima tidak di tempat, telepon tidak aktif', 43, 44),
(28, '117.10735033', '-0.51546551', '2026-09-13', 'Gagal', NULL, 'Alamat tidak ditemukan', 36, 48),
(29, '117.21245165', '-0.59194720', '2026-09-14', 'Berhasil', 'bukti/JE58482694.jpg', 'Diterima langsung oleh penerima', 70, 51),
(30, '117.23115516', '-0.60500342', '2026-09-14', 'Berhasil', 'bukti/JE18534224.jpg', 'Diterima oleh keluarga penerima', 69, 52),
(31, '117.21095681', '-0.52208866', '2026-09-16', 'Berhasil', 'bukti/JE83881997.jpg', 'Diterima langsung oleh penerima', 55, 56),
(32, '117.14731802', '-0.42028500', '2026-09-16', 'Berhasil', 'bukti/JE47909634.jpg', NULL, 29, 57),
(33, '117.16105429', '-0.47838339', '2026-09-17', 'Berhasil', 'bukti/JE53910854.jpg', 'Dititipkan ke satpam', 50, 63),
(34, '117.07889195', '-0.57970404', '2026-09-17', 'Dalam Perjalanan', NULL, NULL, 63, 64),
(35, '117.11417243', '-0.54241165', '2026-09-18', 'Berhasil', 'bukti/JE89937760.jpg', 'Diterima oleh keluarga penerima', 43, 65),
(36, '117.14929195', '-0.41917851', '2026-09-18', 'Berhasil', 'bukti/JE41536285.jpg', 'Diterima oleh keluarga penerima', 28, 67),
(37, '117.15375959', '-0.47078405', '2026-09-18', 'Gagal', NULL, 'Penerima tidak di tempat, telepon tidak aktif', 23, 68),
(38, '117.11244511', '-0.52458419', '2026-09-18', 'Berhasil', 'bukti/JE67292337.jpg', 'Dititipkan ke satpam', 43, 69),
(39, '117.20234014', '-0.52064831', '2026-09-18', 'Dalam Perjalanan', NULL, NULL, 56, 70),
(40, '117.14406522', '-0.49567655', '2026-09-19', 'Gagal', NULL, 'Penerima tidak di tempat, telepon tidak aktif', 7, 71),
(41, '117.14285748', '-0.49835988', '2026-09-22', 'Berhasil', 'bukti/JE94945160.jpg', 'Diterima langsung oleh penerima', 22, 77),
(42, '117.23094942', '-0.59457955', '2026-09-22', 'Berhasil', 'bukti/JE97822635.jpg', 'Diterima langsung oleh penerima', 70, 80),
(43, '117.11057058', '-0.52059051', '2026-09-22', 'Berhasil', 'bukti/JE45164663.jpg', '', 6, 82),
(44, '117.10447402', '-0.51931401', '2026-09-23', 'Dalam Perjalanan', NULL, NULL, 35, 83),
(45, '117.14466587', '-0.51060331', '2026-09-23', 'Berhasil', 'bukti/JE11623032.jpg', 'Diterima langsung oleh penerima', 42, 84),
(46, '117.09940632', '-0.56240436', '2026-09-23', 'Berhasil', 'bukti/JE30815754.jpg', 'Diterima oleh keluarga penerima', 64, 85),
(47, '117.14455530', '-0.46974188', '2026-09-22', 'Gagal', NULL, 'Alamat tidak ditemukan', 22, 86),
(48, '117.14166149', '-0.45384782', '2026-09-22', 'Berhasil', 'bukti/JE89473268.jpg', 'Dititipkan ke satpam', 22, 87),
(49, '117.20761805', '-0.54184207', '2026-09-24', 'Berhasil', 'bukti/JE41897246.jpg', NULL, 57, 88),
(50, '117.11532426', '-0.51026532', '2026-09-25', 'Gagal', NULL, 'Penerima menolak paket', 36, 90),
(51, '117.16356618', '-0.41993609', '2026-09-25', 'Berhasil', 'bukti/JE78867024.jpg', NULL, 28, 91),
(52, '117.08474248', '-0.56781517', '2026-09-25', 'Dalam Perjalanan', NULL, NULL, 64, 92),
(53, '117.07920408', '-0.56267751', '2026-09-27', 'Berhasil', 'bukti/JE32349151.jpg', 'Diterima oleh keluarga penerima', 64, 97),
(54, '117.12657163', '-0.51464494', '2026-09-28', 'Berhasil', 'bukti/JE60142664.jpg', 'Diterima oleh keluarga penerima', 64, 98),
(55, '117.15584217', '-0.48780244', '2026-09-29', 'Dalam Perjalanan', NULL, NULL, 50, 102),
(56, '117.16951563', '-0.48356706', '2026-09-28', 'Ditugaskan', NULL, NULL, 50, 106),
(57, '117.09828538', '-0.56329286', '2026-10-01', 'Berhasil', 'BUKTI-20261107-133847-536.jpg', NULL, 35, 113);

-- --------------------------------------------------------

--
-- Table structure for table `pengiriman`
--

CREATE TABLE `pengiriman` (
  `id_pengiriman` int NOT NULL,
  `no_resi` char(10) NOT NULL,
  `jenis_pengiriman` enum('Intracity','Outbound','Inbound') NOT NULL,
  `total_biaya` int NOT NULL,
  `metode_bayar` enum('Cash','Cashless','COD') NOT NULL,
  `cod` int NOT NULL,
  `batas_kirim` date NOT NULL,
  `status_pengiriman` enum('Terkirim','Gagal','Dalam Pengiriman','Diterima Konter') NOT NULL,
  `id_konter` int NOT NULL,
  `id_paket` int NOT NULL,
  `id_ongkir` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `pengiriman`
--

INSERT INTO `pengiriman` (`id_pengiriman`, `no_resi`, `jenis_pengiriman`, `total_biaya`, `metode_bayar`, `cod`, `batas_kirim`, `status_pengiriman`, `id_konter`, `id_paket`, `id_ongkir`) VALUES
(1, 'JE24423415', 'Intracity', 13140, 'COD', 130000, '2026-09-03', 'Terkirim', 9, 1, 2),
(2, 'JE74240714', 'Outbound', 38950, 'COD', 122000, '2026-09-04', 'Terkirim', 3, 2, 6),
(3, 'JE51958816', 'Intracity', 20160, 'Cashless', 0, '2026-09-02', 'Terkirim', 5, 3, 3),
(4, 'JE13529623', 'Intracity', 17340, 'Cashless', 0, '2026-09-02', 'Terkirim', 7, 4, 2),
(5, 'JE83779421', 'Outbound', 96700, 'Cash', 0, '2026-09-08', 'Terkirim', 10, 5, 11),
(6, 'JE17143479', 'Intracity', 21630, 'Cash', 0, '2026-09-03', 'Terkirim', 5, 6, 3),
(7, 'JE27487409', 'Intracity', 27030, 'COD', 141000, '2026-09-04', 'Terkirim', 6, 7, 3),
(8, 'JE33557996', 'Intracity', 24780, 'Cash', 0, '2026-09-05', 'Terkirim', 1, 8, 3),
(9, 'JE69593594', 'Intracity', 18000, 'COD', 351000, '2026-09-05', 'Terkirim', 10, 9, 3),
(10, 'JE70687035', 'Intracity', 17370, 'Cashless', 0, '2026-09-04', 'Terkirim', 10, 10, 1),
(11, 'JE66543041', 'Intracity', 22230, 'Cash', 0, '2026-09-05', 'Terkirim', 1, 11, 2),
(12, 'JE53110189', 'Intracity', 10110, 'COD', 245000, '2026-09-05', 'Terkirim', 6, 12, 1),
(13, 'JE72246287', 'Inbound', 24800, 'Cash', 0, '2026-09-05', 'Terkirim', 2, 13, 4),
(14, 'JE92536111', 'Outbound', 56650, 'Cashless', 0, '2026-09-10', 'Terkirim', 7, 14, 8),
(15, 'JE24807223', 'Inbound', 27530, 'Cashless', 0, '2026-09-07', 'Terkirim', 10, 15, 5),
(16, 'JE65479637', 'Inbound', 81520, 'Cashless', 0, '2026-09-07', 'Terkirim', 4, 16, 8),
(17, 'JE82015752', 'Intracity', 17010, 'COD', 447000, '2026-09-06', 'Terkirim', 2, 17, 1),
(18, 'JE81964767', 'Outbound', 16560, 'Cash', 0, '2026-09-07', 'Terkirim', 7, 18, 3),
(19, 'JE72587437', 'Inbound', 92200, 'Cash', 0, '2026-09-07', 'Terkirim', 2, 19, 11),
(20, 'JE43828121', 'Inbound', 55690, 'Cash', 0, '2026-09-08', 'Terkirim', 3, 20, 8),
(21, 'JE26582061', 'Outbound', 34990, 'COD', 719000, '2026-09-09', 'Terkirim', 6, 21, 6),
(22, 'JE58036869', 'Intracity', 23160, 'Cashless', 0, '2026-09-08', 'Terkirim', 8, 22, 3),
(23, 'JE57772419', 'Inbound', 44220, 'COD', 590000, '2026-09-08', 'Terkirim', 8, 23, 7),
(24, 'JE63222909', 'Inbound', 60070, 'COD', 388000, '2026-09-07', 'Gagal', 10, 24, 8),
(25, 'JE94664338', 'Intracity', 22740, 'COD', 478000, '2026-09-08', 'Terkirim', 10, 25, 3),
(26, 'JE47371830', 'Intracity', 44280, 'COD', 682000, '2026-09-09', 'Terkirim', 3, 26, 1),
(27, 'JE16828135', 'Intracity', 15600, 'Cashless', 0, '2026-09-09', 'Terkirim', 7, 27, 2),
(28, 'JE42927294', 'Intracity', 31830, 'Cash', 0, '2026-09-09', 'Dalam Pengiriman', 4, 28, 1),
(29, 'JE90837462', 'Outbound', 48780, 'Cashless', 0, '2026-09-13', 'Terkirim', 9, 29, 7),
(30, 'JE88375364', 'Outbound', 36940, 'Cashless', 0, '2026-09-11', 'Terkirim', 8, 30, 6),
(31, 'JE44198838', 'Outbound', 24620, 'Cashless', 0, '2026-09-11', 'Terkirim', 5, 31, 4),
(32, 'JE28258385', 'Inbound', 79400, 'Cashless', 0, '2026-09-11', 'Terkirim', 2, 32, 10),
(33, 'JE61553073', 'Intracity', 28500, 'Cashless', 0, '2026-09-10', 'Terkirim', 8, 33, 3),
(34, 'JE44916676', 'Intracity', 23130, 'COD', 104000, '2026-09-11', 'Terkirim', 4, 34, 3),
(35, 'JE84342000', 'Intracity', 18930, 'Cash', 0, '2026-09-10', 'Terkirim', 2, 35, 3),
(36, 'JE78479872', 'Outbound', 18060, 'Cashless', 0, '2026-09-11', 'Terkirim', 6, 36, 3),
(37, 'JE16186663', 'Outbound', 64550, 'Cash', 0, '2026-09-18', 'Terkirim', 4, 37, 9),
(38, 'JE47032362', 'Intracity', 26730, 'Cashless', 0, '2026-09-12', 'Dalam Pengiriman', 6, 38, 2),
(39, 'JE24665960', 'Intracity', 22170, 'Cashless', 0, '2026-09-11', 'Terkirim', 1, 39, 3),
(40, 'JE17801037', 'Intracity', 35430, 'COD', 469000, '2026-09-13', 'Terkirim', 4, 40, 1),
(41, 'JE76201502', 'Inbound', 58210, 'Cash', 0, '2026-09-13', 'Terkirim', 1, 41, 8),
(42, 'JE73692578', 'Inbound', 49250, 'COD', 453000, '2026-09-13', 'Terkirim', 1, 42, 4),
(43, 'JE22032725', 'Outbound', 56050, 'Cashless', 0, '2026-09-16', 'Dalam Pengiriman', 3, 43, 8),
(44, 'JE61711303', 'Inbound', 23810, 'COD', 85000, '2026-09-13', 'Gagal', 6, 44, 4),
(45, 'JE13752892', 'Outbound', 58470, 'Cash', 0, '2026-09-17', 'Terkirim', 9, 45, 7),
(46, 'JE19446287', 'Outbound', 93820, 'Cashless', 0, '2026-09-20', 'Dalam Pengiriman', 9, 46, 11),
(47, 'JE15236943', 'Intracity', 23280, 'Cashless', 0, '2026-09-13', 'Terkirim', 9, 47, 1),
(48, 'JE28945559', 'Inbound', 64250, 'Cashless', 0, '2026-09-14', 'Gagal', 5, 48, 9),
(49, 'JE20923298', 'Outbound', 50190, 'Cashless', 0, '2026-09-17', 'Terkirim', 10, 49, 7),
(50, 'JE61791986', 'Outbound', 50520, 'Cashless', 0, '2026-09-18', 'Terkirim', 2, 50, 7),
(51, 'JE58482694', 'Inbound', 25940, 'COD', 198000, '2026-09-16', 'Terkirim', 10, 51, 4),
(52, 'JE18534224', 'Inbound', 68160, 'Cashless', 0, '2026-09-16', 'Terkirim', 10, 52, 7),
(53, 'JE19345379', 'Intracity', 15450, 'Cashless', 0, '2026-09-16', 'Terkirim', 2, 53, 2),
(54, 'JE55735563', 'Outbound', 47490, 'Cashless', 0, '2026-09-19', 'Terkirim', 9, 54, 7),
(55, 'JE52191247', 'Outbound', 55240, 'Cashless', 0, '2026-09-19', 'Terkirim', 4, 55, 8),
(56, 'JE83881997', 'Inbound', 30470, 'COD', 335000, '2026-09-16', 'Terkirim', 8, 56, 4),
(57, 'JE47909634', 'Inbound', 38830, 'Cash', 0, '2026-09-17', 'Terkirim', 4, 57, 6),
(58, 'JE16507542', 'Outbound', 55660, 'Cash', 0, '2026-09-20', 'Terkirim', 10, 58, 8),
(59, 'JE37585804', 'Outbound', 77510, 'Cashless', 0, '2026-09-22', 'Terkirim', 8, 59, 10),
(60, 'JE59615576', 'Outbound', 39340, 'Cashless', 0, '2026-09-19', 'Terkirim', 5, 60, 6),
(61, 'JE36004916', 'Outbound', 58240, 'Cash', 0, '2026-09-21', 'Dalam Pengiriman', 5, 61, 8),
(62, 'JE25305380', 'Outbound', 53170, 'Cashless', 0, '2026-09-21', 'Terkirim', 5, 62, 8),
(63, 'JE53910854', 'Inbound', 35320, 'Cashless', 0, '2026-09-18', 'Terkirim', 7, 63, 6),
(64, 'JE58146529', 'Inbound', 52660, 'COD', 651000, '2026-09-18', 'Dalam Pengiriman', 9, 64, 8),
(65, 'JE89937760', 'Inbound', 42790, 'Cashless', 0, '2026-09-18', 'Terkirim', 6, 65, 6),
(66, 'JE54852216', 'Outbound', 36100, 'Cashless', 0, '2026-09-21', 'Terkirim', 8, 66, 6),
(67, 'JE41536285', 'Inbound', 27920, 'Cash', 0, '2026-09-20', 'Terkirim', 4, 67, 4),
(68, 'JE76641147', 'Inbound', 35440, 'Cash', 0, '2026-09-20', 'Gagal', 3, 68, 6),
(69, 'JE67292337', 'Intracity', 17490, 'Cashless', 0, '2026-09-19', 'Terkirim', 6, 69, 3),
(70, 'JE58068609', 'Intracity', 17100, 'Cash', 0, '2026-09-20', 'Dalam Pengiriman', 8, 70, 3),
(71, 'JE74158569', 'Inbound', 47520, 'COD', 510000, '2026-09-20', 'Gagal', 1, 71, 7),
(72, 'JE86084991', 'Outbound', 54190, 'COD', 636000, '2026-09-23', 'Terkirim', 7, 72, 8),
(73, 'JE53939894', 'Outbound', 57760, 'Cash', 0, '2026-09-23', 'Terkirim', 2, 73, 8),
(74, 'JE41653195', 'Outbound', 44340, 'COD', 675000, '2026-09-24', 'Terkirim', 2, 74, 7),
(75, 'JE77742761', 'Inbound', 22400, 'COD', 561000, '2026-09-21', 'Terkirim', 6, 75, 4),
(76, 'JE43349461', 'Outbound', 48900, 'COD', 66000, '2026-09-25', 'Terkirim', 7, 76, 7),
(77, 'JE94945160', 'Intracity', 20880, 'Cashless', 0, '2026-09-23', 'Terkirim', 3, 77, 2),
(78, 'JE55299832', 'Outbound', 58020, 'Cashless', 0, '2026-09-26', 'Terkirim', 7, 78, 7),
(79, 'JE73355301', 'Outbound', 52630, 'COD', 655000, '2026-09-26', 'Dalam Pengiriman', 8, 79, 8),
(80, 'JE97822635', 'Intracity', 24540, 'COD', 469000, '2026-09-24', 'Terkirim', 10, 80, 3),
(81, 'JE19163913', 'Outbound', 50100, 'Cash', 0, '2026-09-27', 'Dalam Pengiriman', 4, 81, 7),
(82, 'JE45164663', 'Intracity', 19350, 'Cashless', 0, '2026-09-23', 'Terkirim', 1, 82, 1),
(83, 'JE71760847', 'Inbound', 22250, 'Cashless', 0, '2026-09-23', 'Dalam Pengiriman', 5, 83, 4),
(84, 'JE11623032', 'Inbound', 50550, 'COD', 222000, '2026-09-23', 'Terkirim', 6, 84, 7),
(85, 'JE30815754', 'Inbound', 21990, 'COD', 170000, '2026-09-23', 'Terkirim', 9, 85, 3),
(86, 'JE42641583', 'Intracity', 17340, 'Cashless', 0, '2026-09-23', 'Gagal', 3, 86, 3),
(87, 'JE89473268', 'Intracity', 16890, 'Cash', 0, '2026-09-23', 'Terkirim', 3, 87, 2),
(88, 'JE41897246', 'Inbound', 54160, 'Cash', 0, '2026-09-24', 'Terkirim', 8, 88, 8),
(89, 'JE97218002', 'Outbound', 46170, 'Cashless', 0, '2026-09-29', 'Terkirim', 10, 89, 7),
(90, 'JE38403354', 'Intracity', 49470, 'Cashless', 0, '2026-09-25', 'Gagal', 5, 90, 3),
(91, 'JE78867024', 'Inbound', 33980, 'Cash', 0, '2026-09-26', 'Terkirim', 4, 91, 4),
(92, 'JE41452062', 'Intracity', 19350, 'COD', 479000, '2026-09-26', 'Dalam Pengiriman', 9, 92, 3),
(93, 'JE34611107', 'Outbound', 55810, 'Cash', 0, '2026-09-30', 'Terkirim', 3, 93, 8),
(94, 'JE42136228', 'Outbound', 45090, 'Cash', 0, '2026-10-01', 'Terkirim', 1, 94, 7),
(95, 'JE26402696', 'Outbound', 18840, 'Cash', 0, '2026-09-28', 'Terkirim', 1, 95, 3),
(96, 'JE80088400', 'Intracity', 10920, 'Cash', 0, '2026-09-28', 'Terkirim', 2, 96, 1),
(97, 'JE32349151', 'Inbound', 46650, 'Cashless', 0, '2026-09-29', 'Terkirim', 9, 97, 7),
(98, 'JE60142664', 'Inbound', 61390, 'Cash', 0, '2026-09-29', 'Terkirim', 9, 98, 8),
(99, 'JE28992626', 'Outbound', 64730, 'Cashless', 0, '2026-09-29', 'Terkirim', 1, 99, 4),
(100, 'JE72418109', 'Outbound', 92980, 'Cashless', 0, '2026-10-06', 'Terkirim', 5, 100, 11),
(101, 'JE79718175', 'Outbound', 64570, 'Cash', 0, '2026-10-03', 'Dalam Pengiriman', 6, 101, 8),
(102, 'JE29338088', 'Inbound', 23180, 'COD', 639000, '2026-09-30', 'Dalam Pengiriman', 7, 102, 4),
(103, 'JE53274220', 'Outbound', 55450, 'Cash', 0, '2026-10-03', 'Diterima Konter', 1, 103, 8),
(104, 'JE16298947', 'Outbound', 58360, 'Cash', 0, '2026-10-03', 'Diterima Konter', 9, 104, 8),
(105, 'JE40240979', 'Inbound', 36190, 'Cash', 0, '2026-09-29', 'Diterima Konter', 7, 105, 6),
(106, 'JE52209465', 'Intracity', 16590, 'Cashless', 0, '2026-09-29', 'Diterima Konter', 7, 106, 2),
(107, 'JE94844437', 'Outbound', 76880, 'Cash', 0, '2026-10-08', 'Diterima Konter', 8, 107, 10),
(108, 'JE38328041', 'Outbound', 60070, 'Cashless', 0, '2026-10-04', 'Dalam Pengiriman', 5, 108, 8),
(109, 'JE88193003', 'Outbound', 27530, 'Cashless', 0, '2026-10-01', 'Dalam Pengiriman', 3, 109, 4),
(110, 'JE20614451', 'Outbound', 80630, 'Cash', 0, '2026-10-06', 'Diterima Konter', 8, 110, 10),
(111, 'JE17064785', 'Inbound', 64760, 'COD', 640000, '2026-10-02', 'Diterima Konter', 3, 111, 9),
(112, 'JE44005414', 'Inbound', 51510, 'Cash', 0, '2026-10-02', 'Terkirim', 1, 112, 7),
(113, 'JE42343987', 'Inbound', 22640, 'COD', 464000, '2026-10-02', 'Dalam Pengiriman', 5, 113, 4);

-- --------------------------------------------------------

--
-- Table structure for table `petugas_konter`
--

CREATE TABLE `petugas_konter` (
  `id_user` int NOT NULL,
  `shift_kerja` enum('Pagi','Siang','Malam') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `petugas_konter`
--

INSERT INTO `petugas_konter` (`id_user`, `shift_kerja`) VALUES
(2, 'Pagi'),
(3, 'Siang'),
(4, 'Malam'),
(5, 'Pagi'),
(10, 'Pagi'),
(11, 'Siang'),
(12, 'Malam'),
(18, 'Pagi'),
(19, 'Siang'),
(20, 'Malam'),
(21, 'Pagi'),
(25, 'Pagi'),
(26, 'Siang'),
(27, 'Malam'),
(31, 'Pagi'),
(32, 'Siang'),
(33, 'Malam'),
(34, 'Pagi'),
(38, 'Pagi'),
(39, 'Siang'),
(40, 'Malam'),
(41, 'Pagi'),
(45, 'Pagi'),
(46, 'Siang'),
(47, 'Malam'),
(48, 'Pagi'),
(52, 'Pagi'),
(53, 'Siang'),
(54, 'Malam'),
(60, 'Pagi'),
(61, 'Siang'),
(62, 'Malam'),
(66, 'Pagi'),
(67, 'Siang'),
(68, 'Malam');

-- --------------------------------------------------------

--
-- Table structure for table `riwayat_pelacakan`
--

CREATE TABLE `riwayat_pelacakan` (
  `id_riwayat` int NOT NULL,
  `deskripsi` varchar(50) NOT NULL,
  `waktu_riwayat` datetime NOT NULL,
  `id_pengiriman` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `riwayat_pelacakan`
--

INSERT INTO `riwayat_pelacakan` (`id_riwayat`, `deskripsi`, `waktu_riwayat`, `id_pengiriman`) VALUES
(1, 'Paket dititipkan di konter Loa Janan Ilir', '2026-09-01 08:06:00', 1),
(2, 'Paket diproses di konter Loa Janan Ilir', '2026-09-01 10:41:34', 1),
(3, 'Paket dibawa kurir menuju alamat penerima', '2026-09-02 03:28:13', 1),
(4, 'Paket diterima oleh penerima', '2026-09-02 08:15:21', 1),
(5, 'Paket dititipkan di konter Samarinda Ulu', '2026-09-01 08:48:00', 2),
(6, 'Paket diproses di hub Samarinda', '2026-09-01 14:24:14', 2),
(7, 'Paket diberangkatkan ke Makassar', '2026-09-02 05:11:35', 2),
(8, 'Paket tiba di hub Makassar', '2026-09-03 03:00:36', 2),
(9, 'Paket dibawa kurir menuju alamat penerima', '2026-09-03 08:21:16', 2),
(10, 'Paket diterima oleh penerima di Makassar', '2026-09-03 10:58:02', 2),
(11, 'Paket dititipkan di konter Samarinda Seberang', '2026-09-01 12:26:00', 3),
(12, 'Paket diproses di konter Samarinda Seberang', '2026-09-01 14:53:37', 3),
(13, 'Paket diambil penerima di konter', '2026-09-02 08:11:28', 3),
(14, 'Paket dititipkan di konter Sungai Pinang', '2026-09-01 15:15:00', 4),
(15, 'Paket diproses di konter Sungai Pinang', '2026-09-01 17:04:54', 4),
(16, 'Paket dibawa kurir menuju alamat penerima', '2026-09-02 12:39:27', 4),
(17, 'Paket diterima oleh penerima', '2026-09-02 14:38:05', 4),
(18, 'Paket dititipkan di konter Palaran', '2026-09-01 15:33:00', 5),
(19, 'Paket diproses di hub Samarinda', '2026-09-01 18:52:39', 5),
(20, 'Paket diberangkatkan ke Jayapura', '2026-09-02 03:19:57', 5),
(21, 'Paket tiba di hub Jayapura', '2026-09-03 10:37:40', 5),
(22, 'Paket dibawa kurir menuju alamat penerima', '2026-09-03 18:09:08', 5),
(23, 'Paket diterima oleh penerima di Jayapura', '2026-09-03 22:02:16', 5),
(24, 'Paket dititipkan di konter Samarinda Seberang', '2026-09-02 10:35:00', 6),
(25, 'Paket diproses di konter Samarinda Seberang', '2026-09-02 11:58:55', 6),
(26, 'Paket diambil penerima di konter', '2026-09-03 11:24:09', 6),
(27, 'Paket dititipkan di konter Sungai Kunjang', '2026-09-02 14:55:00', 7),
(28, 'Paket diproses di konter Sungai Kunjang', '2026-09-02 16:35:37', 7),
(29, 'Paket dibawa kurir menuju alamat penerima', '2026-09-03 11:33:38', 7),
(30, 'Paket diterima oleh penerima', '2026-09-03 12:53:36', 7),
(31, 'Paket dititipkan di konter Samarinda Kota', '2026-09-03 09:49:00', 8),
(32, 'Paket diproses di konter Samarinda Kota', '2026-09-03 10:51:26', 8),
(33, 'Paket dibawa kurir menuju alamat penerima', '2026-09-03 23:48:38', 8),
(34, 'Paket diterima oleh penerima', '2026-09-04 04:36:15', 8),
(35, 'Paket dititipkan di konter Palaran', '2026-09-03 11:47:00', 9),
(36, 'Paket diproses di konter Palaran', '2026-09-03 13:26:03', 9),
(37, 'Paket dibawa kurir menuju alamat penerima', '2026-09-04 05:50:09', 9),
(38, 'Paket diterima oleh penerima', '2026-09-04 07:45:19', 9),
(39, 'Paket dititipkan di konter Palaran', '2026-09-03 13:45:00', 10),
(40, 'Paket diproses di konter Palaran', '2026-09-03 16:20:57', 10),
(41, 'Paket dibawa kurir menuju alamat penerima', '2026-09-04 03:35:54', 10),
(42, 'Paket diterima oleh penerima', '2026-09-04 06:50:43', 10),
(43, 'Paket dititipkan di konter Samarinda Kota', '2026-09-03 15:49:00', 11),
(44, 'Paket diproses di konter Samarinda Kota', '2026-09-03 17:41:15', 11),
(45, 'Paket dibawa kurir menuju alamat penerima', '2026-09-03 23:05:55', 11),
(46, 'Paket diterima oleh penerima', '2026-09-04 00:13:22', 11),
(47, 'Paket dititipkan di konter Sungai Kunjang', '2026-09-03 16:43:00', 12),
(48, 'Paket diproses di konter Sungai Kunjang', '2026-09-03 17:53:23', 12),
(49, 'Paket diambil penerima di konter', '2026-09-04 03:16:50', 12),
(50, 'Paket diterima di konter Samarinda Ilir', '2026-09-04 12:18:00', 13),
(51, 'Paket dibawa kurir menuju alamat penerima', '2026-09-04 17:20:23', 13),
(52, 'Paket diterima oleh penerima', '2026-09-04 21:45:58', 13),
(53, 'Paket dititipkan di konter Sungai Pinang', '2026-09-05 10:08:00', 14),
(54, 'Paket diproses di hub Samarinda', '2026-09-05 14:35:02', 14),
(55, 'Paket diberangkatkan ke Palembang', '2026-09-06 05:26:43', 14),
(56, 'Paket tiba di hub Palembang', '2026-09-08 04:10:42', 14),
(57, 'Paket dibawa kurir menuju alamat penerima', '2026-09-08 08:38:02', 14),
(58, 'Paket diterima oleh penerima di Palembang', '2026-09-08 14:21:48', 14),
(59, 'Paket diterima di konter Palaran', '2026-09-05 12:18:00', 15),
(60, 'Paket dibawa kurir menuju alamat penerima', '2026-09-06 05:56:55', 15),
(61, 'Paket diterima oleh penerima', '2026-09-06 10:55:10', 15),
(62, 'Paket diterima di konter Samarinda Utara', '2026-09-05 13:14:00', 16),
(63, 'Paket diambil penerima di konter', '2026-09-05 18:20:12', 16),
(64, 'Paket dititipkan di konter Samarinda Ilir', '2026-09-05 16:40:00', 17),
(65, 'Paket diproses di konter Samarinda Ilir', '2026-09-05 18:47:25', 17),
(66, 'Paket dibawa kurir menuju alamat penerima', '2026-09-05 21:13:18', 17),
(67, 'Paket diterima oleh penerima', '2026-09-06 01:18:13', 17),
(68, 'Paket dititipkan di konter Sungai Pinang', '2026-09-05 16:45:00', 18),
(69, 'Paket diproses di hub Samarinda', '2026-09-05 23:43:52', 18),
(70, 'Paket diberangkatkan ke Tenggarong', '2026-09-06 10:53:17', 18),
(71, 'Paket tiba di hub Tenggarong', '2026-09-06 17:14:52', 18),
(72, 'Paket dibawa kurir menuju alamat penerima', '2026-09-07 01:25:49', 18),
(73, 'Paket diterima oleh penerima di Tenggarong', '2026-09-07 05:31:33', 18),
(74, 'Paket diterima di konter Samarinda Ilir', '2026-09-05 16:49:00', 19),
(75, 'Paket diambil penerima di konter', '2026-09-06 10:29:29', 19),
(76, 'Paket diterima di konter Samarinda Ulu', '2026-09-06 08:17:00', 20),
(77, 'Paket dibawa kurir menuju alamat penerima', '2026-09-06 11:10:09', 20),
(78, 'Paket diterima oleh penerima', '2026-09-06 14:23:26', 20),
(79, 'Paket dititipkan di konter Sungai Kunjang', '2026-09-06 09:35:00', 21),
(80, 'Paket diproses di hub Samarinda', '2026-09-06 15:17:04', 21),
(81, 'Paket diberangkatkan ke Makassar', '2026-09-06 21:38:42', 21),
(82, 'Paket tiba di hub Makassar', '2026-09-07 09:35:28', 21),
(83, 'Paket dibawa kurir menuju alamat penerima', '2026-09-07 12:47:07', 21),
(84, 'Paket diterima oleh penerima di Makassar', '2026-09-07 18:08:54', 21),
(85, 'Paket dititipkan di konter Sambutan', '2026-09-06 10:17:00', 22),
(86, 'Paket diproses di konter Sambutan', '2026-09-06 12:33:22', 22),
(87, 'Paket dibawa kurir menuju alamat penerima', '2026-09-07 06:31:15', 22),
(88, 'Paket diterima oleh penerima', '2026-09-07 10:40:11', 22),
(89, 'Paket diterima di konter Sambutan', '2026-09-06 10:26:00', 23),
(90, 'Paket dibawa kurir menuju alamat penerima', '2026-09-07 02:52:48', 23),
(91, 'Paket diterima oleh penerima', '2026-09-07 06:27:02', 23),
(92, 'Paket diterima di konter Palaran', '2026-09-06 11:41:00', 24),
(93, 'Paket dibawa kurir menuju alamat penerima', '2026-09-07 02:59:51', 24),
(94, 'Pengantaran gagal, penerima tidak di tempat', '2026-09-07 04:44:38', 24),
(95, 'Paket dititipkan di konter Palaran', '2026-09-07 09:48:00', 25),
(96, 'Paket diproses di konter Palaran', '2026-09-07 11:02:18', 25),
(97, 'Paket dibawa kurir menuju alamat penerima', '2026-09-07 14:01:52', 25),
(98, 'Paket diterima oleh penerima', '2026-09-07 18:29:37', 25),
(99, 'Paket dititipkan di konter Samarinda Ulu', '2026-09-07 14:22:00', 26),
(100, 'Paket diproses di konter Samarinda Ulu', '2026-09-07 15:22:54', 26),
(101, 'Paket dibawa kurir menuju alamat penerima', '2026-09-08 03:26:47', 26),
(102, 'Paket diterima oleh penerima', '2026-09-08 04:43:28', 26),
(103, 'Paket dititipkan di konter Sungai Pinang', '2026-09-07 14:32:00', 27),
(104, 'Paket diproses di konter Sungai Pinang', '2026-09-07 17:04:15', 27),
(105, 'Paket dibawa kurir menuju alamat penerima', '2026-09-08 11:12:22', 27),
(106, 'Paket diterima oleh penerima', '2026-09-08 16:04:18', 27),
(107, 'Paket dititipkan di konter Samarinda Utara', '2026-09-07 15:32:00', 28),
(108, 'Paket diproses di konter Samarinda Utara', '2026-09-07 18:17:05', 28),
(109, 'Paket dibawa kurir menuju alamat penerima', '2026-09-08 05:09:02', 28),
(110, 'Paket dititipkan di konter Loa Janan Ilir', '2026-09-08 15:13:00', 29),
(111, 'Paket diproses di hub Samarinda', '2026-09-08 21:53:25', 29),
(112, 'Paket diberangkatkan ke Palangkaraya', '2026-09-09 14:39:02', 29),
(113, 'Paket tiba di hub Palangkaraya', '2026-09-10 00:36:59', 29),
(114, 'Paket dibawa kurir menuju alamat penerima', '2026-09-10 04:02:46', 29),
(115, 'Paket diterima oleh penerima di Palangkaraya', '2026-09-10 06:33:43', 29),
(116, 'Paket dititipkan di konter Sambutan', '2026-09-08 16:23:00', 30),
(117, 'Paket diproses di hub Samarinda', '2026-09-08 20:57:13', 30),
(118, 'Paket diberangkatkan ke Makassar', '2026-09-09 08:01:50', 30),
(119, 'Paket tiba di hub Makassar', '2026-09-10 08:35:07', 30),
(120, 'Paket dibawa kurir menuju alamat penerima', '2026-09-10 13:11:38', 30),
(121, 'Paket diterima oleh penerima di Makassar', '2026-09-10 16:30:47', 30),
(122, 'Paket dititipkan di konter Samarinda Seberang', '2026-09-09 08:41:00', 31),
(123, 'Paket diproses di hub Samarinda', '2026-09-09 15:44:32', 31),
(124, 'Paket diberangkatkan ke Balikpapan', '2026-09-10 04:36:47', 31),
(125, 'Paket tiba di hub Balikpapan', '2026-09-10 14:03:22', 31),
(126, 'Paket dibawa kurir menuju alamat penerima', '2026-09-10 23:04:00', 31),
(127, 'Paket diterima oleh penerima di Balikpapan', '2026-09-11 04:14:15', 31),
(128, 'Paket diterima di konter Samarinda Ilir', '2026-09-09 11:21:00', 32),
(129, 'Paket diambil penerima di konter', '2026-09-09 17:36:10', 32),
(130, 'Paket dititipkan di konter Sambutan', '2026-09-09 12:52:00', 33),
(131, 'Paket diproses di konter Sambutan', '2026-09-09 14:40:20', 33),
(132, 'Paket dibawa kurir menuju alamat penerima', '2026-09-09 18:38:16', 33),
(133, 'Paket diterima oleh penerima', '2026-09-09 20:00:47', 33),
(134, 'Paket dititipkan di konter Samarinda Utara', '2026-09-09 13:05:00', 34),
(135, 'Paket diproses di konter Samarinda Utara', '2026-09-09 15:03:08', 34),
(136, 'Paket dibawa kurir menuju alamat penerima', '2026-09-09 18:19:52', 34),
(137, 'Paket diterima oleh penerima', '2026-09-09 22:12:06', 34),
(138, 'Paket dititipkan di konter Samarinda Ilir', '2026-09-09 15:16:00', 35),
(139, 'Paket diproses di konter Samarinda Ilir', '2026-09-09 18:07:57', 35),
(140, 'Paket dibawa kurir menuju alamat penerima', '2026-09-09 22:44:12', 35),
(141, 'Paket diterima oleh penerima', '2026-09-10 01:08:24', 35),
(142, 'Paket dititipkan di konter Sungai Kunjang', '2026-09-09 16:33:00', 36),
(143, 'Paket diproses di hub Samarinda', '2026-09-09 20:07:09', 36),
(144, 'Paket diberangkatkan ke Tenggarong', '2026-09-10 10:45:29', 36),
(145, 'Paket tiba di hub Tenggarong', '2026-09-10 17:00:16', 36),
(146, 'Paket dibawa kurir menuju alamat penerima', '2026-09-11 02:35:43', 36),
(147, 'Paket diterima oleh penerima di Tenggarong', '2026-09-11 07:24:10', 36),
(148, 'Paket dititipkan di konter Samarinda Utara', '2026-09-10 09:36:00', 37),
(149, 'Paket diproses di hub Samarinda', '2026-09-10 16:46:21', 37),
(150, 'Paket diberangkatkan ke Pekanbaru', '2026-09-10 23:37:04', 37),
(151, 'Paket tiba di hub Pekanbaru', '2026-09-12 21:44:52', 37),
(152, 'Paket dibawa kurir menuju alamat penerima', '2026-09-13 05:02:49', 37),
(153, 'Paket diterima oleh penerima di Pekanbaru', '2026-09-13 10:38:21', 37),
(154, 'Paket dititipkan di konter Sungai Kunjang', '2026-09-10 11:37:00', 38),
(155, 'Paket diproses di konter Sungai Kunjang', '2026-09-10 12:38:17', 38),
(156, 'Paket dibawa kurir menuju alamat penerima', '2026-09-10 22:04:25', 38),
(157, 'Paket dititipkan di konter Samarinda Kota', '2026-09-10 12:48:00', 39),
(158, 'Paket diproses di konter Samarinda Kota', '2026-09-10 15:26:19', 39),
(159, 'Paket dibawa kurir menuju alamat penerima', '2026-09-11 09:57:58', 39),
(160, 'Paket diterima oleh penerima', '2026-09-11 14:16:18', 39),
(161, 'Paket dititipkan di konter Samarinda Utara', '2026-09-11 08:49:00', 40),
(162, 'Paket diproses di konter Samarinda Utara', '2026-09-11 11:15:09', 40),
(163, 'Paket dibawa kurir menuju alamat penerima', '2026-09-11 22:12:46', 40),
(164, 'Paket diterima oleh penerima', '2026-09-11 23:39:44', 40),
(165, 'Paket diterima di konter Samarinda Kota', '2026-09-11 10:12:00', 41),
(166, 'Paket dibawa kurir menuju alamat penerima', '2026-09-11 17:10:38', 41),
(167, 'Paket diterima oleh penerima', '2026-09-11 19:14:35', 41),
(168, 'Paket diterima di konter Samarinda Kota', '2026-09-11 14:32:00', 42),
(169, 'Paket dibawa kurir menuju alamat penerima', '2026-09-11 19:38:03', 42),
(170, 'Paket diterima oleh penerima', '2026-09-11 22:45:40', 42),
(171, 'Paket dititipkan di konter Samarinda Ulu', '2026-09-11 14:53:00', 43),
(172, 'Paket diproses di hub Samarinda', '2026-09-11 21:14:00', 43),
(173, 'Paket diberangkatkan ke Jakarta', '2026-09-12 10:53:35', 43),
(174, 'Paket diterima di konter Sungai Kunjang', '2026-09-11 15:20:00', 44),
(175, 'Paket dibawa kurir menuju alamat penerima', '2026-09-11 21:59:24', 44),
(176, 'Pengantaran gagal, penerima tidak di tempat', '2026-09-11 23:00:19', 44),
(177, 'Paket dititipkan di konter Loa Janan Ilir', '2026-09-12 10:34:00', 45),
(178, 'Paket diproses di hub Samarinda', '2026-09-12 17:33:53', 45),
(179, 'Paket diberangkatkan ke Denpasar', '2026-09-13 04:02:21', 45),
(180, 'Paket tiba di hub Denpasar', '2026-09-13 11:19:43', 45),
(181, 'Paket dibawa kurir menuju alamat penerima', '2026-09-13 19:41:13', 45),
(182, 'Paket diterima oleh penerima di Denpasar', '2026-09-13 21:48:12', 45),
(183, 'Paket dititipkan di konter Loa Janan Ilir', '2026-09-12 11:19:00', 46),
(184, 'Paket diproses di hub Samarinda', '2026-09-12 16:03:33', 46),
(185, 'Paket diberangkatkan ke Banda Aceh', '2026-09-13 06:05:24', 46),
(186, 'Paket dititipkan di konter Loa Janan Ilir', '2026-09-12 12:21:00', 47),
(187, 'Paket diproses di konter Loa Janan Ilir', '2026-09-12 14:19:16', 47),
(188, 'Paket diambil penerima di konter', '2026-09-12 23:32:18', 47),
(189, 'Paket diterima di konter Samarinda Seberang', '2026-09-12 13:38:00', 48),
(190, 'Paket dibawa kurir menuju alamat penerima', '2026-09-13 05:07:08', 48),
(191, 'Pengantaran gagal, penerima tidak di tempat', '2026-09-13 09:12:48', 48),
(192, 'Paket dititipkan di konter Palaran', '2026-09-12 15:08:00', 49),
(193, 'Paket diproses di hub Samarinda', '2026-09-12 21:24:58', 49),
(194, 'Paket diberangkatkan ke Palangkaraya', '2026-09-13 06:22:12', 49),
(195, 'Paket tiba di hub Palangkaraya', '2026-09-13 21:42:36', 49),
(196, 'Paket dibawa kurir menuju alamat penerima', '2026-09-14 07:22:18', 49),
(197, 'Paket diterima oleh penerima di Palangkaraya', '2026-09-14 09:41:53', 49),
(198, 'Paket dititipkan di konter Samarinda Ilir', '2026-09-13 14:01:00', 50),
(199, 'Paket diproses di hub Samarinda', '2026-09-13 21:09:09', 50),
(200, 'Paket diberangkatkan ke Manado', '2026-09-14 10:58:03', 50),
(201, 'Paket tiba di hub Manado', '2026-09-15 11:55:10', 50),
(202, 'Paket dibawa kurir menuju alamat penerima', '2026-09-15 15:14:27', 50),
(203, 'Paket diterima oleh penerima di Manado', '2026-09-15 20:53:22', 50),
(204, 'Paket diterima di konter Palaran', '2026-09-14 08:35:00', 51),
(205, 'Paket dibawa kurir menuju alamat penerima', '2026-09-14 11:58:54', 51),
(206, 'Paket diterima oleh penerima', '2026-09-14 16:26:54', 51),
(207, 'Paket diterima di konter Palaran', '2026-09-14 11:57:00', 52),
(208, 'Paket dibawa kurir menuju alamat penerima', '2026-09-14 21:40:13', 52),
(209, 'Paket diterima oleh penerima', '2026-09-15 01:39:45', 52),
(210, 'Paket dititipkan di konter Samarinda Ilir', '2026-09-14 12:21:00', 53),
(211, 'Paket diproses di konter Samarinda Ilir', '2026-09-14 13:22:34', 53),
(212, 'Paket diambil penerima di konter', '2026-09-15 07:40:46', 53),
(213, 'Paket dititipkan di konter Loa Janan Ilir', '2026-09-14 15:54:00', 54),
(214, 'Paket diproses di hub Samarinda', '2026-09-14 23:46:53', 54),
(215, 'Paket diberangkatkan ke Surabaya', '2026-09-15 16:07:44', 54),
(216, 'Paket tiba di hub Surabaya', '2026-09-16 15:33:45', 54),
(217, 'Paket dibawa kurir menuju alamat penerima', '2026-09-16 22:35:39', 54),
(218, 'Paket diterima oleh penerima di Surabaya', '2026-09-17 04:16:20', 54),
(219, 'Paket dititipkan di konter Samarinda Utara', '2026-09-14 16:43:00', 55),
(220, 'Paket diproses di hub Samarinda', '2026-09-14 23:43:26', 55),
(221, 'Paket diberangkatkan ke Batam', '2026-09-15 14:05:10', 55),
(222, 'Paket tiba di hub Batam', '2026-09-16 10:28:17', 55),
(223, 'Paket dibawa kurir menuju alamat penerima', '2026-09-16 14:00:04', 55),
(224, 'Paket diterima oleh penerima di Batam', '2026-09-16 19:53:24', 55),
(225, 'Paket diterima di konter Sambutan', '2026-09-15 10:11:00', 56),
(226, 'Paket dibawa kurir menuju alamat penerima', '2026-09-16 04:56:41', 56),
(227, 'Paket diterima oleh penerima', '2026-09-16 09:15:16', 56),
(228, 'Paket diterima di konter Samarinda Utara', '2026-09-15 11:38:00', 57),
(229, 'Paket dibawa kurir menuju alamat penerima', '2026-09-16 05:38:38', 57),
(230, 'Paket diterima oleh penerima', '2026-09-16 06:57:24', 57),
(231, 'Paket dititipkan di konter Palaran', '2026-09-15 12:53:00', 58),
(232, 'Paket diproses di hub Samarinda', '2026-09-15 18:26:17', 58),
(233, 'Paket diberangkatkan ke Jakarta', '2026-09-16 01:03:00', 58),
(234, 'Paket tiba di hub Jakarta', '2026-09-18 01:01:33', 58),
(235, 'Paket dibawa kurir menuju alamat penerima', '2026-09-18 08:25:16', 58),
(236, 'Paket diterima oleh penerima di Jakarta', '2026-09-18 12:14:01', 58),
(237, 'Paket dititipkan di konter Sambutan', '2026-09-15 14:09:00', 59),
(238, 'Paket diproses di hub Samarinda', '2026-09-15 19:45:38', 59),
(239, 'Paket diberangkatkan ke Medan', '2026-09-16 04:23:57', 59),
(240, 'Paket tiba di hub Medan', '2026-09-17 20:09:27', 59),
(241, 'Paket dibawa kurir menuju alamat penerima', '2026-09-18 01:01:48', 59),
(242, 'Paket diterima oleh penerima di Medan', '2026-09-18 03:01:55', 59),
(243, 'Paket dititipkan di konter Samarinda Seberang', '2026-09-16 10:01:00', 60),
(244, 'Paket diproses di hub Samarinda', '2026-09-16 17:48:59', 60),
(245, 'Paket diberangkatkan ke Makassar', '2026-09-17 06:35:30', 60),
(246, 'Paket tiba di hub Makassar', '2026-09-18 06:17:41', 60),
(247, 'Paket dibawa kurir menuju alamat penerima', '2026-09-18 14:55:43', 60),
(248, 'Paket diterima oleh penerima di Makassar', '2026-09-18 20:25:19', 60),
(249, 'Paket dititipkan di konter Samarinda Seberang', '2026-09-16 12:31:00', 61),
(250, 'Paket diproses di hub Samarinda', '2026-09-16 18:04:09', 61),
(251, 'Paket diberangkatkan ke Bandung', '2026-09-17 03:51:36', 61),
(252, 'Paket dititipkan di konter Samarinda Seberang', '2026-09-16 13:16:00', 62),
(253, 'Paket diproses di hub Samarinda', '2026-09-16 18:37:13', 62),
(254, 'Paket diberangkatkan ke Jakarta', '2026-09-17 00:56:22', 62),
(255, 'Paket tiba di hub Jakarta', '2026-09-17 07:17:50', 62),
(256, 'Paket dibawa kurir menuju alamat penerima', '2026-09-17 10:37:59', 62),
(257, 'Paket diterima oleh penerima di Jakarta', '2026-09-17 14:10:09', 62),
(258, 'Paket diterima di konter Sungai Pinang', '2026-09-17 11:50:00', 63),
(259, 'Paket dibawa kurir menuju alamat penerima', '2026-09-17 18:47:36', 63),
(260, 'Paket diterima oleh penerima', '2026-09-17 22:30:45', 63),
(261, 'Paket diterima di konter Loa Janan Ilir', '2026-09-17 11:55:00', 64),
(262, 'Paket dibawa kurir menuju alamat penerima', '2026-09-17 21:57:37', 64),
(263, 'Paket diterima di konter Sungai Kunjang', '2026-09-17 16:38:00', 65),
(264, 'Paket dibawa kurir menuju alamat penerima', '2026-09-18 02:24:32', 65),
(265, 'Paket diterima oleh penerima', '2026-09-18 03:39:32', 65),
(266, 'Paket dititipkan di konter Sambutan', '2026-09-18 08:19:00', 66),
(267, 'Paket diproses di hub Samarinda', '2026-09-18 15:06:16', 66),
(268, 'Paket diberangkatkan ke Makassar', '2026-09-19 02:10:09', 66),
(269, 'Paket tiba di hub Makassar', '2026-09-19 20:46:05', 66),
(270, 'Paket dibawa kurir menuju alamat penerima', '2026-09-20 04:34:09', 66),
(271, 'Paket diterima oleh penerima di Makassar', '2026-09-20 07:19:32', 66),
(272, 'Paket diterima di konter Samarinda Utara', '2026-09-18 11:34:00', 67),
(273, 'Paket dibawa kurir menuju alamat penerima', '2026-09-18 21:58:24', 67),
(274, 'Paket diterima oleh penerima', '2026-09-19 01:48:12', 67),
(275, 'Paket diterima di konter Samarinda Ulu', '2026-09-18 12:08:00', 68),
(276, 'Paket dibawa kurir menuju alamat penerima', '2026-09-18 15:03:53', 68),
(277, 'Pengantaran gagal, penerima tidak di tempat', '2026-09-18 16:24:19', 68),
(278, 'Paket dititipkan di konter Sungai Kunjang', '2026-09-18 12:30:00', 69),
(279, 'Paket diproses di konter Sungai Kunjang', '2026-09-18 15:29:10', 69),
(280, 'Paket dibawa kurir menuju alamat penerima', '2026-09-18 18:02:54', 69),
(281, 'Paket diterima oleh penerima', '2026-09-18 22:24:51', 69),
(282, 'Paket dititipkan di konter Sambutan', '2026-09-18 13:08:00', 70),
(283, 'Paket diproses di konter Sambutan', '2026-09-18 16:04:22', 70),
(284, 'Paket dibawa kurir menuju alamat penerima', '2026-09-18 23:32:19', 70),
(285, 'Paket diterima di konter Samarinda Kota', '2026-09-18 13:20:00', 71),
(286, 'Paket dibawa kurir menuju alamat penerima', '2026-09-19 04:22:37', 71),
(287, 'Pengantaran gagal, penerima tidak di tempat', '2026-09-19 07:18:01', 71),
(288, 'Paket dititipkan di konter Sungai Pinang', '2026-09-18 13:23:00', 72),
(289, 'Paket diproses di hub Samarinda', '2026-09-18 17:02:25', 72),
(290, 'Paket diberangkatkan ke Jakarta', '2026-09-19 06:58:18', 72),
(291, 'Paket tiba di hub Jakarta', '2026-09-20 15:12:21', 72),
(292, 'Paket dibawa kurir menuju alamat penerima', '2026-09-21 00:27:23', 72),
(293, 'Paket diterima oleh penerima di Jakarta', '2026-09-21 05:57:28', 72),
(294, 'Paket dititipkan di konter Samarinda Ilir', '2026-09-18 13:43:00', 73),
(295, 'Paket diproses di hub Samarinda', '2026-09-18 21:12:24', 73),
(296, 'Paket diberangkatkan ke Palembang', '2026-09-19 05:30:56', 73),
(297, 'Paket tiba di hub Palembang', '2026-09-20 16:08:30', 73),
(298, 'Paket dibawa kurir menuju alamat penerima', '2026-09-20 21:30:49', 73),
(299, 'Paket diterima oleh penerima di Palembang', '2026-09-21 01:34:20', 73),
(300, 'Paket dititipkan di konter Samarinda Ilir', '2026-09-19 15:40:00', 74),
(301, 'Paket diproses di hub Samarinda', '2026-09-19 21:48:16', 74),
(302, 'Paket diberangkatkan ke Denpasar', '2026-09-20 13:37:20', 74),
(303, 'Paket tiba di hub Denpasar', '2026-09-21 09:40:33', 74),
(304, 'Paket dibawa kurir menuju alamat penerima', '2026-09-21 19:09:12', 74),
(305, 'Paket diterima oleh penerima di Denpasar', '2026-09-21 22:57:34', 74),
(306, 'Paket diterima di konter Sungai Kunjang', '2026-09-20 09:54:00', 75),
(307, 'Paket diambil penerima di konter', '2026-09-21 09:58:49', 75),
(308, 'Paket dititipkan di konter Sungai Pinang', '2026-09-20 16:12:00', 76),
(309, 'Paket diproses di hub Samarinda', '2026-09-20 19:39:19', 76),
(310, 'Paket diberangkatkan ke Denpasar', '2026-09-21 03:35:28', 76),
(311, 'Paket tiba di hub Denpasar', '2026-09-21 15:08:15', 76),
(312, 'Paket dibawa kurir menuju alamat penerima', '2026-09-21 22:31:26', 76),
(313, 'Paket diterima oleh penerima di Denpasar', '2026-09-22 03:18:16', 76),
(314, 'Paket dititipkan di konter Samarinda Ulu', '2026-09-21 13:03:00', 77),
(315, 'Paket diproses di konter Samarinda Ulu', '2026-09-21 14:54:03', 77),
(316, 'Paket dibawa kurir menuju alamat penerima', '2026-09-22 05:29:13', 77),
(317, 'Paket diterima oleh penerima', '2026-09-22 07:29:17', 77),
(318, 'Paket dititipkan di konter Sungai Pinang', '2026-09-21 14:34:00', 78),
(319, 'Paket diproses di hub Samarinda', '2026-09-21 17:48:08', 78),
(320, 'Paket diberangkatkan ke Surabaya', '2026-09-22 06:37:49', 78),
(321, 'Paket tiba di hub Surabaya', '2026-09-23 10:47:26', 78),
(322, 'Paket dibawa kurir menuju alamat penerima', '2026-09-23 15:05:17', 78),
(323, 'Paket diterima oleh penerima di Surabaya', '2026-09-23 18:13:30', 78),
(324, 'Paket dititipkan di konter Sambutan', '2026-09-21 15:58:00', 79),
(325, 'Paket diproses di hub Samarinda', '2026-09-21 20:57:16', 79),
(326, 'Paket diberangkatkan ke Jakarta', '2026-09-22 14:37:01', 79),
(327, 'Paket dititipkan di konter Palaran', '2026-09-22 10:07:00', 80),
(328, 'Paket diproses di konter Palaran', '2026-09-22 12:50:02', 80),
(329, 'Paket dibawa kurir menuju alamat penerima', '2026-09-22 16:49:19', 80),
(330, 'Paket diterima oleh penerima', '2026-09-22 21:13:40', 80),
(331, 'Paket dititipkan di konter Samarinda Utara', '2026-09-22 10:45:00', 81),
(332, 'Paket diproses di hub Samarinda', '2026-09-22 15:17:31', 81),
(333, 'Paket diberangkatkan ke Denpasar', '2026-09-23 04:46:19', 81),
(334, 'Paket dititipkan di konter Samarinda Kota', '2026-09-22 11:10:00', 82),
(335, 'Paket diproses di konter Samarinda Kota', '2026-09-22 12:17:46', 82),
(336, 'Paket dibawa kurir menuju alamat penerima', '2026-09-22 16:10:02', 82),
(337, 'Paket diterima oleh penerima', '2026-09-22 19:30:29', 82),
(338, 'Paket diterima di konter Samarinda Seberang', '2026-09-22 13:21:00', 83),
(339, 'Paket dibawa kurir menuju alamat penerima', '2026-09-23 05:01:57', 83),
(340, 'Paket diterima di konter Sungai Kunjang', '2026-09-22 13:23:00', 84),
(341, 'Paket dibawa kurir menuju alamat penerima', '2026-09-23 01:51:46', 84),
(342, 'Paket diterima oleh penerima', '2026-09-23 05:09:53', 84),
(343, 'Paket diterima di konter Loa Janan Ilir', '2026-09-22 14:12:00', 85),
(344, 'Paket dibawa kurir menuju alamat penerima', '2026-09-23 05:14:02', 85),
(345, 'Paket diterima oleh penerima', '2026-09-23 09:22:11', 85),
(346, 'Paket dititipkan di konter Samarinda Ulu', '2026-09-22 15:58:00', 86),
(347, 'Paket diproses di konter Samarinda Ulu', '2026-09-22 18:03:57', 86),
(348, 'Paket dibawa kurir menuju alamat penerima', '2026-09-22 20:44:07', 86),
(349, 'Pengantaran gagal, penerima tidak di tempat', '2026-09-22 22:35:41', 86),
(350, 'Paket dititipkan di konter Samarinda Ulu', '2026-09-22 16:33:00', 87),
(351, 'Paket diproses di konter Samarinda Ulu', '2026-09-22 19:30:17', 87),
(352, 'Paket dibawa kurir menuju alamat penerima', '2026-09-22 22:08:44', 87),
(353, 'Paket diterima oleh penerima', '2026-09-23 00:29:09', 87),
(354, 'Paket diterima di konter Sambutan', '2026-09-23 08:48:00', 88),
(355, 'Paket dibawa kurir menuju alamat penerima', '2026-09-24 00:28:13', 88),
(356, 'Paket diterima oleh penerima', '2026-09-24 03:05:54', 88),
(357, 'Paket dititipkan di konter Palaran', '2026-09-24 13:25:00', 89),
(358, 'Paket diproses di hub Samarinda', '2026-09-24 20:47:02', 89),
(359, 'Paket diberangkatkan ke Denpasar', '2026-09-25 06:12:33', 89),
(360, 'Paket tiba di hub Denpasar', '2026-09-25 16:19:02', 89),
(361, 'Paket dibawa kurir menuju alamat penerima', '2026-09-25 22:47:41', 89),
(362, 'Paket diterima oleh penerima di Denpasar', '2026-09-26 03:57:50', 89),
(363, 'Paket dititipkan di konter Samarinda Seberang', '2026-09-24 16:14:00', 90),
(364, 'Paket diproses di konter Samarinda Seberang', '2026-09-24 19:00:04', 90),
(365, 'Paket dibawa kurir menuju alamat penerima', '2026-09-25 00:01:44', 90),
(366, 'Pengantaran gagal, penerima tidak di tempat', '2026-09-25 03:31:13', 90),
(367, 'Paket diterima di konter Samarinda Utara', '2026-09-25 08:06:00', 91),
(368, 'Paket dibawa kurir menuju alamat penerima', '2026-09-25 10:18:13', 91),
(369, 'Paket diterima oleh penerima', '2026-09-25 11:51:32', 91),
(370, 'Paket dititipkan di konter Loa Janan Ilir', '2026-09-25 08:10:00', 92),
(371, 'Paket diproses di konter Loa Janan Ilir', '2026-09-25 09:13:48', 92),
(372, 'Paket dibawa kurir menuju alamat penerima', '2026-09-25 17:04:16', 92),
(373, 'Paket dititipkan di konter Samarinda Ulu', '2026-09-25 15:54:00', 93),
(374, 'Paket diproses di hub Samarinda', '2026-09-25 23:50:17', 93),
(375, 'Paket diberangkatkan ke Kupang', '2026-09-26 12:35:20', 93),
(376, 'Paket tiba di hub Kupang', '2026-09-27 05:37:54', 93),
(377, 'Paket dibawa kurir menuju alamat penerima', '2026-09-27 14:12:42', 93),
(378, 'Paket diterima oleh penerima di Kupang', '2026-09-27 17:49:50', 93),
(379, 'Paket dititipkan di konter Samarinda Kota', '2026-09-26 13:26:00', 94),
(380, 'Paket diproses di hub Samarinda', '2026-09-26 17:46:23', 94),
(381, 'Paket diberangkatkan ke Denpasar', '2026-09-27 07:10:23', 94),
(382, 'Paket tiba di hub Denpasar', '2026-09-27 15:49:14', 94),
(383, 'Paket dibawa kurir menuju alamat penerima', '2026-09-28 01:40:34', 94),
(384, 'Paket diterima oleh penerima di Denpasar', '2026-09-28 03:46:42', 94),
(385, 'Paket dititipkan di konter Samarinda Kota', '2026-09-26 15:14:00', 95),
(386, 'Paket diproses di hub Samarinda', '2026-09-26 19:38:52', 95),
(387, 'Paket diberangkatkan ke Tenggarong', '2026-09-27 05:03:31', 95),
(388, 'Paket tiba di hub Tenggarong', '2026-09-27 11:56:59', 95),
(389, 'Paket dibawa kurir menuju alamat penerima', '2026-09-27 18:40:07', 95),
(390, 'Paket diterima oleh penerima di Tenggarong', '2026-09-27 20:44:46', 95),
(391, 'Paket dititipkan di konter Samarinda Ilir', '2026-09-27 09:20:00', 96),
(392, 'Paket diproses di konter Samarinda Ilir', '2026-09-27 11:36:23', 96),
(393, 'Paket diambil penerima di konter', '2026-09-27 22:12:55', 96),
(394, 'Paket diterima di konter Loa Janan Ilir', '2026-09-27 09:27:00', 97),
(395, 'Paket dibawa kurir menuju alamat penerima', '2026-09-27 23:37:58', 97),
(396, 'Paket diterima oleh penerima', '2026-09-28 02:38:34', 97),
(397, 'Paket diterima di konter Loa Janan Ilir', '2026-09-27 10:15:00', 98),
(398, 'Paket dibawa kurir menuju alamat penerima', '2026-09-28 04:11:30', 98),
(399, 'Paket diterima oleh penerima', '2026-09-28 08:25:16', 98),
(400, 'Paket dititipkan di konter Samarinda Kota', '2026-09-27 14:13:00', 99),
(401, 'Paket diproses di hub Samarinda', '2026-09-27 19:54:18', 99),
(402, 'Paket diberangkatkan ke Sangatta', '2026-09-28 02:08:53', 99),
(403, 'Paket tiba di hub Sangatta', '2026-09-28 08:26:26', 99),
(404, 'Paket dibawa kurir menuju alamat penerima', '2026-09-28 16:01:32', 99),
(405, 'Paket diterima oleh penerima di Sangatta', '2026-09-28 21:18:16', 99),
(406, 'Paket dititipkan di konter Samarinda Seberang', '2026-09-27 15:12:00', 100),
(407, 'Paket diproses di hub Samarinda', '2026-09-27 22:12:40', 100),
(408, 'Paket diberangkatkan ke Banda Aceh', '2026-09-28 11:36:47', 100),
(409, 'Paket tiba di hub Banda Aceh', '2026-09-29 13:32:00', 100),
(410, 'Paket dibawa kurir menuju alamat penerima', '2026-09-29 22:41:25', 100),
(411, 'Paket diterima oleh penerima di Banda Aceh', '2026-09-30 01:23:06', 100),
(412, 'Paket dititipkan di konter Sungai Kunjang', '2026-09-28 10:48:00', 101),
(413, 'Paket diproses di hub Samarinda', '2026-09-28 13:59:06', 101),
(414, 'Paket diberangkatkan ke Bandung', '2026-09-29 01:51:32', 101),
(415, 'Paket tiba di hub Bandung', '2026-09-29 19:32:16', 101),
(416, 'Paket diterima di konter Sungai Pinang', '2026-09-28 12:49:00', 102),
(417, 'Paket dibawa kurir menuju alamat penerima', '2026-09-29 00:42:21', 102),
(418, 'Paket dititipkan di konter Samarinda Kota', '2026-09-28 13:48:00', 103),
(419, 'Paket dititipkan di konter Loa Janan Ilir', '2026-09-28 14:46:00', 104),
(420, 'Paket diterima di konter Sungai Pinang', '2026-09-28 15:08:00', 105),
(421, 'Paket dititipkan di konter Sungai Pinang', '2026-09-28 16:08:00', 106),
(422, 'Paket diproses di konter Sungai Pinang', '2026-09-28 18:18:16', 106),
(423, 'Paket dititipkan di konter Sambutan', '2026-09-29 13:09:00', 107),
(424, 'Paket dititipkan di konter Samarinda Seberang', '2026-09-29 13:53:00', 108),
(425, 'Paket diproses di hub Samarinda', '2026-09-29 18:35:19', 108),
(426, 'Paket diberangkatkan ke Jakarta', '2026-09-30 08:45:31', 108),
(427, 'Paket tiba di hub Jakarta', '2026-09-30 16:40:07', 108),
(428, 'Paket dititipkan di konter Samarinda Ulu', '2026-09-29 15:21:00', 109),
(429, 'Paket diproses di hub Samarinda', '2026-09-29 21:33:03', 109),
(430, 'Paket diberangkatkan ke Balikpapan', '2026-09-30 08:12:38', 109),
(431, 'Paket tiba di hub Balikpapan', '2026-09-30 15:11:48', 109),
(432, 'Paket dititipkan di konter Sambutan', '2026-09-29 16:05:00', 110),
(433, 'Paket diterima di konter Samarinda Ulu', '2026-09-30 14:46:00', 111),
(434, 'Paket diterima di konter Samarinda Kota', '2026-09-30 15:25:00', 112),
(435, 'Paket diterima di konter Samarinda Seberang', '2026-09-30 15:42:00', 113),
(436, 'Paket dibawa kurir menuju alamat penerima', '2026-10-01 07:09:44', 113),
(437, 'Paket dibawa kurir menuju alamat penerima', '2026-10-01 09:10:00', 112),
(438, 'Paket diterima oleh penerima', '2026-10-01 11:40:00', 112),
(439, 'Paket dibawa kurir menuju alamat penerima', '2026-10-01 09:10:00', 111),
(442, 'Status pengantaran: Berhasil', '2026-11-07 01:51:20', 82),
(443, 'Status pengantaran: Berhasil', '2026-11-07 01:51:29', 8),
(444, 'Status pengantaran: Berhasil', '2026-11-07 08:23:12', 82);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id_user` int NOT NULL,
  `nama` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `no_hp` varchar(15) NOT NULL,
  `gaji` int NOT NULL,
  `tanggal_masuk` date NOT NULL,
  `role` enum('Admin','Petugas Konter','Kurir') NOT NULL,
  `id_konter` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id_user`, `nama`, `email`, `password`, `no_hp`, `gaji`, `tanggal_masuk`, `role`, `id_konter`) VALUES
(1, 'Siti Mahendra', 'siti.mahendra@jetexpress.co.id', 'adminkeren47', '082139968745', 7000000, '2025-08-18', 'Admin', 1),
(2, 'Nia Rahman', 'nia.rahman@jetexpress.co.id', 'petugasterbaik83', '089642203407', 4500000, '2026-03-19', 'Petugas Konter', 1),
(3, 'Ahmad Santoso', 'ahmad.santoso@jetexpress.co.id', 'petugasterbaik26', '082170351650', 3900000, '2023-08-12', 'Petugas Konter', 1),
(4, 'Ahmad Kusuma', 'ahmad.kusuma@jetexpress.co.id', 'petugasterbaik91', '085363313617', 4800000, '2023-10-06', 'Petugas Konter', 1),
(5, 'Arif Lubis', 'arif.lubis@jetexpress.co.id', 'petugasterbaik54', '081355686986', 4300000, '2024-02-10', 'Petugas Konter', 1),
(6, 'Linda Noor', 'linda.noor@jetexpress.co.id', 'kurirjago38', '089628909714', 4000000, '2023-08-13', 'Kurir', 1),
(7, 'Nur Salim', 'nur.salim@jetexpress.co.id', 'kurirjago72', '088288613714', 4200000, '2022-07-05', 'Kurir', 1),
(8, 'Ayu Pahlevi', 'ayu.pahlevi@jetexpress.co.id', 'adminkeren15', '089778846905', 6000000, '2024-05-10', 'Admin', 2),
(9, 'Dian Wijaya', 'dian.wijaya@jetexpress.co.id', 'adminkeren64', '085116561596', 5750000, '2026-04-18', 'Admin', 2),
(10, 'Aisyah Amin', 'aisyah.amin@jetexpress.co.id', 'petugasterbaik32', '089740726097', 4500000, '2022-10-19', 'Petugas Konter', 2),
(11, 'Joko Salim', 'joko.salim@jetexpress.co.id', 'petugasterbaik78', '085885134554', 4800000, '2024-08-19', 'Petugas Konter', 2),
(12, 'Ayu Susanto', 'ayu.susanto@jetexpress.co.id', 'petugasterbaik49', '089763948553', 4600000, '2026-06-26', 'Petugas Konter', 2),
(13, 'Yusuf Halim', 'yusuf.halim@jetexpress.co.id', 'kurirjago21', '081230111687', 4000000, '2022-01-19', 'Kurir', 2),
(14, 'Nur Utami', 'nur.utami@jetexpress.co.id', 'kurirjago86', '089772633522', 4000000, '2025-11-19', 'Kurir', 2),
(15, 'Linda Pratama', 'linda.pratama@jetexpress.co.id', 'kurirjago57', '089623203533', 4000000, '2023-10-11', 'Kurir', 2),
(16, 'Bayu Amin', 'bayu.amin@jetexpress.co.id', 'adminkeren93', '085876896901', 6750000, '2022-05-12', 'Admin', 3),
(17, 'Nur Ramadhan', 'nur.ramadhan@jetexpress.co.id', 'adminkeren34', '089529643929', 5750000, '2026-03-11', 'Admin', 3),
(18, 'Ahmad Santoso', 'ahmad.santoso1@jetexpress.co.id', 'petugasterbaik61', '081391890761', 4500000, '2025-04-04', 'Petugas Konter', 3),
(19, 'Yusuf Hakim', 'yusuf.hakim@jetexpress.co.id', 'petugasterbaik08', '081283343091', 3900000, '2025-06-25', 'Petugas Konter', 3),
(20, 'Taufik Lubis', 'taufik.lubis@jetexpress.co.id', 'petugasterbaik75', '087899198595', 4000000, '2022-01-11', 'Petugas Konter', 3),
(21, 'Ratna Kusuma', 'ratna.kusuma@jetexpress.co.id', 'petugasterbaik42', '085773482774', 4000000, '2025-01-22', 'Petugas Konter', 3),
(22, 'Intan Mahendra', 'intan.mahendra@jetexpress.co.id', 'kurirjago19', '089599731916', 4000000, '2022-06-22', 'Kurir', 3),
(23, 'Dimas Mahendra', 'dimas.mahendra@jetexpress.co.id', 'kurirjago68', '085179797368', 4200000, '2024-03-10', 'Kurir', 3),
(24, 'Putri Nugroho', 'putri.nugroho@jetexpress.co.id', 'adminkeren52', '088113461507', 5000000, '2023-12-12', 'Admin', 4),
(25, 'Yuni Hartono', 'yuni.hartono@jetexpress.co.id', 'petugasterbaik97', '087770416819', 4300000, '2025-10-30', 'Petugas Konter', 4),
(26, 'Siti Setiawan', 'siti.setiawan@jetexpress.co.id', 'petugasterbaik24', '085230654844', 4500000, '2024-08-13', 'Petugas Konter', 4),
(27, 'Ratna Pahlevi', 'ratna.pahlevi@jetexpress.co.id', 'petugasterbaik63', '087871581409', 4100000, '2024-06-07', 'Petugas Konter', 4),
(28, 'Fajar Rahman', 'fajar.rahman@jetexpress.co.id', 'kurirjago31', '085396869801', 4200000, '2022-03-11', 'Kurir', 4),
(29, 'Rosa Hidayat', 'rosa.hidayat@jetexpress.co.id', 'kurirjago89', '085374940010', 4300000, '2026-03-26', 'Kurir', 4),
(30, 'Dian Firmansyah', 'dian.firmansyah@jetexpress.co.id', 'adminkeren06', '085262341080', 5500000, '2025-09-16', 'Admin', 5),
(31, 'Maya Noor', 'maya.noor@jetexpress.co.id', 'petugasterbaik44', '088250924228', 4400000, '2022-06-11', 'Petugas Konter', 5),
(32, 'Bayu Lubis', 'bayu.lubis@jetexpress.co.id', 'petugasterbaik81', '089676787065', 4000000, '2023-06-24', 'Petugas Konter', 5),
(33, 'Fitri Halim', 'fitri.halim@jetexpress.co.id', 'petugasterbaik17', '087879703978', 4500000, '2022-12-29', 'Petugas Konter', 5),
(34, 'Wulan Basri', 'wulan.basri@jetexpress.co.id', 'petugasterbaik56', '085822692439', 3900000, '2024-12-15', 'Petugas Konter', 5),
(35, 'Eko Saputra', 'eko.saputra@jetexpress.co.id', 'kurirjago73', '087864761163', 3700000, '2024-07-19', 'Kurir', 5),
(36, 'Budi Lubis', 'budi.lubis@jetexpress.co.id', 'kurirjago28', '085324722812', 3800000, '2023-12-22', 'Kurir', 5),
(37, 'Nia Halim', 'nia.halim@jetexpress.co.id', 'adminkeren41', '085123617158', 6000000, '2025-10-04', 'Admin', 6),
(38, 'Irfan Amin', 'irfan.amin@jetexpress.co.id', 'petugasterbaik92', '081257815518', 4000000, '2022-08-06', 'Petugas Konter', 6),
(39, 'Bayu Ramadhan', 'bayu.ramadhan@jetexpress.co.id', 'petugasterbaik13', '085888934594', 4600000, '2023-10-05', 'Petugas Konter', 6),
(40, 'Fajar Halim', 'fajar.halim@jetexpress.co.id', 'petugasterbaik66', '085844376392', 4300000, '2022-11-27', 'Petugas Konter', 6),
(41, 'Fajar Saputra', 'fajar.saputra@jetexpress.co.id', 'petugasterbaik35', '085865637040', 4400000, '2026-05-10', 'Petugas Konter', 6),
(42, 'Dedi Ramadhan', 'dedi.ramadhan@jetexpress.co.id', 'kurirjago84', '087726511507', 3900000, '2022-02-17', 'Kurir', 6),
(43, 'Nia Lubis', 'nia.lubis@jetexpress.co.id', 'kurirjago23', '089691504394', 4100000, '2026-05-16', 'Kurir', 6),
(44, 'Intan Salim', 'intan.salim@jetexpress.co.id', 'adminkeren58', '082160217143', 6500000, '2025-10-16', 'Admin', 7),
(45, 'Putri Halim', 'putri.halim@jetexpress.co.id', 'petugasterbaik76', '089513176036', 4300000, '2022-04-29', 'Petugas Konter', 7),
(46, 'Rudi Siregar', 'rudi.siregar@jetexpress.co.id', 'petugasterbaik29', '082149854883', 4200000, '2026-01-29', 'Petugas Konter', 7),
(47, 'Fitri Wibowo', 'fitri.wibowo@jetexpress.co.id', 'petugasterbaik94', '087836501061', 4700000, '2022-02-11', 'Petugas Konter', 7),
(48, 'Linda Hidayat', 'linda.hidayat@jetexpress.co.id', 'petugasterbaik11', '082125875669', 3900000, '2022-11-29', 'Petugas Konter', 7),
(49, 'Rahmat Pahlevi', 'rahmat.pahlevi@jetexpress.co.id', 'kurirjago62', '087713864688', 4100000, '2025-05-07', 'Kurir', 7),
(50, 'Dewi Ridwan', 'dewi.ridwan@jetexpress.co.id', 'kurirjago37', '085766503709', 4200000, '2024-02-12', 'Kurir', 7),
(51, 'Rosa Rahman', 'rosa.rahman@jetexpress.co.id', 'adminkeren82', '085140635974', 6500000, '2023-06-07', 'Admin', 8),
(52, 'Budi Anwar', 'budi.anwar@jetexpress.co.id', 'petugasterbaik46', '089545408799', 4600000, '2024-09-07', 'Petugas Konter', 8),
(53, 'Siti Firmansyah', 'siti.firmansyah@jetexpress.co.id', 'petugasterbaik69', '081334065539', 4800000, '2025-04-30', 'Petugas Konter', 8),
(54, 'Linda Pratama', 'linda.pratama84@jetexpress.co.id', 'petugasterbaik18', '087894960701', 4600000, '2023-06-28', 'Petugas Konter', 8),
(55, 'Dedi Saputra', 'dedi.saputra@jetexpress.co.id', 'kurirjago95', '089717824479', 4600000, '2023-05-13', 'Kurir', 8),
(56, 'Agus Hasan', 'agus.hasan@jetexpress.co.id', 'kurirjago33', '085785375365', 4100000, '2026-06-07', 'Kurir', 8),
(57, 'Nur Lubis', 'nur.lubis@jetexpress.co.id', 'kurirjago71', '089683658086', 4300000, '2025-07-28', 'Kurir', 8),
(58, 'Yusuf Lestari', 'yusuf.lestari@jetexpress.co.id', 'adminkeren25', '089710712938', 6500000, '2022-11-11', 'Admin', 9),
(59, 'Dewi Pahlevi', 'dewi.pahlevi@jetexpress.co.id', 'adminkeren87', '081295780740', 6500000, '2026-06-17', 'Admin', 9),
(60, 'Hendra Susanto', 'hendra.susanto@jetexpress.co.id', 'petugasterbaik53', '085828516756', 4300000, '2025-01-24', 'Petugas Konter', 9),
(61, 'Irfan Wijaya', 'irfan.wijaya@jetexpress.co.id', 'petugasterbaik14', '087786857008', 4600000, '2023-03-21', 'Petugas Konter', 9),
(62, 'Rizki Hasan', 'rizki.hasan@jetexpress.co.id', 'petugasterbaik79', '085278284809', 4400000, '2025-01-08', 'Petugas Konter', 9),
(63, 'Hendra Kurniawan', 'hendra.kurniawan@jetexpress.co.id', 'kurirjago48', '085851663837', 4200000, '2023-11-15', 'Kurir', 9),
(64, 'Yusuf Lestari', 'yusuf.lestari38@jetexpress.co.id', 'kurirjago22', '087757945702', 4000000, '2025-01-13', 'Kurir', 9),
(65, 'Intan Hartono', 'intan.hartono@jetexpress.co.id', 'adminkeren67', '085279281900', 6500000, '2023-12-30', 'Admin', 10),
(66, 'Bayu Wibowo', 'bayu.wibowo@jetexpress.co.id', 'petugasterbaik39', '085213814208', 4700000, '2022-10-24', 'Petugas Konter', 10),
(67, 'Joko Mahendra', 'joko.mahendra@jetexpress.co.id', 'petugasterbaik74', '081160272241', 4900000, '2025-12-13', 'Petugas Konter', 10),
(68, 'Fajar Gunawan', 'fajar.gunawan@jetexpress.co.id', 'petugasterbaik12', '085190463047', 4300000, '2023-03-19', 'Petugas Konter', 10),
(69, 'Rahmat Ramadhan', 'rahmat.ramadhan@jetexpress.co.id', 'kurirjago59', '082119815488', 4150000, '2024-09-19', 'Kurir', 10),
(70, 'Dimas Setiawan', 'dimas.setiawan@jetexpress.co.id', 'kurirjago96', '089726232107', 4150000, '2024-08-29', 'Kurir', 10);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id_user`);

--
-- Indexes for table `konter`
--
ALTER TABLE `konter`
  ADD PRIMARY KEY (`id_konter`);

--
-- Indexes for table `kurir`
--
ALTER TABLE `kurir`
  ADD PRIMARY KEY (`id_user`),
  ADD UNIQUE KEY `nomor_kendaraan` (`nomor_kendaraan`);

--
-- Indexes for table `ongkir`
--
ALTER TABLE `ongkir`
  ADD PRIMARY KEY (`id_ongkir`);

--
-- Indexes for table `paket`
--
ALTER TABLE `paket`
  ADD PRIMARY KEY (`id_paket`),
  ADD UNIQUE KEY `id_pengiriman` (`id_pengiriman`);

--
-- Indexes for table `pengantaran`
--
ALTER TABLE `pengantaran`
  ADD PRIMARY KEY (`id_pengantaran`),
  ADD KEY `id_user` (`id_user`),
  ADD KEY `id_pengiriman` (`id_pengiriman`);

--
-- Indexes for table `pengiriman`
--
ALTER TABLE `pengiriman`
  ADD PRIMARY KEY (`id_pengiriman`),
  ADD UNIQUE KEY `id_paket` (`id_paket`),
  ADD KEY `id_konter` (`id_konter`),
  ADD KEY `id_ongkir` (`id_ongkir`);

--
-- Indexes for table `petugas_konter`
--
ALTER TABLE `petugas_konter`
  ADD PRIMARY KEY (`id_user`);

--
-- Indexes for table `riwayat_pelacakan`
--
ALTER TABLE `riwayat_pelacakan`
  ADD PRIMARY KEY (`id_riwayat`),
  ADD KEY `id_pengiriman` (`id_pengiriman`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`),
  ADD KEY `id_konter` (`id_konter`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `konter`
--
ALTER TABLE `konter`
  MODIFY `id_konter` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `ongkir`
--
ALTER TABLE `ongkir`
  MODIFY `id_ongkir` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `paket`
--
ALTER TABLE `paket`
  MODIFY `id_paket` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=114;

--
-- AUTO_INCREMENT for table `pengantaran`
--
ALTER TABLE `pengantaran`
  MODIFY `id_pengantaran` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=58;

--
-- AUTO_INCREMENT for table `pengiriman`
--
ALTER TABLE `pengiriman`
  MODIFY `id_pengiriman` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=114;

--
-- AUTO_INCREMENT for table `riwayat_pelacakan`
--
ALTER TABLE `riwayat_pelacakan`
  MODIFY `id_riwayat` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=445;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=71;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `admin`
--
ALTER TABLE `admin`
  ADD CONSTRAINT `admin_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`);

--
-- Constraints for table `kurir`
--
ALTER TABLE `kurir`
  ADD CONSTRAINT `kurir_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`);

--
-- Constraints for table `paket`
--
ALTER TABLE `paket`
  ADD CONSTRAINT `paket_ibfk_1` FOREIGN KEY (`id_pengiriman`) REFERENCES `pengiriman` (`id_pengiriman`);

--
-- Constraints for table `pengantaran`
--
ALTER TABLE `pengantaran`
  ADD CONSTRAINT `pengantaran_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `kurir` (`id_user`),
  ADD CONSTRAINT `pengantaran_ibfk_2` FOREIGN KEY (`id_pengiriman`) REFERENCES `pengiriman` (`id_pengiriman`);

--
-- Constraints for table `pengiriman`
--
ALTER TABLE `pengiriman`
  ADD CONSTRAINT `pengiriman_ibfk_1` FOREIGN KEY (`id_konter`) REFERENCES `konter` (`id_konter`),
  ADD CONSTRAINT `pengiriman_ibfk_2` FOREIGN KEY (`id_ongkir`) REFERENCES `ongkir` (`id_ongkir`),
  ADD CONSTRAINT `pengiriman_ibfk_3` FOREIGN KEY (`id_paket`) REFERENCES `paket` (`id_paket`);

--
-- Constraints for table `petugas_konter`
--
ALTER TABLE `petugas_konter`
  ADD CONSTRAINT `petugas_konter_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`);

--
-- Constraints for table `riwayat_pelacakan`
--
ALTER TABLE `riwayat_pelacakan`
  ADD CONSTRAINT `riwayat_pelacakan_ibfk_1` FOREIGN KEY (`id_pengiriman`) REFERENCES `pengiriman` (`id_pengiriman`);

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`id_konter`) REFERENCES `konter` (`id_konter`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 22, 2021 at 07:25 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `payment`
--

-- --------------------------------------------------------

--
-- Table structure for table `payment_t`
--

CREATE TABLE `payment_t` (
  `payment_id` int(100) NOT NULL,
  `cus_name` varchar(200) NOT NULL,
  `mobile_no` varchar(200) NOT NULL,
  `amount` varchar(200) NOT NULL,
  `email` varchar(200) NOT NULL,
  `card_type` varchar(200) NOT NULL,
  `card_no` varchar(100) NOT NULL,
  `exp_month` varchar(20) NOT NULL,
  `exp_year` varchar(20) NOT NULL,
  `cvn` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `payment_t`
--

INSERT INTO `payment_t` (`payment_id`, `cus_name`, `mobile_no`, `amount`, `email`, `card_type`, `card_no`, `exp_month`, `exp_year`, `cvn`) VALUES
(1, 'Angelo', '0766312357', '15000', 'angelo@gmeil.com', 'Visa', '78994214237989634', '10', '23', '486');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `payment_t`
--
ALTER TABLE `payment_t`
  ADD PRIMARY KEY (`payment_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `payment_t`
--
ALTER TABLE `payment_t`
  MODIFY `payment_id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

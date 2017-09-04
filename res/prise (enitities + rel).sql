-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Sep 04, 2017 at 05:09 PM
-- Server version: 10.1.19-MariaDB
-- PHP Version: 5.5.38

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `prise`
--

-- --------------------------------------------------------

--
-- Table structure for table `event`
--

CREATE TABLE `event` (
  `id` int(11) NOT NULL,
  `name` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `description` varchar(1000) COLLATE utf8_unicode_ci DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Describe the Event''s Detail ';

--
-- Dumping data for table `event`
--

INSERT INTO `event` (`id`, `name`, `description`, `user_id`) VALUES
(6, '60th Sleepless Anniversary', 'Event of Celebrating 60th Sleepless Anniversary', 1),
(7, 'Nudee Saerlao', 'stationery item consisting of a pad of large  10 paper sheets per one', 1),
(8, '57130500133', 'anf', 1),
(9, 'Nudee Saersorng', 'Mini paper pad with stricky header', 1);

-- --------------------------------------------------------

--
-- Table structure for table `event_guest`
--

CREATE TABLE `event_guest` (
  `guest_id` int(11) NOT NULL,
  `name` varchar(200) COLLATE utf8_bin NOT NULL,
  `corp` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `position` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `portrait_path` text COLLATE utf8_bin,
  `award_no` smallint(6) NOT NULL,
  `award` int(11) NOT NULL,
  `seat_no` smallint(6) NOT NULL,
  `seat_row` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `status` tinyint(1) NOT NULL,
  `event_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Contains the set of Guest Information';

-- --------------------------------------------------------

--
-- Table structure for table `event_logging`
--

CREATE TABLE `event_logging` (
  `event_id` int(11) NOT NULL,
  `by_user_id` int(11) DEFAULT NULL,
  `from_guest_id` int(11) DEFAULT NULL,
  `guest_status` tinyint(1) DEFAULT NULL,
  `message` varchar(500) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Keep an Information during Event is going';

-- --------------------------------------------------------

--
-- Table structure for table `event_sharing`
--

CREATE TABLE `event_sharing` (
  `event_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Stores a total shared events';

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `tel` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `username` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(32) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Contains the User''s Information ';

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `name`, `email`, `tel`, `username`, `password`) VALUES
(1, 'Mo''c Choc Ta', 'fure4ify@gmail.com', '+6655487878', 'moct56', 'r123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `event`
--
ALTER TABLE `event`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `event_guest`
--
ALTER TABLE `event_guest`
  ADD PRIMARY KEY (`guest_id`),
  ADD KEY `event_id` (`event_id`);

--
-- Indexes for table `event_logging`
--
ALTER TABLE `event_logging`
  ADD KEY `event_id` (`event_id`);

--
-- Indexes for table `event_sharing`
--
ALTER TABLE `event_sharing`
  ADD KEY `event_id` (`event_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`),
  ADD UNIQUE KEY `name` (`name`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `event`
--
ALTER TABLE `event`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `event_guest`
--
ALTER TABLE `event_guest`
  MODIFY `guest_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `event`
--
ALTER TABLE `event`
  ADD CONSTRAINT `event_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `event_guest`
--
ALTER TABLE `event_guest`
  ADD CONSTRAINT `event_guest_ibfk_1` FOREIGN KEY (`event_id`) REFERENCES `event` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `event_logging`
--
ALTER TABLE `event_logging`
  ADD CONSTRAINT `event_logging_ibfk_1` FOREIGN KEY (`event_id`) REFERENCES `event` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `event_sharing`
--
ALTER TABLE `event_sharing`
  ADD CONSTRAINT `event_sharing_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `event_sharing_ibfk_2` FOREIGN KEY (`event_id`) REFERENCES `event` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

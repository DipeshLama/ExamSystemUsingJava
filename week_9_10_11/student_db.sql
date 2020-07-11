-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 14, 2020 at 07:05 AM
-- Server version: 10.4.10-MariaDB
-- PHP Version: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `student_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `admin_id` int(20) NOT NULL,
  `AdminName` varchar(50) NOT NULL,
  `AdminEmail` varchar(50) NOT NULL,
  `AdminPassword` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`admin_id`, `AdminName`, `AdminEmail`, `AdminPassword`) VALUES
(1, 'Dipesh Lama', 'dipeslama@gmail.com', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `ethicsquestion`
--

CREATE TABLE `ethicsquestion` (
  `ethicsQuestionId` int(20) NOT NULL,
  `ethicsQuestion` varchar(200) NOT NULL,
  `ethicsOption1` varchar(100) NOT NULL,
  `ethicsOption2` varchar(100) NOT NULL,
  `ethicsOption3` varchar(100) NOT NULL,
  `ethicsOption4` varchar(100) NOT NULL,
  `ethicsCorrectAns` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ethicsquestion`
--

INSERT INTO `ethicsquestion` (`ethicsQuestionId`, `ethicsQuestion`, `ethicsOption1`, `ethicsOption2`, `ethicsOption3`, `ethicsOption4`, `ethicsCorrectAns`) VALUES
(1, 'Claimed right means', 'an obligation of some people to provide certain things for others', 'to claim a right that you want.', 'Having a child.', 'None of the mentioned', 'an obligation of some people to provide certain things for others'),
(2, 'Cookies on your computer means', 'files a web site stores on a visitor\'s computer', 'cookies and milk on your desktop', 'cookies that you can eat while using computer', 'None of the mentioned', 'files a web site stores on a visitor\'s computer'),
(3, 'Using some one’s else email ID, to do illegal or legal work on internet is:', 'cyber bullying', 'Identity theft', 'Identity fraud', 'prank', 'Identity theft'),
(4, 'Intellectual property right protects:', 'Song you wrote on your own.', 'You pet name', 'Land and property owned by your family', 'None of the mentioned', 'Song you wrote on your own.'),
(5, 'Net neutrality (Network neutrality) allows us to', 'Use the internet for free', 'Access all the data and information on the internet as same', 'Ban all the ISPs for over charging', 'visit and hack any websites on internet.', 'Access all the data and information on the internet as same'),
(6, 'Consequentialist theory is an example of', 'deontological theories', 'utilitarianism', 'natural rights', 'none of the mentioned', 'utilitarianism'),
(7, 'Neo- Luddism means:', 'Neo technology to avoid global warming', 'New religion like Buddhism', 'Philosophy opposing many forms of modern technology', 'Computer ethics codes regarding privacy', 'Philosophy opposing many forms of modern technology'),
(8, 'Offshoring means:', 'Getting work done in a different country', 'To contracting work out to an external organization.', 'Working from the shore of the beach using technology', 'None of the mentioned', 'Getting work done in a different country'),
(9, 'Right to act without interferences is', 'Negative right', 'Positive right', 'Natural right', 'None of the mentioned', 'Negative right'),
(10, 'What do you mean by telecommuting?', 'Work from remote place or home with means of technology.', 'Telephone communication', 'Telecommunication codes of ethics', 'None of the mentioned', 'Work from remote place or home with means of technology.');

-- --------------------------------------------------------

--
-- Table structure for table `javaquestion`
--

CREATE TABLE `javaquestion` (
  `question_id` int(50) NOT NULL,
  `question` varchar(200) NOT NULL,
  `option_1` varchar(80) NOT NULL,
  `option_2` varchar(80) NOT NULL,
  `option_3` varchar(80) NOT NULL,
  `option_4` varchar(80) NOT NULL,
  `correct_ans` varchar(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `javaquestion`
--

INSERT INTO `javaquestion` (`question_id`, `question`, `option_1`, `option_2`, `option_3`, `option_4`, `correct_ans`) VALUES
(1, 'Which of the following can be operands of arithematic opertors?', 'Numeric', 'Boolean', 'Characters', 'Both Numeric and Characters', 'Both Numeric and Characters'),
(2, 'Which data type value is returned by all transcendental math functions?', 'int', 'float', 'double', 'long', 'double'),
(3, 'Which of these is long data type literal?', '0x99fffL', 'ABCDEFG', '0x99fffa', '99671246', '0x99fffL'),
(4, ' What is the stored in the object obj in following lines of Java code?', 'Memory address of allocated memory of object', 'NULL', 'Any arbitrary pointer', 'Garbage', 'NULL'),
(5, 'Which of these coding types is used for data type characters in Java?', ' ASCII', 'ISO-LATIN-1', 'UNICODE', 'None of the mentioned', 'UNICODE'),
(6, 'Which of these values can a boolean variable contain?', 'True & False', '0 & 1', 'Any integer value', 'true', 'True & False'),
(7, 'Which of these occupy first 0 to 127 in Unicode character set used for characters in Java?', 'ASCII', 'ISO-LATIN-1', 'None of the mentioned', 'ASCII and ISO-LATIN1', 'ASCII and ISO-LATIN1'),
(8, 'Which of these can be returned by the operator &?', 'Integer', 'Boolean', 'Character', 'Integer or Boolean', 'Integer or Boolean'),
(9, 'Which of these can not be used for a variable name in Java?', 'identifier', 'keyword', 'identifier & keyword', 'none of the mentioned', 'keyword'),
(10, 'Literal can be of which of these data types?', 'integer', 'float', 'boolean', 'all of the mentioned', 'all of the mentioned'),
(15, 'Which of these is long data type literal?', '0x99fffL', '0x99fffa', '99671246', 'abcdefg', '0x99fffL');

-- --------------------------------------------------------

--
-- Table structure for table `networkquestion`
--

CREATE TABLE `networkquestion` (
  `NetworkQuestionId` int(20) NOT NULL,
  `NetQuestion` varchar(200) NOT NULL,
  `NetOption1` varchar(100) NOT NULL,
  `NetOption2` varchar(100) NOT NULL,
  `NetOption3` varchar(100) NOT NULL,
  `NetOption4` varchar(100) NOT NULL,
  `NetCorrectAns` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `networkquestion`
--

INSERT INTO `networkquestion` (`NetworkQuestionId`, `NetQuestion`, `NetOption1`, `NetOption2`, `NetOption3`, `NetOption4`, `NetCorrectAns`) VALUES
(1, 'Which is not a application layer protocol?', 'HTTP', 'SMTP', 'FTP', 'TCP', 'TCP'),
(2, 'Which of the following is an application layer service?', 'Network virtual terminal', 'File transfer, access, and management', 'Mail service', 'All of the mentioned', 'All of the mentioned'),
(3, 'Which is a time-sensitive service?', 'File transfer', 'File download', 'E-mail', 'Internet telephony', 'Internet telephony'),
(4, 'How many layers are present in the Internet protocol stack (TCP/IP model)?', '5', '7', '6', '10', '5'),
(5, 'Which address is used to identify a process on a host by the transport layer?', 'physical address', 'logical address', 'port address', 'specific address', 'port address'),
(6, 'Which layer provides the services to user?', 'application layer', 'session layer', 'presentation layer', 'physical layer', 'application layer'),
(7, 'Which layer is used to link the network support layers and user support layers?', 'session layer', 'data link layer', 'transport layer', 'network layer', 'transport layer'),
(8, 'Which address is used on the internet for employing the TCP/IP protocols?', 'physical address and logical address', 'port address', 'specific address', 'all of the mentioned', 'all of the mentioned'),
(9, 'Which layer is responsible for process to process delivery in a general network model?', 'network layer', 'transport layer', 'session layer', 'data link layer', 'transport layer'),
(10, 'Which of the following is a form of DoS attack?', 'Vulnerability attack', 'Bandwidth flooding', 'Connection flooding', 'All of the mentioned', 'All of the mentioned');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `student_id` int(10) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `Address` varchar(60) NOT NULL,
  `Gender` varchar(30) NOT NULL,
  `Batch` varchar(30) NOT NULL,
  `Token` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`student_id`, `Name`, `Email`, `Address`, `Gender`, `Batch`, `Token`) VALUES
(1, 'Dipesh Lama', 'dipeslama32@gmail.com', 'Pepsicola', 'Male', '25A', 'G6eUXIJQMa'),
(2, 'Anush Gajurel', 'anush@gmail.com', 'Dilibazar', 'Male', '25A', 'iUGn0u1b15'),
(3, 'Anil Subedi', 'anil@gmail.com', 'Butwal', 'Male', '24B', 'mcvAS2ok30');

-- --------------------------------------------------------

--
-- Table structure for table `webquestion`
--

CREATE TABLE `webquestion` (
  `web_questionId` int(30) NOT NULL,
  `webquestion` varchar(100) NOT NULL,
  `weboption_1` varchar(100) NOT NULL,
  `weboption_2` varchar(100) NOT NULL,
  `weboption_3` varchar(100) NOT NULL,
  `weboption_4` varchar(100) NOT NULL,
  `webcorrectans` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `webquestion`
--

INSERT INTO `webquestion` (`web_questionId`, `webquestion`, `weboption_1`, `weboption_2`, `weboption_3`, `weboption_4`, `webcorrectans`) VALUES
(6, 'Whats so great about XML?', 'Easy data exchange', 'High speed on network', 'Only B.is correct', 'Both A & B', 'Both A & B'),
(7, 'Which is not a property of attribute Behaviour of <Marquee> tag?', 'alternate', 'blur', 'scroll', 'slide', 'blur'),
(8, 'The attribute used to define a new namespace is.', 'XMLNS', 'XmlNameSpace', 'Xmlns', 'XmlNs', 'Xmlns'),
(9, 'Which of the following options is correct with regard to HTML?', 'It is a modelling language', 'It is a scripting language', 'It is a partial programming language', 'It is used to structure documents', 'It is used to structure documents'),
(10, 'Which browser can supports the transition property?', 'Internet Explorer 10', 'Firefox', 'Chrome', 'All mentioned', 'All mentioned'),
(11, 'What do you add to a template in order to control where page content goes?', 'Text Frames', 'HTML Controllers', 'Editable Regions', 'Page Content Controllers', 'Editable Regions'),
(12, 'Which of the following is NOT a Style?', 'Linked', 'Embedded', 'Inline', 'Orthogonal', 'Orthogonal'),
(13, 'Which of the following is NOT a Hotspot tool?', 'Orthogonal Hotspot Tool', 'Rectangular Hotspot Tool', 'Oval Hotspot Tool', 'Polygon Hotspot Tool', 'Orthogonal Hotspot Tool'),
(14, 'Which of the following is not supported by older browsers?', 'CSS', 'Layers', 'Frames', 'All mentioned', 'All mentioned'),
(15, 'Which of the following is false?', 'The Site Map can be saved as an image', 'You can FTP files using Dreamweaver', 'You can create forms in Dreamweaver', 'None Mentioned', 'None Mentioned');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`admin_id`);

--
-- Indexes for table `ethicsquestion`
--
ALTER TABLE `ethicsquestion`
  ADD PRIMARY KEY (`ethicsQuestionId`);

--
-- Indexes for table `javaquestion`
--
ALTER TABLE `javaquestion`
  ADD PRIMARY KEY (`question_id`);

--
-- Indexes for table `networkquestion`
--
ALTER TABLE `networkquestion`
  ADD PRIMARY KEY (`NetworkQuestionId`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`student_id`);

--
-- Indexes for table `webquestion`
--
ALTER TABLE `webquestion`
  ADD PRIMARY KEY (`web_questionId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `admin_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `ethicsquestion`
--
ALTER TABLE `ethicsquestion`
  MODIFY `ethicsQuestionId` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `javaquestion`
--
ALTER TABLE `javaquestion`
  MODIFY `question_id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `networkquestion`
--
ALTER TABLE `networkquestion`
  MODIFY `NetworkQuestionId` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `student_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `webquestion`
--
ALTER TABLE `webquestion`
  MODIFY `web_questionId` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

CREATE TABLE `student` (
  `stuid` int(12) NOT NULL AUTO_INCREMENT,
  `stuname` varchar(20) DEFAULT NULL,
  `phone` varchar(12) DEFAULT NULL,
  `gender` varchar(4) DEFAULT NULL,
  `hobby` varchar(255) DEFAULT NULL,
  `info` varchar(255) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  PRIMARY KEY (`stuid`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
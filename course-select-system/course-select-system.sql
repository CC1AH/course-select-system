/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 8.0.19 : Database - 大学生选课
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`大学生选课` /*!40100 DEFAULT CHARACTER SET gbk */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `大学生选课`;

/*Table structure for table `administrator` */

DROP TABLE IF EXISTS `administrator`;

CREATE TABLE `administrator` (
  `admID` varchar(5) NOT NULL,
  `password` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`admID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `administrator` */

insert  into `administrator`(`admID`,`password`) values ('12939','111'),('20397','111'),('34592','111'),('40236','111'),('52044','111'),('62398','111');

/*Table structure for table `classroom` */

DROP TABLE IF EXISTS `classroom`;

CREATE TABLE `classroom` (
  `building` varchar(50) NOT NULL,
  `room_no` int NOT NULL,
  `capacity` int DEFAULT NULL,
  PRIMARY KEY (`building`,`room_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `classroom` */

insert  into `classroom`(`building`,`room_no`,`capacity`) values ('Packard',101,500),('Painter',514,10),('Taylor',3128,70),('Watson',100,30),('Watson',120,50);

/*Table structure for table `course` */

DROP TABLE IF EXISTS `course`;

CREATE TABLE `course` (
  `course_id` varchar(30) NOT NULL,
  `title` varchar(50) DEFAULT NULL,
  `dept_name` varchar(50) NOT NULL,
  `credits` int DEFAULT NULL,
  PRIMARY KEY (`course_id`),
  KEY `dept_name` (`dept_name`),
  CONSTRAINT `course_ibfk_1` FOREIGN KEY (`dept_name`) REFERENCES `department` (`dept_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `course` */

insert  into `course`(`course_id`,`title`,`dept_name`,`credits`) values ('BI-356','Life Sciences','Biology',3),('CS-315','Database Concepts','Comp.Sci.',3),('CS-316','testCourse','Comp.Sci.',3),('CS-317','testCourse','Comp.Sci.',3),('CS-318','testCourse','Comp.Sci.',3),('CS-319','testCourse','Comp.Sci.',3),('CS-321','testCourse','Comp.Sci.',3),('CS-347','Network','Comp.Sci.',4),('FIN-201','Introdution to Finan','Finance',2),('HI-101','Western History','History',3),('MU-199','Music history','Music',2),('PHY-101','Genery physics','Physics',3);

/*Table structure for table `department` */

DROP TABLE IF EXISTS `department`;

CREATE TABLE `department` (
  `dept_name` varchar(50) NOT NULL,
  `building` varchar(50) DEFAULT NULL,
  `budget` double DEFAULT NULL,
  PRIMARY KEY (`dept_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `department` */

insert  into `department`(`dept_name`,`building`,`budget`) values ('Biology','Watson',90000),('Comp.Sci.','Taylor',100000),('Finance','Painter',120000),('History','Painter',50000),('Music','Packard',80000),('Physics','Watson',70000);

/*Table structure for table `instructor` */

DROP TABLE IF EXISTS `instructor`;

CREATE TABLE `instructor` (
  `teaID` varchar(5) NOT NULL,
  `name` varchar(20) NOT NULL,
  `dept_name` varchar(50) NOT NULL,
  `salary` decimal(8,2) DEFAULT NULL,
  `password` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`teaID`),
  KEY `dept_name` (`dept_name`),
  CONSTRAINT `instructor_ibfk_1` FOREIGN KEY (`dept_name`) REFERENCES `department` (`dept_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `instructor` */

insert  into `instructor`(`teaID`,`name`,`dept_name`,`salary`,`password`) values ('10101','Srinivasan','Comp.Sci.','65000.00','111'),('12121','Wu','Finance','90000.00','111'),('15151','Mozart','Music','40000.00','111'),('22223','Kris','Comp.Sci.','64000.00','111'),('45565','Kats','Comp.Sci.','75000.00','111'),('58583','Califieri','History','62000.00','111'),('76543','Singh','Finance','80000.00','111'),('83821','Brandt','Biology','92000.00','111');

/*Table structure for table `section` */

DROP TABLE IF EXISTS `section`;

CREATE TABLE `section` (
  `course_id` varchar(30) NOT NULL,
  `sec_id` varchar(8) NOT NULL,
  `semester` varchar(6) NOT NULL,
  `year` decimal(4,0) NOT NULL,
  `building` varchar(50) NOT NULL,
  `room_no` int NOT NULL,
  `time_slot_id` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`course_id`,`sec_id`,`semester`,`year`),
  KEY `building` (`building`,`room_no`),
  CONSTRAINT `section_ibfk_1` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`),
  CONSTRAINT `section_ibfk_2` FOREIGN KEY (`building`, `room_no`) REFERENCES `classroom` (`building`, `room_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `section` */

insert  into `section`(`course_id`,`sec_id`,`semester`,`year`,`building`,`room_no`,`time_slot_id`) values ('BI-356','1','Fall','2009','Watson',120,'C'),('CS-315','1','Spring','2010','Packard',101,'E'),('CS-315','2','Spring','2010','Taylor',3128,'A'),('CS-316','2','Spring','2010','Taylor',3128,'A'),('CS-347','1','Fall','2009','Painter',514,'B'),('FIN-201','1','Spring','2010','Painter',514,'C'),('HI-101','1','Fall','2009','Packard',101,'A'),('MU-199','1','Spring','2010','Watson',120,'D');

/*Table structure for table `section_variable` */

DROP TABLE IF EXISTS `section_variable`;

CREATE TABLE `section_variable` (
  `section_variable` tinyint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

/*Data for the table `section_variable` */

insert  into `section_variable`(`section_variable`) values (1);

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `stuID` varchar(5) NOT NULL,
  `name` varchar(50) NOT NULL,
  `dept_name` varchar(50) NOT NULL,
  `tot_cred` int DEFAULT NULL,
  `password` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`stuID`),
  KEY `dept_name` (`dept_name`),
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`dept_name`) REFERENCES `department` (`dept_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `student` */

insert  into `student`(`stuID`,`name`,`dept_name`,`tot_cred`,`password`) values ('10236','Jackey','History',0,'111'),('11274','Dandy','Finance',0,'111'),('12138','Bella','Music',0,'111'),('12472','Lisa','Comp.Sci.',0,'111'),('29572','Deft','Physics',0,'111'),('39472','Rose','Physics',0,'111'),('56614','Crisp','Music',0,'111'),('68302','Jennie','Biology',0,'111');

/*Table structure for table `takes` */

DROP TABLE IF EXISTS `takes`;

CREATE TABLE `takes` (
  `sID` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `course_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `sec_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `semester` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `year` int NOT NULL,
  `grade` double DEFAULT NULL,
  PRIMARY KEY (`sID`,`course_id`,`sec_id`,`semester`,`year`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `takes` */

insert  into `takes`(`sID`,`course_id`,`sec_id`,`semester`,`year`,`grade`) values ('10236','BI-356','1','Fall',2009,60),('10236','HI-101','1','Fall',2009,60),('11274','BI-356','1','Fall',2009,50),('11274','CS-347','1','Fall',2009,50),('11274','FIN-201','1','Spring',2010,50),('11274','HI-101','1','Fall',2009,50),('11274','MU-199','1','Spring',2010,50),('56614','CS-315','2','Spring',2010,NULL),('56614','CS-347','1','Fall',2009,NULL),('68302','FIN-201','1','Spring',2010,NULL);

/*Table structure for table `teaches` */

DROP TABLE IF EXISTS `teaches`;

CREATE TABLE `teaches` (
  `tID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `course_id` varchar(50) NOT NULL,
  `sec_id` varchar(50) NOT NULL,
  `semester` varchar(50) NOT NULL,
  `year` int NOT NULL,
  PRIMARY KEY (`tID`,`course_id`,`sec_id`,`semester`,`year`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `teaches` */

insert  into `teaches`(`tID`,`course_id`,`sec_id`,`semester`,`year`) values ('10101','CS-315','1','Spring',2010),('10101','CS-347','1','Fall',2009),('12121','FIN-201','1','Spring',2010),('15151','MU-199','1','Spring',2010),('22223','CS-315','2','Spring',2010),('58583','HI-101','1','Fall',2009),('83821','BI-356','1','Fall',2009);

/*Table structure for table `time_slot` */

DROP TABLE IF EXISTS `time_slot`;

CREATE TABLE `time_slot` (
  `time_slot_id` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `day` enum('M','TU','W','TH','F','SA','SU') CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL,
  `start_time` datetime NOT NULL,
  `end_time` datetime NOT NULL,
  PRIMARY KEY (`time_slot_id`,`day`,`start_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

/*Data for the table `time_slot` */

insert  into `time_slot`(`time_slot_id`,`day`,`start_time`,`end_time`) values ('A','M','2020-03-08 08:00:00','2020-03-08 08:50:00'),('B','M','2020-03-08 09:00:00','2020-03-08 09:50:00'),('C','M','2020-03-08 11:00:00','2020-03-08 11:50:00'),('D','M','2020-03-08 13:00:00','2020-03-08 13:50:00'),('E','TU','2020-03-08 14:10:00','2020-03-08 15:00:00'),('F','TU','2020-03-08 15:10:00','2020-03-08 16:00:00'),('G','W','2020-03-08 16:10:00','2020-03-08 17:00:00'),('H','W','2020-03-08 18:10:00','2020-03-08 19:00:00');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

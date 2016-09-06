-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.5.36


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema mydb
--

CREATE DATABASE IF NOT EXISTS mydb;
USE mydb;

--
-- Definition of table `bookinfor`
--

DROP TABLE IF EXISTS `bookinfor`;
CREATE TABLE `bookinfor` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '图书编号',
  `bname` varchar(45) NOT NULL COMMENT '书名',
  `bzuozhe` varchar(45) NOT NULL COMMENT '作者',
  `bchuban` varchar(45) NOT NULL COMMENT '出版社',
  `btype` varchar(45) NOT NULL COMMENT '图书类型',
  `bnum` int(10) NOT NULL COMMENT '图书数量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `bookinfor`
--

/*!40000 ALTER TABLE `bookinfor` DISABLE KEYS */;
INSERT INTO `bookinfor` (`id`,`bname`,`bzuozhe`,`bchuban`,`btype`,`bnum`) VALUES 
 (2,'活着','余华','人民教育出版社','文学',6),
 (3,'C++','谭浩强','清华大学出版社','IT工具',5),
 (4,'三国演义','罗贯中','天津大学出版社','小说',4),
 (12,'行者','顾壮','人民教育出版社','文学',156),
 (13,'功夫','看见了','离开家','文学',66),
 (21,'离开','大海','人民教育出版社','文学',21),
 (22,'我','顾壮','人民教育出版社','文学',3);
/*!40000 ALTER TABLE `bookinfor` ENABLE KEYS */;


--
-- Definition of table `studentsinfor`
--

DROP TABLE IF EXISTS `studentsinfor`;
CREATE TABLE `studentsinfor` (
  `stuid` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '学生编号',
  `name` varchar(45) NOT NULL COMMENT '姓名',
  `sex` varchar(45) NOT NULL COMMENT '性别',
  `stunum` int(45) unsigned NOT NULL COMMENT '学号',
  `class` varchar(45) NOT NULL COMMENT '班级',
  `tel` int(45) unsigned NOT NULL COMMENT '电话',
  `booknum` int(45) unsigned NOT NULL COMMENT '借阅图书编号',
  PRIMARY KEY (`stuid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `studentsinfor`
--

/*!40000 ALTER TABLE `studentsinfor` DISABLE KEYS */;
INSERT INTO `studentsinfor` (`stuid`,`name`,`sex`,`stunum`,`class`,`tel`,`booknum`) VALUES 
 (1,'顾壮','男',1,'四班',6757865,2),
 (2,'大大','男',1,'火一班',34424,3),
 (3,'张张','女',1,'二班',8979087,4),
 (4,'鱼鱼','女',1,'三班',78968907,12),
 (5,'gugu','女',1,'三班',897987,13),
 (6,'jklh','u',98,'kjh',987,33);
/*!40000 ALTER TABLE `studentsinfor` ENABLE KEYS */;


--
-- Definition of table `userinfor`
--

DROP TABLE IF EXISTS `userinfor`;
CREATE TABLE `userinfor` (
  `uid` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `account` varchar(45) NOT NULL COMMENT '用户名',
  `pass` varchar(45) NOT NULL COMMENT '登录密码',
  `truename` varchar(45) NOT NULL COMMENT '真实姓名',
  `email` varchar(45) NOT NULL COMMENT '邮箱',
  `type` varchar(45) NOT NULL COMMENT '用户类型',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `userinfor`
--

/*!40000 ALTER TABLE `userinfor` DISABLE KEYS */;
INSERT INTO `userinfor` (`uid`,`account`,`pass`,`truename`,`email`,`type`) VALUES 
 (12,'bbbbbb','222222','fwefwe','fs@qq.com','普通用户'),
 (13,'aaaaaa','111111','fgerg','jhgk@qq.com','管理员'),
 (15,'rgdfgdfghfd','111111','rtgrtt','gugug@qq.com','普通用户'),
 (16,'3233','333333','sdfsd','afsa@qq.com','普通用户');
/*!40000 ALTER TABLE `userinfor` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

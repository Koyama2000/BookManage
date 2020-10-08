/*
SQLyog Ultimate v12.3.1 (64 bit)
MySQL - 5.5.28 : Database - bookmanagedb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bookmanagedb` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `bookmanagedb`;

/*Table structure for table `bookmanage` */

DROP TABLE IF EXISTS `bookmanage`;

CREATE TABLE `bookmanage` (
  `b_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `b_name` varchar(40) NOT NULL COMMENT '图书名称',
  `b_author` varchar(40) NOT NULL COMMENT '作者',
  `b_time` date NOT NULL COMMENT '购买时间',
  `b_type` int(11) NOT NULL COMMENT '图书类型选择所属分类：0,计算机/软件：1,小说/文摘：2,杂项：3',
  PRIMARY KEY (`b_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `bookmanage` */

insert  into `bookmanage`(`b_id`,`b_name`,`b_author`,`b_time`,`b_type`) values 
(5,'添加图书','作者','2020-01-03',3);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

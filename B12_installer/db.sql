/*
SQLyog - Free MySQL GUI v5.19
Host - 5.0.15-nt : Database - db_speechsms
*********************************************************************
Server version : 5.0.15-nt
*/

SET NAMES utf8;

SET SQL_MODE='';

create database if not exists `db_speechsms`;

USE `db_speechsms`;

SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO';

/*Table structure for table `m_admin` */

DROP TABLE IF EXISTS `m_admin`;

CREATE TABLE `m_admin` (
  `admin_code` int(5) NOT NULL auto_increment,
  `admin_id` char(30) NOT NULL,
  `admin_password` char(15) NOT NULL,
  `admin_name` char(50) NOT NULL,
  PRIMARY KEY  (`admin_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_admin` */

insert into `m_admin` (`admin_code`,`admin_id`,`admin_password`,`admin_name`) values (1,'admin','admin','Admin');

/*Table structure for table `m_password` */

DROP TABLE IF EXISTS `m_password`;

CREATE TABLE `m_password` (
  `s_no` int(11) NOT NULL auto_increment,
  `user_code` varchar(20) default NULL,
  `pass_detail` varchar(80) default NULL,
  `passwords` varchar(80) default NULL,
  `u_id` varchar(80) default NULL,
  PRIMARY KEY  (`s_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_password` */

insert into `m_password` (`s_no`,`user_code`,`pass_detail`,`passwords`,`u_id`) values (1,'1','Facebook','444SDe4tirbsNxnGvJUnnA==','jack');
insert into `m_password` (`s_no`,`user_code`,`pass_detail`,`passwords`,`u_id`) values (2,'1','instagram','s91W8jYLcAude8JxCvco/w==','ash@');
insert into `m_password` (`s_no`,`user_code`,`pass_detail`,`passwords`,`u_id`) values (3,'1','whatsApp','444SDe4tirbsNxnGvJUnnA==','Ashwini');
insert into `m_password` (`s_no`,`user_code`,`pass_detail`,`passwords`,`u_id`) values (4,'2','face5','zbQ8ztX3EmUaMq1ovf0PIw==','ashwini');
insert into `m_password` (`s_no`,`user_code`,`pass_detail`,`passwords`,`u_id`) values (5,'2','WhatsApp','oa6wt5mDUta2OGGW8olZKw==','ash');

/*Table structure for table `m_user` */

DROP TABLE IF EXISTS `m_user`;

CREATE TABLE `m_user` (
  `u_code` int(5) NOT NULL auto_increment,
  `u_login_id` varchar(50) NOT NULL,
  `u_login_pwd` varchar(50) NOT NULL,
  `u_name` varchar(20) NOT NULL,
  `u_otp_pass` varchar(10) NOT NULL,
  `master_key` varchar(100) default NULL,
  `u_mobile` varchar(100) default NULL,
  `verify_user_status` varchar(50) default NULL,
  `alternate_no` varchar(12) default NULL,
  `imeino` varchar(70) default NULL,
  PRIMARY KEY  (`u_code`),
  UNIQUE KEY `u_login_id` (`u_login_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_user` */

insert into `m_user` (`u_code`,`u_login_id`,`u_login_pwd`,`u_name`,`u_otp_pass`,`master_key`,`u_mobile`,`verify_user_status`,`alternate_no`,`imeino`) values (1,'ash','ash','ash','9997','v9mkwj4y6r5AkRTqR3epEA==','9620725674','Done','9620725674','860848046557352');
insert into `m_user` (`u_code`,`u_login_id`,`u_login_pwd`,`u_name`,`u_otp_pass`,`master_key`,`u_mobile`,`verify_user_status`,`alternate_no`,`imeino`) values (2,'ashwini','123456','ashwini','4485','oJfTtchpM9WC/4Oqpu7FZQ==','9620725674','Done','9620725674','860848046557352');
insert into `m_user` (`u_code`,`u_login_id`,`u_login_pwd`,`u_name`,`u_otp_pass`,`master_key`,`u_mobile`,`verify_user_status`,`alternate_no`,`imeino`) values (6,'abc','abc','abc','1235','Ww0w5itd5fivf5wHBONqWg==','9620725674','Done','9620725674','860848046557352');

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;

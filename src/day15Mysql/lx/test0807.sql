/*
Navicat MySQL Data Transfer

Source Server         : locahhost
Source Server Version : 50712
Source Host           : localhost:3306
Source Database       : test0807

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2016-08-07 17:30:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `CNO` varchar(5) NOT NULL,
  `CNAME` varchar(10) NOT NULL,
  `TNO` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('3-105', '计算机导论', '825');
INSERT INTO `course` VALUES ('3-245', '操作系统', '804');
INSERT INTO `course` VALUES ('6-166', '数据电路', '856');
INSERT INTO `course` VALUES ('9-888', '高等数学', '100');

-- ----------------------------
-- Table structure for grade
-- ----------------------------
DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade` (
  `low` int(11) DEFAULT NULL,
  `upp` int(11) DEFAULT NULL,
  `rank` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of grade
-- ----------------------------
INSERT INTO `grade` VALUES ('90', '100', 'A');
INSERT INTO `grade` VALUES ('80', '89', 'B');
INSERT INTO `grade` VALUES ('70', '79', 'C');
INSERT INTO `grade` VALUES ('60', '69', 'D');
INSERT INTO `grade` VALUES ('0', '59', 'E');

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score` (
  `SNO` varchar(3) NOT NULL,
  `CNO` varchar(5) NOT NULL,
  `DEGREE` decimal(10,1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES ('103', '3-245', '86.0');
INSERT INTO `score` VALUES ('105', '3-245', '75.0');
INSERT INTO `score` VALUES ('109', '3-245', '68.0');
INSERT INTO `score` VALUES ('103', '3-105', '92.0');
INSERT INTO `score` VALUES ('105', '3-105', '88.0');
INSERT INTO `score` VALUES ('109', '3-105', '76.0');
INSERT INTO `score` VALUES ('101', '3-105', '64.0');
INSERT INTO `score` VALUES ('107', '3-105', '91.0');
INSERT INTO `score` VALUES ('108', '3-105', '78.0');
INSERT INTO `score` VALUES ('101', '6-166', '85.0');
INSERT INTO `score` VALUES ('107', '6-106', '79.0');
INSERT INTO `score` VALUES ('108', '6-166', '81.0');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `SNO` varchar(3) NOT NULL,
  `SNAME` varchar(4) NOT NULL,
  `SSEX` varchar(2) NOT NULL,
  `SBIRTHDAY` datetime DEFAULT NULL,
  `CLASS` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('108', '曾华', '男', '1977-09-01 00:00:00', '95033');
INSERT INTO `student` VALUES ('105', '匡明', '男', '1975-10-02 00:00:00', '95031');
INSERT INTO `student` VALUES ('107', '王丽', '女', '1976-01-23 00:00:00', '95033');
INSERT INTO `student` VALUES ('101', '李军', '男', '1976-02-20 00:00:00', '95033');
INSERT INTO `student` VALUES ('109', '王芳', '女', '1975-02-10 00:00:00', '95031');
INSERT INTO `student` VALUES ('103', '陆君', '男', '1974-06-03 00:00:00', '95031');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `TNO` varchar(3) NOT NULL,
  `TNAME` varchar(4) NOT NULL,
  `TSEX` varchar(2) NOT NULL,
  `TBIRTHDAY` datetime NOT NULL,
  `PROF` varchar(6) DEFAULT NULL,
  `DEPART` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('804', '李诚', '男', '1958-12-02 00:00:00', '副教授', '计算机系');
INSERT INTO `teacher` VALUES ('856', '张旭', '男', '1969-03-12 00:00:00', '讲师', '电子工程系');
INSERT INTO `teacher` VALUES ('825', '王萍', '女', '1972-05-05 00:00:00', '助教', '计算机系');
INSERT INTO `teacher` VALUES ('831', '刘冰', '女', '1977-08-14 00:00:00', '助教', '电子工程系');

/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 80023
Source Host           : localhost:3306
Source Database       : gatering

Target Server Type    : MYSQL
Target Server Version : 80023
File Encoding         : 65001

Date: 2022-05-05 07:43:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bill
-- ----------------------------
DROP TABLE IF EXISTS `bill`;
CREATE TABLE `bill` (
  `id` int NOT NULL AUTO_INCREMENT,
  `billId` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '',
  `menuid` int NOT NULL DEFAULT '0',
  `nums` int NOT NULL DEFAULT '0',
  `money` double NOT NULL DEFAULT '0',
  `diningTableId` int NOT NULL DEFAULT '0',
  `billdate` datetime NOT NULL,
  `state` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of bill
-- ----------------------------

-- ----------------------------
-- Table structure for diningtable
-- ----------------------------
DROP TABLE IF EXISTS `diningtable`;
CREATE TABLE `diningtable` (
  `id` int NOT NULL AUTO_INCREMENT,
  `state` varchar(20) COLLATE utf8_bin NOT NULL DEFAULT '',
  `orderName` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '',
  `orderTel` varchar(20) COLLATE utf8_bin NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of diningtable
-- ----------------------------
INSERT INTO `diningtable` VALUES ('1', '已经预定', 'rf', 'af');
INSERT INTO `diningtable` VALUES ('2', '空', '', '');
INSERT INTO `diningtable` VALUES ('3', '空', '', '');
INSERT INTO `diningtable` VALUES ('4', '空', '', '');

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `id` int NOT NULL AUTO_INCREMENT,
  `empId` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '',
  `pwd` char(32) COLLATE utf8_bin NOT NULL DEFAULT '',
  `name` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '',
  `job` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  UNIQUE KEY `empId` (`empId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('1', '1001', 'e10adc3949ba59abbe56e057f20f883e', '张三', '经理');
INSERT INTO `employee` VALUES ('2', '1002', 'e10adc3949ba59abbe56e057f20f883e', '李四', '服务员');
INSERT INTO `employee` VALUES ('3', '1003', 'e10adc3949ba59abbe56e057f20f883e', '王五', '收银员');
INSERT INTO `employee` VALUES ('4', '1004', 'e10adc3949ba59abbe56e057f20f883e', '小明', '经理');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '',
  `type` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '',
  `price` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '宫保鸡丁', '热菜', '10');
INSERT INTO `menu` VALUES ('2', '山药鲅鱼', '凉菜', '20');
INSERT INTO `menu` VALUES ('3', '八宝饭', '主食', '30');
INSERT INTO `menu` VALUES ('4', '叉烧包', '热菜', '40');
INSERT INTO `menu` VALUES ('5', '银丝卷', '甜食', '50');
INSERT INTO `menu` VALUES ('6', '水煮鱼', '热菜', '70');
INSERT INTO `menu` VALUES ('7', '海带汤', '汤类', '80');
INSERT INTO `menu` VALUES ('8', '鸡蛋汤', '汤类', '90');

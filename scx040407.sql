/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80023
Source Host           : localhost:3306
Source Database       : scx040407

Target Server Type    : MYSQL
Target Server Version : 80023
File Encoding         : 65001

Date: 2021-03-20 22:02:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `ID` int NOT NULL COMMENT '编号',
  `UID` int DEFAULT NULL COMMENT '用户编号',
  `MONEY` double DEFAULT NULL COMMENT '金额',
  PRIMARY KEY (`ID`),
  KEY `FK_Reference_8` (`UID`),
  CONSTRAINT `FK_Reference_8` FOREIGN KEY (`UID`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('1', '41', '1000');
INSERT INTO `account` VALUES ('2', '45', '1000');
INSERT INTO `account` VALUES ('3', '41', '2000');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `ID` int NOT NULL COMMENT '编号',
  `ROLE_NAME` varchar(30) DEFAULT NULL COMMENT '角色名称',
  `ROLE_DESC` varchar(60) DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '院长', '管理整个学院');
INSERT INTO `role` VALUES ('2', '总裁', '管理整个公司');
INSERT INTO `role` VALUES ('3', '校长', '管理整个学校');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL COMMENT '用户名称',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `sex` char(1) DEFAULT NULL COMMENT '性别',
  `address` varchar(256) DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('41', '老王', '2018-02-27 17:47:08', '男', '北京');
INSERT INTO `user` VALUES ('42', '小二王', '2018-03-02 15:09:37', '女', '北京金燕龙');
INSERT INTO `user` VALUES ('43', '小二王', '2018-03-04 11:34:34', '女', '北京金燕龙');
INSERT INTO `user` VALUES ('45', '传智播客', '2018-03-04 12:04:06', '男', '北京金燕龙');
INSERT INTO `user` VALUES ('46', '老王', '2018-03-07 17:37:26', '男', '北京');
INSERT INTO `user` VALUES ('48', '小马宝莉', '2018-03-08 11:44:00', '女', '北京修正');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `UID` int NOT NULL COMMENT '用户编号',
  `RID` int NOT NULL COMMENT '角色编号',
  PRIMARY KEY (`UID`,`RID`),
  KEY `FK_Reference_10` (`RID`),
  CONSTRAINT `FK_Reference_10` FOREIGN KEY (`RID`) REFERENCES `role` (`ID`),
  CONSTRAINT `FK_Reference_9` FOREIGN KEY (`UID`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('41', '1');
INSERT INTO `user_role` VALUES ('45', '1');
INSERT INTO `user_role` VALUES ('41', '2');

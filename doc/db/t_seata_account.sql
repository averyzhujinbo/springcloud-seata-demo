/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.1.231
 Source Server Type    : MySQL
 Source Server Version : 50727
 Source Host           : 192.168.1.231:3307
 Source Schema         : seata_account

 Target Server Type    : MySQL
 Target Server Version : 50727
 File Encoding         : 65001

 Date: 04/08/2020 16:23:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_seata_account
-- ----------------------------
DROP TABLE IF EXISTS `t_seata_account`;
CREATE TABLE `t_seata_account` (
  `account_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `balance` int(11) DEFAULT '0' COMMENT '账户余额',
  PRIMARY KEY (`account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='会员账户表';

-- ----------------------------
-- Records of t_seata_account
-- ----------------------------
BEGIN;
INSERT INTO `t_seata_account` VALUES (1, 70000);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;

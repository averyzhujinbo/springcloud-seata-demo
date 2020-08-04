/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.1.231
 Source Server Type    : MySQL
 Source Server Version : 50727
 Source Host           : 192.168.1.231:3307
 Source Schema         : seata_order

 Target Server Type    : MySQL
 Target Server Version : 50727
 File Encoding         : 65001

 Date: 04/08/2020 16:24:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_seata_order
-- ----------------------------
DROP TABLE IF EXISTS `t_seata_order`;
CREATE TABLE `t_seata_order` (
  `order_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `account_id` bigint(20) NOT NULL COMMENT '账户id',
  `goods_code` varchar(100) DEFAULT NULL COMMENT '商品编码',
  `count` int(11) DEFAULT '0' COMMENT '商品数量',
  `money` int(11) DEFAULT '0' COMMENT '订单金额',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COMMENT='订单表';

-- ----------------------------
-- Records of t_seata_order
-- ----------------------------
BEGIN;
INSERT INTO `t_seata_order` VALUES (2, 1, 'SN-000001', 1, 5000);
INSERT INTO `t_seata_order` VALUES (7, 1, 'SN-000001', 4, 20000);
INSERT INTO `t_seata_order` VALUES (8, 1, 'SN-000001', 1, 5000);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;

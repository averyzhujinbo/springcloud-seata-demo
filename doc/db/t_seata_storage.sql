/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.1.231
 Source Server Type    : MySQL
 Source Server Version : 50727
 Source Host           : 192.168.1.231:3307
 Source Schema         : seata_storage

 Target Server Type    : MySQL
 Target Server Version : 50727
 File Encoding         : 65001

 Date: 04/08/2020 16:25:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_seata_storage
-- ----------------------------
DROP TABLE IF EXISTS `t_seata_storage`;
CREATE TABLE `t_seata_storage` (
  `storage_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `goods_code` varchar(11) DEFAULT NULL COMMENT '商品编码',
  `goods_name` varchar(11) DEFAULT NULL COMMENT '商品名称',
  `price` int(11) DEFAULT '0' COMMENT '商品单价',
  `count` int(11) DEFAULT '0' COMMENT '库存数量',
  PRIMARY KEY (`storage_id`),
  UNIQUE KEY `un_goods_code` (`goods_code`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='库存表';

-- ----------------------------
-- Records of t_seata_storage
-- ----------------------------
BEGIN;
INSERT INTO `t_seata_storage` VALUES (1, 'SN-000001', '三星S20', 5000, 94);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;

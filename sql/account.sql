/*
 Navicat Premium Data Transfer

 Source Server         : root@mysql57
 Source Server Type    : MySQL
 Source Server Version : 50741 (5.7.41)
 Source Host           : localhost:3306
 Source Schema         : account

 Target Server Type    : MySQL
 Target Server Version : 50741 (5.7.41)
 File Encoding         : 65001

 Date: 30/03/2023 23:39:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_point_record
-- ----------------------------
DROP TABLE IF EXISTS `t_point_record`;
CREATE TABLE `t_point_record`  (
  `id` int(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '记录ID',
  `user_id` int(20) NOT NULL COMMENT '积分变更操作用户ID',
  `order_id` int(20) NOT NULL COMMENT '积分变更操作对应的订单ID',
  `change_value` int(11) NOT NULL COMMENT '积分变更值',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of point_change_record
-- ----------------------------
--
-- -- ----------------------------
-- -- Table structure for point_record
-- -- ----------------------------
-- DROP TABLE IF EXISTS `point_record`;
-- CREATE TABLE `point_record`  (
--   `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '记录ID',
--   `user_id` int(20) NOT NULL COMMENT '积分变更操作用户ID',
--   `change_value` int(11) NOT NULL COMMENT '积分变更值',
--   `create_time` datetime NOT NULL COMMENT '记录创建时间',
--   PRIMARY KEY (`id`) USING BTREE
-- ) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of point_record
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '邮箱',
  `balance` decimal(10,2) DEFAULT '0.00' COMMENT '账户资产',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------


-- ----------------------------
-- Table structure for undo_log
-- ----------------------------
DROP TABLE IF EXISTS `undo_log`;
CREATE TABLE `undo_log`  (
 `id` int(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
 `branch_id` int(20) NOT NULL COMMENT 'branch transaction id',
 `xid` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'global transaction id',
 `context` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'undo/redo log context,such as serialization',
 `rollback_info` longblob NOT NULL COMMENT 'rollback info',
 `log_status` int(11) NOT NULL COMMENT '0:normal status,1:defense status',
 `log_created` datetime DEFAULT CURRENT_TIMESTAMP COMMENT 'create datetime',
 `log_modified` datetime NULL COMMENT 'modify datetime',
 PRIMARY KEY (`id`) USING BTREE,
 UNIQUE INDEX `ux_undo_log`(`xid`, `branch_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'AT undo table' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of undo_log
-- ----------------------------


-- ----------------------------
-- 初始10条user表数据
-- ----------------------------
INSERT INTO `account`.`t_user` (`id`, `username`, `email`, `balance`, `create_time`, `update_time`) VALUES (11, 'user1', 'user1@example.com', 10000.00, '2023-04-02 04:28:59', NULL);
INSERT INTO `account`.`t_user` (`id`, `username`, `email`, `balance`, `create_time`, `update_time`) VALUES (12, 'user2', 'user2@example.com', 100.00, '2023-04-02 04:28:59', NULL);
INSERT INTO `account`.`t_user` (`id`, `username`, `email`, `balance`, `create_time`, `update_time`) VALUES (13, 'user3', 'user3@example.com', 10.00, '2023-04-02 04:28:59', NULL);
INSERT INTO `account`.`t_user` (`id`, `username`, `email`, `balance`, `create_time`, `update_time`) VALUES (14, 'user4', 'user4@example.com', 0.00, '2023-04-02 04:28:59', NULL);
INSERT INTO `account`.`t_user` (`id`, `username`, `email`, `balance`, `create_time`, `update_time`) VALUES (15, 'user5', 'user5@example.com', 0.00, '2023-04-02 04:28:59', NULL);
INSERT INTO `account`.`t_user` (`id`, `username`, `email`, `balance`, `create_time`, `update_time`) VALUES (16, 'user6', 'user6@example.com', 0.00, '2023-04-02 04:28:59', NULL);
INSERT INTO `account`.`t_user` (`id`, `username`, `email`, `balance`, `create_time`, `update_time`) VALUES (17, 'user7', 'user7@example.com', 0.00, '2023-04-02 04:28:59', NULL);
INSERT INTO `account`.`t_user` (`id`, `username`, `email`, `balance`, `create_time`, `update_time`) VALUES (18, 'user8', 'user8@example.com', 0.00, '2023-04-02 04:28:59', NULL);
INSERT INTO `account`.`t_user` (`id`, `username`, `email`, `balance`, `create_time`, `update_time`) VALUES (19, 'user9', 'user9@example.com', 0.00, '2023-04-02 04:28:59', NULL);
INSERT INTO `account`.`t_user` (`id`, `username`, `email`, `balance`, `create_time`, `update_time`) VALUES (20, 'user10', 'user10@example.com', 0.00, '2023-04-02 04:28:59', NULL);



SET FOREIGN_KEY_CHECKS = 1;

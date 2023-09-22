/*
 Navicat Premium Data Transfer

 Source Server         : a_local
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : localhost:3306
 Source Schema         : novel

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 21/09/2023 17:29:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for friend
-- ----------------------------
DROP TABLE IF EXISTS `friend`;
CREATE TABLE `friend`  (
                           `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键id',
                           `user_id` bigint(0) NOT NULL COMMENT '用户id',
                           `friend_id` bigint(0) NOT NULL COMMENT '好友id',
                           `remark_name` varchar(50)  NULL DEFAULT NULL COMMENT '备注',
                           `group_id` bigint(0) NOT NULL DEFAULT 0 COMMENT '所属分组',
                           `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
                           `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
                           PRIMARY KEY (`id`)
)  COMMENT = '好友关系' ;

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
                            `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键id',
                            `receiver_id` bigint(0) NOT NULL COMMENT '登录账号',
                            `sender_id` bigint(0) NOT NULL COMMENT '昵称',
                            `text` varchar(500)  NULL DEFAULT NULL COMMENT '密码',
                            `has_read` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否已读',
                            `delete` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除',
                            `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
                            `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
                            PRIMARY KEY (`id`)
)  COMMENT = '消息' ;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
                         `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键id',
                         `login_name` varchar(50)  NOT NULL COMMENT '登录账号',
                         `nick_name` varchar(50)  NOT NULL COMMENT '昵称',
                         `real_name` varchar(50)  NULL DEFAULT NULL COMMENT '真实名称',
                         `password` varchar(255)  NULL DEFAULT NULL COMMENT '密码',
                         `phone` varchar(20)  NULL DEFAULT NULL COMMENT '手机号',
                         `status` varchar(255)  NOT NULL COMMENT '账户状态',
                         `reg_ip` varchar(255)  NULL DEFAULT NULL COMMENT '注册ip',
                         `try_times` tinyint(1) NOT NULL DEFAULT 0 COMMENT '重试次数',
                         `id_card_no` varchar(30)  NULL DEFAULT NULL COMMENT '身份证号',
                         `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
                         `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
                         PRIMARY KEY (`id`)
)  COMMENT = '用户信息' ;

SET FOREIGN_KEY_CHECKS = 1;

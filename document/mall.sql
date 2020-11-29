/*
Navicat MySQL Data Transfer

Source Server         : mall
Source Server Version : 80021
Source Host           : 116.62.239.206:3306
Source Database       : mall

Target Server Type    : MYSQL
Target Server Version : 80021
File Encoding         : 65001

Date: 2020-11-10 17:04:43
*/

SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for u_biz_merchant
-- ----------------------------
DROP TABLE IF EXISTS `u_biz_merchant`;
CREATE TABLE `u_biz_merchant`
(
    `id`             bigint unsigned NOT NULL COMMENT '商家id',
    `name`           varchar(256)         DEFAULT NULL COMMENT '名称',
    `status`         tinyint unsigned     DEFAULT NULL COMMENT '状态',
    `logo`           varchar(512)         DEFAULT NULL COMMENT 'logo',
    `create_user_id` bigint unsigned      DEFAULT NULL COMMENT '创建人',
    `create_time`    timestamp       NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_user_id` bigint unsigned      DEFAULT NULL COMMENT '更新人',
    `update_time`    timestamp       NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted`        tinyint unsigned     DEFAULT '0' COMMENT '是否删除',
    `version`        int unsigned         DEFAULT '0' COMMENT '版本',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for u_permission
-- ----------------------------
DROP TABLE IF EXISTS u_permission;
CREATE TABLE `u_permission`
(
    `id`             bigint unsigned NOT NULL COMMENT '权限ID',
    `parent_id`      bigint unsigned                                               DEFAULT NULL COMMENT '上级ID',
    `name`           varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '权限名称',
    `level`          varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '权限层级',
    `icon`           varchar(512)                                                  DEFAULT NULL COMMENT '图标',
    `type`           tinyint unsigned                                              DEFAULT NULL COMMENT '类型',
    `url`            varchar(256)                                                  DEFAULT NULL COMMENT '链接',
    `method`         varchar(32)                                                   DEFAULT NULL COMMENT '请求方法',
    `status`         tinyint unsigned                                              DEFAULT NULL COMMENT '权限状态',
    `merchant_id`    bigint unsigned                                               DEFAULT NULL COMMENT '权限所属商家id',
    `create_user_id` bigint unsigned                                               DEFAULT NULL COMMENT '创建人员',
    `create_time`    timestamp       NULL                                          DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_user_id` bigint unsigned                                               DEFAULT NULL COMMENT '更新人员',
    `update_time`    timestamp       NULL                                          DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted`        tinyint unsigned                                              DEFAULT '0' COMMENT '是否删除',
    `version`        int unsigned                                                  DEFAULT '0' COMMENT '版本',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='权限表';

-- ----------------------------
-- Table structure for u_role
-- ----------------------------
DROP TABLE IF EXISTS u_role;
CREATE TABLE `u_role`
(
    `id`             bigint unsigned                                               NOT NULL COMMENT '角色ID',
    `name`           varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '角色名称（前缀为ROLE_）',
    `name_zh`        varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci      DEFAULT NULL COMMENT '自定义权限名称',
    `description`    varchar(512)                                                       DEFAULT NULL COMMENT '描述',
    `status`         tinyint unsigned                                                   DEFAULT '1' COMMENT '状态(0停用,1启用)',
    `merchant_id`    bigint unsigned                                                    DEFAULT NULL COMMENT '角色所属商家id',
    `create_user_id` bigint unsigned                                                    DEFAULT NULL COMMENT '创建人员',
    `create_time`    timestamp                                                     NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_user_id` bigint unsigned                                                    DEFAULT NULL COMMENT '更新人员',
    `update_time`    timestamp                                                     NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted`        tinyint unsigned                                                   DEFAULT '0' COMMENT '是否删除',
    `version`        int unsigned                                                       DEFAULT '0' COMMENT '版本',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='角色表';

-- ----------------------------
-- Table structure for u_role_permission
-- ----------------------------
DROP TABLE IF EXISTS u_role_permission;
CREATE TABLE `u_role_permission`
(
    `id`             bigint unsigned NOT NULL COMMENT '角色权限关系id',
    `role_id`        bigint unsigned      DEFAULT NULL COMMENT '角色id',
    `permission_id`  bigint unsigned      DEFAULT NULL COMMENT '权限id',
    `merchant_id`    bigint unsigned      DEFAULT NULL COMMENT '所属商家id',
    `create_user_id` bigint unsigned      DEFAULT NULL COMMENT '创建人员',
    `create_time`    timestamp       NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_user_id` bigint unsigned      DEFAULT NULL COMMENT '更新人员',
    `update_time`    timestamp       NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted`        tinyint unsigned     DEFAULT '0' COMMENT '是否删除',
    `version`        int unsigned         DEFAULT '0' COMMENT '版本',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='角色权限关系表';

-- ----------------------------
-- Table structure for u_biz_user
-- ----------------------------
DROP TABLE IF EXISTS `u_biz_user`;
CREATE TABLE `u_biz_user`
(
    `id`             bigint unsigned NOT NULL COMMENT '用户ID',
    `username`       varchar(64)                                                   DEFAULT NULL COMMENT '用户名',
    `password`       varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '密码',
    `icon`           varchar(512)                                                  DEFAULT NULL COMMENT '头像',
    `phone`          bigint unsigned                                               DEFAULT NULL COMMENT '手机号',
    `email`          varchar(128)                                                  DEFAULT NULL COMMENT '邮箱',
    `nick_name`      varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '昵称',
    `login_time`     timestamp       NULL                                          DEFAULT CURRENT_TIMESTAMP COMMENT '最后登录时间',
    `status`         tinyint unsigned                                              DEFAULT NULL COMMENT '账号状态',
    `merchant_id`    bigint unsigned                                               DEFAULT NULL COMMENT '用户所属商家id',
    `create_user_id` bigint unsigned                                               DEFAULT NULL COMMENT '创建人员',
    `create_time`    timestamp       NULL                                          DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_user_id` bigint unsigned                                               DEFAULT NULL COMMENT '更新人员',
    `update_time`    timestamp       NULL                                          DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted`        tinyint unsigned                                              DEFAULT '0' COMMENT '是否删除',
    `version`        int unsigned                                                  DEFAULT '0' COMMENT '版本',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='用户表';

-- ----------------------------
-- Table structure for u_user_permission
-- ----------------------------
DROP TABLE IF EXISTS u_user_permission;
CREATE TABLE `u_user_permission`
(
    `id`             bigint unsigned NOT NULL COMMENT '用户权限关系id',
    `user_id`        bigint unsigned      DEFAULT NULL COMMENT '用户id',
    `permission_id`  bigint unsigned      DEFAULT NULL COMMENT '权限id',
    `type`           tinyint unsigned     DEFAULT NULL COMMENT '类型',
    `merchant_id`    bigint unsigned      DEFAULT NULL COMMENT '所属商家id',
    `create_user_id` bigint unsigned      DEFAULT NULL COMMENT '创建人员',
    `create_time`    timestamp       NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_user_id` bigint unsigned      DEFAULT NULL COMMENT '更新人员',
    `update_time`    timestamp       NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted`        tinyint unsigned     DEFAULT '0' COMMENT '是否删除',
    `version`        int unsigned         DEFAULT '0' COMMENT '版本',
    PRIMARY KEY (`id`),
    UNIQUE KEY `Index_1` (`user_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='用户权限关系表';

-- ----------------------------
-- Table structure for u_user_role
-- ----------------------------
DROP TABLE IF EXISTS u_user_role;
CREATE TABLE `u_user_role`
(
    `id`             bigint unsigned NOT NULL COMMENT '用户与角色关系id',
    `user_id`        bigint unsigned      DEFAULT NULL COMMENT '用户id',
    `role_id`        bigint unsigned      DEFAULT NULL COMMENT '角色id',
    `merchant_id`    bigint unsigned      DEFAULT NULL COMMENT '所属商家id',
    `create_user_id` bigint unsigned      DEFAULT NULL COMMENT '创建人员',
    `create_time`    timestamp       NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_user_id` bigint unsigned      DEFAULT NULL COMMENT '更新人员',
    `update_time`    timestamp       NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted`        tinyint unsigned     DEFAULT '0' COMMENT '是否删除',
    `version`        int unsigned         DEFAULT '0' COMMENT '版本',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='用户角色关系表';

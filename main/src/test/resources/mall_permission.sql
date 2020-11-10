DROP TABLE IF EXISTS `u_biz_permission`;
CREATE TABLE `u_biz_permission` (
  `id` bigint NOT NULL COMMENT '权限ID',
  `parent_id` bigint DEFAULT NULL COMMENT '上级ID',
  `name` varchar(128) DEFAULT NULL COMMENT '权限名称',
  `level` varchar(256) DEFAULT NULL COMMENT '权限层级',
  `icon` varchar(512) DEFAULT NULL COMMENT '图标',
  `type` tinyint DEFAULT NULL COMMENT '类型',
  `url` varchar(256) DEFAULT NULL COMMENT '链接',
  `method` varchar(32) DEFAULT NULL COMMENT '请求方法',
  `status` tinyint DEFAULT NULL COMMENT '权限状态',
  `merchant_id` bigint DEFAULT NULL COMMENT '权限所属商家id',
  `create_user_id` bigint DEFAULT NULL COMMENT '创建人员',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_user_id` bigint DEFAULT NULL COMMENT '更新人员',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` tinyint DEFAULT '0' COMMENT '是否删除',
  `version` int DEFAULT '0' COMMENT '版本',
  PRIMARY KEY (`id`)
) COMMENT='权限表';
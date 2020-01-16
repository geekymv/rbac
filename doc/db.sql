CREATE TABLE `user` (
  `id` bigint(20) NOT NULL COMMENT '主键ID',
  `account` varchar(32) NOT NULL COMMENT '帐号',
  `username` varchar(64) DEFAULT NULL COMMENT '姓名',
  `password` varchar(128) DEFAULT NULL COMMENT '密码',
  `enable` tinyint(1) DEFAULT NULL COMMENT '是否启用：1启用，0禁用，默认是1',
  `is_delete` tinyint(1) DEFAULT NULL COMMENT '是否删除：1已删除，0正常（未删除），默认是0',
  `create_at` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `update_at` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` bigint(20) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户';


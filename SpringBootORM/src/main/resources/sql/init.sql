-- 创建数据库

-- 用户组织模块表结构
-- sys_user

-- sys_org
-- sys_role
-- sys_role_resource
-- sys_user_role

-- sys_resource
-- sys_menu
-- sys_menu_resource

DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` varchar(36) NOT NULL,
  `login_id` varchar(36) NOT NULL,
  `password` varchar(36) DEFAULT NULL,
  `name` varchar(36) DEFAULT NULL,
  `org_id` varchar(36) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `mobile` varchar(50) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` varchar(36)  NULL,
  `updated_by` varchar(36) NOT NULL,
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `del_flag` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `sys_org`;
CREATE TABLE `sys_org` (
  `id` varchar(36) NOT NULL,
  `inheritance` varchar(3000) NOT NULL,
  `name` varchar(36) NOT NULL,
  `full_name` varchar(36) NOT NULL,
  `parent` varchar(36) NOT NULL DEFAULT '',
  `order` int(11) DEFAULT NULL,

  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` varchar(36)  NULL,
  `updated_by` varchar(36) NOT NULL,
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `del_flag` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` varchar(36) NOT NULL,
  `name` varchar(36) NOT NULL,
  `code` varchar(36) NOT NULL,
  `remark` varchar(100) NOT NULL,
  `priority` int(11) NOT NULL,

  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` varchar(36)  NULL,
  `updated_by` varchar(36) NOT NULL,
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `del_flag` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` varchar(36) NOT NULL,
  `user_id` varchar(36) NOT NULL,
  `role_id` varchar(36) NOT NULL,

  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` varchar(36)  NULL,
  `updated_by` varchar(36) NOT NULL,
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `del_flag` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE `sys_user`
(
    `id`               bigint   NOT NULL AUTO_INCREMENT COMMENT '用户唯一ID',
    `uuid`             varchar(64)       DEFAULT NULL COMMENT '全局用户标识（对外暴露）',
    `nickname`         varchar(255)      DEFAULT '' COMMENT '用户昵称',
    `avatar_url`       varchar(512)      DEFAULT '' COMMENT '头像URL',
    `status`           int               DEFAULT '0' COMMENT '状态：0-正常, 1-冻结, 2-注销',
    `gmt_create`       datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `gmt_modify`       datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `archive`          int               DEFAULT '0' COMMENT '删除标识',
    `create_user_id`   varchar(64)       DEFAULT 'system' COMMENT '创建人id',
    `create_user_name` varchar(256)      DEFAULT 'system' COMMENT '创建人name',
    `update_user_id`   varchar(64)       DEFAULT 'system' COMMENT '修改人id',
    `update_user_name` varchar(256)      DEFAULT 'system' COMMENT '修改人名称',
    `user_name`        varchar(32)       DEFAULT NULL COMMENT '账号密码登录存储账号',
    `phone_num`        varchar(32)       DEFAULT NULL COMMENT '手机号',
    `email`            varchar(32)       DEFAULT NULL COMMENT '邮箱',
    PRIMARY KEY (`id`),
    KEY                `idx_uuid` (`uuid`),
    KEY                `idx_email` (`email`),
    KEY                `idx_phone_num` (`phone_num`),
    KEY                `idx_user_name` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户基础信息表'



# 基本字段sql
CREATE TABLE `xxxxxxx`
(
    `id`               bigint   NOT NULL AUTO_INCREMENT COMMENT '用户唯一ID',
    `gmt_create`       datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `gmt_modify`       datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `archive`          int               DEFAULT '0' COMMENT '删除标识',
    `create_user_id`   varchar(64)       DEFAULT 'system' COMMENT '创建人id',
    `create_user_name` varchar(256)      DEFAULT 'system' COMMENT '创建人name',
    `update_user_id`   varchar(64)       DEFAULT 'system' COMMENT '修改人id',
    `update_user_name` varchar(256)      DEFAULT 'system' COMMENT '修改人名称',
    PRIMARY KEY (`id`),
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='xxx表'




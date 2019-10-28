# 创建数据库
CREATE DATABASE springboot_practice;

# 创建用户表
DROP TABLE IF EXISTS user;
CREATE TABLE user
(
    id            BIGINT UNSIGNED            NOT NULL AUTO_INCREMENT COMMENT '主键 ID',
    dept_id       BIGINT                     NULL COMMENT '用户所在部门 ID',
    user_name     VARCHAR(32)      DEFAULT NULL COMMENT '用户名',
    user_password VARCHAR(32)      DEFAULT NULL COMMENT '密码',
    user_sex      TINYINT UNSIGNED DEFAULT NULL COMMENT '性别',
    nick_name     VARCHAR(32)      DEFAULT NULL COMMENT '真实姓名',
    create_time   DATETIME                   NULL COMMENT '创建时间',
    update_time   DATETIME                   NULL COMMENT '更新时间',
    is_deleted    TINYINT UNSIGNED DEFAULT 0 NOT NULL COMMENT '1-删除，0-未删除',
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = UTF8MB4
    COMMENT '用户表';


# 创建部门表
DROP TABLE IF EXISTS dept;
CREATE TABLE dept
(
    id          BIGINT UNSIGNED            NOT NULL AUTO_INCREMENT COMMENT '主键 ID',
    dept_name   VARCHAR(32)      DEFAULT NULL COMMENT '部门名称',
    parent_id   BIGINT           DEFAULT NULL COMMENT '父部门 ID',
    create_time DATETIME                   NULL COMMENT '创建时间',
    update_time DATETIME                   NULL COMMENT '更新时间',
    is_deleted  TINYINT UNSIGNED DEFAULT 0 NOT NULL COMMENT '1-删除，0-未删除',
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = UTF8MB4
    COMMENT '公司部门表';
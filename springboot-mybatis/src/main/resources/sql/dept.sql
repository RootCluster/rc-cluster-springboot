DROP TABLE IF EXISTS tbl_dept;
CREATE TABLE tbl_dept
(
    id          bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    dept_name   varchar(11) DEFAULT NULL COMMENT '部门名称',
    parent_id   bigint(20) NOT NULL COMMENT '父部门 ID',
    create_time datetime    DEFAULT NULL COMMENT '创建时间',
    update_time datetime    DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='部门表';
CREATE TABLE tbl_staff
(
    id          bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    user_id     varchar(32)  DEFAULT NULL COMMENT '其他系统用户 ID 表示',
    staff_name  varchar(150) DEFAULT NULL COMMENT '成员名称',
    mobile      varchar(12)  DEFAULT NULL COMMENT '手机号码',
    dept_id     bigint(20)   DEFAULT NULL COMMENT '部门 ID',
    create_time datetime     DEFAULT NULL COMMENT '创建时间',
    update_time datetime     DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='员工信息表';
DROP TABLE IF EXISTS tbl_staff;
CREATE TABLE tbl_staff
(
    id          BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT COMMENT '主键',
    parent_id   BIGINT(20)   DEFAULT NULL COMMENT '上级主键',
    user_name   VARCHAR(150) DEFAULT NULL COMMENT '用户名',
    age         INT(3)       DEFAULT NULL COMMENT '成员年龄',
    mobile      VARCHAR(12)  DEFAULT NULL COMMENT '手机号码',
    dept_id     BIGINT(20)   DEFAULT NULL COMMENT '所在部门主键',
    create_time DATETIME     DEFAULT NULL COMMENT '创建时间',
    update_time DATETIME     DEFAULT NULL COMMENT '更新时间',
    is_deleted  INT(1)       DEFAULT 0 COMMENT '1-删除，0-未删除',
    CONSTRAINT parent_fk FOREIGN KEY (parent_id) REFERENCES tbl_staff (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='员工表';
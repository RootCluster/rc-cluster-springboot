DROP TABLE IF EXISTS tbl_dept;
CREATE TABLE tbl_dept
(
    id          BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    dept_name   VARCHAR(11) DEFAULT NULL COMMENT '部门名称',
    superior_id BIGINT(20)  DEFAULT NULL COMMENT '上级部门主键',
    create_time DATETIME    DEFAULT NULL COMMENT '创建时间',
    update_time DATETIME    DEFAULT NULL COMMENT '更新时间',
    is_deleted  INT(1)      DEFAULT 0 COMMENT '1-删除，0-未删除',
    CONSTRAINT superior_fk FOREIGN KEY (superior_id) REFERENCES tbl_dept (id),
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='部门表';
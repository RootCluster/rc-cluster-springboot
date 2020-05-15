package org.incoder.plus.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 员工表
 * </p>
 *
 * @author Jerry xu
 * @since 2020-05-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tbl_staff")
public class Staff implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 上级主键
     */
    private Long parentId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 成员年龄
     */
    private Integer age;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 所在部门主键
     */
    private Long deptId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 1-删除，0-未删除
     * 设置了删除表示 @TableLogic
     * 设置查询返回不显示 @TableField(select = false)，这里对于自定义的 SQL 语句是无效
     */
    @TableLogic
    @TableField(select = false)
    private Integer isDeleted;


}

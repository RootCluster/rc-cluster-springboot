package org.incoder.mybatis.domain;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author : Jerry xu
 * @date : 2019/10/26  19:30
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long id;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String userPassword;
    /**
     * 真实姓名
     */
    private String nickName;
    /**
     * 性别
     */
    private Integer userSex;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
    /**
     * 删除标识，1-删除，0-未删除
     */
    private Integer isDeleted;

    public User(String userName, String userPassword, String nickName, Integer userSex) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.nickName = nickName;
        this.userSex = userSex;
    }
}

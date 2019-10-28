package org.incoder.mybatis.mapper;

import org.apache.ibatis.annotations.*;
import org.incoder.mybatis.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : Jerry xu
 * @date : 2019/10/26  19:35
 */
@Repository
public interface UserMapper {

    /**
     * 查询所有用户
     *
     * @return 用户列表
     */
    @Select("SELECT * FROM user")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "userSex", column = "user_sex"),
            @Result(property = "nickName", column = "nick_name"),
    })
    List<User> getAll();

    /**
     * 根据用户 id 获取用户
     *
     * @param id 用户 id
     * @return 用户信息
     */
    @Select("SELECT * FROM user WHERE id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "userNex", column = "user_name"),
            @Result(property = "userSex", column = "user_sex"),
            @Result(property = "nickName", column = "nick_name"),
    })
    User getUserById(@Param("id") Long id);

    /**
     * 插入用户信息
     *
     * @param user 用户信息
     */
    @Insert("INSERT INTO user(user_name, user_password, user_sex, nick_name) VALUES(#{userName}, #{userPassword}, #{userSex}, #{nickName})")
    void insertUser(User user);

    /**
     * 更新用户信息
     *
     * @param user 用户信息
     */
    @Update("UPDATE user SET userName=#{userName},nick_name=#{nickName} WHERE id = #{id}")
    void updateUserById(User user);

    /**
     * 删除指定用户
     *
     * @param id 用户 id
     */
    @Delete("DELETE FROM user WHERE id = #{id}")
    void deleteUserById(@Param("id") Long id);
}

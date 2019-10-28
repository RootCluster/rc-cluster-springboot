package org.incoder.mybatis;

import org.incoder.mybatis.domain.User;
import org.incoder.mybatis.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author : Jerry xu
 * @date : 2019/10/27  21:33
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    @Autowired
    UserMapper userMapper;

    /**
     * 插入用户
     */
    @Test
    public void insertUser() {
        userMapper.insertUser(new User("zhangsan", "123456", "张三", 20));
        userMapper.insertUser(new User("lisi", "123456", "李四", 24));
        userMapper.insertUser(new User("wangwu", "123456", "王五", 28));
    }

    /**
     * 获取全部用户
     */
    @Test
    public void getAll() {
        userMapper.getAll();
    }

    /**
     * 根据 id 获取用户
     */
    @Test
    public void getUserById() {
        userMapper.getUserById(1L);
    }

    /**
     * 根据用户 id 更新用户信息
     */
    @Test
    public void updateUserById() {
        userMapper.updateUserById(new User("wangwu", "123456", "王五", 28));
    }

    /**
     * 根据 id 删除用户
     */
    @Test
    public void deleteUserById() {
        userMapper.deleteUserById(1L);
    }
}

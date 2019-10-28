package org.incoder.mybatis.controller;

import org.incoder.mybatis.domain.User;
import org.incoder.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : Jerry xu
 * @date : 2019/10/26  23:19
 */
@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/getUsers")
    public List<User> getUsers() {
        List<User> users=userMapper.getAll();
        return users;
    }

    @RequestMapping("/getUser")
    public User getUser(Long id) {
        User user=userMapper.getUserById(id);
        return user;
    }

    @RequestMapping("/add")
    public void save(User user) {
        userMapper.insertUser(user);
    }

    @RequestMapping(value="update")
    public void update(User user) {
        userMapper.updateUserById(user);
    }

    @RequestMapping(value="/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        userMapper.deleteUserById(id);
    }
}

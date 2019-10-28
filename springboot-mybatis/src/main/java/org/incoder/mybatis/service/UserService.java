package org.incoder.mybatis.service;

import org.incoder.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : Jerry xu
 * @date : 2019/10/27  11:04
 */
@Service
public class UserService {

    @Autowired
    UserMapper userMapper;



}

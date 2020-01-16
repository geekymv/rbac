package com.rbac.service.impl;

import com.rbac.base.BaseService;
import com.rbac.model.User;
import com.rbac.service.UserService;
import com.rbac.repository.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class UserServiceImpl extends BaseService<UserMapper, User> implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User getUserInfo(String userId) {
        log.info("userId = " + userId);
        return userMapper.selectById(userId);
    }

    @Override
    public User add(User user) {
       userMapper.insert(user);
       return user;
    }
}
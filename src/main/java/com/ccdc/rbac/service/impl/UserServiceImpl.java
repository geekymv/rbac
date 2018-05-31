package com.ccdc.rbac.service.impl;

import com.ccdc.rbac.base.BaseService;
import com.ccdc.rbac.model.User;
import com.ccdc.rbac.repository.UserMapper;
import com.ccdc.rbac.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseService implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(String userId) {
        logger.info("userId = " + userId);
        return userMapper.selectById(userId);
    }

    @Override
    public User add(User user) {
       userMapper.insert(user);
       return user;
    }
}

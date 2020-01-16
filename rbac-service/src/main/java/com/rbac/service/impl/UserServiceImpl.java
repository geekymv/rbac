package com.rbac.service.impl;

import com.rbac.base.BaseService;
import com.rbac.model.User;
import com.rbac.repository.UserMapper;
import com.rbac.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
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
        // 密码加密
        Md5PasswordEncoder passwordEncoder = new Md5PasswordEncoder();
        String password = passwordEncoder.encodePassword(user.getPassword(), user.getAccount());
        user.setPassword(password);

        userMapper.insert(user);
        return user;
    }

    @Override
    public boolean isPasswordValid(String encPass, String rawPass, String salt) {
        Md5PasswordEncoder passwordEncoder = new Md5PasswordEncoder();
        return passwordEncoder.isPasswordValid(encPass, rawPass, salt);
    }
}

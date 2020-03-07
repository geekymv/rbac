package com.rbac.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rbac.base.BaseService;
import com.rbac.model.User;
import com.rbac.mapper.UserMapper;
import com.rbac.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

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
        final String username = user.getUsername();
        final String password = user.getPassword();
        if(StringUtils.isBlank(username)) {
            throw new IllegalArgumentException("参数username不能为空");
        }
        if(StringUtils.isBlank(password)) {
            throw new IllegalArgumentException("参数password不能为空");
        }

        // 验证帐号是否已存在
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("username", username);
        Integer userCnt = userMapper.selectCount(userQueryWrapper);
        if(userCnt != null && userCnt > 0) {
            throw new RuntimeException("帐号"+username+"已存在，无法再次创建");
        }

        // 将用户输入的密码加密
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        String encPassword = passwordEncoder.encode(password);
//        user.setPassword(encPassword);

        // 设置创建时间
        user.setCreateAt(new Date());

        // 保存用户信息
        userMapper.insert(user);
        return user;
    }

    @Override
    public boolean isPasswordValid(String encPass, String rawPass, String salt) {
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        return passwordEncoder.matches(rawPass, encPass);
        return true;
    }
}

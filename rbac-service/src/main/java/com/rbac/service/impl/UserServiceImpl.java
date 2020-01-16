package com.rbac.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rbac.base.BaseService;
import com.rbac.model.User;
import com.rbac.repository.UserMapper;
import com.rbac.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
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
        final String account = user.getAccount();
        final String password = user.getPassword();
        if(StringUtils.isBlank(account)) {
            throw new IllegalArgumentException("参数account不能为空");
        }
        if(StringUtils.isBlank(password)) {
            throw new IllegalArgumentException("参数password不能为空");
        }

        // 验证帐号是否已存在
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("account", account);
        Integer userCnt = userMapper.selectCount(userQueryWrapper);
        if(userCnt != null && userCnt > 0) {
            throw new RuntimeException("帐号"+account+"已存在，无法再次创建");
        }

        // 将用户输入的密码加密
        Md5PasswordEncoder passwordEncoder = new Md5PasswordEncoder();
        String encPassword = passwordEncoder.encodePassword(password, account);
        user.setPassword(encPassword);

        // 设置创建时间
        user.setCreateAt(new Date());

        // 保存用户信息
        userMapper.insert(user);
        return user;
    }

    @Override
    public boolean isPasswordValid(String encPass, String rawPass, String salt) {
        Md5PasswordEncoder passwordEncoder = new Md5PasswordEncoder();
        return passwordEncoder.isPasswordValid(encPass, rawPass, salt);
    }
}

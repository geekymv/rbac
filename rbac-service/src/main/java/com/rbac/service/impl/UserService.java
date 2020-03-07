package com.rbac.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rbac.mapper.UserMapper;
import com.rbac.model.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Resource
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper<com.rbac.model.User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        com.rbac.model.User user = userMapper.selectOne(queryWrapper);
        if(user == null) {
            throw new UsernameNotFoundException("用户名或密码错误");
        }
        List<GrantedAuthority> authorities = new ArrayList<>(); // 用户角色

        List<Role> roles = user.getRoles();
        for(Role role : roles) {
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getName());
            authorities.add(authority);
        }


        User userDetail = new User(user.getUsername(), user.getPassword(), authorities);
        return userDetail;
    }
}

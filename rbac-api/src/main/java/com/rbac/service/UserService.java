package com.rbac.service;


import com.rbac.model.User;

public interface UserService {

    User getUserInfo(String userId);

    User add(User user);

}

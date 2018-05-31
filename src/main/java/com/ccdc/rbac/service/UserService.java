package com.ccdc.rbac.service;

import com.ccdc.rbac.model.User;

public interface UserService {

    User getUserById(String userId);

    User add(User user);

}

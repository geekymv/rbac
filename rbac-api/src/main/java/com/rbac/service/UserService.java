package com.rbac.service;


import com.rbac.model.User;

public interface UserService {

    /**
     * 根据用户id获取用户基本信息
     * @param userId
     * @return
     */
    User getUserInfo(String userId);

    /**
     * 新增用户（帐号account 不能修改且唯一）
     * @param user
     * @return
     */
    User add(User user);

    /**
     * 验证密码
     * @param encPass 加密后密码
     * @param rawPass 原始密码
     * @return
     */
    boolean isPasswordValid(String encPass, String rawPass, String salt);
}

package com.ccdc.rbac.web;

import com.ccdc.rbac.base.BaseController;
import com.ccdc.rbac.model.User;
import com.ccdc.rbac.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@Api(value = "用户管理", description = "用户接口")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @PostMapping("/list")
    public List<User> list(User user) {
        return null;
    }

    @PostMapping("/add")
    @ApiOperation(value = "新增用户", notes = "新增用户接口")
    public User addUser(@RequestBody User user) {
        return user;
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") String userId) {
        return userService.getUserById(userId);
    }

}

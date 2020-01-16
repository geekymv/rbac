package com.rbac.web;

import com.rbac.base.BaseController;
import com.rbac.model.User;
import com.rbac.service.UserService;
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

    @ApiOperation(value = "新增用户", notes = "新增用户接口")
    @PostMapping("/add")
    public User addUser(@RequestBody User user) {
        return userService.add(user);
    }

    @ApiOperation(value = "根据id查询用户", notes = "根据id查询用户接口")
    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") String userId) {
        return userService.getUserInfo(userId);
    }

}

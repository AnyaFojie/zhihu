package com.hmh.zhihu.controller;

import cn.dev33.satoken.util.SaResult;
import com.hmh.zhihu.entity.User;
import com.hmh.zhihu.services.UserService;
import net.sf.jsqlparser.expression.LongValue;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/users")
public class UserController {
    @Resource
    private UserService userService;

    // 用户注册
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        // 调用userService的方法来处理用户注册逻辑
        boolean success = userService.registerUser(user);
        if (success) {
            return new ResponseEntity<>("用户注册成功", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("用户注册失败", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 用户登录
   /* @PostMapping ("/login")
    public ResponseEntity<String> loginUser(@RequestParam String username, @RequestParam String password) {
        // 调用userService的方法来处理用户登录逻辑
        boolean success = userService.loginUser(username, password);
        if (success) {
            return new ResponseEntity<>("用户登录成功", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("用户名或密码错误", HttpStatus.UNAUTHORIZED);
        }
    }*/
    @PostMapping("/login")
    public SaResult login( String username, String password) {
        // 调用userService的方法来处理用户登录逻辑
        boolean success = userService.loginUser(username, password);
        if (success) {
            return SaResult.ok("登录成功");
        } else {
            return SaResult.error("用户名或密码错误");
        }
    }
     @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody User user) {
        User currentUser = userService.getUserById(id);
        if (currentUser != null) {
            currentUser.setNickname(user.getNickname());
            currentUser.setAvatar(user.getAvatar());
            userService.updateUser(currentUser);
        }
    }
     @PatchMapping("/{id}/password")
    public void changePassword(@PathVariable Long id, @RequestParam String newPassword) {
        userService.changePassword(id, newPassword);
    }
}

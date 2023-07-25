package com.hmh.zhihu.services.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hmh.zhihu.entity.User;
import com.hmh.zhihu.mapper.UserMapper;
import com.hmh.zhihu.services.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public boolean registerUser(User user) {
         // 检查用户名是否已存在
        User existingUser = userMapper.selectOne(new QueryWrapper<User>().eq("username", user.getUsername()));
        if (existingUser != null) {
            return false;
        }

        // 保存用户信息到数据库
        user.setCreatedAt(LocalDateTime.now());
        int result = userMapper.insert(user);
        return result > 0;
    }

    @Override
    public boolean loginUser(String username, String password) {
       // 根据用户名查询用户信息
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("username", username));

        // 校验密码是否匹配
        return user != null && user.getPassword().equals(password);
    }

    @Override
    public User getUserById(Long id) {
        return userMapper.selectById(id);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateById(user);
    }

    @Override
    public void changePassword(Long id, String newPassword) {
          User user = userMapper.selectById(id);
        if (user != null) {
            user.setPassword(newPassword);
            userMapper.updateById(user);
        }
    }
}

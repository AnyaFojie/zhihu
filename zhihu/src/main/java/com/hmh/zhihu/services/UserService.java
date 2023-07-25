package com.hmh.zhihu.services;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hmh.zhihu.entity.User;

public interface UserService extends IService<User> {
    
    boolean registerUser(User user);
    boolean loginUser(String username, String password);
    User getUserById(Long id);
    void updateUser(User user);
    void changePassword(Long id, String newPassword);

}

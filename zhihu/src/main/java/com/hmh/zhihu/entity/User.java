package com.hmh.zhihu.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("users")
public class User {
    private Integer id;
    private String username;
    private String password;
    private String nickname;
    private String avatar;
    private LocalDateTime createdAt;

}
